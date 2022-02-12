package Hotpot;
import yanghui.CircleSqQueue;
public class Hotpot {

	public static void main(String[] args) throws Exception {
		CircleSqQueue a=new CircleSqQueue(100);
		int i=0;
		do {
			double r=1+Math.random()*1;
			if(r>=0.6) {
				if(a.isFull())break;
				a.offer(i);
				System.out.println("…œ≤À"+a.length());
			}else {
				if(a.isEmpty())break;
				a.poll();
				System.out.println("≥‘≤À"+a.length());
			}
			i++;
		}while(!a.isEmpty());
		System.out.println("÷¥––"+i+"¥Œ");
	}

}
