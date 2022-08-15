package assignment;

import java.io.*;

import simpleIO.Console;

/*
* @author Engy Elsayed 
* Date: May 7th 2021 
* Course: ICS4U 
* StudentRecords.java 
* A student records program that gives the user an option to either read information from a file, or to input their own information. The user then gets a display menu where they can choose to either display the list of names and grades, search the list by name, search the list by grade, sort the list by name, sort the list by grade, or to save information to a file. The user can then name the file they want to save their info to. This is the client code for IntSorts, StringSorts, Search, and Student classes.
*/

public class StudentRecords {

  // Array of Student objects
  private static Student[] studentList;

  public static void main(String[] args) {

    // Local constants & variables
    final int DISPLAY = 1, SEARCH_BY_NAME = 2, SEARCH_BY_GRADE = 3, SORT_BY_NAME = 4, SORT_BY_GRADE = 5, SAVE_DATA = 6,
        QUIT = 0;
    int userChoice;
    int displayOption;

    // Get the user's choice for whether they want to input new info or to use
    // prerecorded data
    userChoice = Console
        .readInt("To input new information to the Student Records program\nEnter: 1\nFor prerecorded data\nEnter: 2\n");

    // If the user chooses 1
    if (userChoice == 1) {
      // Local variables
      int numberOfStudents;
      String name;
      double grade;

      // How many students does the user want to enter
      numberOfStudents = Console.readInt("How many Students would you like to add? ");

      // Create the array with the given number of students
      studentList = new Student[numberOfStudents];

      // Ask user for names and grades and keep going for the number of students they
      // chose above
      for (int i = 0; i < studentList.length; i++) {
        name = Console.readString("Enter the name for student #" + (i + 1) + ": ");
        grade = Console.readDouble("Enter the grade for student #" + (i + 1) + ": ");
        // Make a new Student object, store in the array
        // Populate the array with the user input
        studentList[i] = new Student(name, grade);
      }

    } else if (userChoice == 2) {
      // Local variables
      int numberOfStudents = 0;
      double grade = 0;
      String line, name = "";

      // File handling objects
      FileReader studentFile;
      BufferedReader studentStream;

      // Go into try catch block to validate info coming in
      try {
        // Instantiate the file handling objects
        studentFile = new FileReader("data/students.txt");
        studentStream = new BufferedReader(studentFile);

        // First line of the file contains the number of students in the file
        // Read the line as a String, then convert to an int
        line = studentStream.readLine();
        numberOfStudents = Integer.parseInt(line);

        // Create the array with the given number of students
        studentList = new Student[numberOfStudents];

        // Read the rest of the file and fill the array
        for (int i = 0; i < studentList.length; i++) {

          // Get the name from the file (Name is first)
          name = studentStream.readLine();

          // Read the next line as a String, then convert to a double (Grade is next)
          line = studentStream.readLine();
          grade = Double.parseDouble(line);

          // store in array
          studentList[i] = new Student(name, grade);
        }

        // close the file
        studentFile.close();

        // Deal with all the things that could go wrong using try catch blocks
      } catch (FileNotFoundException e) {
        Console.print("No file was found: " + e.getMessage());
      } catch (IOException e) {
        Console.print("Problems reading the file: " + e.getMessage());
      } catch (NumberFormatException e) {
        Console.print("File not formatted properly: " + e.getMessage());
      }

    }

    // Enter do while loop with the display options, only exit if they quit (as well
    // as a message if they input something that is not an option)
    do {
      // Get user's choice of display option
      displayOption = Console.readInt(
          "\nPlease choose from the following menu:\n1. Display the list of students and grades\n2. Search by Name\n3. Search by Grade\n4. Sort by Name\n5. Sort by Grade\n6. Save information to a file\n0. To exit the program\n");

      // if the user chooses DISPLAY
      if (displayOption == DISPLAY) {
        // Print info to the screen
        Console.print("------Student data from file------");
        for (int i = 0; i < studentList.length; i++) {
          Console.print(studentList[i]);
        }

        // else if the user chooses SEARCH_BY_NAME
      } else if (displayOption == SEARCH_BY_NAME) {
        // Call the merge sort method to sort the list by name, before using the binary
        // search method
        StringSorts.mergeSortString(studentList, 0, studentList.length - 1);
        // Temp variable to hold location where the element was found
        int location;
        // Temp variable to hold the name user wants to search for
        String nameToFind;
        // Get user input for name they want to search for
        nameToFind = Console.readString("What name would you like to search for?\n");
        // Call the binary search method, save result in location variable
        location = Search.binary(studentList, nameToFind, 0, studentList.length - 1);
        // If statements for whether the name is found or not.
        if (location == -1) {
          System.out.println("Sorry, name not found in roster.");
        } else {
          // Add 1 to location value so it starts at 1 (more user friendly)
          System.out.println("Your list has been sorted by name for this search.\n"+studentList[location].getName() + " has a grade of " + studentList[location].getGrade());          
          // System.out.println("Your list has been sorted by name for this search.\nFirst occurrence of name "
          //     + nameToFind + " is at element " + (location + 1));
        }

        // else if the user chooses SEARCH_BY_GRADE
      } else if (displayOption == SEARCH_BY_GRADE) {
        // Call the merge sort method to sort the list by grade, before using the binary
        // search method
        IntSorts.mergeSortInt(studentList, 0, studentList.length - 1);
        // Temp variable to hold location where the element was found
        int location;
        // Temp variable to hold the grade user wants to search for
        double gradeToFind;
        // Get user input for grade they want to search for
        gradeToFind = Console.readDouble("What grade would you like to search for?\n");
        // Call the binary search method, save results in location variable
        location = Search.binary(studentList, gradeToFind, 0, studentList.length - 1);
        // If statemts for whether the grade is found or not.
        if (location == -1) {
          System.out.println("Sorry, grade not found in roster.");
        } else {
          // Add 1 to location value so it starts at 1 (more user friendly)
          System.out.println("Your list has been sorted by grade for this search.\nFirst occurrence of grade "
              + gradeToFind + "% is at element " + (location + 1));
        }

        // else if the user chooses SORT_BY_NAME
      } else if (displayOption == SORT_BY_NAME) {
        // Call the merge string sort method to sort the list by name
        StringSorts.mergeSortString(studentList, 0, studentList.length - 1);
        // Print a message to user informing them that their list has been sorted
        Console.print("Your list has been sorted by name. Please choose the display option to view the sorted list");

        // else if the user chooses SORT_BY_GRADE
      } else if (displayOption == SORT_BY_GRADE) {
        // Call the merge string sort method to sort the list by grade
        IntSorts.mergeSortInt(studentList, 0, studentList.length - 1);
        // Print a message to user informing them that their list has been sorted
        Console.print("Your list has been sorted by grade. Please choose the display option to view the sorted list");

        // else if the user chooses SAVE_DATA
      } else if (displayOption == SAVE_DATA) {
        // File handling objects
        FileWriter studentFile;
        PrintWriter studentPrinter;

        // Try catch block to catch any errors while saving to the file
        try {
          // Print a user friendly message informing user their file is being saved
          Console.print("\nSaving file ...");

          // Local variable to hold the name of the file that the user wants to save their
          // info to
          String fileName;
          // Get user input for file name
          fileName = Console.readString("What would you like to name the file which will hold this information?\n");
          // Instantiate the file handling objects (concatenate the user input to name the
          // file)
          studentFile = new FileWriter("data/" + fileName + ".txt");
          studentPrinter = new PrintWriter(studentFile);

          // The first line of the file will be the number of students that the file
          // contains
          studentPrinter.println(studentList.length);

          // Save contents of the array to the file
          for (int i = 0; i < studentList.length; i++) {
            studentPrinter.println(studentList[i]);
          }

          // Close the file
          studentFile.close();

          // If successful, success message will print
          Console.print("File saved successfully");
          // Catch blocks to catch any possible errors that occur while saving to file
        } catch (IOException e) {
          Console.print("Error writing to file: " + e.getMessage());
        }
        // If user enters a choice that isn't on the menu, stay in loop, but print
        // message reminding them to choose a valid number.
      } else {
        if (displayOption != QUIT) {
          Console.print("Please input a valid list item\n");
        }
      }

      // While condition is that the user does not choose the quit option
    } while (displayOption != QUIT);
  }
}