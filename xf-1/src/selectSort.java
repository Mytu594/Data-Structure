import java.util.Scanner;

public class selectSort {
    public static void selectionSort(int[] a,int n) {
        if(n>a.length) {
            System.out.println("�������鳤��");
            System.exit(1);
        }
        for (int i = 1; i < n; i++) {    //i��ʾ������������n-1��ѡ��ͽ���
            int minIndex = i-1;            //��minIndex��ʾ��СԪ�ص��±�
            for (int j = i; j < n; j++) {//�ҵ���ǰ������������СԪ�ص��±�
                if(a[minIndex]>a[j]) {//��������Ԫ��С�ڵ�ǰ��СԪ�أ�����minIndex��¼�º�����СԪ�ص��±�
                    minIndex = j;
                }
            }
            if(minIndex != i-1) {//���minIndex==i-1,˵��minIndex���ǵ�ǰ����������λԪ�ص��±꣬��˲��ý���
                int temp = a[i-1];
                a[i-1] = a[minIndex];
                a[minIndex] = temp;
            }
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("������Ԫ�صĸ���");
//        int n = input.nextInt();
//        int[] a = new int[n];
//        System.out.println("����������Ԫ��");
//        for (int i = 0; i < a.length; i++) {
//            a[i] = input.nextInt();
//        }
//        System.out.println("���������Ԫ�صĸ���");
//        int m = input.nextInt();
//        selectionSort(a,m);
    	int num[] = new int[] {25,30,11,7,22,16,18,33,40,55};
		int len = num.length;
        System.out.println("ֱ��ѡ������");
        selectionSort(num,len);
        for (int j = 0; j < num.length; j++) {
            System.out.print(num[j]+" ");
        }
    }
}