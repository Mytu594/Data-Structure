package amusement;

import java.util.Random;

public class Project{
	CircleSqQueue<String> a = new CircleSqQueue<String>(String.class, 7);   //��Ŀa
	CircleSqQueue<String> b = new CircleSqQueue<String>(String.class, 7);   //��Ŀb
	CircleSqQueue<String> c = new CircleSqQueue<String>(String.class, 7);   //��Ŀc
	CircleSqQueue<String> d = new CircleSqQueue<String>(String.class, 7);   //��Ŀd
	CircleSqQueue<String> e = new CircleSqQueue<String>(String.class, 2);   //������e
	int count = 0;
	int cnt = 0;
	public boolean getProject(int choice) throws Exception {      //���ѡһ����Ŀ 
		int num = (int) (Math.random() * choice + 1);
		boolean flag = true;
        System.out.println("num:" + num);
        switch(num) {
        	case 1:{
        			flag = InA();
        			break;
        	}
        	case 2:{
        			flag = InB();
        			break;
        	}
        	case 3:{
        			flag = InC();
        			break;
        	}
        	case 4:{
        			flag = InD();
        			break;
        	}
        	case 5:{
        		
        	}
        }
        return flag;
	}
	

	public boolean getProject2(int choice,String people) throws Exception {      //���ѡһ����Ŀ 
		int num = (int) (Math.random() * choice + 1);
		boolean flag = true;
        System.out.println("ѡ���" + num + "��Ŀ��");
        switch(num) {
        	case 1:{
        			flag = InA(people);
        			break;
        	}
        	case 2:{
        			flag = InB(people);
        			break;
        	}
        	case 3:{
        			flag = InC(people);
        			break;
        	}
        	case 4:{
        			flag = InD(people);
        			break;
        	}
        	case 5:{
        		System.out.println(people + "�Ѿ���԰��");
        	}
        }
        return flag;
	}
	
	public int getPeople() {    //���ɷֲ�����һ����������
		pMath pM = new pMath();
		return pM.getPossionVariable(2);
	}
	
	public void getInQ_2() throws Exception {    //��԰
		boolean flag_full; 
		while(!e.full() && cnt != 30) {     //�Ƚ���ѡ���ȴ���ÿ�ν�һ����ѡ��Ŀ��������Ŀ����ʱ�������������ڻ�����
			int getpeople = getPeople();
			int man = 0;
			System.out.println(cnt);
			System.out.println("���ɷֲ�������" + getpeople + "����");
			while(man < getpeople && cnt < 30) {
				cnt++;
				e.offer("e" + cnt);    
				System.out.println("e�����" + cnt + "����");
				if(count != 28) {
					if(getProject(4)) {   //��ѡ��Ŀ����ʱ��ֱ��ѡ����Ŀ
					
					}
					else {    //��ѡ��Ŀ�������ɼ���ѡ������û������Ŀ
						do {
							flag_full = getProject(4);
						}while(!flag_full && count != 28);
					}
				}
				man++;
			}
		}
		if(e.full())
			System.out.println("����԰�����ˣ�����һ�ȣ�");
	}
	
	public void next(int times) throws Exception {    //�ĸ���Ŀ��һ���ˣ��Ƿ�����棿
		int i = 0;
		while(i < times) {
		String peopleA = null;
		String peopleB = null;
		String peopleC = null;
		String peopleD = null;
		Random rand = new Random();
		if (rand.nextFloat() > 0.5) {
			peopleA = OutA();
			getProject2(5,peopleA);
		}
		if (rand.nextFloat() > 0.5) {
			peopleB = OutB();    //����Ŀ���뿪
			getProject2(5,peopleB);           //ѡ����or�뿪
		}
		if (rand.nextFloat() > 0.5) {
			peopleC = OutC();
			getProject2(5,peopleC);
		}
		if (rand.nextFloat() > 0.5) {
			peopleD = OutD();
			getProject2(5,peopleD);
		}
		if (a.length() < 7)
			InA();
		if (b.length() < 7)
			InB();
		if (c.length() < 7)
			InC();
		if (d.length() < 7)
			InD();
		getInQ_2();
		i++;
		}
	}

