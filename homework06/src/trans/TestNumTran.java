package trans;
import java.util.Arrays;
import java.util.Scanner;
public class TestNumTran {
	public void DecimalToBinary(int num) { //ʮ����ת������
		int rev=num;
		LinkStack stack = new LinkStack();
		int flag = 0;
		while(num != 0) {
			flag = num%2;
			if(flag == 0 ) {
				stack.push(0);
			} else {
				stack.push(1);
			}
			num = num/2;
		}
		System.out.print(rev + "ת���ɶ�����Ϊ��");
		while(!stack.isEmpty()) {
			System.out.print(stack.peek());
			stack.pop();
		}
	}
	public String  BinaryTo(String n, int n1, int n2) {
		/**
	     * ����ת��
	     * �㷨��ƣ��Ƚ���������ͳһתΪ10���ƣ�������ȡ�෨
	     * ��10����תΪ��������
	     * @param n  ��Ҫת������
	     * @param n1 ��Ҫת�����Ľ���
	     * @param n2 ת����Ľ���
	     * @return ת�������
	     */
		LinkStack e = new LinkStack();
	    char[] a=new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	    char[] b=n.toCharArray();
	    int bNumber=0,t=0;
	    //[start]��n1����תΪ10����
	    for (char p:b){
	         e.push(p);
	    }
	    while (!e.isEmpty()){
	        char temp=(char) e.pop();
	        bNumber+= Arrays.binarySearch(a,temp)*Math.pow(n1,t);
	        t++;
	    }
	    //[end]
	    //[start]  ��10����תΪn2����
	    StringBuilder builder=new StringBuilder();
	    while (bNumber>0){
	        e.push(a[bNumber%n2]);
	        bNumber/=n2;
	    }
	    while (!e.isEmpty()) {
	        builder.append(e.pop());
	    }
	    //[end]
	    String str;
	    str=builder.toString();
	    return str;
	}
	public static void main(String[] args) {
		TestNumTran s=new TestNumTran();
		Scanner reader = new Scanner(System.in);
		System.out.println("������һ��ʮ��������");
		int num = reader.nextInt();
		s.DecimalToBinary(num);
		System.out.println();
		System.out.println("������һ������������");
		int num1 = reader.nextInt();
		System.out.println(num1 + "ת����ʮ������Ϊ��");
		System.out.println(s.BinaryTo(String.valueOf(num1),2,8));
		System.out.println("������һ������������");
		int num2 = reader.nextInt();
		System.out.println(num2 + "ת���ɰ˽���Ϊ��");
		System.out.println(s.BinaryTo(String.valueOf(num2),2,16));
		
	}

}
