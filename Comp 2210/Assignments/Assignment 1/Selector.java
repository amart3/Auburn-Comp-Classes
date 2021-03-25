import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Lawrence Martin (YOU@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  TODAY
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) {
      if (a == null) {
         throw new IllegalArgumentException();
      }
      if (a.length == 0) { 
         throw new IllegalArgumentException(); 
      }
      int min = a[0];
      for (int i = 0; i < a.length; i++) {
         if (a[i] < min) {
            min = a[i];
         }
      }
      return min;
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) {
      if (a == null) {
         throw new IllegalArgumentException(); 
      } 
      if (a.length == 0) { 
         throw new IllegalArgumentException(); 
      }
      int max = a[a.length - 1]; 
      for (int i = 0; i < a.length; i++) {
         if (a[i] > max) {
            max = a[i];
         }
      }
      return max; 
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      if (a == null) { 
         throw new IllegalArgumentException(); 
      }
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (k < 1 || k > a.length) { 
         throw new IllegalArgumentException();
      } 
      int[] arrayFix = Arrays.copyOf(a, a.length);
      Arrays.sort(arrayFix);
      int index = 0;
      int d = 0;
      
      for (int i = 0; i < arrayFix.length - 1; i++) {
         if (arrayFix[i] == arrayFix[i + 1]) {
            index++;
         }
      }
      
      d = arrayFix.length - index;
      
      if (k > d) {
         throw new IllegalArgumentException();
      }
      
      int[] duplicates = Arrays.copyOf(arrayFix, arrayFix.length);
      int start = 0;
      int fix = 1;
      
      while (fix < duplicates.length) {
         if (duplicates[start] == duplicates[fix]) {
            fix++;
         }
         else {
            start++;
            duplicates[start] = duplicates[fix];
            fix++;
         }
      }
      int kmin = duplicates[k - 1];
      return kmin;
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
      if (a == null) { 
         throw new IllegalArgumentException(); 
      }
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (k > a.length || k <= 0) {
         throw new IllegalArgumentException();
      }
      
      int[] arrayFix = Arrays.copyOf(a, a.length);
      Arrays.sort(arrayFix);
      
      int index = 0;
      int d = 0;
      
      for (int i = 0; i < arrayFix.length - 1; i++) {
         if (arrayFix[i] == arrayFix[i + 1]) {
            index++;
         }
      }
      
      d = arrayFix.length - index;
      if (k > d) {
         throw new IllegalArgumentException();
      }
      
      int[] duplicates = Arrays.copyOf(arrayFix, arrayFix.length);
      int start = 0;
      int fix = 1;
      
      while (fix < duplicates.length) {
         if (duplicates[start] == duplicates[fix]) {
            fix++;
         }
         else {
            start++;
            duplicates[start] = duplicates[fix];
            fix++;
         }
      }
      int kmax = duplicates[d - k];
      return kmax;
   }

   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {
      if (a == null) { 
         throw new IllegalArgumentException(); 
      }
      if (a.length == 0) {
         throw new IllegalArgumentException(); 
      }
      int index = 0;
      int i;
      for (i = 0; i < a.length; i++) { 
         if (a[i] >= low && a[i] <= high) {
            index++;
         }
      }
      int[] range = new int[index];
      
      int newIndex = 0;
      for (i = 0; i < a.length; i++) {
         if (a[i] >= low && a[i] <= high) {
            int num = a[i];
            range[newIndex] = num;
            newIndex++;
         }
      }
      return range;
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
      int cap = 0;
      int qual = 0;
   
      if (a == null) {
         throw new IllegalArgumentException();
      }
     
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
    
      for (int i = 0; i < a.length; i++) {
         cap += a[i];
      }
      
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= key && a[i] <= cap) {
            cap = a[i];
            qual++;
         }
      }
      
      if (qual == 0) {
         throw new IllegalArgumentException();
      }
      
      return cap;
   }   

   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
      
      int qual = 0;
      int done = 0;
      if (a == null) {
         throw new IllegalArgumentException();
      }
      
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      for (int i = 0; i < a.length; i++) {
         done -= a[i];
      }
      
      for (int i = 0; i < a.length; i++) {
         if (a[i] <= key && a[i] >= done) {
            done = a[i];
            qual++;
         }
      }
      
      if (qual == 0) {
         throw new IllegalArgumentException();
      }
      
      return done;
   }
   
}
