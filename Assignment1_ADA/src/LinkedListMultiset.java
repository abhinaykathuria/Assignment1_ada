import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T> {
	protected Node head;

	public LinkedListMultiset() {
		// Implement me!
		head = null;
	} // end of LinkedListMultiset()

	public void add(T item) {
		// Implement me!
		Node new_node = new Node(item);
		if (head != null)
			new_node.setNext(head);
			head = new_node;
	} // end of add()

	public int search(T item) {
		// Implement me!
		if (head == null)
			return 0;
		Node start = head;
		int count = 0;
		while (start!= null) {
			if (start.getValue().equals(item)) {
				count++;
			}
			start = start.getNext();
		}
		return count;
	} // end of add()

	public void removeOne(T item) {
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
		if (head == null)
			return;
		while(head.getValue().equals(item)) {
			head=head.getNext();
		}
		Node start = head;
		Node prev = head;
		int count = 0;
		while (start != null) {
			if (start.getValue().equals(item))
				prev.setNext(start.getNext());
			else
				prev = start;
			start = start.getNext();
		}
	} // end of removeAll()

	public void print(PrintStream out) {
		// Implement me!
		HashMap hs=new HashMap();
		Node start=head;
		if(start==null)
			return;
		while(start!=null)
		{
			if(hs.containsKey(start.getValue()))
			{
				int count=(int)hs.get(start.getValue())+1;
				hs.put(start.getValue(),count);
			}
			else
			{
				hs.put(start.getValue(),1);

			}
			start=start.getNext();
		}
		System.out.println(hs);
	} // end of print()

	/**
	 * Node type, inner private class.
	 */
	private class Node<T> {
		/** Stored value of node. */
		protected T value;
		/** Reference to next node. */
		protected Node next;

		public Node(T value) {
			this.value = value;
			next = null;
		}

		public T getValue() {
			return value;
		}

		public Node getNext() {
			return next;
		}

		public void setValue(int value) {
			value = value;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
} // end of class LinkedListMultiset