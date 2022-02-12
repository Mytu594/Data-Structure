package other;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {
	public static void main(String[] args) {
		int[] arr = {1,22,6,86,71,94,64,11,7,45};
		Arrays.sort(arr);
		Scanner reader = new Scanner(System.in);
		System.out.println("please input a sum£º");
		int sum = reader.nextInt();
		System.out.println("the addends are:"+ Arrays.toString(level3(arr,sum)) );
		
	}
	public static int[] level1(int[] arr,int sum) {//O(n^2)
		int[] result = new int[2];
		for(int i = 0;i < arr.length;i++) {
			for(int j = 0;j < arr.length;j++) {
				if(arr[i] + arr[j] == sum) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return null;
	}
	public static int[] level2(int[] arr,int sum) {//O(nlogn)
		BinarySearchDemo bsd = new BinarySearchDemo();
		int[] result = new int[2];
		for(int i = 0;i < arr.length;i++) {
			int target = sum - arr[i];
			int j = bsd.BinarySearch(arr, 0, arr.length - 1, target); 
			if(j != -1) {
				result[0] = i;
				result[1] = j;
				return result;
			}
		}
		return null;
	}
	public static int[] level3(int[] arr,int sum) {//O(n)
		head_tailSearchDemo htsd = new head_tailSearchDemo();
		return htsd.head_tailSearch(arr, 0, arr.length - 1, sum);
	}
}
