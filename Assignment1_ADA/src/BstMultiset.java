import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T extends Comparable<T>> extends Multiset<T>
{
	Node root;
	public BstMultiset() {
		root=null;

	} // end of BstMultiset()

	public void add(T item) {
		// Implement me!
		root=addRecursive(root,item);
	} // end of add()


	public Node addRecursive(Node root,T item)
	{
	
		Node new_node=new Node(item);
		new_node.setOccurances(1);
		if(root==null)
		{
			//new_node.setOccurances(1);
			root = new_node;
			return root;
		}
		if(root.getKey().compareTo(item)==0)
		{
			root.setOccurances(root.getOccurances()+1);
			return root;
		}
		if(root.getKey().compareTo(item)>0)
		{
			root.left = addRecursive(root.getLeft(), item);
		}
		else if(root.getKey().compareTo(item)<0)
		{
			root.right = addRecursive(root.getRight(), item);
		}
		return root;
	}

	public int search(T item) {
		// Implement me!

		return searchRec(root,item);
		// default return, please override when you implement this method

	} // end of add()


	public int searchRec(Node root,T item)
	{
		if(root==null)
			return 0;
		if ( root.getKey().equals(item)) {
			return root.getOccurances();
		}
		if (root.getKey().compareTo(item)>0)
			return searchRec(root.getLeft(), item);
		else
			return searchRec(root.getRight(), item);
	}
	public void removeOne(T item) {
		int occ=decreaseOccurances(root,item);
		if(occ==0)
			root=removeAllRec(root,item);
	} // end of removeOne()


	private int decreaseOccurances(Node root,T item) {
		// TODO Auto-generated method stub

		if(root==null)
			return 0;
		if (root==null || root.getKey().equals(item)) {
			root.setOccurances(root.getOccurances()-1);
			return root.getOccurances();
		}
		if (root.key.compareTo(item)>0)
			return  decreaseOccurances(root.getLeft(), item);
		else
			return   decreaseOccurances(root.getRight(), item);
		// TODO Auto-generated method stub	
	
	}

	public void removeAll(T item) {
		// Implement me!
		root=removeAllRec(root,item);
	} // end of removeAll()

	public Node removeAllRec(Node root, Comparable comparable)
	{       
		if (root == null)  
			return root;
		if (root.getKey().compareTo(comparable)>0)
			root.setLeft(removeAllRec(root.getLeft(), comparable));
		else if (root.getKey().compareTo(comparable)<0)
			root.right = removeAllRec(root.right, comparable);
		else
		{
			if (root.left == null)
				return root.getRight();
			else if (root.right == null)
				return root.getLeft();
			Node minimumNode=minimum(root.getRight());
			root.setKey(minimumNode.getKey());
			root.setOccurances(minimumNode.getOccurances());
			root.right = removeAllRec(root.getRight(), root.getKey());
		}
		return root;
	}
	private Node minimum(Node node) {
		Node new_node=node;
		while (new_node.getLeft() != null)
		{
			new_node=new_node.getLeft();
		}
		return new_node;
	}

	public void print(PrintStream out) {
		// Implement me!
		inorderRec(root);
	} // end of print()

	// A utility function to do inorder traversal of BST
	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key + " | "+root.getOccurances());
			inorderRec(root.right);
		}
	}
	class Node<T extends Comparable<T>>{
		T key;
		int occurances;
		Node left, right;

		public T getKey() {
			return key;
		}

		public void setKey(T key) {
			this.key = key;
		}

		public int getOccurances() {
			return occurances;
		}

		public void setOccurances(int occurances) {
			this.occurances = occurances;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node(T item) {
			key = item;
			left = right = null;
			occurances=0;
		}
	}
} // end of class BstMultiset
