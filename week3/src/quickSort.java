
public class quickSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int q = partition(a,p,r);
		quickSort(a,p,q-1);
		quickSort(a,p+1,r);
	}
	public static int partition(int[] a,int p,int r) {
		int i = p,j = r;
		int x = a[i];
		int temp;
		while(true) {
			while((a[i] < x) && i < r)
				i++;
			while(a[j] > x)
				j--;
			if(i >= j)
				break;
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		a[p] = a[j];
		a[j] = x;
		return j;
	}
}
