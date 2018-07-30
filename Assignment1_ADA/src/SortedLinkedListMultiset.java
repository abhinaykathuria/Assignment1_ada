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

		int occur = getOccurances(item);
		if(occur>0)
			return;
		Node new_node=new Node(item);
		new_node.setOccur(1);
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
		while (start!= null && start.getValue().compareTo(item)<=0) {
			if (start.getValue().equals(item)) {
				return start.getOccur();
			}

			start = start.getNext();
		}
		return 0;

	} // end of add()


	public void removeOne(T item) {
		// Implement me!

		if (head == null)
			return;
		
		if (head.getValue().equals(item)) {
			if(head.getOccur()>1)
				head.setOccur(head.getOccur()-1);
			else
				head = head.getNext();
			return;
		}
		Node start = head;
		Node prev = null;
		int count = 0;
		while (start != null&& start.getValue().compareTo(item)<=0) {
			if (start.getValue().equals(item) ) {
				if(start.getOccur()>1)
				{
					start.setOccur(start.getOccur()-1);
					return;
				}
				else
				{
					prev.setNext(start.getNext());
					return;
				}
			} else
				prev = start;
			start = start.getNext();
		}
		
	} // end of removeOne()

	public void removeAll(T item) {
		
		if (head == null)
			return;
		if (head!=null&&head.getValue().equals(item)) {
			head = head.getNext();
			return;
		}
		Node start = head;
		Node prev = head;
		while (start != null&& start.getValue().compareTo(item)<=0) {
			if (start.getValue().equals(item)) {
				prev.setNext(start.getNext());
				return;
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
	private class Node<T extends Comparable<T>>  {
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