package search;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class Sum {
	//暴力法--时间复杂度为O（n^2）
	public static int[] twoSum(int[] nums, int target) {
		int []res = new int[2];
       for(int i = 0;i<nums.length;i++){
       	for(int j = i+1;j<nums.length;j++){
       		if(nums[i] + nums[j] == target){
       			res[0] = i;
       			res[1] = j;
       		}
       	}
       }
       return res; 
    }
	//折半--时间复杂度为O（n）
	public void twoSum1(int[] nums,int target)
	{
		if(nums.length>0)
		{
			int low=0,high=nums.length-1;
			while(low<=high)
			{
				if(nums[low]+nums[high]==target)
				{
					System.out.println(target+"="+nums[low]+"+"+nums[high]);
					low++;
				}
				else if(nums[low]+nums[high]>target)
				{
					high--;
				}
				else
				{
					low++;
				}
			}
		}
	}
	public static int[] twoSum1_1(int[] nums,int target)
	{
		int[] res=new int[2];
		if(nums.length>0)
		{
			int low=0,high=nums.length-1;
			while(low<=high)
			{
				if(nums[low]+nums[high]==target)
				{
					res[0] = low;
	       			res[1] = high;
					low++;
				}
				else if(nums[low]+nums[high]>target)
				{
					high--;
				}
				else
				{
					low++;
				}
			}
		}
		return res;
	}
	//哈希算法--时间复杂度为O（n）
	/*public static int[] twoSum0(int[] nums, int target) {
		
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0;i<nums.length;i++){
			map.put(nums[i], i);
		}
        for(int i = 0;i<nums.length;i++){
        	int tmpt = target - nums[i];
        	if(map.containsKey(tmpt) && map.get(tmpt) != i){
        		return new int[] { i, map.get(tmpt) };
        	}
        }
        throw new IllegalArgumentException("No two sum solution");
         
     }*/
	//三数之和
	
	public static int[] threeSum(int[] nums,int sum) {//O(n^3)
		int[] res = new int[3];
		for(int i = 0;i < nums.length;i++) {
			for(int j = 0;j < nums.length;j++) {
				for(int k = 0;k < nums.length;k++) {
					if(nums[i] + nums[j] + nums[k] == sum) {
						res[0] = i;
						res[1] = j;
						res[2] = k;
						return res;
					}	
				}
			}
		}
		return null;
	}
	public static int[] threeSum1(int[] nums,int sum) {//O(log(n)(n^2))
		Search s = new Search();
		int[] res = new int[3];
		for(int i = 0;i < nums.length;i++) {
			for(int j = 0;j < nums.length;j++) {
				int target = sum - nums[i] - nums[j];
				int index = s.binarySearch(nums, target);
				if(index != -1) {
					res[0] = i;
					res[1] = j;
					res[2] = index;
					return res;
				}
			}
		}
		return null;
	}
	public void threeSum2(int[] nums,int sum)//O(n2)
	{
		for(int i=0;i<nums.length-2;i++)
		{
			int low=i+1,high=nums.length-1;
			while(low<=high)
			{
				if(nums[i]+nums[low]+nums[high]==sum)
				{
					System.out.println(sum+"="+nums[i]+"+"+nums[low]+"+"+nums[high]);
					low++;
				}
				else if(nums[low]+nums[high]>sum-nums[i])
				{
					high--;
				}
				else
				{
					low++;
				}
			}
		}
	}
	public static int[] threeSum2_1(int[] nums,int sum)//O(n2)
	{
		int[] res=new int[3];
		for(int i=0;i<nums.length-2;i++)
		{
			int low=i+1,high=nums.length-1;
			while(low<=high)
			{
				if(nums[i]+nums[low]+nums[high]==sum)
				{
					res[0]=i;
					res[1]=low;
					res[2]=high;
					low++;
				}
				else if(nums[low]+nums[high]>sum-nums[i])
				{
					high--;
				}
				else
				{
					low++;
				}
			}
		}
		return res;
	}
	public void threeSum3(int[] nums,int sum)//O(nlogn)
	{
		int low=0,high=nums.length-1;
		while(low<=high)
		{
			int left=low,right=high;
			int mid=0;
			while(left<=right)
			{
				mid=(left+right)/2;
				if(nums[low]+nums[high]+nums[mid]==sum)
				{
					System.out.println(sum+"="+nums[low]+"+"+nums[high]+"+"+nums[mid]);
					left++;
				}
				else if(nums[mid]>sum-nums[low]+nums[high])
				{
					right=mid-1;
				}
				else
				{
					left=mid+1;
				}
			}
			if(nums[low]+nums[high]+nums[mid]>sum)
			{
				high--;
			}
			else
			{
				low++;
			}
		}
	}
	public static int[] threeSum3_1(int[] nums,int sum)//O(nlogn)
	{
		int[] res=new int[3];
		int low=0,high=nums.length-1;
		while(low<=high)
		{
			int left=low,right=high;
			int mid=0;
			while(left<=right)
			{
				mid=(left+right)/2;
				if(nums[low]+nums[high]+nums[mid]==sum)
				{
					res[0]=low;
					res[1]=high;
					res[2]=mid;
					left++;
				}
				else if(nums[mid]>sum-nums[low]+nums[high])
				{
					right=mid-1;
				}
				else
				{
					left=mid+1;
				}
			}
			if(nums[low]+nums[high]+nums[mid]>sum)
			{
				high--;
			}
			else
			{
				low++;
			}
		}
		return res;
	}
	//四数之和
	//网上代码
	public static ArrayList<ArrayList<Integer>> fourSum0(int[] numbers, int target) {
		Arrays.sort(numbers);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		dfs(ret, new ArrayList<Integer>(), numbers, 0, target);
		return ret;
	}
	private static void dfs(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> condidate, int[] numbers, int curIndex,
			int target) {
	    // 以后求n数和，只要改这里就能解决，比如4改为3，改为5
		if (condidate.size() == 4) {
			int total = getSum(condidate);
			if (total == target) {
				ret.add(new ArrayList<>(condidate));
			}
			return;
		}
		if (curIndex > numbers.length - 1) {
			return;
		}
		for (int i = curIndex; i < numbers.length; i++) {
		    // 如果是一样的数字，直接忽略，否则会有重复的答案
			if (i != curIndex && numbers[i] == numbers[i - 1]) {
				continue;
			}
			condidate.add(numbers[i]);
			// 如果已经大于target，并且当前数字大于0，再循环加下去已经没有意义了，因为只会更大，直接return
			if (getSum(condidate) > target && numbers[i] > 0) {
				if (!condidate.isEmpty()) {
					condidate.remove(condidate.size() - 1);
				}
				return;
			}
			dfs(ret, condidate, numbers, i + 1, target);
			if (!condidate.isEmpty()) {
				condidate.remove(condidate.size() - 1);
			}
		}
	} 
	private static int getSum(ArrayList<Integer> condidate) {
		int total = 0;
		for (Integer num : condidate) {
			total += num;
		}
		return total;
	}
	
	
	public void fourSum1 (int[] nums,int key)//O(n3logn)
	{
		for(int i=0;i<nums.length-3;i++)
		{
			for(int j=i+1;j<nums.length-2;j++)
			{
				for(int k=j+1;k<nums.length-1;k++)
				{
					int low=k+1,high=nums.length-1;
					while(low<=high)
					{
						int mid=(low+high)/2;
						if(nums[i]+nums[k]+nums[j]+nums[mid]==key)
						{
							System.out.println(key+"="+nums[i]+"+"+nums[j]+"+"+nums[k]+"+"+nums[mid]);
							low++;
						}
						else if(nums[mid]>key-nums[i]-nums[k]-nums[j])
						{
							high=mid-1;
						}
						else
						{
							low=mid+1;
						}
					}
				}
			}
		}
	}
	public static int[] fourSum1_1(int[] nums, int key) {//O(n3logn)
		int[] res=new int[4];
		for(int i=0;i<nums.length-3;i++) {
			for(int j=i+1;j<nums.length-2;j++) {
				for(int k=j+1;k<nums.length-1;k++) {
					int low=k+1,high=nums.length-1;
					while(low<=high) {
						int mid=(low+high)>>1;
						if(nums[i]+nums[j]+nums[k]+nums[mid]==key) {
							res[0]=i;
							res[1]=j;
							res[2]=k;
							res[3]=mid;
							low++;
						}
						else if(nums[mid]>key-nums[i]-nums[j]-nums[k]) {
							high=mid-1;
						}
						else
						{
							low=mid+1;
						}
					
					}
				}
			}
		}
		return res;
	}
	
	public void fourSum2(int[] nums,int key)//O(n3)
	{
		for(int k=0;k<nums.length-3;k++)
		{
			for(int i=k+1;i<nums.length-2;i++)
			{
				int low=i+1,high=nums.length-1;
				while(low<=high)
				{
					if(nums[k]+nums[i]+nums[low]+nums[high]==key)
					{
						System.out.println(key+"="+nums[k]+"+"+nums[i]+"+"+nums[low]+"+"+nums[high]);
						low++;
					}
					else if(nums[low]+nums[high]>key-nums[i]-nums[k])
					{
						high--;
					}
					else
					{
						low++;
					}
				}
			}
		}
	}
	public static int[] fourSum2_1(int[] nums,int key)//O(n3)
	{
		int []res = new int[4];
		for(int k=0;k<nums.length-3;k++) {
			for(int i=k+1;i<nums.length-2;i++) {
				int low=i+1,high=nums.length-1;
				while(low<=high)
				{
					if(nums[k]+nums[i]+nums[low]+nums[high]==key)
					{
						res[0] = k;
		       			res[1] = i;
		       			res[2] = low;
		       			res[3] = high;
		       			low++;
					}
					else if(nums[low]+nums[high]>key-nums[i]-nums[k])
					{
						high--;
					}
					else
					{
						low++;
					}
				}
			}
		}
		return res;
	}
	public void fourSum3(int[] nums,int key)//O(n2)
	{
		int low=0,high=nums.length-1;
		while(low<high)
		{
			int left=low+1;
			while(nums[low]+nums[high]>=key)
				high--;
			int right=high-1;
			while(left<right)
			{
				if(nums[low]+nums[high]+nums[left]+nums[right]==key)
				{
					System.out.println(key+"="+nums[low]+"+"+nums[high]+"+"+nums[left]+"+"+nums[right]);
					left++;
					right--;
				}
				else if(nums[left]+nums[right]>key-nums[low]-nums[high])
				{
					right--;
				}
				else
				{
					left++;
				}
			}
			if(nums[low]+nums[high]>key-nums[left]-nums[right+1])
			{
				high--;
			}
			else if(nums[low]+nums[high]<key-nums[left]-nums[right+1])
			{
				low++;
			}
			else {
				high--;
				low++;
			}
		}
	}
	public static int[] fourSum3_1(int[] nums,int key)//O(n2)
	{
		int[] res=new int[4];
		int low=0,high=nums.length-1;
		while(low<high)
		{
			int left=low+1,right=high-1;
			while(nums[low]+nums[high]>key)
				high--;
			while(left<right)
			{
				if(nums[low]+nums[high]+nums[left]+nums[right]==key)
				{
					res[0] = left;
	       			res[1] = right;
	       			res[2] = low;
	       			res[3] = high;
	       			left++;
					right--;
				}
				else if(nums[left]+nums[right]>key-nums[low]-nums[high])
				{
					right--;
				}
				else
				{
					left++;
				}
			}
			if(nums[low]+nums[high]>key-nums[left]-nums[right+1])
			{
				high--;
			}
			else if(nums[low]+nums[high]<key-nums[left]-nums[right+1])
			{
				low++;
			}
			else {
				high--;
				low++;
			}
		}
		return res;
	}
	
	public static void display(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Sum s=new Sum();
		int[] arr = {1,2,3,4,5,6,12,24};
		display(arr);
		Arrays.sort(arr);
		Scanner reader = new Scanner(System.in);
		System.out.println("请输入一个和：");
		int sum = reader.nextInt();
		System.out.println("两数之和O（n^2）为:"+ Arrays.toString(twoSum(arr,sum)));
		System.out.println("两数之和O（n）为:"+ Arrays.toString(twoSum1_1(arr,sum)));
		//System.out.println("两数之和结果为:"+ Arrays.toString(twoSum1(arr,sum)));
		System.out.println("三数之和O(n^3)为:"+ Arrays.toString(threeSum(arr,sum)));
		System.out.println("三数之和O(log(n)(n^2))为:"+ Arrays.toString(threeSum1(arr,sum)));
		System.out.println("三数之和O(n2))为:"+ Arrays.toString(threeSum2_1(arr,sum)));
		System.out.println("三数之和O(nlogn)为:"+ Arrays.toString(threeSum3_1(arr,sum)));
		System.out.println("四数之和结果为:"+ fourSum0(arr,sum));
		System.out.println("四数之和O(n3logn)为:"+ Arrays.toString(fourSum1_1(arr,sum)));
		System.out.println("四数之和O(nlogn)为:"+ Arrays.toString(fourSum2_1(arr,sum)));
		System.out.println("四数之和O(n^2)为:"+ Arrays.toString(fourSum3_1(arr,sum)));
		System.out.println();
		System.out.println("两数之和O(n):");
		s.twoSum1(arr,sum);
		System.out.println("三数之和O(n2):");
		s.threeSum2(arr,sum);
		System.out.println("三数之和O(nlogn):");
		s.threeSum3(arr,sum);
		System.out.println("四数之和O(n3logn):");
		s.fourSum1(arr,sum);
		System.out.println("四数之和O(nlogn):");
		s.fourSum2(arr,sum);
		System.out.println("四数之和O(n2):");
		s.fourSum3(arr,sum);
	}
}
