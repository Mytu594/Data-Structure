package horse;

public class d_1 {

	 public static int[] rotate(int[] nums) {
		int n = nums.length;
        int k=(int)(1+Math.random()*(5-1+1));
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        return nums;     
    }
	public static void reverse(int[] nums1, int start, int end) {
        while (start < end) {
            int temp = nums1[start];
            nums1[start++] = nums1[end];
            nums1[end--] = temp;
        }
    }
	public static void main(String[] args) {
		 
        int[] rotateArray = {3, 4, 5, 1, 2};
        int r=(int)(1+Math.random()*(100-1+1));
        int[] Array=rotate(rotateArray);
		for(int i=0; i<r; i++) {
			//将数组的每一个元素向后移
			int temp = Array[Array.length-1];
			for(int j=Array.length-1; j>0; j--) {
				Array[j] = Array[j-1];
			}
			Array[0] = temp;
			for(int k=0; k<Array.length; k++) {
				System.out.print(Array[k]+" ");
			}
			System.out.println();
		}
     }  
}
