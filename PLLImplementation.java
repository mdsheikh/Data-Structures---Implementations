import java.util.*;
import java.util.LinkedList;

public class PolynomialLinkedListMS{

   private static class PNode{
      private int coe;
      private int exp;
      private PNode next;
      public PNode(int c, int e){
	    this(c, e, null);
      }
      public PNode(int c, int e, PNode n){
	      coe = c;
	      exp = e;
	      next = n;
      }
      public void setCoe(int c){ coe = c;}
      public void setExp(int e){ exp = e;}
      public void setNext(PNode n){ next = n;}
      public int getCoe(){ return coe;}
      public int getExp(){ return exp;}
      public PNode getNext(){ return next;}
   }

	 
   private PNode head;
   public PolynomialLinkedListMS(){
      head = null;
   }

    private void addFirst(int c, int e){
      PNode tempN = new PNode(c, e, head);
      head = tempN;
   }

   public void removeDuplicate(){
      if (head == null) return;
      PNode lookUp, checkPrev;
      lookUp = checkPrev = head;

			while(lookUp.getNext() != null){
	    while (checkPrev.getNext() != null){
	     if (checkPrev.getNext().getExp() == lookUp.getExp()){//found a duplicate
		//lookUp.coe += checkPrev.next.coe;
		      lookUp.setCoe(lookUp.getCoe() + checkPrev.getNext().getCoe());
	      	checkPrev.setNext(checkPrev.getNext().getNext());
	     }
	     else checkPrev = checkPrev.getNext();
	  }
         lookUp = lookUp.getNext();
	       checkPrev = lookUp;
      }	     	     
   }


  public PolynomialLinkedListMS add(PolynomialLinkedListMS pl){
      PNode addTerm = this.head;
      PolynomialLinkedListMS ans = new PolynomialLinkedListMS();
      for (int i = 0; i < 2; i++){
	    while (addTerm != null){
	    ans.addFirst(addTerm.getCoe(), addTerm.getExp());
	    addTerm = addTerm.next;
	  }
         addTerm = pl.head;
      }
      ans.removeDuplicate();
      return ans;	 
   }

   public PolynomialLinkedListMS multiply(PolynomialLinkedListMS pl){
      PolynomialLinkedListMS ans = new PolynomialLinkedListMS();

			PNode addTerm1 = this.head;

			while( addTerm1 != null){
				PNode addTerm2 = this.head;
				while(addTerm2 != null){

					PNode x = addTerm1.getCoe() * addTerm2.getCoe();
					PNode y = addTerm1.getExp() + addTerm2.getExp();

					ans.addFirst(x,y);
          addterm2 = addTerm2.next;

				}

				addTerm1 = addTerm1.next;
			}
			
			//ans.removeDuplivcate();
      return ans;	 
   }

	 
   public void print(){

      if (head == null){
         System.out.println();
         return;
      }
      removeDuplicate();
      PNode temp = head;
      while (temp.getNext() != null){
         if (temp.getCoe() != 0){
	    System.out.print("(" + temp.getCoe() + ")");
	    if (temp.getExp() != 0){
	       System.out.print("X^" + temp.exp);
	    }
	    System.out.print(" + ");
  	 }
	 temp = temp.next;
      }
      if (temp != null){
         System.out.print(temp.coe);
	 if (temp.exp != 0) System.out.print("X^" + temp.exp);
         System.out.println();
      }

   }
  
}