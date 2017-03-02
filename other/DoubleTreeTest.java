package other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class DoubleTreeTest {
	private class Node{
		private int value;
		private Node left;
		private Node right;
		public Node(int value,Node left,Node right){
			this.value=value;
			this.left=left;
			this.right=right;
		}
	}
	
	private Node head=null;
	public void put(int value){
		if(head==null){
			head=new Node(value,null,null);
			return;
		}
		Node temp=head;
		while(true){
			int cmp=value>=temp.value?1:-1;
			if(cmp==1){
				if(temp.right==null){
					temp.right=new Node(value,null,null);
					break;
				}
				else{
					temp=temp.right;
				}
			}
			else{
				if(temp.left==null){
					temp.left=new Node(value,null,null);
					break;
				}
				else{
					temp=temp.left;
				}
			}
		}
	}
	public String lastprint(){
		Node temp=head;
		
		StringBuilder str=new StringBuilder();
		lastprint(temp,str);
		return str.toString();
	}
	private void lastprint(Node temp,StringBuilder str){
		if(temp!=null){
			lastprint(temp.left,str);
			lastprint(temp.right,str);
			str.append(temp.value+" ");
			
		}
	}
	public String pirprint(){
		Node temp=head;
		StringBuilder str=new StringBuilder();
		pirprint(temp,str);
		return str.toString();
	}
	private void pirprint(Node temp,StringBuilder str){
		if(temp!=null){
			str.append(temp.value+" ");
			lastprint(temp.left,str);
			lastprint(temp.right,str);
			
		}
	}
	
	public String midprint(){
		Node temp=head;
		StringBuilder str=new StringBuilder();
		midprint(temp,str);
		return str.toString();
	}
	private void midprint(Node temp,StringBuilder str){
		if(temp!=null){
			lastprint(temp.left,str);
			str.append(temp.value+" ");
			lastprint(temp.right,str);
			
		}
	}
	
	public String layerprint(){
		StringBuilder str=new StringBuilder();
		Node temp=head;
		Queue<Node> queue=new LinkedList<>();
 		queue.offer(temp);
 		while(!queue.isEmpty()){
 			Node n=queue.poll();
 			str.append(n.value+" ");
 			if(n.left!=null){
 				queue.offer(n.left);
 			}
 			if(n.right!=null){
 				queue.offer(n.right);
 			}
 		}
		
		return str.toString();
	}

	public static boolean JudgeTree(DoubleTreeTest t1,DoubleTreeTest t2){
		if(t1.pirprint().equals(t2.pirprint())&& t1.midprint().equals(t2.midprint())&&t1.lastprint().equals(t2.lastprint())){
			return true;
		}
		else{
			return false;
		}
	}
	public static void main(String[] args){
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int len=Integer.parseInt(sc.nextLine());
		DoubleTreeTest tree1=new DoubleTreeTest();
		DoubleTreeTest tree2=new DoubleTreeTest();
		String[] fr=sc.nextLine().split(" ");
		for(int i=0;i<len;i++){
			tree1.put(Integer.parseInt(fr[i]));
		}
		
		String[] se=sc.nextLine().split(" ");
		for(int i=0;i<len;i++){
			tree2.put(Integer.parseInt(se[i]));
		}
		String s1=tree1.lastprint();
		String s2=tree1.layerprint();
		if(DoubleTreeTest.JudgeTree(tree1, tree2)){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
		System.out.println(s1);
		System.out.println(s2);
	}
}





