import java.util.Scanner;

public class selectSort {
    public static void selectionSort(int[] a,int n) {
        if(n>a.length) {
            System.out.println("超出数组长度");
            System.exit(1);
        }
        for (int i = 1; i < n; i++) {    //i表示次数，共进行n-1次选择和交换
            int minIndex = i-1;            //用minIndex表示最小元素的下标
            for (int j = i; j < n; j++) {//找到当前排序区间中最小元素的下标
                if(a[minIndex]>a[j]) {//如果后面的元素小于当前最小元素，则用minIndex记录下后面最小元素的下标
                    minIndex = j;
                }
            }
            if(minIndex != i-1) {//如果minIndex==i-1,说明minIndex就是当前排序区间首位元素的下标，因此不用交换
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
//        System.out.println("请输入元素的个数");
//        int n = input.nextInt();
//        int[] a = new int[n];
//        System.out.println("请依次输入元素");
//        for (int i = 0; i < a.length; i++) {
//            a[i] = input.nextInt();
//        }
//        System.out.println("请输入待排元素的个数");
//        int m = input.nextInt();
//        selectionSort(a,m);
    	int num[] = new int[] {25,30,11,7,22,16,18,33,40,55};
		int len = num.length;
        System.out.println("直接选择排序：");
        selectionSort(num,len);
        for (int j = 0; j < num.length; j++) {
            System.out.print(num[j]+" ");
        }
    }
}