package problems.LinkedList;

public class DeleteElement {

	static class Node {
		int data;
		Node next;
	}
	
	private void deleteNode(Node head, int key) {
		if (head == null) {
			return;
		}
		
		if (head.data == key) {
			head = head.next;
		}
		
		Node curr = head;
		while (curr.next != null) {
			if (curr.next.data == key) {
				curr.next = curr.next.next;
				break;
			}
			curr = curr.next;
		}
	}
}
