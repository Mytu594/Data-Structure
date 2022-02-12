package yanghui;
import java.util.Scanner;
public class yanghui1 {
	public static void main(String[] args)throws Exception{
		
		Scanner reader=new Scanner(System.in);
		System.out.print("请输入杨辉的行数:");
		int rows=reader.nextInt();
		CircleSqQueue queue=new CircleSqQueue(100);
		queue.offer(0);
		queue.offer(1);
		int n=0;
		while(n<=rows) {
			int a1=(int)queue.poll();//出队的那个元素
			int a2=(int)queue.peek();//a1出队后的队首元素,此时a2还没出队
			if(a1==0) {//借用0进行换行判断,每行的最前其实都有一个0
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
