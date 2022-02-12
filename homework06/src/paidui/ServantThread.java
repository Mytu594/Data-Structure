package paidui;

import java.util.concurrent.TimeUnit;
  
public class ServantThread extends Thread{
	//����˿���Ŀ
	private static int customerNum = 0;
	//�ܵȴ�ʱ��
	private static int sumWaitTime = 0;
	//�ܷ���ʱ��
	private static int sumServeTime = 0;
	//���ȴ�ʱ��
	private static int maxWaitTime = 0;
	private boolean flag = false;
	private String name;
	
	public ServantThread(String name) {
		super(name);
		this.name = name;
	}
	
	public static int getMaxWaitTime() {
		return maxWaitTime;
	}
 
	public static int getSumServeTime() {
		return sumServeTime;
	}
 
	@Override
	public void run() {
		flag = true;
		while (flag) {
			CustomerBean customer = CustomerQuene.getCustomerQuene().getCustomerBean();
			//����˿��߳��Ѿ��ر��Ҷ�����û�й˿ͣ�����̨�̹߳ر��ͷ�
			if (customer == null) {
				if (!CustomerQuene.getCustomerQuene().isFlag()) {
					flag = false;
					print();
				}
				continue;
			}
			long now = System.currentTimeMillis();
			int waitTime = (int) (now - customer.getArriveTime());
			//�������ĵȴ�ʱ��
			if (waitTime > maxWaitTime) {
				maxWaitTime = waitTime;
			}
			//˯��ʱ��Ϊ�˿͵ķ���ʱ�䣬�������ʱ���ڷ���˿�
			try {
				TimeUnit.MILLISECONDS.sleep(customer.getServeTime());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.err.println("�˿�"+(customerNum+1)+"��"+name+"��ʱ" + customer.getServeTime() + ",�ȴ���" + waitTime + "ms");
			customerNum++;
			sumWaitTime += waitTime;
			sumServeTime += customer.getServeTime();
			
		}
	}
	
	public static void print() {
		if (customerNum > 0) {
			System.out.println("--------------------------------------");
			System.out.println("�˿���Ŀ��" + customerNum);
			System.out.println("���ȴ�ʱ�䣺" + maxWaitTime);
			System.out.println("�ȴ��˿���Ŀ��" + CustomerQuene.getCustomerQuene().getWaitCustomerNum());
			System.out.println("���ȴ��˿���Ŀ��" + CustomerQuene.getCustomerQuene().getMaxWaitNum());
			//����˿�ƽ���ȴ�ʱ�䣬������λС��
//			System.out.println("�˿�ƽ���ȴ�ʱ�䣺" + ParseUtil.parseDoubleToDouble((sumWaitTime * 1.0 / customerNum), 2) + "ms");
//			System.out.println("�˿�ƽ������ʱ�䣺" + ParseUtil.parseDoubleToDouble((sumServeTime * 1.0 / customerNum), 2) + "ms");
			System.out.println("ϵͳ�ܷ���ʱ�䣺" + sumServeTime + "ms");
		}
	}
	public static void main(String[] args) {
		ServantThread No1=new ServantThread("1��");
		ServantThread No2=new ServantThread("2��");
		Thread n1=new Thread(No1);
		Thread n2=new Thread(No2);
		n1.start();
		n2.start();
	
	}
}
