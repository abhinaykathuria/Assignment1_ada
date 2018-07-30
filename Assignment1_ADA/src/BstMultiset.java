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
		addRecursive(root,item);
	} // end of add()


	public Node addRecursive(Node root,T item)
	{
		Node new_node=new Node(item);
		if(root==null)
		{
			//new_node.setOccurances(1);
			root = new_node;
		}
		//int occur=numberOccur(item);
		//new_node.setOccurances(occur);
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
	private  int numberOccur(T item) {
		
	    
		return 0;
		// TODO Auto-generated method stub	
	}

	public int search(T item) {
		// Implement me!

		// default return, please override when you implement this method
		return 0;
	} // end of add()


	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()


	public void print(PrintStream out) {
		// Implement me!
		inorderRec(root);
	} // end of print()

	 // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
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
