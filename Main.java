package dLinkedList;

public class Main {

	public static void main(String[] args) {
             DLinkedListMS<String> ll = new DLinkedListMS<String>();
			
      ll.addFirst("Three");
      ll.addLast("Four");
      ll.addFirst("Two");
      ll.addFirst("One");
      ll.addLast("Five");
      ll.addFirst("Zero");
      ll.print();
			
			
      System.out.println("at 1: " + ll.get(1));
      System.out.println("at 2: " + ll.get(2));
      System.out.println("at 3: " + ll.get(3));
      ll.print();

		

	}

}
