package LinkList;

import java.util.Scanner;
public class Combine {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader=new Scanner(System.in);
		int m=0,n=0;//记录个数
		System.out.println("请输入L1中节点的个数:");
		m=reader.nextInt();
		System.out.println("请从小到大输入"+m+"个数字:");
		LinkList L1=new LinkList();
		L1.insetTail(m);
		System.out.println("请输入L2中节点的个数:");
		n=reader.nextInt();
		System.out.println("请从小到大输入"+n+"个数字:");
		LinkList L2=new LinkList();
		L2.insetTail(n);
		System.out.println("合并后:");
		
	}
	
	public static void combine_L(Node L1,Node L2) {
		Node pa=L1.next;
		Node pb=L2.next;
		Node pc=L1;
		int da,db;
		while(pa!=null&&pb!=null) {
			da=Integer.valueOf(pa.data.toString());
			db=Integer.valueOf(pa.data.toString());
			if(da<=db) {
				pc.next=pa;
				pc=pa;
				pa=pa.next;
			}
			else {
				pc.next=pb;
				pc=pb;
				pb=pb.next;
					
				}
			}
		pc.next=(pa!=null?pa:pb);
		L1=L1.next;
		if(L1.next!=null) {
			System.out.print(L1.data+" ");
			
		}
	}
}
