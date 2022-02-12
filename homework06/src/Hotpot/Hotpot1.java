package Hotpot;

public class Hotpot1<S> {
	//最多只能放10道菜
	static CircleSqQueue<String> queue=new CircleSqQueue<String>(String.class,15);
	//定义全局变量
	static int empty=0;  //判断是否放了菜
	static boolean full=false;  //判断是否放满了菜
	public String menu(int index) {
		String[] menu= {
/*锅底*/"三鲜锅底","鸳鸯锅底","麻辣锅底",
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
	public void start() throws Exception {
		System.out.println("请问你要什么锅底?");
		int rand1=(int)(Math.random()*2);  //随机产生0-2的随机数
		System.out.println(menu(rand1));  //给锅底
		int rand2;
		//第一次把餐桌放满
		for(int i=0;i<10;i++) {
			if(i<2) {  //随机两道菜
				rand2=(int)(Math.random()*13+3);
				queue.offer(menu(rand2));
				empty++;
			}
			else if(i<4) {  //随机两道肉
				rand2=(int)(Math.random()*24+16);
				queue.offer(menu(rand2));
				empty++;
			}
			else if(i<6) {  //随机两道水产类
				rand2=(int)(Math.random()*18+40);
				queue.offer(menu(rand2));
				empty++;
			}
			else if(i<8){  //随机两道豆制品
				rand2=(int)(Math.random()*8+58);
				queue.offer(menu(rand2));
				empty++;
			}
			else {  //随机两道主食
				rand2=(int)(Math.random()*10+66);
				queue.offer(menu(rand2));
				empty++;
			}
		}
		full=true;  //放满餐桌了
		System.out.print("食材有：");
		queue.display();
		System.out.println();
	}
	public void chef() throws Exception {
		if(full!=true || empty<10) {
			double rand1=Math.random();
			int rand2=(int)(Math.random()*72+3);//随机放一道菜
			//随机数大于0.5，厨师放菜
			if(rand1>0.5) {
				queue.offer(menu(rand2));
				System.out.println("厨师放了："+menu(rand2));
				empty++;
				if(empty==10) {
					full=true;
				}
			}
			else {
				System.out.println("厨师没放菜");
			}
		}
	}
	public void customer() throws Exception {
		if(empty>0) {
			double rand=Math.random();
			//随机数小于0.5，顾客拿菜
			if(rand<0.5) {
				System.out.println("顾客吃了："+queue.peek());
				queue.poll();
				full=false;
				empty--;
			}
			else {
				System.out.println("顾客没吃");
			}
		}
	}
	public void Finally() {
		if(!queue.isEmpty())
			System.out.println("该顾客因没光盘被罚钱");
		double rand=Math.random();
		if(rand>0.5)
			System.out.println("该顾客没带钱被发配后厨洗碗");
	}
	public static void main(String[] args) throws Exception {
		Hotpot1 hp=new Hotpot1();
		hp.start();
		int circle=1;
//		do {
//			double r=(int)(Math.random()*+1);
//			if(r>0.4) {
//				if(!queue.isFull()) break;
//				hp.customer();
//				circle++;
//			}
//			else {
//				if(!queue.isEmpty()) break;
//				hp.chef();
//				circle++;
//			}
//			
//		}while(!queue.isEmpty());
		while(circle<10) {
			System.out.print("第"+circle+"轮");
			hp.customer();
			hp.chef();
			circle++;
		}
		hp.Finally();
		System.out.println("执行了"+circle+"次");
	}
}
