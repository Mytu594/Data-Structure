package Fibonacci;
import java.math.BigDecimal;
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		System.out.println(f(10));
		System.out.println(f(20));
		System.out.println(f(40));
		long endTime = System.currentTimeMillis(); 
    	System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
	}
	public static BigDecimal f(int n) {
		if(n==1||n==2)
			return BigDecimal.ONE;
		else
			return f(n-1).add(f(n-2));
	}
}
