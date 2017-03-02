package socket;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    CloseableHttpClient httpClient;
    static int bookId = 496;
    Map<String,Integer> proxyMap;//ip->�˿�
    List<String> ipList;//�����list�ж���ip������ip��map�ж����˿�
    int i = 0;//���������list��ȡ��ip�����϶�Ӧ�Ĵ���

    public static void main(String[] args) {
        Main m = new Main();

//        List<String> tagList = m.getTagList();
        List<String> tagList = new LinkedList<String>();
//        tagList.add("����");
//        tagList.add("�ձ���ѧ");
//        tagList.add("ɢ��");
//        tagList.add("�й���ѧ");
       tagList.add("�㷨");
//        tagList.add("ͯ��");
//        tagList.add("�����ѧ");
//        tagList.add("��ѧ");
//        tagList.add("С˵");
//        tagList.add("����");
        tagList.add("ʫ��");
//        tagList.add("����ѧ");
//        tagList.add("��Ӱ");
//        tagList.add("���");
//        tagList.add("����ѧ");
        m.pullAndWrite(tagList,10);
    }

    public Main() {
//        HttpHost proxy = new HttpHost("122.225.106.35",80);
//        httpClient = HttpClients.custom().setProxy(proxy).build();
        httpClient = HttpClients.createDefault();
        setProxyMap();
    }

    public void setProxyMap() {
        proxyMap = new HashMap<String, Integer>();
        ipList = new LinkedList<String>();
        proxyMap.put("10.129.215.145",80);ipList.add("10.129.215.145");
    }

    public List<String> getTagList() {
        HttpGet getTag = new HttpGet("http://book.douban.com/tag/");
        getTag.addHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 5.2) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.122 Safari/534.30");
        CloseableHttpResponse tagPageResponse = null;
        String tagPageCode = null;//��ҳԴ��
        try {
            tagPageResponse = httpClient.execute(getTag);
            tagPageCode = EntityUtils.toString(tagPageResponse.getEntity());
            tagPageResponse.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                tagPageResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Pattern p = Pattern.compile("class=\"tag\">(.*?)</a>");
        Matcher m = p.matcher(tagPageCode);
        List<String> resultTagList = new LinkedList<String>();
        while (m.find()) {
            resultTagList.add(m.group(1));
        }

        return resultTagList;
    }

    /**
     *
     * @param tagList  Ҫץ��ͼ������
     * @param maxPageNum ÿ��ͼ�����ץȡ��ҳ��
     */
    public void pullAndWrite(List<String> tagList,int maxPageNum) {
        Pattern bookAddressRegex = Pattern.compile("href=\"(.*?)\" class=\"title\" target=\"_blank\">(.*?)</a>");   //��ȡ�����鼮��ַ������
        Pattern bookAuthorRegex = Pattern.compile("(?s)<span class=\"pl\"> ����</span>:.*?>(.*?)</a>");//ƥ������
        Pattern bookPublishRegex = Pattern.compile("<span class=\"pl\">������:</span> (.*?)<br/>");
        Pattern bookIsbnRegex = Pattern.compile("<span class=\"pl\">ISBN:</span> (.*?)<br/>");
        Pattern bookImgRegex = Pattern.compile("<img src=\"(.*?)\" title=\"�������ͼ\"");

        //�ֱ�ץȡÿһ�������鼮
        for (String tag:tagList) {
            int nowPageNum = 0;//Ŀǰ����ץȡ��ҳ��
            Document newDocument = DocumentHelper.createDocument();
            Element rootElement = newDocument.addElement("root");

            while (nowPageNum < maxPageNum) {
                System.out.println(1);
                String nowPageAddress = "http://www.douban.com/tag/" + tag + "/book?start=" + nowPageNum * 15;//��ǰҳ����ַ
                HttpGet getBooksPage = new HttpGet(nowPageAddress);
                getBooksPage.addHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 5.2) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.122 Safari/534.30");
                CloseableHttpResponse booksPageResponse;
                Matcher m = null;
                try {
                    System.out.println(2);
                    booksPageResponse = httpClient.execute(getBooksPage);
                    System.out.println(3);
                    m = bookAddressRegex.matcher(EntityUtils.toString(booksPageResponse.getEntity()));
                    booksPageResponse.close();
                    if (booksPageResponse.getStatusLine().getStatusCode() != 200) {
                        System.out.println("ץ " + nowPageAddress + " ʱ����:");
                        System.out.println("������Ϣ:" + booksPageResponse.getStatusLine());
                        changeProxy();
                        continue;//���������������ǰҳ
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //����ÿһ���飬����ץȡ
                int findCount = 0;//�ҵ����鼮����Ŀ
                List<Thread> threadList = new LinkedList<Thread>();
                while (m.find()) {
                    threadList.add(new GetBookInfoThread(httpClient, m.group(1), m.group(2), rootElement, bookAuthorRegex, bookPublishRegex, bookIsbnRegex,bookImgRegex));
                    findCount++;
                }
                //û��֪�����������������鶼�����ˣ���ôֱ���˳������鼮�Ĳ���
                if (findCount == 0) {
                    break;
                }

                for (Thread thread:threadList) {
                    thread.start();
                }
                for (Thread thread:threadList) {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                nowPageNum++;
            }
            //һ�������������д��
            new WriteBookInfoToFile(rootElement,"/home/geekgao/book/" + tag + ".xml").start();  //��һ���߳�д���ļ�

        }
    }

    private void changeProxy() {
        if (i >= ipList.size()) {
            System.out.println("����������,�˳�");
            System.exit(0);
        }
        String ip = ipList.get(i++);
        httpClient = HttpClients.custom().setProxy(new HttpHost(ip,proxyMap.get(ip))).build();
        System.out.println("��������,ʹ�ô���:" + ip + "���˿�:" + proxyMap.get(ip));
    }

}