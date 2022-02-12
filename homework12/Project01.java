package week04;

public class Project01 {
	
	public static int MatrixChain(int []p, int [][]m, int [][]s) {
		int n = p.length - 1;
		for(int i = 1; i <= n; i++) m[i][i] = 0;
		for(int r = 2; r <= n; r++) {
			for(int i = 1; i <= n - r + 1; i++) {
				int j = i + r - 1;
				m[i][j] = m[i][i] + m[i + 1][j] + p[i-1]*p[i]*p[j];
				s[i][j] = i;
				for(int k = i + 1; k < j; k++) {
					int t = m[i][k] + m[k + 1][j] + p[i - 1]*p[k]*p[j];
					if (t < m[i][j]) {
						m[i][j] = t;
						s[i][j] = k;
					}
				}
			}
		}
		return m[1][n];
	}
	
	public static void traceback(int[][] s, int i, int j) {
		if(i == j) 
			return;
		traceback(s, i, s[i][j]);
		traceback(s,s[i][j] + 1, j);
		System.out.println("Mutiply A" + i + "," + s[i][j] + "and A" + (s[i][j] + 1) + "," + j);
	}
	
	public static void main(String[] args) {
		int[] p = {5, 200, 2, 100, 30, 200};
	    int n = 5;
		int arrayA[][]=new int[n+1][n+1];
	    int arrayB[][]=new int[n+1][n+1];
	    int res=MatrixChain(p, arrayA, arrayB);
	       System.out.println("最少乘法次数:"+res);
		traceback(arrayB, 1, n);
	}
}
