import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import java.util.Arrays;


public class SelectorTest {

   private int[] a1 = {1, 4, 6, 3, 10};
   private int[] a2 = {1, 3, 5, 7, 9};
   private int[] a3 = {2, 8, 8, 7, 3, 3, 4};
   private int[] a4 = {8, 7, 6, 5, 4};
   private int[] a5 = {2, 8, 7, 3, 4};
   private int[] b = {2, 3, 4};

   private int target;
   private int expected;


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** A test that always fails. 
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }*/
   
   @Test public void minTest() {
      target = 1;
      expected = 1;
      Assert.assertEquals(1, Selector.min(a2));
   }
    
   @Test(expected = IllegalArgumentException.class)
   public void minTest2() {
      int[] a = {};
      Selector.min(a);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void minTest3() {
      int[] a = null;
      Selector.min(a);
   }
   
   @Test public void maxTest() {
      Assert.assertEquals(10, Selector.max(a1));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void maxTest2() {
      int[] a = null;
      Selector.min(a);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void maxTest3() {
      int[] a = {};
      Selector.min(a);
   }
   
   @Test public void kminTest() {
      Assert.assertEquals(8, Selector.kmin(a3, 5));
   } 
   
   @Test(expected = IllegalArgumentException.class)
   public void kminTest2() {
      int[] a = {};
      Selector.range(a, 1, 5);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void kminTest3() {
      int[] a = null;
      Selector.range(a, 1, 5);
   }
   
   @Test public void kmaxTest1() {
      Assert.assertEquals(4, Selector.kmax(a4, 5));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void kmaxTest2() {
      int[] a = null;
      Selector.kmax(a, 1);
   }
  
   @Test(expected = IllegalArgumentException.class)
   public void kmaxTest3() {
      int[] a = {};
      Selector.kmax(a, 1);
   }
   
   @Test public void rangeTest() {
      Assert.assertArrayEquals(b, Selector.range(a5, 1, 5));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void rangeTest2() {
      int[] a = {};
      Selector.range(a, 1, 5);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void rangeTest3() {
      int[] a = null;
      Selector.range(a, 1, 5);
   }
   
   @Test public void ceilingTest() {
      Assert.assertEquals(2, Selector.ceiling(a5, 1));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void ceiling2() {
      int[] a = null;
      Selector.ceiling(a, 1);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void ceiling3() {
      int[] a = {};
      Selector.ceiling(a, 1);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void ceiling4() {
      int[] a = {8, 8, 8, 8, 8};
      Selector.ceiling(a, 9);
   }
   
   @Test public void floorTest() {
      Assert.assertEquals(4, Selector.floor(a5, 6));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void floorTest2() {
      int[] a = {7, 7, 7, 7};
      Assert.assertEquals(expected, Selector.floor(a, 1));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void floorTest3() {
      int[] a = {};
      Assert.assertEquals(expected, Selector.floor(a, 1));
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void floorTest4() {
      int[] a = null;
      Assert.assertEquals(expected, Selector.floor(a, 1));
   }  
}
