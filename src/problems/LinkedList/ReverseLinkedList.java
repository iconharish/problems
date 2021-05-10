package problems.LinkedList;

public class ReverseLinkedList {
	static class Node {
		int data;
		Node next;
	}
	
	Node getReversedLinkedList(Node head) {
		
		Node previous = null;
		Node curr = head;
		
		
		while (curr != null) {
			
			Node next = curr.next;
			
			curr.next = previous;
			
			previous = curr;
			
			curr = next;
		}
		
		return previous;
		
	}
}
