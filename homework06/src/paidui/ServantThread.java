package paidui;

import java.util.concurrent.TimeUnit;
  
public class ServantThread extends Thread{
	//服务顾客数目
	private static int customerNum = 0;
	//总等待时间
	private static int sumWaitTime = 0;
	//总服务时间
	private static int sumServeTime = 0;
	//最大等待时间
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
			//如果顾客线程已经关闭且队列中没有顾客，服务台线程关闭释放
			if (customer == null) {
				if (!CustomerQuene.getCustomerQuene().isFlag()) {
					flag = false;
					print();
				}
				continue;
			}
			long now = System.currentTimeMillis();
			int waitTime = (int) (now - customer.getArriveTime());
			//保存最大的等待时间
			if (waitTime > maxWaitTime) {
				maxWaitTime = waitTime;
			}
			//睡眠时间为顾客的服务时间，代表这段时间在服务顾客
			try {
				TimeUnit.MILLISECONDS.sleep(customer.getServeTime());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.err.println("顾客"+(customerNum+1)+"玩"+name+"耗时" + customer.getServeTime() + ",等待了" + waitTime + "ms");
			customerNum++;
			sumWaitTime += waitTime;
			sumServeTime += customer.getServeTime();
			
		}
	}
	
	public static void print() {
		if (customerNum > 0) {
			System.out.println("--------------------------------------");
			System.out.println("顾客数目：" + customerNum);
			System.out.println("最大等待时间：" + maxWaitTime);
			System.out.println("等待顾客数目：" + CustomerQuene.getCustomerQuene().getWaitCustomerNum());
			System.out.println("最大等待顾客数目：" + CustomerQuene.getCustomerQuene().getMaxWaitNum());
			//输出顾客平均等待时间，保留两位小数
//			System.out.println("顾客平均等待时间：" + ParseUtil.parseDoubleToDouble((sumWaitTime * 1.0 / customerNum), 2) + "ms");
//			System.out.println("顾客平均服务时间：" + ParseUtil.parseDoubleToDouble((sumServeTime * 1.0 / customerNum), 2) + "ms");
			System.out.println("系统总服务时间：" + sumServeTime + "ms");
		}
	}
	public static void main(String[] args) {
		ServantThread No1=new ServantThread("1号");
		ServantThread No2=new ServantThread("2号");
		Thread n1=new Thread(No1);
		Thread n2=new Thread(No2);
		n1.start();
		n2.start();
	
	}
}
