package DuLLinkList02_unity;
class DuLLink<S> {
	public DuLNode<S> head;
	//构造只含1个头结点的双向循环链表
	public DuLLink() {  
		head=new DuLNode<S>();
		head.prior=head;  //双向循环链表
		head.next=head;
	}
	//计算链表长度
	public int length() {
		int len=0;
		DuLNode<S> pre=head.next;
		while(!pre.equals(head)) {
			pre=pre.next;
			++len;
		}
		return len;
	}
	//插入结点
	public void insert(int i,S x) throws Exception{
		DuLNode<S> pre=head.next;
		int j=0;
		while(!pre.equals(head) && j<i) {
			pre=pre.next;
			++j;
		}
		if(j!=i && !pre.equals(head))
			throw new Exception("插入位置不合法");
		DuLNode<S> s=new DuLNode<S>(x);
		pre.prior.next=s;
		s.prior=pre.prior;
		s.next=pre;
		pre.prior=s;
	}
	//删除结点
	public void remove(int i) throws Exception {
		DuLNode<S> pre=head.next;
		int j=0;
		while(!pre.equals(head) && j<i) {
			pre=pre.next;
			++j;
		}
		if(i!=j)
			throw new Exception("删除位置不合理");
		pre.prior.next=pre.next;
		pre.next.prior=pre.prior;
	}
	//清空链表
	public void clear() {
		head.data=null;
		head.prior=head;
		head.next=head;
	}
	//判断是否为空
	public boolean isEmpty() {
		return head.next==head;
	}
	//查找，输出值
	public S get(int i) throws Exception{
		DuLNode<S> pre=head.next;
		int j=0;
		while(!pre.equals(head) && j<i) {
			pre=pre.next;
			++j;
		}
		if(j>i || pre.equals(head))
			throw new Exception("第"+i+"个元素不存在");
		return pre.data;
	}
	//查找，输出下标
	public int index(S x) {
		DuLNode<S> pre=head.next;
		int j=0;
		while(!pre.equals(head) && !pre.data.equals(x)) {
			pre=pre.next;
			++j;
		}
		if(!pre.equals(head))
			return j;
		else
			return -1;
	}
	//输出链表
	public void display() {
		DuLNode<S> node=head.next;
		while(!node.equals(head)) {
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
	//翻转链表
	public void reverse() {
		DuLNode<S> pre=head;
		DuLNode<S> cur=head.next;
        while (cur!=head) {
            DuLNode<S> temp=cur;
            cur=cur.next;  //cur指针后移
            temp.next=pre;  //反转
            pre.prior=temp;
            pre=temp;  //pre指针后移
        }
        pre.prior=head;
        head.next=pre;
	}
	//两两交换（1-2、3-4）
	public void swap1() {
		DuLNode<S> odd=head.next;
		DuLNode<S> even=odd.next;
		while(odd!=head && even!=head) {
			odd.prior.next=even;  //交换1-2
			even.next.prior=odd;
			odd.next=even.next;  //分别连接1、2前后
			even.prior=odd.prior;
			odd.prior=even;  //连接1-2
			even.next=odd;
			odd=odd.next;  //更新位置
			even=odd.next;
		}
	}
	//两两交换（1-3、2-4）
	public void swap2() {
		DuLNode<S> cur=head;
		DuLNode<S> cure=head;
		DuLNode<S> odd=head.next;
		DuLNode<S> even=odd.next;
		int len=length();
		while(odd.next!=head && even!=head) {
			if(len==2) {  //交换后剩余两个节点构成循环后直接输出
				even.next=cure;
				cure.prior=even;
				break;
			}
			else if(len==3) {
				cur.next=even.next;  //h->3
				even.next.prior=cur;
				cur=cur.next;  //h==3
				cur.next=even;  //3->2
				even.prior=cur;
				even.next=odd;  //2->1
				odd.prior=even;
				odd.next=cure;  //1->h
				cure.prior=odd;
				len-=3;
			}
			else {
				cur.next=even.next;  //h->3
				even.next.prior=cur;
				cur=cur.next.next;  //h==4
				DuLNode<S> temp=cur.next;  //存5
				cur.next=odd;  //4->1
				odd.prior=cur;
				even.next=temp;  //2->5
				temp.prior=even;
				len-=4;
				if(temp==head) {  //交换的结点是4的倍数
					break;
				}
				else if(temp!=head && temp.next!=head) {
					even=temp.next;  //更新位置
					odd=temp;
					cur=cur.next.next;
				}
				else if(temp.next==head) {  //交换后只剩一个结点构成循环后直接输出
					temp.next=cure;
					cure.prior=temp;
					break;
				}
			}
		}
	}
	//拆分链表
	public void divide() {
		if(head.next==head || head.next.next==head)
			return;
		DuLNode<S> odd=head.next,even=odd.next;
		DuLNode<S> newHead=new DuLNode<S>();  //创建一个新的空循环双向链表
		newHead.next=even;  //首个偶结点
		even.prior=newHead;
        while(odd!=head && even!=head) {
            odd.next=even.next;  //接奇结点
            even.next.prior=odd;
            odd=even.next;  //更新奇结点位置
            even.next=odd.next;  //接偶结点
            odd.next.prior=even;
            even=odd.next;  //更新偶结点位置
        }
        System.out.print("奇数链为：");
        display();
		//将原双向循环链表的尾切断
		even.next=null;
		System.out.print("偶数链为：");
        DuLNode<S> node1=newHead.next;
		while(node1.next!=null) {
			System.out.print(node1.data+" "); 
			node1=node1.next;
		}
		System.out.println();
	}
	//顺时针递归遍历
	public void clockwise(DuLNode<S> node) {
		if(node.next==head)
			return;  //返回空链表
		else {
			System.out.print(node.next.data+" ");
			clockwise(node.next);
		}
	}
	//逆时针遍历
	public void anticlockwise(DuLNode<S> node) {
		if(node.prior==head)
			return;  //返回空链表
		else {
			System.out.print(node.prior.data+" ");
			anticlockwise(node.prior);
		}
	}
	//执行递归
	public void act() {
		System.out.print("顺时针遍历：");
		clockwise(head);
		System.out.println();
		System.out.print("逆时针遍历：");
		anticlockwise(head);
		System.out.println();
	}
}
public class DuLLinkList<S> {
	public static void main(String[] args) throws Exception {
		DuLLink<Integer> dul=new DuLLink<Integer>();
		for(int i=1;i<10;i++) {
			dul.insert(dul.length(),i);
		}
		System.out.print("创建链表：");
		dul.display();
		dul.act();
	//	dul.divide();
		System.out.print("翻转：");
		dul.reverse();
		dul.display();
		System.out.print("两两交换(1-2、3-4)：");
		dul.swap1();
		dul.display();
		System.out.print("两两交换(1-3、2-4)：");
		dul.swap2();
		dul.display();
		System.out.print("删除下标为5的结点：");
		if(data%2==1) {
			dul.remove(i);
		}
		//dul.remove(5);
		dul.display();
		System.out.println("获取下标为2的结点："+dul.get(2));
		System.out.println("获取结点5的下标："+dul.index(5));
		dul.clear();
		System.out.println("链表是否为空："+dul.isEmpty());
	}
}
