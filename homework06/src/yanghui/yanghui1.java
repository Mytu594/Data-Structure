package yanghui;
import java.util.Scanner;
public class yanghui1 {
	public static void main(String[] args)throws Exception{
		
		Scanner reader=new Scanner(System.in);
		System.out.print("��������Ե�����:");
		int rows=reader.nextInt();
		CircleSqQueue queue=new CircleSqQueue(100);
		queue.offer(0);
		queue.offer(1);
		int n=0;
		while(n<=rows) {
			int a1=(int)queue.poll();//���ӵ��Ǹ�Ԫ��
			int a2=(int)queue.peek();//a1���Ӻ�Ķ���Ԫ��,��ʱa2��û����
			if(a1==0) {//����0���л����ж�,ÿ�е���ǰ��ʵ����һ��0
				n++;
				queue.offer(0);
			}
			queue.offer(a1+a2);
			if(a1==0) {
				System.out.println();
			}else {
				System.out.print(a1+" ");
			}
		}
	}
}
