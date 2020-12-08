import java.util.ArrayList;

public class LinkedList<T> {
	
	private class Node{
		public T t;
		public Node next;
		public Node(T t, Node next) { //constructor
			this.t = t;
			this.next = next;
		}
	}
	
	private int index = 0;
	private int size = 0;
	private Node current;
	private Node head;
	
	
	public boolean isEmpty() {
		// 1. check if the list is empty
		if (size == 0) {
			return true;
		}
		return false;
	}
	
	public int size() {
		// 2. return size of the list
		return size;
	}
	public void resetIndex() {
		index = 0;
		current = head;
	}
	public void add(T t) {
		if(size==0) {
			head = new Node(t, null);
		}else {
			current = head;
			while(current.next != null) {
				current = current.next;//若有新輸入則不斷更新current
			}
			current.next = new Node(t, null);//不再有新輸入後建立new node
		}
		size++;
		resetIndex();
	}
	public void add(int index, T t) {
		// 3. add new node by using given index
		if (index == 0)
		{
			head = new Node(t, head);
		}
		else
		{
			current = head;
			for (int i = 1; i < index; i++)
			{
					current = current.next;
			}
			current.next = new Node(t, current.next);
		}
		size++;
		resetIndex();
	}
	
	public T get(int index) {
		// 4. return the node at given index
		T nodeAsked;
		if (index == 0)
		{
			nodeAsked = head.t;
		}
		else
		{
			current = head;
			for (int i = 0; i < index; i++)
			{
					current = current.next;
			}
			nodeAsked = current.t;
		}
		return nodeAsked;
	}
	
	public T remove(int index) {
		// 5. remove the node at given index and return the node
		T deleNode;
		if (index == 0)
		{
			current = head;
			deleNode = current.t;
			head = current.next;
		}
		else
		{
			current = head;
			for (int i = 0; i < index - 1; i++)
			{
					current = current.next;
			}
			deleNode = current.next.t;
			current.next = current.next.next;
		}
		size--;
		resetIndex();
		return deleNode;
	}
	
	public void printList() {
		//6. print the list
		current = head;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<size;i++){
		    sb.append(current.t.toString()+"\n");   
		    current = current.next;
		}
		System.out.print(sb.toString());
	}
}
