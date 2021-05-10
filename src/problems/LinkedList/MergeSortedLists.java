package problems.LinkedList;

public class MergeSortedLists {
	
	Node getMergedList(Node head1, Node head2) {
		// 1-4-6-8
		// 2-3-7-9
		Node dummy = new Node();
		Node tail = dummy;
		while(true) {
			if (head1 == null) {
				tail.next = head2;
				break;
			}
			
			if (head2 == null) {
				tail.next = head1;
				break;
			}
			
			if (head1.value <= head2.value) {
				tail.next = head1;
				head1 = head1.next;
			} else {
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
		}
		
		return dummy.next;
	}
	
	Node getMergedList1(Node head1, Node head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		
		if (head1.value <= head2.value) {
			head1.next = getMergedList1(head1.next, head2);
			return head1;
		} else {
			head2.next = getMergedList1(head1, head2.next);
			return head2;
		}
	}
	
	
	static class Node {
		int value;
		Node next;
	}

}
