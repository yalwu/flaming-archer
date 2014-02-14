/**

Given a binary tree, flatten it to a linked list in-place.
For example, Given
         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like: 
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

**/

public class FlattenBinaryTreeToLinkedList {


	public static void main(String args[]) {

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		node1.left = node2;
		node1.right = node5;
		node2.left = node3;
		node2.right = node4;
		node3.left = null;
		node3.right = null;
		node4.left = null;
		node4.right = null;
		node5.left = null;
		node5.right = node6;
		node6.left = null;
		node6.right = null;

		FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
		Node list = test.flatten(node1);
	
		while (list!=null) {
			System.out.print(list.value+" --> ");
			list = list.right;
		}

		System.out.println("null");
	}

	public Node flatten(Node root){
		if (root == null) {		
			return null;
		}
		Node left_list = flatten (root.left);		
		
		Node right_list = flatten (root.right);
		
		if (left_list !=null) {
			root.right = left_list;

			 // get to the end of left_list
               		 while (left_list.right!=null) {
				left_list = left_list.right;
			}
			left_list.right = right_list;
		}
		else {
			root.right = right_list;
		}
		return root;	
	}

}

class Node {
	int value;
	Node left;
	Node right;

	public Node (int v) {
		this.value = v;
		this.left = null;
		this.right = null;
	}

}
