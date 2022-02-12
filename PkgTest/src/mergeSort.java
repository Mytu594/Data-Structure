import java.util.Arrays;

public class mergeSort {
/*	public void mergeSort(Comparable a[],int left,int right)
	{
		Comparable [] b=new Comparable[a.length];
		if(left<right) {
			//至少有2个元素
			int i=(left+right)/2;
			mergeSort(a,left,i);
			mergeSort(a,i+1,right);
			merge(a,b,left,i,right);
			copy(a,b,left,right);
		}
		display(b);
	}
	public Comparable[] copy(Comparable[] a, Comparable[] b, int left, int right) {
		int i=0;
		for(i=left;i<right-1;i++) {
			a[i]=b[i];
		}
		return a;
	}
	public void merge(Comparable[] c, Comparable[] d, int l,int m, int r) {
		//合并c[1:m]和c[m+1:r]到d[1:r]
		int i=l,j=m+1,k=l;
		while((i<=m)&&(j<=r)) {
			if(c[i].compareTo(c[j])<=0) {
				d[k++]=c[i++];
			}
			else
				d[k++]=c[j++];
		}
		if(i>m) {
			for(int q=j;q<=r;q++) {
				d[k++]=c[q];
			}
		}
		else {
			for(int q=i;q<=m;q++) {
				d[k++]=c[q];
			}
		}
	}
	*/
	public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
	public static void display(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr= {23,5,9,16,30,25,17,18};
		System.out.println("原数组：");
		display(arr);
		mergeSort m=new mergeSort();
		System.out.println("合并排序结果：");
		m.display(m.MergeSort(arr));
	}
}
