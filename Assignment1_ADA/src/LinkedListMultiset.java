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
		int occur = getOccurances(item);
		new_node.setOccur(occur + 1);
		if (head != null)
			new_node.setNext(head);
		head = new_node;
	} // end of add()

	private int getOccurances(T item) {
		if (head == null)
			return 0;
		Node start = head;
		int occ = 0;
		while (start != null) {
			if (start.getValue().equals(item)) {
				occ = start.getOccur();
				start.setOccur(occ + 1);

			}
			start = start.getNext();
		}
		return occ;
	}

	public int search(T item) {
		// Implement me!
		if (head == null)
			return 0;
		Node start = head;
		while (start != null) {
			if (start.getValue().equals(item)) {
				return start.getOccur();
			}
			start = start.getNext();
		}
		return 0;
	} // end of add()

	public void removeOne(T item) {
		if (head == null)
			return;
		if (head.getValue().equals(item)) {
			head = head.getNext();
			decreaseOccurances(item);
			return;
		}
		Node start = head;
		Node prev = null;
		int count = 0;
		while (start != null) {
			if (start.getValue().equals(item)) {
				prev.setNext(start.getNext());
				decreaseOccurances(item);
				return;
			} else
				prev = start;
			start = start.getNext();
		}

	} // end of removeOne()

	private void decreaseOccurances(T item) {

		if (head == null)
			return;
		Node start = head;
		while (start != null) {
			if (start.getValue().equals(item)) {
				start.setOccur(start.getOccur() - 1);
			}
			start = start.getNext();
		}

	}

	public void removeAll(T item) {
		// Implement me!
		
		if (head == null)
			return;
		int occur=getOccurances(item);
		int count=0;
		while (head!=null&&head.getValue().equals(item)&&occur>0) {
			head = head.getNext();
			occur--;
		}
		Node start = head;
		Node prev = head;
		while (start != null&&occur>0) {
			if (start.getValue().equals(item)) {
				prev.setNext(start.getNext());
				occur--;
			}
			else
				prev = start;
			start = start.getNext();
		}
	} // end of removeAll()

	public void print(PrintStream out) {
		// Implement me!
		HashSet hs = new HashSet();
		Node start = head;
		if (start == null)
			return;
		while (start != null) {
			if (!hs.contains(start.getValue())) {
				System.out.println(start.getValue() + " | " + start.getOccur());
				hs.add(start.getValue());
			}
			start = start.getNext();

		}
	} // end of print()

	/**
	 * Node type, inner private class.
	 */
	private class Node<T> {
		/** Stored value of node. */
		protected T value;
		/** Reference to next node. */
		protected Node next;
		/** Stored value of number of occur. */
		protected int occur;

		public int getOccur() {
			return occur;
		}

		public void setOccur(int occur) {
			this.occur = occur;
		}

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