package paidui; 

public class CustomerBean {
	//最小服务时间
	private static int minServeTime = 3 * 1000;
	//最大服务时间
	private static int maxServeTime = 15 * 1000;
	//顾客达到时间
	private long arriveTime;
	//顾客需要服务耗时
	private int serveTime;
	
	public CustomerBean() {
		//设置到达时间
		arriveTime = System.currentTimeMillis();
		//随机设置顾客的服务时间
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
