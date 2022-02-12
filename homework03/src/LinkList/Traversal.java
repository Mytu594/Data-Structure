package LinkList;


class Traversal{
	//Ë³Ðò±éÀú
	public static void traversal(Node node,Node pre) {
		if(node==null)
			return;
		Node next=node.next;
		traversal(next,node);
		node.next=pre;
		System.out.print(node.data+" ");
	}
	//ÄæÐò±éÀú
	public static void reverse(Node node,Node pre) {
		if(node==null)
			return;
		Node next=node.next;
		node.next=pre;
		reverse(next,node);
	}
	
	public static void printNode(Node node) {
		System.out.print(node.data+" ");
		if(node.next!=null) {
			printNode(node.next);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Node node5=new Node(5);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		reverse(node1,null);
		printNode(node5);
		System.out.println();	
		traversal(node5,null);			
	}

}
