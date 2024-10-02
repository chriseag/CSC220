package lab09;


// Chapter 17.1 - page 1021
// Class for storing a single node of a binary tree of ints

public class IntNode {
	public int data;
	public IntNode left;
	public IntNode right;
	
	//constructs a leaf node with given data
	public IntNode(int data){
		this(data, null, null);
	}
	
	// constructs a branch node with given data, left subtree, right subtree
	public IntNode(int data, IntNode left, IntNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}







//		if (node == null) {
//node = new IntNode(-1);
//}
//
//if (height <= 0) {
//return null;
//}
//
//if (node.left == null && node.right == null) {
//return null;
//}
//
//
//
//else {
//node.left = perfectify(node.left, height - 1);
//node.right = perfectify(node.right, height - 1);
//return node;
//}