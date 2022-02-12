package Sorting;

public class sorting1 {
	public void dbouble(int[] array)
	{
		int l=0,r=array.length;
		boolean judge=true;
		for(int i=0;i<array.length-1;i++) {
			judge=true;
			for(int j=i;j<r-1;j++) {
				int temp;
				int num=array[j+1];
				if(array[j]>num) {
					temp=array[j];
					array[j]=num;
					array[j+1]=temp;
					judge=false;
					if(array[l]>num)
					{
						temp=array[l];
						array[l]=num;
						array[j]=temp;
					}
				}
				if(judge)
					break;
			}
			r--;
			l++;
		}
		display(array);
		System.out.println();
	}
	public static void dbubbleSort(int[] arr) {
		int low,high,index;
		low = index = 0;
		high = arr.length-1;
		while (low<high)
		{
		//最大往尾端
			for(int i = low;i<high;i++)
			{
				if(arr[i]>arr[i+1])
				{
					Swap(arr[i],arr[i+1]);
					index = i;
				}
			}
			high = index;
			//最小往前端
			for(int i = high;i>low;i--)
			{
				if(arr[i]<arr[i-1])
				{
					Swap(arr[i],arr[i-1]);
					index = i;
				}
			}
			low = index;
		}
	}
	public static void Swap( int i, int j)
	{
		int t = i;
		i=j;
		j=t;
	}
	public static void display(int[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	}
	public static void main(String[] args) {
		sorting1 s=new sorting1();
		int[] li= {1,5,65,25,4,87,36,65,49,20,10,47,60};
//		s.dbouble(li);
		s.dbubbleSort(li);
		display(li);
	}
}
