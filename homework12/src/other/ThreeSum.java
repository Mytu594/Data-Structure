package other;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum {
	public static void main(String[] args) {
		int[] arr = {1,22,6,86,71,94,64,11,7,45};//1,6,7,11,22,45,64,71,86,94
		Arrays.sort(arr);
		Scanner reader = new Scanner(System.in);
		System.out.println("please input a sum£º");
		int sum = reader.nextInt();
		System.out.println("the addends are:"+ Arrays.toString(level4(arr,sum)));
	}
	public static int[] level1(int[] arr,int sum) {//O(n^3)
		int[] result = new int[3];
		for(int i = 0;i < arr.length;i++) {
			for(int j = 0;j < arr.length;j++) {
				for(int k = 0;k < arr.length;k++) {
					if(arr[i] + arr[j] + arr[k] == sum) {
						result[0] = i;
						result[1] = j;
						result[2] = k;
						return result;
					}	
				}
			}
		}
		return null;
	}
	public static int[] level2(int[] arr,int sum) {//O(log(n)(n^2))
		BinarySearchDemo bsd = new BinarySearchDemo();
		int[] result = new int[3];
		for(int i = 0;i < arr.length;i++) {
			for(int j = 0;j < arr.length;j++) {
				int target = sum - arr[i] - arr[j];
				int k = bsd.BinarySearch(arr, 0, arr.length - 1, target);
				if(k != -1) {
					result[0] = i;
					result[1] = j;
					result[2] = k;
					return result;
				}
			}
		}
		return null;
	}
	public static int[] level3(int[] arr,int sum) {//O(n^2)
		int[] result = new int[3];
		head_tailSearchDemo htsd = new head_tailSearchDemo();
		for(int i = 0;i < arr.length;i++) {
			int target = sum - arr[i];
			int[] temp = htsd.head_tailSearch(arr, 0, arr.length - 1, target);
			if(temp != null) {
				result[0] = i;
				result[1] = temp[0];
				result[2] = temp[1];
				return result;
			}
		}
		return null;
	}
	public static int[] level4(int[] arr,int sum) {//O(nlogn)
		BinarySearchDemo bsd = new BinarySearchDemo();
		int lo = 0;
		int hi = arr.length - 1;
		int[] result = new int[3];
		while(lo <= hi) {
			int target = sum - arr[lo] - arr[hi];
			int temp = bsd.BinarySearch(arr, lo, hi, target);
			if(temp != -1) {
				result[0] = lo;
				result[1] = temp;
				result[2] = hi;
				return result;
			}
			else {
				if(arr[lo] + arr[hi] + arr[hi] > sum)
					hi--;
				else if(arr[lo] + arr[hi] + arr[lo] < sum)
					lo++;
			}
		}
		return null;
	}
}
