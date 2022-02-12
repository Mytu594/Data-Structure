package paidui; 

public class CustomerBean {
	//��С����ʱ��
	private static int minServeTime = 3 * 1000;
	//������ʱ��
	private static int maxServeTime = 15 * 1000;
	//�˿ʹﵽʱ��
	private long arriveTime;
	//�˿���Ҫ�����ʱ
	private int serveTime;
	
	public CustomerBean() {
		//���õ���ʱ��
		arriveTime = System.currentTimeMillis();
		//������ù˿͵ķ���ʱ��
		serveTime = (int) (Math.random() * (maxServeTime - minServeTime) + minServeTime);
	}
 
	public static int getMinServeTime() {
		return minServeTime;
	}
 
	public static void setMinServeTime(int minServeTime) {
		CustomerBean.minServeTime = minServeTime;
	}
 
	public static int getMaxServeTime() {
		return maxServeTime;
	}
 
	public static void setMaxServeTime(int maxServeTime) {
		CustomerBean.maxServeTime = maxServeTime;
	}
 
	public long getArriveTime() {
		return arriveTime;
	}
 
	public void setArriveTime(long arriveTime) {
		this.arriveTime = arriveTime;
	}
 
	public int getServeTime() {
		return serveTime;
	}
 
	public void setServeTime(int serveTime) {
		this.serveTime = serveTime;
	}
}
