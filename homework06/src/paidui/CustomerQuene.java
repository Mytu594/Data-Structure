package paidui;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
  
public class CustomerQuene {
	//等待顾客队列
	private LinkedList<CustomerBean> customers = new LinkedList<CustomerBean>();
	//下一个顾客过来最短时间
	private int minTime = 0;
	//下一个顾客过来最大时间
	private int maxTime = 1 * 1000;
	//来顾客的概率
	private double rate = 0.5;
	//标识是否继续产生顾客
	private boolean flag = true;
	//最大排队人数
	private int maxWaitNum = 7;
	
	public int getMaxWaitNum() {
		return maxWaitNum;
	}
	
	public boolean isFlag() {
		return flag;
	}
 
	/**
	 * @return
	 * @Description: 获取排在队头的顾客
	 */
	public synchronized CustomerBean getCustomerBean() {
		if (customers == null || customers.size() < 1) {
			return null;
		}
		return customers.removeFirst();
	}
	
	public void close() {
		if (flag) {
			flag = false;
		}
	}
	
	/**
	 * @return
	 * @Description: 获取等待顾客数量
	 */
	public int getWaitCustomerNum() {
		return customers.size();
	}
	
	/**
	 *@Description: 生成顾客线程 
	 */
	private class CustomerThread extends Thread {
		private CustomerThread(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			while (flag) {
				//队尾添加一个新顾客
				if (Math.random() < rate) {
					customers.addLast(new CustomerBean());
					if (maxWaitNum < customers.size()) {
						maxWaitNum = customers.size();
						break;
					}
				}
				int sleepTime = (int) (Math.random() * (maxTime - minTime) + minTime);
				try {
					TimeUnit.MILLISECONDS.sleep(sleepTime);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
 
	//单例模式开始
	private static class CustomerQueneDao {
		private static CustomerQuene customerQuene = new CustomerQuene();
	}
	private CustomerQuene() {
		CustomerThread customerThread = new CustomerThread("顾客产生线程");
		customerThread.start();
	}
	public static CustomerQuene getCustomerQuene() {
		return CustomerQueneDao.customerQuene;
	}
	//单例模式结束
	
	public int getMinTime() {
		return minTime;
	}
	
	public void setMinTime(int minTime) {
		this.minTime = minTime;
	}
	
	public int getMaxTime() {
		return maxTime;
	}
	
	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}
 
	public double getRate() {
		return rate;
	}
 
	public void setRate(double rate) {
		this.rate = rate;
	}
}
