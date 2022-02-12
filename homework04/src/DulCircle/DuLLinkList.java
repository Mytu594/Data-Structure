package DulCircle;

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
		int length=0;
		DuLNode<S> cur=head.next;
		while(!cur.equals(head)) {
			cur=cur.next;
			++length;
		}
		return length;
	}
	//插入结点
	public void insert(int i,S x) throws Exception{
		DuLNode<S> cur=head.next;
		int j=0;
		while(!cur.equals(head) && j<i) {
			cur=cur.next;
			++j;
		}
		if(j!=i && !cur.equals(head))
			throw new Exception("插入位置不合法");
		DuLNode<S> s=new DuLNode<S>(x);
		cur.prior.next=s;
		s.prior=cur.prior;
		s.next=cur;
		cur.prior=s;
	}
	//删除结点
	public void remove(int i) throws Exception {
		DuLNode<S> cur=head.next;
		int j=0;
		while(!cur.equals(head) && j<i) {
			cur=cur.next;
			++j;
		}
		if(i!=j)
			throw new Exception("删除位置不合理");
		cur.prior.next=cur.next;
		cur.next.prior=cur.prior;
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
		DuLNode<S> cur=head.next;
		int j=0;
		while(!cur.equals(head) && j<i) {
			cur=cur.next;
			++j;
		}
		if(j>i || cur.equals(head))
			throw new Exception("第"+i+"个元素不存在");
		return cur.data;
	}
	//查找，输出下标
	public int index(S x) {
		DuLNode<S> cur=head.next;
		int j=0;
		while(!cur.equals(head) && !cur.data.equals(x)) {
			cur=cur.next;
			++j;
		}
		if(!cur.equals(head))
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
	//链表转置
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
	public void swapPairs1_2() {
		DuLNode<S> odd=head.next;
		DuLNode<S> even=odd.next;
		while(odd!=head && even!=head) {
			odd.prior.next=even;  //交换1-2
			even.prior=odd.prior; //抽调1
			odd.next=even.next; 
			even.next.prior=odd;  
			odd.prior=even;  
			even.next=odd;   
			odd=odd.next;  //更新位置
			even=odd.next;
		}
	}
	public void swapPairs1_3() {
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



//	//翻转链表
//	public void reverse() {
//		DuLNode<S> pre=head;
//		DuLNode<S> cur=head.next;
//        while (cur!=head) {
//            DuLNode<S> temp=cur;
//            cur=cur.next;  //cur指针后移
//            temp.next=pre;  //反转
//            pre.prior=temp;
//            pre=temp;  //pre指针后移
//        }
//        pre.prior=head;
//        head.next=pre;
//	}
//	//两两交换（1-2、3-4）
//	public void swap1() {
//		DuLNode<S> odd=head.next;
//		DuLNode<S> even=odd.next;
//		while(odd!=head && even!=head) {
//			odd.prior.next=even;  //交换1-2
//			even.next.prior=odd;
//			odd.next=even.next;  //分别连接1、2前后
//			even.prior=odd.prior;
//			odd.prior=even;  //连接1-2
//			even.next=odd;
//			odd=odd.next;  //更新位置
//			even=odd.next;
//		}
//	}
//	//两两交换（1-3、2-4）
//	public void swap2() {
//		DuLNode<S> cur=head;
//		DuLNode<S> cure=head;
//		DuLNode<S> odd=head.next;
//		DuLNode<S> even=odd.next;
//		int len=length();
//		while(odd.next!=head && even!=head) {
//			if(len==2) {  //交换后剩余两个节点构成循环后直接输出
//				even.next=cure;
//				cure.prior=even;
//				break;
//			}
//			else if(len==3) {
//				cur.next=even.next;  //h->3
//				even.next.prior=cur;
//				cur=cur.next;  //h==3
//				cur.next=even;  //3->2
//				even.prior=cur;
//				even.next=odd;  //2->1
//				odd.prior=even;
//				odd.next=cure;  //1->h
//				cure.prior=odd;
//				len-=3;
//			}
//			else {
//				cur.next=even.next;  //h->3
//				even.next.prior=cur;
//				cur=cur.next.next;  //h==4
//				DuLNode<S> temp=cur.next;  //存5
//				cur.next=odd;  //4->1
//				odd.prior=cur;
//				even.next=temp;  //2->5
//				temp.prior=even;
//				len-=4;
//				if(temp==head) {  //交换的结点是4的倍数
//					break;
//				}
//				else if(temp!=head && temp.next!=head) {
//					even=temp.next;  //更新位置
//					odd=temp;
//					cur=cur.next.next;
//				}
//				else if(temp.next==head) {  //交换后只剩一个结点构成循环后直接输出
//					temp.next=cure;
//					cure.prior=temp;
//					break;
//				}
//			}
//		}
//	}
//	//拆分链表
//	public void divide() {
//		if(head.next==head || head.next.next==head)
//			return;
//		DuLNode<S> odd=head.next,even=odd.next;
//		DuLNode<S> newHead=new DuLNode<S>();  //创建一个新的空循环双向链表
//		newHead.next=even;  //首个偶结点
//		even.prior=newHead;
//        while(odd!=head && even!=head) {
//            odd.next=even.next;  //接奇结点
//            even.next.prior=odd;
//            odd=even.next;  //更新奇结点位置
//            even.next=odd.next;  //接偶结点
//            odd.next.prior=even;
//            even=odd.next;  //更新偶结点位置
//        }
//        System.out.print("奇数链为：");
//        display();
//		//将原双向循环链表的尾切断
//		even.next=null;
//		System.out.print("偶数链为：");
//        DuLNode<S> node1=newHead.next;
//		while(node1.next!=null) {
//			System.out.print(node1.data+" "); 
//			node1=node1.next;
//		}
//		System.out.println();
//	}
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
	public void recursion() {
		System.out.print("递归顺时针：");
		clockwise(head);
		System.out.println();
		System.out.print("递归逆时针：");
		anticlockwise(head);
		System.out.println();
	}
}
	
public class DuLLinkList<S> {
	public static void main(String[] args) throws Exception {
		DuLLink<Integer> dul=new DuLLink<Integer>();
		for(int i=1;i<7;i++) {
			dul.insert(dul.length(),i);
		}
		System.out.print("创建链表：");
		dul.display();
		dul.reverse();
		System.out.print("链表转置：");
		dul.display();
//	//	dul.divide();
//		System.out.print("翻转：");

		System.out.print("两两交换(1-2、3-4)：");
		dul.swapPairs1_2();
		dul.display();
//		System.out.print("两两交换(1-3、2-4)：");
//		dul.swap2();
//		dul.display();
		System.out.print("删除第二个：");
		dul.remove(1);
		dul.display();
		System.out.println("第三位是："+dul.get(2));
		System.out.println("5的下标是："+dul.index(2));
		dul.recursion();
		dul.clear();
		System.out.println("链表是否为空："+dul.isEmpty());
	}
}

