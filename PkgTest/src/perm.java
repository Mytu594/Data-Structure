
public class perm {
	public void perm(int[] li,int k,int m)
	{
		//����list[k:m]����������
		if(k==m) {
			//ֻʣ��һ��Ԫ��
			for(int i=0;i<=m;i++) {
				System.out.print(li[i]);
			}
			System.out.println();
		}
		else
			for(int i=k;i<=m;i++) {
				swap(li,k,i);
				perm(li,k+1,m);
				swap(li,k,i);
			}
	}

	private static void swap(int[] list, int m, int n) {
		int temp = (int) list[m];
		list[m] = list[n];
		list[n] = temp;
	}
	public static void main(String[] args) {
		int[] li = {1,2,3};
		perm p = new perm(); //���ȫ����������static,���Բ���new����
		p.perm(li, 0, li.length-1);
	}
}