	public boolean InA() throws Exception{
		if (!a.full()) {
			System.out.println("a��Ŀ����һ���οͣ�");
			count++;
			a.offer(e.poll());
			return true;
		}
		else {
			System.out.println("����Ŀ�Ѿ������ˣ�");
			return false;
		}
	}
	public boolean InA(String x) throws Exception{
		if (!a.full()) {
			System.out.println("a��Ŀyou����һ���οͣ�");
			if (x != null) {
				count++;
				a.offer(x);
			}
			return true;
		}
		else {
			System.out.println("a��Ŀ�Ѿ������ˣ�");
			System.out.println(x + "�Ѿ���԰��");
			cnt--;
			return false;
		}
	}
	public String OutA() throws Exception{
		if (!a.isEmpty()) {
			System.out.println("a��Ŀһ���ο��뿪��");
			System.out.println(a.peek() + "�뿪��Ŀa");
			count--;
			return a.poll();
			
		}
		return null;
	}
	public boolean InB() throws Exception{
		if (!b.full()) {
			System.out.println("b��Ŀ����һ���οͣ�");
			count++;
			b.offer(e.poll());
			return true;
		}
		else {
			System.out.println("b��Ŀ�Ѿ������ˣ�");

			return false;
		}
			
	}
	public boolean InB(String x) throws Exception{
		if (!b.full()) {
			System.out.println("b��Ŀyou����һ���οͣ�");
			if (x != null) {
				count++;
				b.offer(x);
			}
			return true;
		}
		else {
			System.out.println("b��Ŀ�Ѿ������ˣ�");
			System.out.println(x + "�Ѿ���԰��");
			cnt--;
			return false;
		}
			
	}
	public String OutB() throws Exception{
		if (!b.isEmpty()) {
			System.out.println("b��Ŀһ���ο��뿪��");
			//return b.poll();
			System.out.println(b.peek() + "�뿪��Ŀb");
			count--;
			return b.poll();
		}
		return null;
	}
	public boolean InC() throws Exception{
		if (!c.full()) {
			System.out.println("c��Ŀ����һ���οͣ�");
			count++;
			c.offer(e.poll());
			return true;
		}
		else {
			System.out.println("c��Ŀ�Ѿ������ˣ�");
			return false;
		}
	}
	public boolean InC(String x) throws Exception{
		if (!c.full()) {
			System.out.println("c��Ŀyou����һ���οͣ�");
			if (x != null) {
				count++;
				c.offer(x);
			}
			return true;
		}
		else {
			System.out.println("c��Ŀ�Ѿ������ˣ�");
			System.out.println(x + "�Ѿ���԰��");
			cnt--;
			return false;
		}
	}
	public String OutC() throws Exception{
		if (!c.isEmpty()) {
			System.out.println("c��Ŀһ���ο��뿪");
			//return c.poll();
			System.out.println(c.peek() + "�뿪��Ŀc");
			count--;
			return c.poll();
		}
		return null;
	}
	public boolean InD() throws Exception{
		if (!d.full()) {
			System.out.println("d��Ŀ����һ���οͣ�");
			count++;
			d.offer(e.poll());
			return true;
		}
		else { 
			System.out.println("d��Ŀ�Ѿ������ˣ�");
			return false;
		}
	}
	public boolean InD(String x) throws Exception{
		if (!d.full()) {
			System.out.println("d��Ŀyou����һ���οͣ�");
			if (x != null) {
				count++;
				d.offer(x);
			}
			return true;
		}
		else { 
			System.out.println("d��Ŀ�Ѿ������ˣ�");
			System.out.println(x + "�Ѿ���԰��");
			cnt--;
			return false;
		}
	}
	public String OutD() throws Exception{
		if (!d.isEmpty()) {
			System.out.println("d��Ŀһ���ο��뿪");
			//return d.poll();
			System.out.println(d.peek() + "�뿪��Ŀd");
			count--;
			return d.poll();
		}
		else
			return null;
	}
}
