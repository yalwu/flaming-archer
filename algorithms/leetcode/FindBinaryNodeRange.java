/**
In a BST, given search key find the Range[Maximum Min, Minimum Max] 
Key = 4.5   O/P Range[4,6]

Key = 7.5   O/P Range[7,8]

Key = 5.5   O/P Range[5,6]


**/






public class FindBinaryNodeRange {

	public static void main(String args[]) {

  BinaryNode node5 = new BinaryNode(5);

        BinaryNode node3 = new BinaryNode(3);

        BinaryNode node1 = new BinaryNode(1);

        BinaryNode node2 = new BinaryNode(2);

        BinaryNode node6 = new BinaryNode(6);

        BinaryNode node7 = new BinaryNode(7);


        node6.right = node7;
        node5.right = node6;

        node3.left = node1;
        node3.right = node2;

        node5.left = node3;


	findBinaryNodeRange(node5, 3.2);



	}


public findBinaryNodeRange(BinaryNode node, double val){

	if (node.value == val) {
		System.out.println("Ok we find what we want");

	}
	else {
		if(val < node.value) {
			if (node.l)
	
		}
	



	}






}







}

class BinaryNode {
	
	double value;

	BinaryNode left;
	BinaryNode right;

	public BinaryNode(double v) {
		this.value=v;
		this.left = null;
		this.right = null;

	}




}
