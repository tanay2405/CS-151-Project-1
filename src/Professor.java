package src;

import java.util.*;

public class Professor implements Person  {
    private int professorID;
    private String professorName; 
    private String email;
    private int courseID1;
    private int courseID2;
    private int courseID3;
    private Map<String, Integer> officeHours = new HashMap<>();
    
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
    public Map<String, Integer> getOfficeHours() {
        return officeHours;
    }
    public void setOfficeHours(Map<String, Integer> officeHours) {
        this.officeHours = officeHours;
    }

    // Helper Method
    private Student verifyProfInputs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Professor ID: ");
        int profInput = scanner.nextInt();
        if (profInput != this.professorID) {
            System.out.println("Error: Wrong Professor ID. Please Try Again.");
            return null;
        }
        System.out.print("Enter Student ID: ");
        int studentIDInput = scanner.nextInt();
        for (Student s : studentsList) {
            if (s.getStudID() == studentIDInput) {
                return s;
            }
        }
        System.out.println("Student not found.");
        return null;
    }

    // Method 1
    public void approveStudent() {
        Student studentEX = verifyProfInputs();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        for(Course c :  studentEX.getCourses()){
            if (studentEX.getGrades()[count] == null && checkIfCourseIsTaughtByProfessor(c)){ 
                System.out.println("Approve Student for " + c.getCourseName() + "? Enter Y or N: ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("Y")) {
                    studentEX.getGrades()[count] = new Grade();
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

    // Method 2
    public void dropStudent() {
        Student studentEX = verifyProfInputs();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        
        for(Course c :  studentEX.getCourses()){
            
            if (studentEX.getGrades()[count] != null && checkIfCourseIsTaughtByProfessor(c)){ 
                System.out.println("Drop Student for " + c.getCourseName() + "? Enter Y or N: ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("Y")) {
                    studentEX.getGrades()[count] = new Grade();
                    studentEX.getCourses()[count] = new Course(); 
                    System.out.println("Dropped Student");
                } else {
                    System.out.println("Didn't Drop Student");
                }
            }
            count++;
        }


    }
    
    // Method 3
    public void addOfficeHours() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Professor ID: ");
        int profInput = scanner.nextInt();
        if (profInput != this.professorID) {
           System.out.println("Error: Wrong Professor ID. Please Try Again.");
           return;
        }
        System.out.println("Enter Course ID to set your desired Office Hours for:");
        int courseIDInput = scanner.nextInt();
        Course courseEX = null;
        for (Course c : coursesList) {
            if (c.getCourseID() == courseIDInput && checkIfCourseIsTaughtByProfessor(c)) {
                courseEX = c;
                break;
            }
        }
        System.out.println("Set your Office Hours: ");
        int officeHoursSlot = scanner.nextInt();
        if (officeHoursSlot == courseEX.getTime()) {
            System.out.println("Error: Conflicting with course time!");
            return;
        }
        officeHours.put(courseEX.getCourseName(), officeHoursSlot);
        System.out.println(courseEX.getCourseName() + "| Office Hours: " + officeHoursSlot);

    }
    
    // Method 4
    public void removeOfficeHours() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Professor ID: ");
        int profInput = scanner.nextInt();
        if (profInput != this.professorID) {
            System.out.println("Error: Wrong Professor ID. Please Try Again.");
            return;
        }
        System.out.println("Enter Course ID to remove Office Hours for:");
        int courseIDInput = scanner.nextInt();
        Course courseEX = null;
        for (Course c : coursesList) {
            if (c.getCourseID() == courseIDInput && checkIfCourseIsTaughtByProfessor(c)) {
                courseEX = c;
                break;
            }
        }
        if (!officeHours.containsKey(courseEX.getCourseName())) {
            System.out.println("No office hours set for this course.");
            return;
        }
        officeHours.remove(courseEX.getCourseName());
        System.out.println("Removed office hours for: " + courseEX.getCourseName());
        System.out.println(courseEX.getCourseName() + "| Office Hours: N/A");
    }

    public void printInfo() {
        System.out.println("Professor " + professorName + "'s Schedule:" );
        for (Course course: coursesList) {
            int id = course.getCourseID();
            if (id == courseID1 || id == courseID2 || id == courseID3 ) {
                String printOfficeHours;
                if (officeHours.containsKey(course.getCourseName())) {
                    printOfficeHours = String.valueOf(officeHours.get(course.getCourseName()));
                } else {
                    printOfficeHours = "N/A";
                }
                System.out.println("Course: " + course.getCourseName() + " | Course ID: " + course.getCourseID() + 
                " | Course Time: " + course.getTime() + " | Office Hours: " + printOfficeHours);
            }
        }
    }

    public void submitAssignment(int index) {

    }

}

    


    


    


    
