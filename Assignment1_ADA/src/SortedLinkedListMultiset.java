import java.io.PrintStream;
import java.util.*;




public class SortedLinkedListMultiset<T extends Comparable<T>> extends Multiset<T>  
{
	protected Node head;
	
	public SortedLinkedListMultiset() {
		head=null;
	} // end of SortedLinkedListMultiset()
	
	
	public void add(T item) {
		// Implement me!
	//Node new_node=new Node(item);
		Node new_node=new Node(item);
		
		
	if(head==null) {
		head=new_node;
		return;
	}
	if(head.getValue().compareTo(item)>0) {
		new_node.setNext(head);
		head=new_node;
	}
	Node start=head;
	Node prev=head;
		while(start!=null) {
			if(start.getValue().compareTo(item)>0)
			{
				break;
			}
			else
			{
				prev=start;
			}
			start=start.next;
		}
		if(prev!=null)
			prev.setNext(new_node);
		new_node.setNext(start);
			
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		
	
		if (head == null)
			return 0;
		Node start = head;
		int count = 0;
		while (start!= null && start.getValue().compareTo(item)<=0) {
			if (start.getValue().equals(item)) {
				count++;
			}
			
			start = start.getNext();
		}
		return count;
	
	} // end of add()
	
	
	public void removeOne(T item) {
		// Implement me!

		if (head == null)
			return;
		if(head.getValue().equals(item)) {
			head=head.getNext();
			return;
		}
		Node start = head;
		Node prev = null;
		int count = 0;
		while (start != null) {
			if (start.getValue().equals(item)) {
				prev.setNext(start.getNext());
				return;
			}
			else
				prev = start;
			start = start.getNext();
		}

	
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		// Implement me!
		Node start=head;
		while(start!=null) {
			System.out.print(start.getValue()+"->");
		start=start.next;
		}
		System.out.println();
	} // end of print()
	/**
	 * Node type, inner private class.
	 */
	private class Node<T extends Comparable<T>>  {
		/** Stored value of node. */
		protected T value;
		/** Reference to next node. */
		protected Node next;

		public Node(T item) {
			// TODO Auto-generated constructor stub
			value=item;
		}

		public T getValue() {
			return value;
		}

		public Node getNext() {
			return next;
		}

		public void setValue(T item) {
			item = item;
		}

		public void setNext(Node next) {
			this.next = next;
		}		
	}

} // end of class SortedLinkedListMultiset