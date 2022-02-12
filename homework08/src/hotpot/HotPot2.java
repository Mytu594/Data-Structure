package hotpot;
class MyThread implements Runnable {  //由Runnable接口实现MyThread类
	private String who;
	public MyThread(String str) {  //构造方法，用于设置成员变量who
		who=str;
	}
	public void run() {  //覆盖Thread类里的run()方法
		try {
			Thread.sleep((int)(1000*Math.random()));
		} catch(InterruptedException e) {
			System.out.println(e.toString());
		}
		HotPot2 hp2=new HotPot2();
		hp2.firstly(who);
	}
}
public class HotPot2 {
	//最多只能放15道菜
	CircleSqQueue<String> queue=new CircleSqQueue<String>(String.class,16);
	//定义全局变量
	static int empty=15;  //判断是否放了菜
	static boolean full=false;  //判断是否放满了菜
	public void firstly(String TeamName) {
		//给锅底
		System.out.println(TeamName+"，你好，欢迎光临火锅小店！请问您们要什么锅底？");
		int rand=(int)(Math.random()*2);  //随机产生0-2的随机数
		System.out.println(menu(rand));
		//给厨师和顾客
		int rand1=getPossionVariable();  //n个顾客,最多20个顾客
		int rand2=(int)(Math.random()*4+1);  //n个厨师,最多4个厨师
		System.out.println("总共"+rand1+"位顾客");
		System.out.println("总共"+rand2+"位厨师");
		//存起每位顾客所点的菜
		int[] order=new int[rand1];
		int index=0;
		for(int i=0;i<rand1;i++) {
			int r=(int)(Math.random()*3+1);  //每个顾客点2-3道菜
			order[index++]=r;
			System.out.println("第"+(i+1)+"位顾客点了"+r+"道菜");
		}
		System.out.println();
		int j=0;
		while(full!=true) {
			++j;
			System.out.println("第"+j+"轮");
			try {
				chef(rand2);
				System.out.println();
				int[] a=change(order,customer(rand1));
				System.out.println();
				//改变顾客人数及点菜数
				int n=0,in=0;
				for(int i:a) {
					if(i==0) {
						n++;   //记录多少个0
					}
					else
						order[in++]=i;  //存起非0数
				}
				rand1=rand1-n;
				if(rand1==0) {
					System.out.println("顾客走光了");
					System.exit(0);
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	public String menu(int index) {
		String[] menu= {
		/*锅底*/"清汤锅底","鸳鸯锅底","麻辣锅底",
		/*蔬菜类*/"包菜","大白菜","豆芽","黄瓜","香菇","黄花菜",
				"藕片","香菜","生菜","小青菜","土豆片","金针菇","蘑菇",
		/*肉类*/	"鸡翅","鸡爪","鸭舌","蟹柳","香肠","红肠","羊肉卷","羊肉串",
				"牛百叶","鱿鱼","鱼片","猪腰","猪脑","里脊肉","牛肉","驴肉",
				"鸡蛋","锅巴","水饺","南瓜饼","鱼丸","虾丸","鸭肠","午餐肉",
		/*水产类*/"鲫鱼","草鱼","鲤鱼","鳝鱼","泥鳅","河蟹","河虾","海蟹","海虾","水发海参",
				"墨鱼","水发鱿鱼","水发鱼肚","鱼唇","鱼翅","鲜贝","带鱼","水发海带",
		/*豆制品类*/"豆腐皮","腐竹","冻豆腐","日本豆腐","素鸡","茶干","豆腐泡","千张结",
		/*主食类*/"手擀面","杂粮面","宽面","粉条","粉丝","玉米","油条","年糕","米饭","方便面",
		};
		return menu[index];
	}
	public void chef(int number) throws InterruptedException {
		if(full!=true || empty>0) {
			int i=1;
			for(;i<=number;i++) {
				double rand1=Math.random();
				int rand2=0;
				//随机数大于0.5，厨师放菜
				if(rand1>0.5) {
					try {
						rand2=(int)(Math.random()*72+3);  //随机产生一道菜
						Thread.sleep(1000);  //每1000毫秒炒一道菜
						queue.offer(menu(rand2));
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("第"+i+"位厨师放了："+menu(rand2));
					empty--;
					if(empty==0) {
						full=true;
						System.out.println("餐桌满了！");
						System.exit(0);
					}
				}
				else {
					System.out.println("第"+i+"位厨师没放菜");
				}
			}
		}
		else {
			System.out.println("餐桌满了！");
			System.exit(0);
		}
	}
	public int[] customer(int number) throws InterruptedException {
		int[] arr=new int[number];  //记录顾客吃几道菜
		int i=0;
		for(;i<number;i++) {
			double rand=Math.random();
			//随机数小于0.5，顾客拿菜
			if(rand<0.5) {
				if(queue.peek()==null) {
					System.out.println("第"+(i+1)+"位顾客催菜");
					arr[i]=0;
				}
				else {
					System.out.println("第"+(i+1)+"位顾客吃了："+queue.peek());
					queue.poll();
					full=false;
					empty++;
					arr[i]=1;
				}
			}
			else {
				arr[i]=0;
				System.out.println("这道菜第"+(i+1)+"位顾客不喜欢，没吃");
			}
		}
		return arr;
	}
	public int[] change(int[] a,int[] b) {  //修改顾客还没吃的菜的个数
		int j=0;
		for(int i=0;i<b.length;i++) {
			a[i]=a[i]-b[j];
			j++;
		}
		return a;
	}
	//泊松分布
	public double getPossionProbability(int k) {
		double c=Math.exp(-5.0),b=Math.pow(5.0,k),sum=1;
		for(int i=1;i<=k;i++) {
			sum*=b/i;
		}
		return sum*c;
	}
	//产生顾客人数
	public int getPossionVariable() {
		int x=0;
		double y=Math.random(),cdf=getPossionProbability(x);
		while(cdf<y) {
			x++;
			cdf+=getPossionProbability(x);
		}
		return x;
	}
	public static void main(String[] args) throws InterruptedException {
		MyThread No1=new MyThread("夕阳红旅游团");
		Thread t=new Thread(No1);
		t.start();
	}
}
