package forest;
public class HNode {
	public String code = "";// �ڵ�Ĺ���������
    public String data = "";// �ڵ������
    public int count;// �ڵ��Ȩֵ
    public HNode lChild;
    public HNode rChild;
    public HNode() {}
    public HNode(String data, int count)
    {
        this.data = data;
        this.count = count;
    }

    public HNode(int count, HNode lChild, HNode rChild)
    {
        this.count = count;
        this.lChild = lChild;
        this.rChild = rChild;
    }
    public HNode(String data, int count, HNode lChild, HNode rChild) 
    {
        this.data = data;
        this.count = count;
        this.lChild = lChild;
        this.rChild = rChild;
    }
}
