package Fibonacci;
public class fibonacii2 {  
    public static long fibonacci2(int n) {  
        long arr[] = new long[n+1];
        arr[0]=0;
        arr[1]=1;           //n����Ϊ0����ΪnΪ0ʱ��arr��СΪ1��arr[1]Խ�硣
        for(int i=2;i<=n;i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
   
    public static void main(String[] args) {
        for(int i=1;i<11;i++) {        
            long num = fibonacci2(i);
            System.out.print(num+" ");
        }
        System.out.println();
        for(int i=1;i<21;i++) {        
            long num = fibonacci2(i);
            System.out.print(num+" ");
        }
        System.out.println();
        for(int i=1;i<41;i++) {        
            long num = fibonacci2(i);
            System.out.print(num+" ");
        }
     }  
}  