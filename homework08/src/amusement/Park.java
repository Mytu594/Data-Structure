package amusement;

import java.util.Scanner;

public class Park {
	Project pro = new Project();
	public void getIn() throws Exception {
		pro.getInQ_2();
		System.out.println("�������д�����");
		Scanner reader = new Scanner(System.in);
		pro.next(reader.nextInt());
	}
	
	public static void main(String[] args) throws Exception {
		Park P = new Park();
		P.getIn();
	}
	
}
