package paidui;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
  
public class CustomerQuene {
	//�ȴ��˿Ͷ���
	private LinkedList<CustomerBean> customers = new LinkedList<CustomerBean>();
	//��һ���˿͹������ʱ��
	private int minTime = 0;
	//��һ���˿͹������ʱ��
	private int maxTime = 1 * 1000;
	//���˿͵ĸ���
	private double rate = 0.5;
	//��ʶ�Ƿ���������˿�
	private boolean flag = true;
	//����Ŷ�����
	private int maxWaitNum = 7;
	
	public int getMaxWaitNum() {
		return maxWaitNum;
	}
	
	public boolean isFlag() {
		return flag;
	}
 
	/**
	 * @return
	 * @Description: ��ȡ���ڶ�ͷ�Ĺ˿�
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
	 * @Description: ��ȡ�ȴ��˿�����
	 */
	public int getWaitCustomerNum() {
		return customers.size();
	}
	
	/**
	 *@Description: ���ɹ˿��߳� 
	 */
	private class CustomerThread extends Thread {
		private CustomerThread(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			while (flag) {
				//��β���һ���¹˿�
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
 
	//����ģʽ��ʼ
	private static class CustomerQueneDao {
		private static CustomerQuene customerQuene = new CustomerQuene();
	}
	private CustomerQuene() {
		CustomerThread customerThread = new CustomerThread("�˿Ͳ����߳�");
		customerThread.start();
	}
	public static CustomerQuene getCustomerQuene() {
		return CustomerQueneDao.customerQuene;
	}
	//����ģʽ����
	
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
