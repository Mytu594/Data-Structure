package paidui;

import java.util.concurrent.TimeUnit;

public class Test {
 
	public static void main(String[] args) {
		//����
		System.out.println("����԰�ӿ�����");
		boolean flag = true;
		CustomerQuene.getCustomerQuene();
		long a = System.currentTimeMillis();
		int servantNum = 4 ;
		for (int i = 0; i < servantNum; i++) {
			ServantThread thread = new ServantThread("��Ϸ" + (i+1));
			thread.start();
		}
		while (flag) {
			long b = System.currentTimeMillis();
			if (b - a > 1 * 20 * 1000 && flag) {
				//����
				flag = false;
				CustomerQuene.getCustomerQuene().close();
				System.out.println("���Ų��ӿ�����");
			}
//			System.out.println("ϵͳ����ʱ�䣺" + (b -a) + "ms");
//			System.out.println("ϵͳ����ʱ�䣺" + ((b -a) * servantNum - ServantThread.getSumServeTime()));
			ServantThread.print();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
 
}