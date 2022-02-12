package hotpot;
class MyThread implements Runnable {  //��Runnable�ӿ�ʵ��MyThread��
	private String who;
	public MyThread(String str) {  //���췽�����������ó�Ա����who
		who=str;
	}
	public void run() {  //����Thread�����run()����
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
	//���ֻ�ܷ�15����
	CircleSqQueue<String> queue=new CircleSqQueue<String>(String.class,16);
	//����ȫ�ֱ���
	static int empty=15;  //�ж��Ƿ���˲�
	static boolean full=false;  //�ж��Ƿ�����˲�
	public void firstly(String TeamName) {
		//������
		System.out.println(TeamName+"����ã���ӭ���ٻ��С�꣡��������Ҫʲô���ף�");
		int rand=(int)(Math.random()*2);  //�������0-2�������
		System.out.println(menu(rand));
		//����ʦ�͹˿�
		int rand1=getPossionVariable();  //n���˿�,���20���˿�
		int rand2=(int)(Math.random()*4+1);  //n����ʦ,���4����ʦ
		System.out.println("�ܹ�"+rand1+"λ�˿�");
		System.out.println("�ܹ�"+rand2+"λ��ʦ");
		//����ÿλ�˿�����Ĳ�
		int[] order=new int[rand1];
		int index=0;
		for(int i=0;i<rand1;i++) {
			int r=(int)(Math.random()*3+1);  //ÿ���˿͵�2-3����
			order[index++]=r;
			System.out.println("��"+(i+1)+"λ�˿͵���"+r+"����");
		}
		System.out.println();
		int j=0;
		while(full!=true) {
			++j;
			System.out.println("��"+j+"��");
			try {
				chef(rand2);
				System.out.println();
				int[] a=change(order,customer(rand1));
				System.out.println();
				//�ı�˿������������
				int n=0,in=0;
				for(int i:a) {
					if(i==0) {
						n++;   //��¼���ٸ�0
					}
					else
						order[in++]=i;  //�����0��
				}
				rand1=rand1-n;
				if(rand1==0) {
					System.out.println("�˿��߹���");
					System.exit(0);
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	public String menu(int index) {
		String[] menu= {
		/*����*/"��������","ԧ�����","��������",
		/*�߲���*/"����","��ײ�","��ѿ","�ƹ�","�㹽","�ƻ���",
				"źƬ","���","����","С���","����Ƭ","���빽","Ģ��",
		/*����*/	"����","��צ","Ѽ��","з��","�㳦","�쳦","�����","���⴮",
				"ţ��Ҷ","����","��Ƭ","����","����","�Ｙ��","ţ��","¿��",
				"����","����","ˮ��","�Ϲϱ�","����","Ϻ��","Ѽ��","�����",
		/*ˮ����*/"����","����","����","����","����","��з","��Ϻ","��з","��Ϻ","ˮ������",
				"ī��","ˮ������","ˮ�����","�㴽","���","�ʱ�","����","ˮ������",
		/*����Ʒ��*/"����Ƥ","����","������","�ձ�����","�ؼ�","���","������","ǧ�Ž�",
		/*��ʳ��*/"��ߦ��","������","����","����","��˿","����","����","���","�׷�","������",
		};
		return menu[index];
	}
	public void chef(int number) throws InterruptedException {
		if(full!=true || empty>0) {
			int i=1;
			for(;i<=number;i++) {
				double rand1=Math.random();
				int rand2=0;
				//���������0.5����ʦ�Ų�
				if(rand1>0.5) {
					try {
						rand2=(int)(Math.random()*72+3);  //�������һ����
						Thread.sleep(1000);  //ÿ1000���보һ����
						queue.offer(menu(rand2));
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("��"+i+"λ��ʦ���ˣ�"+menu(rand2));
					empty--;
					if(empty==0) {
						full=true;
						System.out.println("�������ˣ�");
						System.exit(0);
					}
				}
				else {
					System.out.println("��"+i+"λ��ʦû�Ų�");
				}
			}
		}
		else {
			System.out.println("�������ˣ�");
			System.exit(0);
		}
	}
	public int[] customer(int number) throws InterruptedException {
		int[] arr=new int[number];  //��¼�˿ͳԼ�����
		int i=0;
		for(;i<number;i++) {
			double rand=Math.random();
			//�����С��0.5���˿��ò�
			if(rand<0.5) {
				if(queue.peek()==null) {
					System.out.println("��"+(i+1)+"λ�˿ʹ߲�");
					arr[i]=0;
				}
				else {
					System.out.println("��"+(i+1)+"λ�˿ͳ��ˣ�"+queue.peek());
					queue.poll();
					full=false;
					empty++;
					arr[i]=1;
				}
			}
			else {
				arr[i]=0;
				System.out.println("����˵�"+(i+1)+"λ�˿Ͳ�ϲ����û��");
			}
		}
		return arr;
	}
	public int[] change(int[] a,int[] b) {  //�޸Ĺ˿ͻ�û�ԵĲ˵ĸ���
		int j=0;
		for(int i=0;i<b.length;i++) {
			a[i]=a[i]-b[j];
			j++;
		}
		return a;
	}
	//���ɷֲ�
	public double getPossionProbability(int k) {
		double c=Math.exp(-5.0),b=Math.pow(5.0,k),sum=1;
		for(int i=1;i<=k;i++) {
			sum*=b/i;
		}
		return sum*c;
	}
	//�����˿�����
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
		MyThread No1=new MyThread("Ϧ����������");
		Thread t=new Thread(No1);
		t.start();
	}
}
