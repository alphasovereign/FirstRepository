package com.datastructures.trees;

public class BST {

	
	public static void main(String[] args) {
		
		BST bst = new BST();
		Tree root = null;
		root = bst.insert(root, 10);
	/*	root = bst.insert(root, 6);
		root = bst.insert(root, 12);
		root = bst.insert(root, 8);*/
	
		System.out.println(  bst.findMin(root)  );
		System.out.println(  bst.findRootHeight(root)  );
	}
	
	public void printBreadthFirstTraversal( Tree tree){
		
		 if( tree == null ){
			 return;
		 }
		 System.out.println( tree.data  );
		 
		 
		
	}
	
	public int findRootHeight(Tree tree){
		
		// Exit criteria
		 if( tree == null ){
			 return -1; // We return -1 in case of height to determine no height exists
		 }
		 
		 int leftHeight = findRootHeight(tree.left);
		 int rightHeight = findRootHeight(tree.right);
		 
		 return Math.max(leftHeight, rightHeight) + 1; 
		
	}

	public int findMin(Tree tree){
		
		//CASE:1 Check if the tree is empty
		if(tree == null){
			return -1;
		}
		
		// Keep Loopoing unless the 
		while( tree.left != null ){
			return findMin( tree.left );
		}
		
		return tree.data;
	}
	
	public Tree insert(Tree tree , int data){
		
		if( tree == null  ){
			tree = new Tree();
			tree.data = data;
			return tree;
		}
		
		if( tree.data > data ){
			tree.left = insert( tree.left, data );
		}
		
		if( tree.data < data ){
			tree.right = insert( tree.right, data );
		}
		return tree;
	}
	
}


class Tree{
	
	int data;
	Tree left;
	Tree right;
	

	
}