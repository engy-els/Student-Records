package assignment;

/*
* @author Engy Elsayed 
* Date: May 7th 2021 
* Course: ICS4U 
* Search.java
* This class contains a collection of search algorithms. One to search an int, the other to search a String.
*/

public class Search {

  /**
   * Uses a recursive binary search to return the index of the element searchString in the array. -1 returned if element not found. 
   * pre: array is sorted from low to high 
   * post: index of searchString has been returned. -1 has been returned if element not found.
   */
  public static int binary(Student array[], String searchString, int left, int right) {

    // Base case: item not found
    if (left > right) {
      return -1;
    }

    // Find the location in the middle of the current sub-list
    int middle = (left + right) / 2;

    // Check to see if searchString is found at the middle element
    if (array[middle].getName().equals(searchString)) {
      return middle; // return the location where the searchString was founds

    }

    // Which sub-list should be checked?
    if (array[middle].getName().compareTo(searchString) > 0) { // Check the left side; element too big
      return binary(array, searchString, left, middle - 1);
    } else { // check the right side
      return binary(array, searchString, middle + 1, right);
    }

  }

  /**
   * Uses a recursive binary search to return the index of the element numToFind in the array. -1 returned if element not found. 
   * pre: array is sorted from low to high 
   * post: array numToFind has been returned. -1 has been returned if element not found.
   */
  public static int binary(Student[] array, double numToFind, int left, int right) {
    // Base case: item not found
    if (left > right) {
      return -1;
    }

    // Find the location in the middle of the current sub-list
    int middle = (left + right) / 2;

    // Check to see if numToFind is found at the middle element
    if (array[middle].getGrade() == (numToFind)) {
      return middle; // return the location where the numToFind was found
    }

    // Which sub-list should be checked?
    if (array[middle].getGrade() > numToFind) { // Check the left side
      return binary(array, numToFind, left, middle - 1);
    } else { // check the right side
      return binary(array, numToFind, middle + 1, right);
    }
  }
}