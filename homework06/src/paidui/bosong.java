package paidui;

public class bosong {
	private static int getPossionVariable(double lamda) {
		int x = 0;
		double y = Math.random(), cdf = getPossionProbability(x, lamda);
		while (cdf < y) {
			x++;
			cdf += getPossionProbability(x, lamda);
		}
		return x;
	}

	private static double getPossionProbability(int k, double lamda) {
		double c = Math.exp(-lamda), sum = 1;
		for (int i = 1; i <= k; i++) {
			sum *= lamda / i;
		}
		return sum * c;
	}
	public static void main(String[] args)throws Exception{
		System.out.println(getPossionProbability(100,1));
		System.out.println(getPossionProbability(100,4));
		System.out.println(getPossionProbability(100,10));
		System.out.println(getPossionVariable(1));
		System.out.println(getPossionVariable(4));
		System.out.println(getPossionVariable(10));
	}
}
