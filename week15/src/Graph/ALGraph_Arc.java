package Graph;

public class ALGraph_Arc {//����
	private int adjVexSite = 0;  //�ñ������ӵĶ�����ڽӵ��λ��
    
    private ALGraph_Arc nextArc = null;  //��һ���ߵ�ָ��
    
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
