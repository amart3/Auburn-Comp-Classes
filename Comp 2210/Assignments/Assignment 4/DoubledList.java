import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * List.java. Describes the abstract behavior of a list collection.
 * This interface together with one or more subinterfaces describe the behavior
 * of a specific type of list.
 *
 * All list types prohibit nulls but allow duplicates. That is, if e1 == null
 * then e1 is not allowed as a list element. If e1.equals(e2) both e1 and e2
 * are allowed as list elements.
 * 
 * @author   Lawrence Martin (LAM0097)
 * @version  2019/10/13
 */
public class DoubledList<T> implements DoubleEndedList<T> {

   private Node front;
   private Node last;
   private int size;
   
   /**
   * Creates a RandomList object.
   */
   public DoubledList() {
      front = null;
      size = 0;
   }

   /**
   * Creates a RandomList object.
   */
   public void addFirst(T element) {
   
      if (element == null) {
         throw new IllegalArgumentException();
      }
   
      Node n = new Node(element);
      
      if (size() == 0) {
      
         front = n;
         last = n;
      }
      
      else {
         n.next = front;
         front = n;
      }
      
      size++;  
   }

   /**
   * Creates a RandomList object.
   */
   public void addLast(T element) {
   
      if (element == null) {
         throw new IllegalArgumentException();
      }
   
      Node n = new Node(element);
      n.element = element;
      
      if (size == 0) {
         front = n;
         last = n;
      }
      
      else {
         last.next = n;
         last = n;
      }
      
      size++;
   }

   /**
   * Creates a RandomList object.
   */
   public T removeFirst() {
   
      if (size == 0) {
         return null;
      }
      
      T deleted = front.element;
      front = front.next;
      size--;
   
      return deleted;
   }
   
   /**
   * Creates a RandomList object.
   */
   
   public T removeLast() {
   
      if (size == 0) {
         return null;
      }
      
      else if (size == 1) {
      
         T deleted = front.element;
         front = null;
         last = null;
         size--;
         return deleted;
      }
      
      else {
         Node n = front;
      
         while (n.next.next != null) {
            n = n.next;
         }
      
      
         T deleted = n.next.element;
         n.next = null;
         last = n;
         size--;
         return deleted;
      }
      
   }

/**
   * Creates a RandomList object.
   */
   public int size() {
   
      return size;
   }

/**
   * Creates a RandomList object.
   */
   public Iterator<T> iterator() {
   
      return new Iteration();
   }

/**
   * Creates a RandomList object.
   */
   public boolean isEmpty() {
   
      return size == 0;
   }
   
   /**
   * Creates a RandomList object.
   */
   private class Node {
   
      private T element;
      private Node next;
   
      public Node(T t) {
      
         element = t;
      }
   /**
   * Creates a RandomList object.
   */
   
      public Node(T t, Node n) {
      
         element = t;
         next = n;
      }
   
   }
   
   /**
   * Creates a RandomList object.
   */
   private class Iteration implements Iterator<T> {
   
      private Node now = front;
   
      public T next() {
      
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         
         T result = now.element;
         now = now.next;
        
         return result;
      }
   /**
   * Creates a RandomList object.
   */
   
      public boolean hasNext() {
      
         return now != null;
      }
   
   /**
   * Creates a RandomList object.
   */
      public void remove() {
      
         throw new UnsupportedOperationException();
      }
   }

}

   
