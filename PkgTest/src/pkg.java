// ��άʵ��
 
 public class pkg {
	public static void main(String[] args) {
		//w[]����Ʒ������v[]����Ʒ��ֵ��m���������أ�n����Ʒ������maxValue[][]��״̬
		int[] w = {0, 10, 3, 4, 5}; //��һ����Ϊ0����Ϊ�������ʱ��i��ʾ��i����Ʒ
		int[] v = {0, 3, 4, 6, 7};
		int m = 10;
		int n = 4;
		int[][] maxValue = new int[5][16];
		
		// 01�����㷨
		for (int i=1; i<=n; i++) { //��һ������ �� ��1��
			for (int j=0; j<=m; j++) {
				if (i > 0) {
					maxValue[i][j] = maxValue[i-1][j];
					if (j >= w[i]) {
						maxValue[i][j] = max(maxValue[i][j], maxValue[i-1][j-w[i]] + v[i]);
						//ע��maxValue[i][j]��ʵ����maxValue[i-1][j]   ��Ϊ����ĸ�ֵ
					}
				} else {          //��ʼ����ֻ����һ������
					if (j >= w[1]) {
						maxValue[1][j] = v[1];
					}
				}
			}
		}
		
		System.out.println("4����Ʒ�ڱ�������Ϊ10������µ���ϵ�����ֵΪ��"+maxValue[n][m]);
		System.out.println();
		
		// ��ӡ�����Ĳ�ͬ������
		System.out.print("   " + "\t");
		for (int i=0; i<=m; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		// ��ӡ01�����㷨 �õ���״̬����ֵ
		for (int i=1; i<=n; i++) {
			System.out.print("i="+ i +"\t");
			for (int j=0; j<=m; j++) {
				System.out.print(maxValue[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static int max(int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}
 }
