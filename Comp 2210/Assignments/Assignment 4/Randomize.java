import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

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
 
public class Randomize<T> implements RandomizedList<T> { 
 
 /** 
 Returns the number of elements in the list. 
 */ 
   private T[] elements; 
   private int size; 
   private static final int LENGTH = 1; 
 
   @SuppressWarnings("unchecked") 
   public Randomize() { 
      size = 0;
      elements = (T[]) new Object [LENGTH];
   }
   public Iterator<T> iterator() { 
      Iteration itr = new Iteration(elements, size()); 
      return itr;
   } 
   
   /**
   *creates random list object.
   *@param element added element. 
   */
   public void add(T element) {
      if (element == null) {
         throw new IllegalArgumentException(); 
      } 
      if (size == elements.length) { 
         resize(elements.length * 2); 
      }
      elements[size()] = element; 
      size++; 
   }
   
   /** 
   *Creates random list object. 
   *@param element added element.
   */ 
   public T remove() {
      if (size() == 0) {
         return null;
      }
      int r = new Random().nextInt(size());
      
      T deleted = elements[r];
      elements[r] = elements[size() - 1];
      elements[size() - 1] = null;
      size--;
      
      if (size() > 0 && size() < elements.length / 4) {
         resize(elements.length / 2);
      }
      
      return deleted;
   }

   /**
   * returns a random element from the list.
   * @return the random element.
   */
   public T sample() {
      if (size == 0) {
         return null;
      }
      int r = new Random().nextInt(size());
      return elements[r];
   }
   
   /**
   * returns the size of the list.
   * @return size is the size.
   */
   public int size() {
      return size;
   }
   
   /**
   * checks if the list is empty.
   * @return boolean for if list is empty.
   */
   public boolean isEmpty() {
      return size == 0;
   }
   
   /**
   * resizes elements[] for dynamic memory usage.
   * @param capacity is the new capacity of the array.
   */
   @SuppressWarnings("unchecked")
   private void resize(int capacity) {
   
      T[] array = (T[]) new Object[capacity];
      for (int i = 0; i < size(); i++) {
         array[i] = elements[i];
      }
      elements = array;
   }
      
   /**
   * Defines the behavior of the iterator of RandomList.
   */
   private class Iteration implements Iterator<T> {
      private T[] items;
      private int count;
      private int now;
      
      /**
      * creates special iterator, "Iteration," for program.
      */
      Iteration(T[] array, int amount) {    
         items = array;
         count = amount;
         now = 0;
      }
   
      /**
      * compares the size.
      */
      public boolean hasNext() {
         return (now < size());
      }
      
      /**
      * returns next element of the list.
      * @return the next element.
      */
      public T next() {
         if	(!hasNext()) {
            throw new NoSuchElementException();
         }
         return items[now++];
      }
      
      /**
      *gets overrided.
      */
      public void remove() {
         throw new UnsupportedOperationException();
      }
   
   }

   
   
}
   
   
   
   
   
 

