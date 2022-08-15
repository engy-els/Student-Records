package assignment;

/*
* @author Engy Elsayed 
* Date: May 7th 2021 
* Course: ICS4U 
* Student.java 
* A class that holds a Student object.
*/

public class Student {

  //Instance data fields
  private String name;
  private double grade;

  //Constructor
  public Student(String n, double g) {
    name = n;
    grade = g;
  }

  //Accessor methods
  public String getName() {
    return name;
  }
  public double getGrade() {
    return grade;
  }

  @Override
  /**
   * Override the toString() method - defined in the Object class
   * pre : none
   * post:
   * A String with the list of students and grades are returned in a visually appealing way
   */
  public String toString() {
    //Display student name and grade on separate lines
    String studentString = "Name: " + name + "\t\tGrade: " + grade;
    return studentString;
  }
}