package Graph;
import java.util.LinkedList;
import java.util.Scanner;
public class ALGraph {//图类
	private ALGraph_Head[] aLGraph_Heads = null;  //顶点数组
	private boolean[] visited = null; //访问标志数组
	public ALGraph(int vexNum,int arcNum) { //输入顶点个数，边的个数
        
	    this.aLGraph_Heads = new ALGraph_Head[vexNum];
	        
	    System.out.print("请依次输入顶点值，以空格隔开：");
	    Scanner sc = new Scanner(System.in);
	    for(int i = 0; i < vexNum; i++) { //建立顶点数组存储点结点
	        this.aLGraph_Heads[i] = new ALGraph_Head(sc.next());
	    }
	    start:for(int i = 0; i < arcNum; i++) { //开始存储边信息
            
	        sc = new Scanner(System.in);
	        int vex1Site = 0;
	        int vex2Site = 0;
	        String vex1 = null;
	        String vex2 = null;
	            
	        System.out.print("请输入第" + (i+1) + "条边所依附的两个顶点，以空格隔开：");
	        vex1 = sc.next();
	        vex2 = sc.next();
	        for(int j = 0; j < this.aLGraph_Heads.length; j++) {  //查找第一个顶点的位置
	            if (this.aLGraph_Heads[j].getData().equals(vex1)) {
	                vex1Site = j;
	                break;
	            }
	            if (j == this.aLGraph_Heads.length - 1) {
	                System.out.println("未找到第一个顶点，请重新输入！");
	                i--;
	                continue start;
	            }
	        }
	        for (int j = 0; j < this.aLGraph_Heads.length; j++) {   //查找第二个顶点的位置
	            if(this.aLGraph_Heads[j].getData().equals(vex2)) {
	                vex2Site = j;
	                break;
	            }
	            if (j == this.aLGraph_Heads.length - 1) {
	                System.out.println("未找到第二个顶点，请重新输入！");
	                i--;
	                continue start;
	            }
	        }
	        ALGraph_Arc aLGraph_Arc = this.aLGraph_Heads[vex1Site].getFirstArc();  //获取点结点里的边指针
	        while(aLGraph_Arc != null) { //判断边是否已存储
	            if(aLGraph_Arc.getAdjVexSite() == vex2Site) {
	                System.out.println("该边已存在！");
	                i--;
	                continue start;
	            }
	            aLGraph_Arc = aLGraph_Arc.getNextArc();
	        }
	        this.aLGraph_Heads[vex1Site].setFirstArc(new ALGraph_Arc(vex2Site, this.aLGraph_Heads[vex1Site].getFirstArc()));  //将边结点加入单链表中
	        this.aLGraph_Heads[vex2Site].setFirstArc(new ALGraph_Arc(vex1Site, this.aLGraph_Heads[vex2Site].getFirstArc()));  //对称边结点也加入单链表
	    }
	    System.out.println("基于邻接表的无向图创建成功！");
	    sc.close();
	}
	//深度遍历
	public void dFSTraverse() {
        
	    this.visited = new boolean[this.aLGraph_Heads.length];  //建立并初始化访问标志数组
	    for(int i = 0; i < this.visited.length; i++) {
	        this.visited[i] = false;
	    }
	    
	    for(int i = 0; i < this.visited.length; i++) {   //以未访问的点为始点调用深度优先遍历算法
	        if(!this.visited[i]) {
	            dFS_AM(i);
	        }
	    }
	}
	public void dFS_AM(int site) {
	    System.out.println(this.aLGraph_Heads[site].getData());  //输出点值
	    this.visited[site] = true;  //置访问标志为true
	    ALGraph_Arc aLGraph_Arc = this.aLGraph_Heads[site].getFirstArc();  //获取点结点中的边指针
	    while(aLGraph_Arc != null) {
	        if(!visited[aLGraph_Arc.getAdjVexSite()]) {  //如果该边所连接的顶点的邻接点未访问，则以该邻接点为始点调用深度优先遍历算法
	            this.dFS_AM(aLGraph_Arc.getAdjVexSite());
	        }
	        aLGraph_Arc = aLGraph_Arc.getNextArc();//获取下一个临接点
	    }
	}
	//广度遍历
	public void bFSTraverse() {
        
		this.visited = new boolean[this.aLGraph_Heads.length];  //建立并初始化访问标志数组
		for(int i = 0; i < this.visited.length; i++) {
		    this.visited[i] = false;
		    }
		        
		    for(int i = 0; i < this.visited.length; i++) {   //以未访问的点为始点调用广度优先遍历算法
		        if(!this.visited[i]) {
		            bFS_AM(i);
		        }
		    }
		}
	public void bFS_AM(int site) {
	    System.out.println(this.aLGraph_Heads[site].getData());  //输出点值
	    this.visited[site] = true;   //置访问标志为true
	    LinkedList<Integer> linkedList = new LinkedList<Integer>();   //利用队列实现广度优先遍历
	    linkedList.offer(site);  //点入队
	    while(!linkedList.isEmpty()) {
	        int vexSite = linkedList.poll();  //点出队
	        ALGraph_Arc aLGraph_Arc = this.aLGraph_Heads[vexSite].getFirstArc();  //获取点结点中的边指针
	        while(aLGraph_Arc != null) {
	            vexSite = aLGraph_Arc.getAdjVexSite();   //获取该边所连接的顶点的邻接点
	            if(!this.visited[vexSite]) {   //如果该邻接点未访问，则访问
	                System.out.println(this.aLGraph_Heads[vexSite].getData());
	                this.visited[vexSite] = true;
	                linkedList.offer(vexSite);  //被访问的点入队
	            }
	            aLGraph_Arc = aLGraph_Arc.getNextArc();//获取下一个临接点
	        }
	    }
	}
	
}
