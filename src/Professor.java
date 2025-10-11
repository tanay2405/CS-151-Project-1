package src;

import java.util.*;


public class Professor  {


   private int professorID;
  private String professorName;
  private String email;
  private int courseID1;
  private int courseID2;
  private int courseID3;
  private Map<String, Integer> schedule = new HashMap<>();


  public Professor(int professorID, String professorName,  String email, int courseID1, int courseID2, int courseID3) {
      this.professorID = professorID;
      this.professorName = professorName;
      this.email = email;
      this.courseID1 = courseID1;
      this.courseID2 = courseID2;
      this.courseID3 = courseID3;

 }

  public void setProfessorID(int professorID) {
      this.professorID = professorID;
  }
  public int getProfessorID() {
      return professorID;
  }
  public void setProfessorName(String professorName) {
      this.professorName = professorName;
  }
  public String getProfessorName() {
      return professorName;
  }
  public void setEmail(String email) {
      this.email = email;
  }
  public String getEmail() {
      return email;
  }
  public int getCourseID1() {
      return courseID1;
  }
  public void setCourseID1(int courseID1) {
      this.courseID1 = courseID1;
  }
  public int getCourseID2() {
      return courseID2;
  }
  public void setCourseID2(int courseID2) {
      this.courseID2 = courseID2;
  }
  public int getCourseID3() {
      return courseID3;
  }
  public void setCourseID3(int courseID3) {
      this.courseID3 = courseID3;
  }




  public void approveStudent(List<Student> studentsList) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter your Professor ID: ");
       int profInput = scanner.nextInt();
       if (profInput != this.professorID) {
           System.out.println("Error: Wrong Professor ID. Please Try Again.");
           return;
       }
       System.out.print("Enter Student ID to approve: ");
       int studentIDInput = scanner.nextInt();
       int count = 0;
       Student studentEX = null;
       for (Student s : studentsList) {
           if (s.getStudID() == studentIDInput) {
                studentEX = s;
                break;
            }
       }
        for(Course c :  studentEX.getCourses()){
            
            if (studentEX.getGrades()[count] == null && checkIfCourseIsTaughtByProfessor(c)){ 
                System.out.println("Approve Student for " + c.getCourseName() + "? Enter Y or N: ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("Y")) {
                    studentEX.getGrades()[count].setGradeID(100);
                    System.out.println("Approved Student");
                } else {
                    System.out.println("Didn't Approve Student");
                }
            }
            count++;
        }
        
   }

   public boolean checkIfCourseIsTaughtByProfessor(Course c) {
        if (c.getCourseID() == courseID1 || c.getCourseID() == courseID2 || c.getCourseID() == courseID3) {
            return true;
        }
        return false;
   }

    
    public void dropStudent(List<Student> studentsList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Professor ID: ");
        int profInput = scanner.nextInt();
        if (profInput != this.professorID) {
           System.out.println("Error: Wrong Professor ID. Please Try Again.");
           return;
        }
        System.out.println("Enter StudentID to drop");
        int studentIDInput = scanner.nextInt();
        int count = 0;
        Student studentEX = null;
        for (Student s : studentsList) {
            if (s.getStudID() == studentIDInput) {
                studentEX = s;
                break;
            }
        }
        for(Course c :  studentEX.getCourses()){
            
            if (studentEX.getGrades()[count] != null && checkIfCourseIsTaughtByProfessor(c)){ 
                System.out.println("Drop Student for " + c.getCourseName() + "? Enter Y or N: ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("Y")) {
                    studentEX.getGrades()[count] = null;
                    studentEX.getCourses()[count] = null; 
                    System.out.println("Dropped Student");
                } else {
                    System.out.println("Didn't Drop Student");
                }
            }
            count++;
        }


    }
}

    
