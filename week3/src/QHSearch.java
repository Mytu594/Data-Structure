
public class QHSearch {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = new int[] {1,8,12,15,16,21,30,35,39};
		int[] res = binarySearch(arr,10,arr.length);
		int l = 0,r = 0;
		if(res[0] == -1) {
			l = res[1] - 1;
			r = res[1];
			System.out.println("�޴�Ԫ��");
			System.out.println("С��x�����Ԫ��λ�ã�"+l);
			System.out.println("����x����СԪ��λ�ã�"+r);
		}
		else
			System.out.println("��Ԫ����"+res[0]+"λ��");
	}
	public static int[] binarySearch(int[] a,int x,int n) {
		int left = 0;
		int right = n-1;
		int[] res = new int[] {-1,0};
		while(left <= right) {
			int middle = (left +right)/2;
			if(x == a[middle])
				res[0] = middle;
			if(x > a[middle])
				left = middle +1;
			else
				right = middle - 1;
		}
		return res;
	}
}
