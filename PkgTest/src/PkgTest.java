// 滚动数组实现
 
public class PkgTest {
	public static void main(String[] args) {
		int[] w = {0,10, 3, 4, 5};
		int[] v = {0,3, 4, 6, 7};
		int m = 10;
		int n = 4;
		int k = 0;  // k的作用是指向数组的某一行（两行其中之一）,不能再用下标i来指定数组的行数了
		int[][] maxValue = new int[2][16];
		
		for (int i=1; i<=n; i++) { 
			for (int j=0; j<=m; j++) {
				if (i > 1) {
					k = i & 1; // k = i % 2  获得滚动数组当前索引 k
					maxValue[k][j] = maxValue[k^1][j]; // k ^ 1  获得滚动数组逻辑上的“上一行”
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
		
		System.out.println("4个物品在背包承重为10的情况下的组合的最大价值为："+maxValue[k][m]);
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