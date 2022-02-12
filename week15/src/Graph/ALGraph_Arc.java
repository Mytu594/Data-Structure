package Graph;

public class ALGraph_Arc {//边类
	private int adjVexSite = 0;  //该边所连接的顶点的邻接点的位置
    
    private ALGraph_Arc nextArc = null;  //下一条边的指针
    
    public int getAdjVexSite() {
        return adjVexSite;
    }
    
    public ALGraph_Arc getNextArc() {
        return nextArc;
    }
    
    public ALGraph_Arc(int adjVexSite, ALGraph_Arc nextArc) {
        this.adjVexSite = adjVexSite;
        this.nextArc = nextArc;
    }
}
