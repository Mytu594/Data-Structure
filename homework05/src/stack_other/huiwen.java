package stack_other;

class isPalindrome{
	public boolean isPalindrome1(int x) {
        if(x<0)
            return false;
        int rem=0,y=0;
        int quo=x;
        while(quo!=0){
            rem=quo%10;
            y=y*10+rem;
            quo=quo/10;
        }
        return y==x;
    }
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
	 public boolean isPalindrome3(int x) {
	        if (x < 0) return false;
	        String s = String.valueOf(x);
	        int len = s.length();
	        for (int start = 0, end = len - 1; start < end; start++, end--) {
	            if (s.charAt(start) != s.charAt(end)) return false;
	        }
	        return true;
	    }
	 
}
public class huiwen {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPalindrome s=new isPalindrome();
		System.out.println(s.isPalindrome1(121));
		System.out.println(s.isPalindrome2(121));
		System.out.println(s.isPalindrome3(121));
	}

}
