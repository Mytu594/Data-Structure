// ��������ʵ��
 
public class PkgTest {
	public static void main(String[] args) {
		int[] w = {0,10, 3, 4, 5};
		int[] v = {0,3, 4, 6, 7};
		int m = 10;
		int n = 4;
		int k = 0;  // k��������ָ�������ĳһ�У���������֮һ��,���������±�i��ָ�������������
		int[][] maxValue = new int[2][16];
		
		for (int i=1; i<=n; i++) { 
			for (int j=0; j<=m; j++) {
				if (i > 1) {
					k = i & 1; // k = i % 2  ��ù������鵱ǰ���� k
					maxValue[k][j] = maxValue[k^1][j]; // k ^ 1  ��ù��������߼��ϵġ���һ�С�
					if (j >= w[i]) {
						maxValue[k][j] = max(maxValue[k][j], maxValue[k^1][j-w[i]] + v[i]);
					}
				} else {  
					if (j >= w[1]) {
						maxValue[1][j] = v[0];
					}
				}
			}
		}
		
		System.out.println("4����Ʒ�ڱ�������Ϊ10������µ���ϵ�����ֵΪ��"+maxValue[k][m]);
		System.out.println();
		
		System.out.print("i=0"+"\t");
		for (int i=0; i<=m; i++) {
			System.out.print(maxValue[1][i] + "\t");
		}
		System.out.print("\ni=1"+"\t");
		for (int i=0; i<=m; i++) {
			System.out.print(maxValue[0][i] + "\t");
		}
	}
	
	public static int max(int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}
}