package Hotpot;

public class Hotpot1<S> {
	//���ֻ�ܷ�10����
	static CircleSqQueue<String> queue=new CircleSqQueue<String>(String.class,15);
	//����ȫ�ֱ���
	static int empty=0;  //�ж��Ƿ���˲�
	static boolean full=false;  //�ж��Ƿ�����˲�
	public String menu(int index) {
		String[] menu= {
/*����*/"���ʹ���","ԧ�����","��������",
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
	public void start() throws Exception {
		System.out.println("������Ҫʲô����?");
		int rand1=(int)(Math.random()*2);  //�������0-2�������
		System.out.println(menu(rand1));  //������
		int rand2;
		//��һ�ΰѲ�������
		for(int i=0;i<10;i++) {
			if(i<2) {  //���������
				rand2=(int)(Math.random()*13+3);
				queue.offer(menu(rand2));
				empty++;
			}
			else if(i<4) {  //���������
				rand2=(int)(Math.random()*24+16);
				queue.offer(menu(rand2));
				empty++;
			}
			else if(i<6) {  //�������ˮ����
				rand2=(int)(Math.random()*18+40);
				queue.offer(menu(rand2));
				empty++;
			}
			else if(i<8){  //�����������Ʒ
				rand2=(int)(Math.random()*8+58);
				queue.offer(menu(rand2));
				empty++;
			}
			else {  //���������ʳ
				rand2=(int)(Math.random()*10+66);
				queue.offer(menu(rand2));
				empty++;
			}
		}
		full=true;  //����������
		System.out.print("ʳ���У�");
		queue.display();
		System.out.println();
	}
	public void chef() throws Exception {
		if(full!=true || empty<10) {
			double rand1=Math.random();
			int rand2=(int)(Math.random()*72+3);//�����һ����
			//���������0.5����ʦ�Ų�
			if(rand1>0.5) {
				queue.offer(menu(rand2));
				System.out.println("��ʦ���ˣ�"+menu(rand2));
				empty++;
				if(empty==10) {
					full=true;
				}
			}
			else {
				System.out.println("��ʦû�Ų�");
			}
		}
	}
	public void customer() throws Exception {
		if(empty>0) {
			double rand=Math.random();
			//�����С��0.5���˿��ò�
			if(rand<0.5) {
				System.out.println("�˿ͳ��ˣ�"+queue.peek());
				queue.poll();
				full=false;
				empty--;
			}
			else {
				System.out.println("�˿�û��");
			}
		}
	}
	public void Finally() {
		if(!queue.isEmpty())
			System.out.println("�ù˿���û���̱���Ǯ");
		double rand=Math.random();
		if(rand>0.5)
			System.out.println("�ù˿�û��Ǯ��������ϴ��");
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
			System.out.print("��"+circle+"��");
			hp.customer();
			hp.chef();
			circle++;
		}
		hp.Finally();
		System.out.println("ִ����"+circle+"��");
	}
}
