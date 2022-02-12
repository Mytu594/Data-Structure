package chicken;

public class wan_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis(); 
		int cock,hen,chicken;
		for(cock=1;cock<=2000;cock++) {
			for(hen=1;hen<=5000;hen++) {
				chicken=10000-cock-hen;
				if(5*cock+2*hen+chicken/3==10000&&cock+hen+chicken==10000&&chicken%3==0) {
					System.out.println("公鸡:"+cock+",母鸡:"+hen+",小鸡:"+chicken);
					break;
				}
			}
		}
		long endTime = System.currentTimeMillis(); 
    	System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
	}
}
