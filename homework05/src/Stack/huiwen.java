package Stack;
import SqStack.SqStack;
import java.util.Scanner;
class isPalindrome{
	//��ѧ�ⷨ:ͨ��ȡ����ȡ�������ȡ�����ж�Ӧ�����ֽ��бȽ�
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
	//��ͨ�ⷨ:�Ƚ�����תΪ�ַ��� ��Ȼ���ַ����ָ�Ϊ����
	//ֻ��Ҫѭ�������һ�볤�Ƚ����ж϶�ӦԪ���Ƿ���ȼ���
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
	//ȡ���������ֽ��з�ת
	public boolean isPalindrome3(int x) {
        //˼���������ҿ���˼��һ�£�ΪʲôĩβΪ 0 �Ϳ���ֱ�ӷ��� false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev= rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev/ 10; //��ż
    }

	//ͷβָ��
	public boolean isPalindrome4(int x) {
		if (x < 0) return false;
        String in = String.valueOf(x); //�Ƚ�����תΪ�ַ���
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
	//ջ�ⷨ
	 public boolean isPalindrome5(int x) throws Exception {
		 String in = String.valueOf(x); //�Ƚ�����תΪ�ַ���
		 SqStack s=new SqStack(in.length());  //˳��ջ
		 int mid=in.length()/2;
		 for(int i=0;i<mid;i++) {
			 s.push(in.charAt(i));
		 }
		 //�ж��ַ�������ż����
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
		 SqStack s=new SqStack(in.length());  //˳��ջ
		 int mid=in.length()/2;
		 for(int i=0;i<mid;i++) {
			 s.push(in.charAt(i));
		 }
		 //�ж��ַ�������ż����
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
		System.out.println("������һ��������:");
		int num = reader.nextInt();
		System.out.println("��ѧ�ⷨ:"+s.isPalindrome1(num));
		System.out.println("��ͨ�ⷨ:"+s.isPalindrome2(num));
		System.out.println("���ַ�ת:"+s.isPalindrome3(num));
		System.out.println("ͷβָ��:"+s.isPalindrome4(num));
		System.out.println("ջ����:"+s.isPalindrome5(num));
		System.out.println("������һ�����Ĵ�:");
		String str=reader.next();
		System.out.println("��ͨ�ⷨ:"+s.isPalindrome2_1(str));
		System.out.println("ͷβָ��:"+s.isPalindrome4_1(str));
		System.out.println("ջ����:"+s.isPalindrome5_1(str));
		
	}
}
