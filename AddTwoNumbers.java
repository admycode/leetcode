/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

class ListNode{
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
	
		ListNode sol = null;
		ListNode temp = null;
		int carry = 0;
		while((l1 != null) || (l2 != null)){
			int i=0;
			int j=0;
			if(l1 != null){
				i = l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				j = l2.val;
				l2 = l2.next;
			}
			int res = i + j + carry;
			carry = res/10;
			res = res%10;
			//System.out.println(res);
			//System.out.println(carry);
			ListNode newnode = new ListNode(res);

			if(sol == null){
				sol = newnode;
				temp = sol;
			} else {
				temp.next = newnode;
				temp = temp.next;
			}
		}
		if(carry > 0){
			temp.next = new ListNode(carry);
			temp = temp.next;
		}

		return sol;
	}

	public static void main(String[] args){
		
		ListNode node1 = new ListNode(5);
		//node1.next = new ListNode(8);
		//node1.next.next = new ListNode(3);

		ListNode node2 = new ListNode(5);
		//node2.next = new ListNode(6);
		//node2.next.next = new ListNode(4);

		ListNode result = addTwoNumbers(node1, node2);

		while(result != null){
			System.out.println(result.val + "->");
			result = result.next;
		}
	}

}
