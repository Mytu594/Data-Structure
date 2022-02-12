package search;

import java.util.Scanner;

public class Search {
	//˳���ѯ
	public static int seqSearch(int[] a, int key){
		for (int i = 0, length = a.length; i < length; i++) {
	        if (a[i] == key)
	            return i;
	    }
	    return -1;
	}
	//˳���ѯ--ʹ��һ���ڱ�����ȥ��ÿ�ζ�ҪԽ����ж�
	public static int seqSearch1(int[] a, int key) {
	    int index = a.length - 1;
	    if (key == a[index])
	        return index;
	    a[index] = key;
	    int i = 0;
	    while (a[i++] != key) ;
	    return i == index + 1 ? -1 : i - 1;
	}
	//�����ѯ
	public static int revSearch(int[] a, int key) {
		int len=a.length;
	    for (int i = a.length - 1; i >= 0; i--) {
	        if (a[i] == key)
	        {
	            return i;
	        }
	    }
	    return -1;
	}
	//�����ѯ--ʹ��һ���ڱ�����ȥ��ÿ�ζ�ҪԽ����ж�
	public static int revSearch1(int[] a, int key) {
	    if (key == a[0])
	        return 0;
	    int index = a.length - 1;
	    a[0] = key;
	    while (a[index--] != key) ;
	    return index == -1 ? index : index == 0 ? 1 : index + 1;
	}
	//���ַ���ѯ
	public static int binarySearch(int[] array, int value) {
	    int low = 0;
	    int high = array.length - 1;
	    while (low <= high) {
	        //int middle = (low + high) >> 1;
	    	int middle = low + ((high - low) >> 1);
	        if (value == array[middle]) {
	            return middle;
	        }
	        if (value > array[middle]) {
	            low = middle + 1;
	        }
	        if (value < array[middle]) {
	            high = middle - 1;
	        }
	    }
	    return -1;
	}
	//�ǵݹ�
	public static int binarySearch1(int[] array, int value) {
	    int low = 0;
	    int high = array.length - 1;
	    return searchmy(array, low, high, value);
	}
	private static int searchmy(int array[], int low, int high, int value) {
	    if (low > high)
	        return -1;
	    int mid = low + ((high - low) >> 1);
	    if (value == array[mid])
	        return mid;
	    if (value < array[mid])
	        return searchmy(array, low, mid - 1, value);
	    return searchmy(array, mid + 1, high, value);
	}
	public static void display(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Search s=new Search();
		Scanner reader=new Scanner(System.in);
		int[] arr = {1,4,7,10,13,15,21,25};
		int len=arr.length;
		s.display(arr);
		System.out.println("������������ҵ���:");
		int num=reader.nextInt();
		int index1 = seqSearch(arr,num);
		System.out.println("˳��1��ѯ���:"+index1);
		int index2 = seqSearch1(arr,num);
		System.out.println("˳��2��ѯ���:"+index2);
//		int index3 = revSearch(arr,num);
//		System.out.println("����1��ѯ���:"+index3);
//		int index4 = revSearch1(arr,num);
//		System.out.println("����2��ѯ���:"+index4);
		int index5 = binarySearch(arr,num);
		System.out.println("�۰��ѯ���:"+index5);
		int index6 = binarySearch1(arr,num);
		System.out.println("�ǵݹ��۰��ѯ���:"+index6);
		
	}
}
