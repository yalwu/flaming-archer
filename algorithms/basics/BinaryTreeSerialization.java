/**

Binary Tree Serialization/deserialization

**/

public class BinaryTreeSerialization {

	public static void main(String args[]) {

  	BinaryNode node5 = new BinaryNode(5);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node1 = new BinaryNode(1);
        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node6 = new BinaryNode(6);
	BinaryNode node4 = new BinaryNode(4);
        BinaryNode node7 = new BinaryNode(7);


        node6.right = node7;
        node5.right = node6;

        node3.left = node1;
        node3.right = node4;
	
	node1.right=node2;
        node5.left = node3;

	BinaryTreeSerialization test = new BinaryTreeSerialization();
	
	ListNode node = test.serializeBinaryTree(node5);

	test.printListNode(node);


	BinaryNode bn= test.deserializeListNode(node);
	test.printBinaryNodeInOrder(bn);

	}

	public ListNode serializeBinaryTree(BinaryNode root) {
	
		if (root==null)
			return null;

		ListNode node = new ListNode(root.value);	

		ListNode  left= serializeBinaryTree(root.left);
		if (left!=null)
			node.add(left);

		ListNode right = serializeBinaryTree(root.right);
		if (right!=null)
			node.add(right);

		return node;
	}

	public void printListNode(ListNode n) {
		while(n!=null) {
			System.out.print(n.value+ " ");
			n=n.next;
		}

		System.out.println();
	}

	public BinaryNode deserializeListNode(ListNode n) {
	
		if (n==null)
			return null;

		if (n.next == null)
			return new BinaryNode(n.value);

		ListNode cur = n;
		while (cur.next!=null) {
			if (cur.next.value<n.value)
				cur = cur.next;
			else
				break;
		}

		BinaryNode node = new BinaryNode(n.value);
		if (cur.next != null) {
			BinaryNode rightNode = deserializeListNode(cur.next);
			node.right=rightNode;

			if (cur != n) {
				cur.next=null;		
				BinaryNode leftNode = deserializeListNode (n.next);;
                       		node.left =leftNode;
			}

		} else {
			BinaryNode leftNode = deserializeListNode (n.next);;
			node.left =leftNode;
		}
			
		return node;

	}

	public void printBinaryNodeInOrder(BinaryNode n){

		if (n==null)
			return;
	
		printBinaryNodeInOrder(n.left); 
		System.out.print(n.value+ " ");
              	printBinaryNodeInOrder(n.right);

	}
}


class ListNode {
	
	int value;
	ListNode next;

	public ListNode(int v) {
		this.value =v;
		this.next = null;
	}

	public void add(ListNode n) {
		if (this.next ==null)
			this.next = n;
		else
			this.next.add(n);

	}
	

}

class BinaryNode {

        int value;

        BinaryNode left;
        BinaryNode right;

        public BinaryNode(int v) {
                this.value=v;
                this.left = null;
                this.right = null;

        }
}
