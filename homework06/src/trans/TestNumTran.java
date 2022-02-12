package trans;
import java.util.Arrays;
import java.util.Scanner;
public class TestNumTran {
	public void DecimalToBinary(int num) { //十进制转二进制
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
		System.out.print(rev + "转换成二进制为：");
		while(!stack.isEmpty()) {
			System.out.print(stack.peek());
			stack.pop();
		}
	}
	public String  BinaryTo(String n, int n1, int n2) {
		/**
	     * 进制转换
	     * 算法设计：先将其他进制统一转为10进制，再利用取余法
	     * 将10进制转为其他进制
	     * @param n  需要转化的数
	     * @param n1 需要转化数的进制
	     * @param n2 转化后的进制
	     * @return 转换后的数
	     */
		LinkStack e = new LinkStack();
	    char[] a=new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	    char[] b=n.toCharArray();
	    int bNumber=0,t=0;
	    //[start]将n1进制转为10进制
	    for (char p:b){
	         e.push(p);
	    }
	    while (!e.isEmpty()){
	        char temp=(char) e.pop();
	        bNumber+= Arrays.binarySearch(a,temp)*Math.pow(n1,t);
	        t++;
	    }
	    //[end]
	    //[start]  将10进制转为n2进制
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
		System.out.println("请输入一个十进制数：");
		int num = reader.nextInt();
		s.DecimalToBinary(num);
		System.out.println();
		System.out.println("请输入一个二进制数：");
		int num1 = reader.nextInt();
		System.out.println(num1 + "转换成十六进制为：");
		System.out.println(s.BinaryTo(String.valueOf(num1),2,8));
		System.out.println("请输入一个二进制数：");
		int num2 = reader.nextInt();
		System.out.println(num2 + "转换成八进制为：");
		System.out.println(s.BinaryTo(String.valueOf(num2),2,16));
		
	}

}
