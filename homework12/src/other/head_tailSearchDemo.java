package other;

public class head_tailSearchDemo {
	public int[] head_tailSearch(int[] arr,int lo,int hi,int target) {
		boolean flag = false;
		int[] result = new int[2];
		while(lo <= hi) {
			if(arr[lo] + arr[hi] > target)
				hi--;
			else if(arr[lo] + arr[hi] < target)
				lo++;
			else {
				flag = true;
				result[0] = lo;
				result[1] = hi;
				break;
			}
		}
		if(flag)
			return result;
		else
			return null;
	}
}
