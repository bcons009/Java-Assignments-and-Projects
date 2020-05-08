/*
 * File: ArrayRecursion.java
 * Class which creates an array with a random amount of random integers. The 
 * class also includes recursive methods to reverse the array's sorting, return 
 * the largest element's index within a given range, and to sort the array by 
 * ascending order. Also included is an overriden toString method and a main 
 * method to test the class.
 */
package arrayrecursion;

/**
 * Class which creates an array of integers that can be sorted using recursive 
 * methods.
 * @author Bryan Consuegra
 */

import java.util.Random;

public class ArrayRecursion
{
   // instance var's

   private int[] list;		// array of ints
   private int count = 0;	// number of elements used

   /**
    * Create an ArrayRecursion object. Create an array with between 10 and 15
    * elements, and fill it with random positive 2-digit ints
    */
   public ArrayRecursion()
   {
      Random r = new Random();
      count = r.nextInt(6) + 10;
      list = new int[count];

      for (int i = 0; i < count; i++)
      {
         list[i] = r.nextInt(90) + 10;
      }
   }

   /*
    * Return the list as a string
    * @return a string containing all ints stored in list
    */
   public String toString()
   {
      String out = "";
      for (int i = 0; i < count; i++)
      {
         out += list[i] + "  ";
      }
      return out + "\n";
   }

   /**
    * Reverse the order of the values stored in the list. (called by client to
    * reverse list using first algorithm)
    */
   public void reverse()
   {
      reverseRecurse(list, 0, count);
   }

   /**
    * Recursive "helper" method to reverse the values stored in the list 
    * (called by public method reverse()).
    * @param list Array to be sorted.
    * @param start Starting index
    * @param count Number of elements in the array to be checked.
    */
   private void reverseRecurse(int[] list, int start, int count)
   {
       //Using integer temp, swap the values located in list[start] and 
       //list[count - 1].
       int temp = list[start];
       list[start] = list[count - 1];
       list[count - 1] = temp;
       //Recursively call this method if count divded by 2 is less than start, 
       //incrementing start by 1 and decrementing count by 1 each time.
       if(start <= count / 2){
           reverseRecurse(list, start + 1, count - 1);
       }
   }

   /*
    * Returns the index of the largest value in the array.
    * @return the index of the largest value in the array
    */
   public int getIndexOfLargest()
   {
      return recursiveGetIndexOfLargest(list, count);
   }
   
   /**
    * Recursive "helper" method to return index of largest value (called by 
    * public method getLargest()).
    * @param list Array to be sorted.
    * @param count Number of elements in the array to be checked.
    * @return The index of the largest value in the array.
    */
   private int recursiveGetIndexOfLargest(int[] list, int count)
   {
       //If the array has only 1 element...
       //(Impossible with the current skeleton code, but just in case)
       if(this.count == count && count == 1){
           return list[0];
       }
       //Else if count equals zero...
       else if(count == 0){
           //Return count.
           return count;
       }
       //Else, recursively call this function until the value at an index 
       //(count - 1) is greater than the value obtained by a recursive fucntion 
       //call.
       else{
           if (list[count - 1] > list[recursiveGetIndexOfLargest(list, count - 1)]){
               return count - 1;
           }
           else{
               return recursiveGetIndexOfLargest(list, count - 1);
           }
       }
   }

   /*
    * Sort the array in ascending order using the selection sort
    */
   public void sort()
   {
      recursiveSort(list, count);
   }

   /**
    * Recursive "helper" method to sort the array (called by public method 
    * sort()).
    * @param list Array to be sorted.
    * @param count Number of elements in the array to be checked.
    */
   private void recursiveSort(int[] list, int count)
   {
       //Swap the values stored at the end at the array and at the index of the
       //largest value in the array.
       int index = recursiveGetIndexOfLargest(list, count);
       int temp = list[index];
       list[index] = list[count - 1];
       list[count - 1] = temp;
       //If count is greater than 1, recursively call this function, with 
       //parameter count decremented by 1.
       if(count > 1){
           recursiveSort(list, count - 1);
       }
   }
   
    public static void main(String[] args)
   {
      ArrayRecursion list = new ArrayRecursion();

      System.out.println("\nOriginal:  " + list);
      list.reverse();
      System.out.println("\nReversed:    " + list);
      System.out.println("Largest value is at index: "
              + list.getIndexOfLargest());
      list.sort();
      System.out.println("\nSorted:    " + list);
   }
}
