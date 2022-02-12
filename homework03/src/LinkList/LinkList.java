package LinkList;


public class LinkList {
	public Node head;
	public LinkList() {
		head = new Node();  //初始化头结点
	}
	//获取链表长度
	public int length() {
		Node pre = head.next;
		int len = 0;
		while(pre != null) {
			pre = pre.next;
			++len;
		}
		return len;
	}
	//尾插法
	public void insetTail(Object x){
		Node pre = head;
		while(pre.next!=null) {
			pre = pre.next;
		}
		Node val = new Node(x);
		pre.next = val;
	}
	//头插法
	public void insetHead(Object y){
		Node pre = head;
		Node val = new Node(y);
		val.next = pre.next;
		pre.next = val;
	}
	//指定插入
	public void inset(int pos,Object z) throws Exception {
		Node pre = head.next;
		int j = 0;
		Node val = new Node(z);
		while(pre!=null) {
			if(j==pos-1) {
				val.next = pre.next;
				pre.next = val;
			}
			j++;
			pre = pre.next;
		}
		if(pos<0 || pos>this.length())
			throw new Exception("插入位置不合法");
	}
	//按位查找
	public Object get(int i) throws Exception {
		Node pre = head.next;
		int j = 0;
		while(pre!=null && j<i) {
			pre = pre.next;
			++j;
		}
		if(j>i || pre==null)
			throw new Exception("元素不存在");
		return pre.data;
	}
	//按值查找
	public int indexOf(Object val) {
		Node pre = head.next;
		int j = 0;
		while(pre!=null && !pre.data.equals(val)) {
			pre = pre.next;
			++j;
		}
		if(pre != null)
			return j;
		else
			return -1;
	}
	//删除结点
	public void remove(int k) throws Exception {
		Node pre = head;
		int j = 0;
		while(pre.next!=null && j<k) {
			pre = pre.next;
			j++;
		}
		if(j>k || pre.next==null)
			throw new Exception("删除位置不合法");
		pre.next = pre.next.next;
	}
	//输出结点
	public void display() {
		Node node = head.next;
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}
}
