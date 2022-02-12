
public class week9 {
	public static void mnset(int[] c, int[][] size) {
		int n = c.length-1;
		for(int j = 0; j < c[1]; j++)
			size[1][j] = 0;
		for(int j = c[1]; j <= n; j++)
			size[1][j] = 1;
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < c[i]; j++)
				size[i][j] = size[i-1][j];
			for(int j = c[i]; j <= n; j++)
				size[i][j] = Math.max(size[i-1][j], size[i-1][c[i]-1]+1);
		}
		size[n][n] = Math.max(size[n-1][n], size[n-1][c[n]-1]+1);
		for(int i = 0; i < size.length; i++) {
			for(int j = 0; j <size[i].length; j++) {
				System.out.print(size[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int traceback(int[] c, int[][] size, int[] net) {
		int n = c.length-1;
		int j = n;
		int m = 0;
		for(int i = n; i > 0; i--) {
			if(size[i][j] != size[i-1][j]) {
				net[m++] = i;
				j = c[i] - 1;
			}
		}
		if(j >= c[1])
			net[m++] = 1;
		System.out.println("最大不相交连线分别为：");
	    for(int i = 0; i < m; i++) {
	        System.out.print(net[i]+"——"+c[net[i]]+"\t");
	    }
	    System.out.println();
		return m;
	}
	public static void main(String[] args) {
		int[] c = {0, 6, 8, 12, 2, 1, 4, 5, 3, 11, 7, 10, 9, 13};
		int n = c.length;
		int[][] size = new int[n][n];
		int[] net = new int[n];
		mnset(c, size);
		System.out.println("最大不相交连线数有"+traceback(c, size, net)+"条");
	}
}
