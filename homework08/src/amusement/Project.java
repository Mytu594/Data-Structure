package amusement;

import java.util.Random;

public class Project{
	CircleSqQueue<String> a = new CircleSqQueue<String>(String.class, 7);   //项目a
	CircleSqQueue<String> b = new CircleSqQueue<String>(String.class, 7);   //项目b
	CircleSqQueue<String> c = new CircleSqQueue<String>(String.class, 7);   //项目c
	CircleSqQueue<String> d = new CircleSqQueue<String>(String.class, 7);   //项目d
	CircleSqQueue<String> e = new CircleSqQueue<String>(String.class, 2);   //缓冲区e
	int count = 0;
	int cnt = 0;
	public boolean getProject(int choice) throws Exception {      //随机选一个项目 
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
	

	public boolean getProject2(int choice,String people) throws Exception {      //随机选一个项目 
		int num = (int) (Math.random() * choice + 1);
		boolean flag = true;
        System.out.println("选择第" + num + "项目玩");
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
        		System.out.println(people + "已经离园！");
        	}
        }
        return flag;
	}
	
	public int getPeople() {    //泊松分布产生一次性来的人
		pMath pM = new pMath();
		return pM.getPossionVariable(2);
	}
	
	public void getInQ_2() throws Exception {    //入园
		boolean flag_full; 
		while(!e.full() && cnt != 30) {     //先进候选区等待，每次进一个人选项目，所有项目已满时，再入两个人在缓冲区
			int getpeople = getPeople();
			int man = 0;
			System.out.println(cnt);
			System.out.println("泊松分布产生：" + getpeople + "个人");
			while(man < getpeople && cnt < 30) {
				cnt++;
				e.offer("e" + cnt);    
				System.out.println("e中入队" + cnt + "个人");
				if(count != 28) {
					if(getProject(4)) {   //所选项目不满时，直接选该项目
					
					}
					else {    //所选项目已满，可继续选其他还没满的项目
						do {
							flag_full = getProject(4);
						}while(!flag_full && count != 28);
					}
				}
				man++;
			}
		}
		if(e.full())
			System.out.println("游乐园满人了，您等一等！");
	}
	
	public void next(int times) throws Exception {    //哪个项目走一个人，是否继续玩？
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
			peopleB = OutB();    //从项目中离开
			getProject2(5,peopleB);           //选择玩or离开
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
			System.out.println("a项目加入一名游客！");
			count++;
			a.offer(e.poll());
			return true;
		}
		else {
			System.out.println("该项目已经满人了！");
			return false;
		}
	}
	public boolean InA(String x) throws Exception{
		if (!a.full()) {
			System.out.println("a项目you加入一名游客！");
			if (x != null) {
				count++;
				a.offer(x);
			}
			return true;
		}
		else {
			System.out.println("a项目已经满人了！");
			System.out.println(x + "已经离园！");
			cnt--;
			return false;
		}
	}
	public String OutA() throws Exception{
		if (!a.isEmpty()) {
			System.out.println("a项目一名游客离开！");
			System.out.println(a.peek() + "离开项目a");
			count--;
			return a.poll();
			
		}
		return null;
	}
	public boolean InB() throws Exception{
		if (!b.full()) {
			System.out.println("b项目加入一名游客！");
			count++;
			b.offer(e.poll());
			return true;
		}
		else {
			System.out.println("b项目已经满人了！");

			return false;
		}
			
	}
	public boolean InB(String x) throws Exception{
		if (!b.full()) {
			System.out.println("b项目you加入一名游客！");
			if (x != null) {
				count++;
				b.offer(x);
			}
			return true;
		}
		else {
			System.out.println("b项目已经满人了！");
			System.out.println(x + "已经离园！");
			cnt--;
			return false;
		}
			
	}
	public String OutB() throws Exception{
		if (!b.isEmpty()) {
			System.out.println("b项目一名游客离开！");
			//return b.poll();
			System.out.println(b.peek() + "离开项目b");
			count--;
			return b.poll();
		}
		return null;
	}
	public boolean InC() throws Exception{
		if (!c.full()) {
			System.out.println("c项目加入一名游客！");
			count++;
			c.offer(e.poll());
			return true;
		}
		else {
			System.out.println("c项目已经满人了！");
			return false;
		}
	}
	public boolean InC(String x) throws Exception{
		if (!c.full()) {
			System.out.println("c项目you加入一名游客！");
			if (x != null) {
				count++;
				c.offer(x);
			}
			return true;
		}
		else {
			System.out.println("c项目已经满人了！");
			System.out.println(x + "已经离园！");
			cnt--;
			return false;
		}
	}
	public String OutC() throws Exception{
		if (!c.isEmpty()) {
			System.out.println("c项目一名游客离开");
			//return c.poll();
			System.out.println(c.peek() + "离开项目c");
			count--;
			return c.poll();
		}
		return null;
	}
	public boolean InD() throws Exception{
		if (!d.full()) {
			System.out.println("d项目加入一名游客！");
			count++;
			d.offer(e.poll());
			return true;
		}
		else { 
			System.out.println("d项目已经满人了！");
			return false;
		}
	}
	public boolean InD(String x) throws Exception{
		if (!d.full()) {
			System.out.println("d项目you加入一名游客！");
			if (x != null) {
				count++;
				d.offer(x);
			}
			return true;
		}
		else { 
			System.out.println("d项目已经满人了！");
			System.out.println(x + "已经离园！");
			cnt--;
			return false;
		}
	}
	public String OutD() throws Exception{
		if (!d.isEmpty()) {
			System.out.println("d项目一名游客离开");
			//return d.poll();
			System.out.println(d.peek() + "离开项目d");
			count--;
			return d.poll();
		}
		else
			return null;
	}
}
