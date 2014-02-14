/**


Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space.

 You may not modify the values in the list, only nodes itself can be changed.





**/


public class SwapNodesInPairs{


	public static void main(String args[]) {

		// create test array
		LinkedNode n1 = new LinkedNode(1);
		LinkedNode n2 = new LinkedNode(2);
		LinkedNode n3 = new LinkedNode(3);
		LinkedNode n4 = new LinkedNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		// before and after swap
		printNodes(n1);
		printNodes(swapNodesInPairs(n1));

	}
	
	private static LinkedNode swapNodesInPairs(LinkedNode n) {

		if (n==null || n.next==null)
			return null;

		// let's swap  n and n.next
		LinkedNode reversed = swapNodesInPairs( n.next.next);
                LinkedNode temp = n.next;
		n.next = reversed;
		temp.next = n;

		return temp;
	}

	private static void printNodes (LinkedNode n) {

		while (n!=null) {
			System.out.print(n.value+" ");
			n = n.next;
		
		}

		System.out.println();
	}

}

class LinkedNode {

	int value;
	LinkedNode next;

	
	public LinkedNode(int v){
		this.value=v;
		this.next=null;
	}
}
