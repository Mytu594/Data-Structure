package Graph;

public class ALGraph_Head {//顶点类
	private String data = null; //点结点值
    
    private ALGraph_Arc firstArc= null;  //第一条边的指针
    
    public String getData() {
        return data;
    }
    
    public ALGraph_Arc getFirstArc() {
        return firstArc;
    }
    
    public void setFirstArc(ALGraph_Arc firstArc) {
        this.firstArc = firstArc;
    }
    
    public ALGraph_Head(String data) {
        this.data = data;
    }
}
