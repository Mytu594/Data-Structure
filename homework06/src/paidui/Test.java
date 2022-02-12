package paidui;

import java.util.concurrent.TimeUnit;

public class Test {
 
	public static void main(String[] args) {
		//开门
		System.out.println("游乐园接客啦！");
		boolean flag = true;
		CustomerQuene.getCustomerQuene();
		long a = System.currentTimeMillis();
		int servantNum = 4 ;
		for (int i = 0; i < servantNum; i++) {
			ServantThread thread = new ServantThread("游戏" + (i+1));
			thread.start();
		}
		while (flag) {
			long b = System.currentTimeMillis();
			if (b - a > 1 * 20 * 1000 && flag) {
				//关门
				flag = false;
				CustomerQuene.getCustomerQuene().close();
				System.out.println("关门不接客啦！");
			}
//			System.out.println("系统运行时间：" + (b -a) + "ms");
//			System.out.println("系统空闲时间：" + ((b -a) * servantNum - ServantThread.getSumServeTime()));
			ServantThread.print();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
 
}