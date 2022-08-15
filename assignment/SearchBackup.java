package assignment;

/**
  Search.java
  This class contains a collection of search algorithms
*/
public class SearchBackup {

  ////////////////////////////DEMO SEARCH///////////////////////////////////////
  ////////////////////////////DO TOGETHER///////////////////////////////////////

  /**
  * Returns the index of the element numToFind in the array.
  * -1 returned if element not found.
  * pre: none
  * post: index of numToFind has been returned. -1 has been
  * returned if element not found.
  */
  public static int linear(Student[] array, int numToFind) {

    for (int index = 0; index < array.length; index++) {
      if (array[index].getGrade() == numToFind) { // found the element!
        return index;
      }
    }

    // if we get here, no element was found
    return -1;
  }

  /////////////////////////PROGRAMMING EXERCISES////////////////////////////////////
  /////////////////////////COMPLETE ON YOUR OWN/////////////////////////////////////

  /**
  * Returns the index of the element searchString in the array.
  * -1 returned if element not found.
  * pre: none
  * post: index of searchString has been returned. -1 has been
  * returned if element not found.
  */
  public static int linear(Student[] myArray, String searchString) {

    for (int index = 0; index < myArray.length; index++) {
      if (myArray[index].getName().equals(searchString)) { // found the element
        return index;
      } 

    }

    // if we get here, no element was found
    return -1;

  }
}