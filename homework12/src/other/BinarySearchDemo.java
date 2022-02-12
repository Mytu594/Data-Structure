package other;

public class BinarySearchDemo {
	public int BinarySearch(int[] arr,int lo,int hi,int target) {
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			if(arr[mid] > target) {
				hi = mid - 1;
				BinarySearch(arr, lo, hi, target);
			}
			else if(arr[mid] < target) {
				lo = mid + 1;
				BinarySearch(arr, lo, hi, target);
			}
			else {
				return mid;
			}
		}
		return -1;
	}
}