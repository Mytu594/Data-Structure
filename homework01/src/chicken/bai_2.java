package chicken;

public class bai_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis(); 
		int cock,hen,chicken;
		for(cock=0;cock<=20;cock++) {
			for(hen=0;hen<=100/3;hen++) {
				chicken=100-cock-hen;
				if(5*cock+3*hen+chicken/3==100&&cock+hen+chicken==100&&chicken%3==0) {
					System.out.println("公鸡:"+cock+",母鸡:"+hen+",小鸡:"+chicken);
					break;
				}
			}
		}
		long endTime = System.currentTimeMillis(); 
    	System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
	}

}
