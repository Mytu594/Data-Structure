package Stack;
import SqStack.SqStack;
import java.util.Scanner;
class isPalindrome{
	//数学解法:通过取整和取余操作获取整数中对应的数字进行比较
	public boolean isPalindrome1(int x) {
        if(x<0)
            return false;
        int rem=0,y=0;
        int temp=x;
        while(temp!=0){
            rem=temp%10;
            y=y*10+rem;
            temp=temp/10;
        }
        return y==x;
    }
	//普通解法:先将整数转为字符串 ，然后将字符串分割为数组
	//只需要循环数组的一半长度进行判断对应元素是否相等即可
	public boolean isPalindrome2(int x) {
        char[] chars = String.valueOf(x).toCharArray();  
        int length = chars.length;
        for (int i = 0; i < length/2; i++) {
            char head = chars[i];
            char tail = chars[length - 1 - i];
            if(head == tail){
                continue;
            }
            return false;
        }
        return true;
    }
	public boolean isPalindrome2_1(String in) {
        char[] chars = in.toCharArray();  
        int length = chars.length;
        for (int i = 0; i < length/2; i++) {
            char head = chars[i];
            char tail = chars[length - 1 - i];
            if(head == tail){
                continue;
            }
            return false;
        }
        return true;
    }
	//取出后半段数字进行翻转
	public boolean isPalindrome3(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev= rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev/ 10; //奇偶
    }

	//头尾指针
	public boolean isPalindrome4(int x) {
		if (x < 0) return false;
        String in = String.valueOf(x); //先将整数转为字符串
        int i = 0;
        int j = in.length() - 1;
        while (i < j) {
            if (in.charAt(i++) != in.charAt(j--)) return false;
        }
        return true;
    }
	public boolean isPalindrome4_1(String in) {
		if(!" ".equals(in)&&in!=null) {
			int i = 0;
			int j = in.length() - 1;
			while (i < j) {
				if (in.charAt(i++) != in.charAt(j--)) return false;
			}
			return true;
		}
		return false;
    }
	//栈解法
	 public boolean isPalindrome5(int x) throws Exception {
		 String in = String.valueOf(x); //先将整数转为字符串
		 SqStack s=new SqStack(in.length());  //顺序栈
		 int mid=in.length()/2;
		 for(int i=0;i<mid;i++) {
			 s.push(in.charAt(i));
		 }
		 //判断字符串的奇偶个数
		 if(in.length()%2==1) {
			 mid+=1;
		 }
		 for(;mid<in.length();mid++) {
			 if(s.peek().equals(in.charAt(mid)))
				 s.pop();
			 else
				 return false;
		 }
		return true;
		 
	 }	
	 public boolean isPalindrome5_1(String in) throws Exception {
		 SqStack s=new SqStack(in.length());  //顺序栈
		 int mid=in.length()/2;
		 for(int i=0;i<mid;i++) {
			 s.push(in.charAt(i));
		 }
		 //判断字符串的奇偶个数
		 if(in.length()%2==1) {
			 mid+=1;
		 }
		 for(;mid<in.length();mid++) {
			 if(s.peek().equals(in.charAt(mid)))
				 s.pop();
			 else
				 return false;
		 }
		return true;
		 
	 }
}
public class huiwen {
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		isPalindrome s=new isPalindrome();
		Scanner reader=new Scanner(System.in);
		System.out.println("请输入一个回文数:");
		int num = reader.nextInt();
		System.out.println("数学解法:"+s.isPalindrome1(num));
		System.out.println("普通解法:"+s.isPalindrome2(num));
		System.out.println("数字翻转:"+s.isPalindrome3(num));
		System.out.println("头尾指针:"+s.isPalindrome4(num));
		System.out.println("栈处理法:"+s.isPalindrome5(num));
		System.out.println("请输入一个回文串:");
		String str=reader.next();
		System.out.println("普通解法:"+s.isPalindrome2_1(str));
		System.out.println("头尾指针:"+s.isPalindrome4_1(str));
		System.out.println("栈处理法:"+s.isPalindrome5_1(str));
		
	}
}
