/**
 * @author lxh
 *
 */
public class binarySearch {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] array = new int[] {1,8,12,15,16,21,30,35,39};
		int result = binarySearch(array,20,array.length);
		if(result == -1)
			System.out.println("�޴�Ԫ��");
		else
			System.out.println("��Ԫ����"+result+"λ��");
	}
	public static int binarySearch(int[] a,int x,int n) {
		int left = 0;
		int right = n-1;
		while(left <= right) {
			int middle = (left + right)/2;
			if(x == a[middle])
				return middle;
			if(x > a[middle])
				left = middle + 1;
			else
				right = middle - 1;
		}
		return -1;
	}
}
