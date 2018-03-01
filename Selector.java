import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Brian Betz (betzbri@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  2016-01-15
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
 *
 * @return returns smallest value.
 * @param a is array passed into method parameter.
 */
 
   public static int min(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      int smallest = a[0];
      for (int i = 0; i < a.length; i++) {
         if (a[i] <= smallest) {
            smallest = a[i];
         }
      } 
               
      return smallest;
   }

/**
 * Selects the maximum value from the array a. This method
 * throws IllegalArgumentException if a is null or has zero
 * length. The array a is not changed by this method.
 *
 * @return returns largest value in array.
 * @param a is array passed into method parameter.
 */
 
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      int largest = a[0];
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= largest) {
            largest = a[i];
         }
      } 
               
      return largest;
   }

/**
 * Selects the kth minimum value from the array a. This method
 * throws IllegalArgumentException if a is null, has zero length,
 * or if there is no kth minimum value. Note that there is no kth
 * minimum value if k < 1, k > a.length, or if k is larger than
 * the number of distinct values in the array. The array a is not
 * changed by this method.
 *
 * @return kmin is the kmin of the array.
 * @param a is the array passed into the method parameter.
 * @param k is the int passed into the method parameter.
 */
 
   public static int kmin(int[] a, int k) {
   
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      int[] b = new int[0];
      b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      int kmin = 0;
      int x = 1;
      int c = 1;
      
      for (int i = 0; i < b.length - 1; i++) {
         if (b[i] != b[i + 1]) {
            c++;
         }
      }
        
      if (k < 1 || k > a.length || k > c) {
         throw new IllegalArgumentException();
      }
        
      if (k == 1) {
         kmin = b[0];
      }
        
      for (int i = 0; i < b.length - 1; i++) {
         if (b[i] != b[i + 1]) {
            x++;
         }
         
         if (x == k) {
            kmin = b[i + 1];
         }
      }
      
      return kmin; 
   }

/**
 * Selects the kth maximum value from the array a. This method
 * throws IllegalArgumentException if a is null, has zero length,
 * or if there is no kth maximum value. Note that there is no kth
 * maximum value if k < 1, k > a.length, or if k is larger than
 * the number of distinct values in the array. The array a is not
 * changed by this method.
 *
 *@return returns the kmax value.
 *@param a is the array passed into method parameter.
 *@param k is the int passed into method parameter.  
 */
 
   public static int kmax(int[] a, int k) {
   
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int[] b = new int[0];
      b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      int kmax = 0;
      int x = 1;
      int c = 1;
      
      for (int i = a.length - 1; i > 0; i--) {
         if (b[i] != b[i - 1]) {
            c++;
         }
      }
        
      if (k < 1 || k > b.length || k > c) {
         throw new IllegalArgumentException();
      }
        
      if (k == 1) {
         kmax = b[b.length - 1];
      }
        
      for (int i = b.length - 1; i > 0; i--) {
         if (b[i] != b[i - 1]) {
            x++;
         }
         
         if (x == k) {
            kmax = b[i - 1];
         }
      }
      
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
 
 * @param a is the array passed into method parameter.
 * @param low is the low int passed into method parameter.
 * @param high is the high int passed into method parameter.
 * @return returns the array with the range of ints.
 */
 
   public static int[] range(int[] a, int low, int high) {
   
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
   
      int[] b = new int[0];
      int j = 0;
       
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= low && a[i] <= high) {
            b = Arrays.copyOf(b, b.length + 1);
            
            b[j] = a[i];
            j++;
         }    
      }
         
      return b;
   }
      
/**
 * Returns the smallest value in a that is greater than or equal to
 * the given key. This method throws an IllegalArgumentException if
 * a is null or has zero length, or if there is no qualifying
 * value. Note that key does not have to be an actual value in a.
 * The array a is not changed by this method.
 *
 * @param a is the array passed into method parameter.
 * @param key is the int passed into method parameter.
 * @return returns the int ceiling.
 */
 
   public static int ceiling(int[] a, int key) {
      int[] b = new int[0];
      int j = 0;
      
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= key) {
            b = Arrays.copyOf(b, b.length + 1);
         
            b[j] = a[i];
            j++;
         } 
      }
      
      if (b.length == 0) {
         throw new IllegalArgumentException();
      }
      
      int ceiling = 0;  
      int smallest = b[0];
      for (int z = 0; z < b.length; z++) {
         if (b[z] < smallest) {
            smallest = b[z];
         }
      }
      
      ceiling = smallest;
      
      return ceiling;
   }

/**
 * Returns the largest value in a that is less than or equal to
 * the given key. This method throws an IllegalArgumentException if
 * a is null or has zero length, or if there is no qualifying
 * value. Note that key does not have to be an actual value in a.
 * The array a is not changed by this method.
 *
 * @param a is the array passed into method parameter.
 * @param key is the int passed into method parameter.
 * @return returns the int floor.
 */
 
   public static int floor(int[] a, int key) {
      int[] b = new int[0];
      int j = 0;
      
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      for (int i = 0; i < a.length; i++) {
         if (a[i] <= key) {
            b = Arrays.copyOf(b, b.length + 1);
         
            b[j] = a[i];
            j++;
         } 
      }
      
      if (b.length == 0) {
         throw new IllegalArgumentException();
      }
      
      int floor = 0;
      int largest = b[0];
      for (int z = 0; z < b.length; z++) {
         if (b[z] > largest) {
            largest = b[z];
         }
      }
      
      floor = largest;
      
      return floor;
   }
}
