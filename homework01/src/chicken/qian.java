package chicken;

public class qian {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis(); 
		int cock,hen,chicken;
		for(cock=1;cock<=200;cock++) {
			for(hen=1;hen<=500;hen++) {
				for(chicken=3;chicken<=3000;chicken++) {
					if(5*cock+2*hen+chicken/3==1000&&cock+hen+chicken==1000&&chicken%3==0) {
						System.out.println("����:"+cock+",ĸ��:"+hen+",С��:"+chicken);
						break;
					}
				}
			}
		}
		long endTime = System.currentTimeMillis(); 
    	System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");
	}
}
