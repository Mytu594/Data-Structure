package Fibonacci;
import java.math.BigDecimal;
public class jiecheng_2 {
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
		int i=1;
		BigDecimal result=new BigDecimal(1);
		for(i=1;i<=n;i++) {
			BigDecimal i_value=new BigDecimal(i);
			result=result.multiply(i_value);
		}
		return result;
	}
}
