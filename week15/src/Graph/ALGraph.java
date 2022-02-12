package Graph;
import java.util.LinkedList;
import java.util.Scanner;
public class ALGraph {//ͼ��
	private ALGraph_Head[] aLGraph_Heads = null;  //��������
	private boolean[] visited = null; //���ʱ�־����
	public ALGraph(int vexNum,int arcNum) { //���붥��������ߵĸ���
        
	    this.aLGraph_Heads = new ALGraph_Head[vexNum];
	        
	    System.out.print("���������붥��ֵ���Կո������");
	    Scanner sc = new Scanner(System.in);
	    for(int i = 0; i < vexNum; i++) { //������������洢����
	        this.aLGraph_Heads[i] = new ALGraph_Head(sc.next());
	    }
	    start:for(int i = 0; i < arcNum; i++) { //��ʼ�洢����Ϣ
            
	        sc = new Scanner(System.in);
	        int vex1Site = 0;
	        int vex2Site = 0;
	        String vex1 = null;
	        String vex2 = null;
	            
	        System.out.print("�������" + (i+1) + "�������������������㣬�Կո������");
	        vex1 = sc.next();
	        vex2 = sc.next();
	        for(int j = 0; j < this.aLGraph_Heads.length; j++) {  //���ҵ�һ�������λ��
	            if (this.aLGraph_Heads[j].getData().equals(vex1)) {
	                vex1Site = j;
	                break;
	            }
	            if (j == this.aLGraph_Heads.length - 1) {
	                System.out.println("δ�ҵ���һ�����㣬���������룡");
	                i--;
	                continue start;
	            }
	        }
	        for (int j = 0; j < this.aLGraph_Heads.length; j++) {   //���ҵڶ��������λ��
	            if(this.aLGraph_Heads[j].getData().equals(vex2)) {
	                vex2Site = j;
	                break;
	            }
	            if (j == this.aLGraph_Heads.length - 1) {
	                System.out.println("δ�ҵ��ڶ������㣬���������룡");
	                i--;
	                continue start;
	            }
	        }
	        ALGraph_Arc aLGraph_Arc = this.aLGraph_Heads[vex1Site].getFirstArc();  //��ȡ������ı�ָ��
	        while(aLGraph_Arc != null) { //�жϱ��Ƿ��Ѵ洢
	            if(aLGraph_Arc.getAdjVexSite() == vex2Site) {
	                System.out.println("�ñ��Ѵ��ڣ�");
	                i--;
	                continue start;
	            }
	            aLGraph_Arc = aLGraph_Arc.getNextArc();
	        }
	        this.aLGraph_Heads[vex1Site].setFirstArc(new ALGraph_Arc(vex2Site, this.aLGraph_Heads[vex1Site].getFirstArc()));  //���߽����뵥������
	        this.aLGraph_Heads[vex2Site].setFirstArc(new ALGraph_Arc(vex1Site, this.aLGraph_Heads[vex2Site].getFirstArc()));  //�ԳƱ߽��Ҳ���뵥����
	    }
	    System.out.println("�����ڽӱ������ͼ�����ɹ���");
	    sc.close();
	}
	//��ȱ���
	public void dFSTraverse() {
        
	    this.visited = new boolean[this.aLGraph_Heads.length];  //��������ʼ�����ʱ�־����
	    for(int i = 0; i < this.visited.length; i++) {
	        this.visited[i] = false;
	    }
	    
	    for(int i = 0; i < this.visited.length; i++) {   //��δ���ʵĵ�Ϊʼ�����������ȱ����㷨
	        if(!this.visited[i]) {
	            dFS_AM(i);
	        }
	    }
	}
	public void dFS_AM(int site) {
	    System.out.println(this.aLGraph_Heads[site].getData());  //�����ֵ
	    this.visited[site] = true;  //�÷��ʱ�־Ϊtrue
	    ALGraph_Arc aLGraph_Arc = this.aLGraph_Heads[site].getFirstArc();  //��ȡ�����еı�ָ��
	    while(aLGraph_Arc != null) {
	        if(!visited[aLGraph_Arc.getAdjVexSite()]) {  //����ñ������ӵĶ�����ڽӵ�δ���ʣ����Ը��ڽӵ�Ϊʼ�����������ȱ����㷨
	            this.dFS_AM(aLGraph_Arc.getAdjVexSite());
	        }
	        aLGraph_Arc = aLGraph_Arc.getNextArc();//��ȡ��һ���ٽӵ�
	    }
	}
	//��ȱ���
	public void bFSTraverse() {
        
		this.visited = new boolean[this.aLGraph_Heads.length];  //��������ʼ�����ʱ�־����
		for(int i = 0; i < this.visited.length; i++) {
		    this.visited[i] = false;
		    }
		        
		    for(int i = 0; i < this.visited.length; i++) {   //��δ���ʵĵ�Ϊʼ����ù�����ȱ����㷨
		        if(!this.visited[i]) {
		            bFS_AM(i);
		        }
		    }
		}
	public void bFS_AM(int site) {
	    System.out.println(this.aLGraph_Heads[site].getData());  //�����ֵ
	    this.visited[site] = true;   //�÷��ʱ�־Ϊtrue
	    LinkedList<Integer> linkedList = new LinkedList<Integer>();   //���ö���ʵ�ֹ�����ȱ���
	    linkedList.offer(site);  //�����
	    while(!linkedList.isEmpty()) {
	        int vexSite = linkedList.poll();  //�����
	        ALGraph_Arc aLGraph_Arc = this.aLGraph_Heads[vexSite].getFirstArc();  //��ȡ�����еı�ָ��
	        while(aLGraph_Arc != null) {
	            vexSite = aLGraph_Arc.getAdjVexSite();   //��ȡ�ñ������ӵĶ�����ڽӵ�
	            if(!this.visited[vexSite]) {   //������ڽӵ�δ���ʣ������
	                System.out.println(this.aLGraph_Heads[vexSite].getData());
	                this.visited[vexSite] = true;
	                linkedList.offer(vexSite);  //�����ʵĵ����
	            }
	            aLGraph_Arc = aLGraph_Arc.getNextArc();//��ȡ��һ���ٽӵ�
	        }
	    }
	}
	
}
