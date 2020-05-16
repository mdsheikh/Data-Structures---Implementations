package dLinkedList;

public class DLinkedList<E> {
	
	private static class DNode<E>{
		private E element;
		private DNode<E> prev;
		private DNode<E> next;
		public DNode<E> data;
		
		public DNode(E e) {
			this(e,null,null);
		}
		
		public DNode(E e, DNode<E> p, DNode<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		
		public void setE(E element) {
			this.element = element;
		}
		public void setPrev(DNode<E> p) {
			this.prev = p;
		}
		
		public void setNext(DNode<E> n) {
			this.next = n;
		}
		public E getE() {
			return element;
		}
		public DNode<E> getPrev(){
			return prev;
		}
		public DNode<E> getNext(){
			return next;
		}
		
		
	}

	private DNode<E> head;
	private DNode<E> tail;
	private int size;
	
	public DLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void addFirst(E e) {
		DNode<E> tempSec = head.getNext();
		DNode<E> tempN = new DNode<E>(e, head, tempSec );
		tempSec.setPrev(tempN);
		head.setNext(tempN);
		
		size++;
	}
	
	public void addLast(E e) {
		DNode<E> tempSec = tail.getPrev();
		DNode<E> tempN = new DNode<E> (e, tempSec, tail);
		tempSec.setNext(tempN);
		tail.setPrev(tempN);
		
		size++;
	}
	
	public void print() {
		if(head == null || size == 0) return;
		
		DNode<E> temp = head.getNext();
		while(temp != null) {
			System.out.println(temp.getE() + " ");
			temp = temp.getNext();
		}
		
	    System.out.println();
		
		
	}
	
	public void remove(DNode<E> data) {
		
		if(head == null || size == 0) return;
		DNode<E> current = head.getNext();
		while(current != null) {
			if(current.getNext().data == data) {
				current.getNext()= current.getNext(). getNext();
				return;
			}
			current = current.getNext();
			
		}
		
	}
	


}
