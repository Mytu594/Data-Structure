// 二维实现
 
 public class pkg {
	public static void main(String[] args) {
		//w[]：物品重量，v[]：物品价值，m：背包承重，n：物品个数，maxValue[][]：状态
		int[] w = {0, 10, 3, 4, 5}; //第一个数为0，是为了让输出时，i表示有i个物品
		int[] v = {0, 3, 4, 6, 7};
		int m = 10;
		int n = 4;
		int[][] maxValue = new int[5][16];
		
		// 01背包算法
		for (int i=1; i<=n; i++) { //第一个物体 是 第1行
			for (int j=0; j<=m; j++) {
				if (i > 0) {
					maxValue[i][j] = maxValue[i-1][j];
					if (j >= w[i]) {
						maxValue[i][j] = max(maxValue[i][j], maxValue[i-1][j-w[i]] + v[i]);
						//注：maxValue[i][j]其实就是maxValue[i-1][j]   因为上面的赋值
					}
				} else {          //初始化，只考虑一个物体
					if (j >= w[1]) {
						maxValue[1][j] = v[1];
					}
				}
			}
		}
		
		System.out.println("4个物品在背包承重为10的情况下的组合的最大价值为："+maxValue[n][m]);
		System.out.println();
		
		// 打印背包的不同承重量
		System.out.print("   " + "\t");
		for (int i=0; i<=m; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		// 打印01背包算法 得到的状态矩阵值
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
