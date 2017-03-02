package socket;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Mains {
    public static void main(String[] args) {
        RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT).build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();

        HttpGet getHomePage = new HttpGet("http://www.zhihu.com/");
        try {
            //����½�����л����Ĳ���
            CloseableHttpResponse response = httpClient.execute(getHomePage);
            String responseHtml = EntityUtils.toString(response.getEntity());
            String xsrfValue = responseHtml.split("<input type=\"hidden\" name=\"_xsrf\" value=\"")[1].split("\"/>")[0];
            System.out.println("_xsrf:" + xsrfValue);
            response.close();
            List<NameValuePair> valuePairs = new LinkedList<NameValuePair>();
            valuePairs.add(new BasicNameValuePair("_xsrf" , xsrfValue));
            valuePairs.add(new BasicNameValuePair("email"," �û���"));
            valuePairs.add(new BasicNameValuePair("password"," ����"));
            valuePairs.add(new BasicNameValuePair("rememberme", "true"));

            //��ȡ��֤��
            HttpGet getCaptcha = new HttpGet("http://www.zhihu.com/captcha.gif?r=" + System.currentTimeMillis() + "&type=login");
            CloseableHttpResponse imageResponse = httpClient.execute(getCaptcha);
            FileOutputStream out = new FileOutputStream("/tmp/zhihu.gif");
            byte[] bytes = new byte[8192];
            int len;
            while ((len = imageResponse.getEntity().getContent().read(bytes)) != -1) {
                out.write(bytes,0,len);
            }
            out.close();
            Runtime.getRuntime().exec("eog /tmp/zhihu.gif");//ubuntu�¿�ͼƬ��������eog

            //���û�������֤��
            System.out.print("��������֤�룺");
            @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
            String captcha = scanner.next();
            valuePairs.add(new BasicNameValuePair("captcha", captcha));

            //��ɵ�½����Ĺ���
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
            HttpPost post = new HttpPost("http://www.zhihu.com/login/email");
            post.setEntity(entity);
            httpClient.execute(post);//��¼

            HttpGet g = new HttpGet("http://www.zhihu.com/question/following");//��ȡ���ҹ�ע�����⡱ҳ��
            CloseableHttpResponse r = httpClient.execute(g);
            System.out.println(EntityUtils.toString(r.getEntity()));
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}