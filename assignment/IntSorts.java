package assignment;

/*
* @author Engy Elsayed 
* Date: May 7th 2021 
* Course: ICS4U 
* IntSorts.java 
* A class that implements an int sorting algorithm, using the merge sort method of sorting.
*/

public class IntSorts {

  /**
   * Sorts an array of Students from low to high using the merge sort algorithm
   * pre: low > 0, high > 0 
   * post: array has been sorted from low to high (increasing)
   */
  public static void mergeSortInt(Student[] data, int low, int high) {

    // Preventing infinite recursion, use an if statement
    if (low < high) {
      int mid = (low + high) / 2;

      // Recursive mergeSort
      mergeSortInt(data, low, mid); // Sort the left side
      mergeSortInt(data, mid + 1, high); // Sort the right side

      // Merge both sub-lists TOGETHER
      merge(data, low, mid, high);
    }
  }

  /**
   * Merges two sorted portions of data array. 
   * pre: data[start..mid] is sorted. data[mid+1..end] sorted. 
   *        start <= mid <= end 
   * post: data[start..end] is sorted
   */
  private static void merge(Student[] data, int start, int mid, int end) {

    // Create a temporary array of the same type as data (Student array)
    Student[] temp = new Student[data.length];

    // Create new variables to track position in each sub-list and the temp array
    int pos1 = start; // Position/index sub-list 1 (left sub-list)
    int pos2 = mid + 1; // Position/index sub-list 2 (right sub-list)
    int index = start; // Full temp array

    // Process both lists - getting the smallest from each
    // Keep going while both lists still have elements left
    while (pos1 <= mid && pos2 <= end) {
      if (data[pos2].getGrade() < data[pos1].getGrade()) { // Element in right list (pos2) is smaller
        temp[index] = data[pos2]; // Place element from the right list in temp array
        index++; // Increment Index
        pos2++; // Move the index to the next element in right sub-list
      } else { // Otherwise, other, get element from the left list (pos1)
        temp[index] = data[pos1]; // Place element from the left list in temp array
        index++; // Increment Index
        pos1++; // Move the index to the next element in left sub-list
      }
    }

    while (pos1 <= mid) {
      temp[index] = data[pos1]; // Place element from the left list in temp array
      index++; // Increment Index
      pos1++; // Move the index to the next element in left sub-list

    }

    while (pos2 <= end) {
      temp[index] = data[pos2]; // Place element from the right list in temp array
      index++; // Increment Index
      pos2++; // Move the index to the next element in right sub-list

    }

    // Copy temp array back into data
    for (int i = start; i <= end; i++) {
      data[i] = temp[i];
    }
  }
}