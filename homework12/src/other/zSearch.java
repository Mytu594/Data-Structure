package other;

import java.util.Arrays;
import java.util.Scanner;

import search.Search;

public class zSearch {
	//a+b=k
	public static void n2_2(int[] array,int key)
	{
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=i+1;j<array.length;j++)
			{
				if(array[i]+array[j]==key)
					System.out.println(key+"="+array[i]+"+"+array[j]);
			}
		}
	}
	public void n_2(int[] array,int key)
	{
		if(array.length>0)
		{
			int low=0,high=array.length-1;
			while(low<=high)
			{
				if(array[low]+array[high]==key)
				{
					System.out.println(key+"="+array[low]+"+"+array[high]);
					low++;
				}
				else if(array[low]+array[high]>key)
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
	//a+b+c=k
	public void n3_3(int[] array,int key)
	{
		for(int i=0;i<array.length-2;i++)
		{
			for(int j=i+1;j<array.length-1;j++)
			{
				for(int k=j+1;k<array.length;k++)
				{
					if(array[i]+array[j]+array[k]==key)
						System.out.println(key+"="+array[i]+"+"+array[j]+"+"+array[k]);
				}
			}
		}
	}
	public void n2logn_3(int[] array,int key)
	{
		for(int i=0;i<array.length-2;i++)
		{
			for(int j=i+1;j<array.length-1;j++)
			{
				int low=j+1,high=array.length-1;
				while(low<=high)
				{
					int mid=(low+high)/2;
					if(array[i]+array[j]+array[mid]==key)
					{
						System.out.println(key+"="+array[i]+"+"+array[j]+"+"+array[mid]);
						low++;
					}
					else if(array[mid]>key-array[i]-array[j])
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
	public void n2_3(int[] array,int key)
	{
		for(int i=0;i<array.length-2;i++)
		{
			int low=i+1,high=array.length-1;
			while(low<=high)
			{
				if(array[i]+array[low]+array[high]==key)
				{
					System.out.println(key+"="+array[i]+"+"+array[low]+"+"+array[high]);
					low++;
				}
				else if(array[low]+array[high]>key-array[i])
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
	public void nlogn_3(int[] array,int key)
	{
		int low=0,high=array.length-1;
		while(low<=high)
		{
			int left=low,right=high;
			int mid=0;
			while(left<=right)
			{
				mid=(left+right)/2;
				if(array[low]+array[high]+array[mid]==key)
				{
					System.out.println(key+"="+array[low]+"+"+array[high]+"+"+array[mid]);
					left++;
				}
				else if(array[mid]>key-array[low]+array[high])
				{
					right=mid-1;
				}
				else
				{
					left=mid+1;
				}
			}
			if(array[low]+array[high]+array[mid]>key)
			{
				high--;
			}
			else
			{
				low++;
			}
		}
	}
	//a+b+c+d=k
	public void n3logn_4(int[] array,int key)
	{
		for(int i=0;i<array.length-3;i++)
		{
			for(int j=i+1;j<array.length-2;j++)
			{
				for(int k=j+1;k<array.length-1;k++)
				{
					int low=k+1,high=array.length-1;
					while(low<=high)
					{
						int mid=(low+high)/2;
						if(array[i]+array[k]+array[j]+array[mid]==key)
						{
							System.out.println(key+"="+array[i]+"+"+array[j]+"+"+array[k]+"+"+array[mid]);
							low++;
						}
						else if(array[mid]>key-array[i]-array[k]-array[j])
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
	public void n3_4(int[] array,int key)
	{
		for(int k=0;k<array.length-3;k++)
		{
			for(int i=k+1;i<array.length-2;i++)
			{
				int low=i+1,high=array.length-1;
				while(low<=high)
				{
					if(array[k]+array[i]+array[low]+array[high]==key)
					{
						System.out.println(key+"="+array[k]+"+"+array[i]+"+"+array[low]+"+"+array[high]);
						low++;
					}
					else if(array[low]+array[high]>key-array[i]-array[k])
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
	public void n2_4(int[] array,int key)
	{
		int low=0,high=array.length-1;
		while(low<=high)
		{
			int left=low+1,right=high-1;
			while(left<=right)
			{
				if(array[low]+array[high]+array[left]+array[right]==key)
				{
					System.out.println(key+"="+array[low]+"+"+array[high]+"+"+array[low]+"+"+array[high]);
					low++;
				}
				else if(array[left]+array[right]>key-array[low]-array[high])
				{
					right--;
				}
				else
				{
					left++;
				}
			}
			if(array[low]+array[high]+array[left]+array[right]>key)
			{
				high--;
			}
			else
			{
				low++;
			}
		}
	}
	public static void display(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		zSearch s=new zSearch();
		Scanner reader=new Scanner(System.in);
		int[] arr = {1,4,7,10,13,15,21,25};
		s.display(arr);
		System.out.println("请输入你想查找的数:");
		int num=reader.nextInt();
		s.n2_2(arr,num);
		s.n_2(arr,num);
		s.n3_3(arr,num);
		s.n2logn_3(arr,num);
		s.n2_3(arr,num);
		s.nlogn_3(arr,num);
		s.n3logn_4(arr,num);
		s.n3_4(arr,num);
		s.n2_4(arr,num);
	}

}
