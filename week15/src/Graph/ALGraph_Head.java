package Graph;

public class ALGraph_Head {//������
	private String data = null; //����ֵ
    
    private ALGraph_Arc firstArc= null;  //��һ���ߵ�ָ��
    
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
