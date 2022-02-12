package Fibonacci;

import java.math.BigDecimal;
public class jiecheng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis(); 
		System.out.println(f(10));
		System.out.println(f(20));
		System.out.println(f(100));
		System.out.println(f(200));
		long endTime = System.currentTimeMillis(); 
    	System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
	}
	public static BigDecimal f(int n) {
		BigDecimal result=new BigDecimal(1);
		if(n==1) {
			return result;
		}
		else
		{
			BigDecimal n_value=new BigDecimal(n);
			result=f(n-1).multiply(n_value);
			return result;
		}
	}
}
