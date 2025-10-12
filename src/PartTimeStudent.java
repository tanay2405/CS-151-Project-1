package src;

import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartTimeStudent extends Student {
    // Attributes
    public static final int COURSE_LIMIT = 4;  // part-time limit (informational)
    public Map<String, Integer> Schedule = new HashMap<>();
    public List<Course> roadmapCourseList = new ArrayList<>(); 
    private static Course c1  = new Course(1001, "CMPE 120", 3, 530, true);
    private static Course c2  = new Course(1002, "CMPE 121", 4, 800, true);
    private static Course c3  = new Course(1003, "CMPE 122", 3, 930, true);
    private static Course c4  = new Course(1004, "CMPE 123", 4, 1100, true);
    private static Course c5  = new Course(1005, "CMPE 124", 3, 1230, false);
    private static Course c6  = new Course(1006, "CMPE 125", 4, 1400, true);
    private static Course c7  = new Course(1007, "CMPE 126", 3, 1530, true);
    private static Course c8  = new Course(1008, "CS 120", 3, 800, false);
    private static Course c9  = new Course(1009, "CS 121", 3, 930, true);
    private static Course c10 = new Course(1010, "CS 122", 4, 1100, true);
    private static Course c11 = new Course(1011, "CS 123", 3, 1230, true);
    private static Course c12 = new Course(1012, "CS 124", 4, 1400, false);
    private static Course c13 = new Course(1013, "CS 125", 3, 1530, true);
    private static Course c14 = new Course(1014, "CS 126", 4, 800, true);
    private static Course c15 = new Course(1015, "ENGR 120", 3, 930, false);
    private static Course c16 = new Course(1016, "ENGR 121", 4, 1100, true);
    private static Course c17 = new Course(1017, "ENGR 122", 3, 1230, true);
    private static Course c18 = new Course(1018, "ENGR 123", 4, 1400, true);
    private static Course c19 = new Course(1019, "ENGR 124", 3, 1530, false);
    private static Course c20 = new Course(1020, "ENGR 125", 4, 800, true);
    private static Course c21 = new Course(1021, "ENGR 126", 4, 900, true);
    private static Course[] coursesList = {
        c1, c2, c3, c4, c5,
        c6, c7, c8, c9, c10,
        c11, c12, c13, c14, c15,
        c16, c17, c18, c19, c20
    };
    
    //int courseID, String courseName, int credits, int time, boolean passFail

    // super() attribute (constructor delegates to Student)
    protected PartTimeStudent(Integer studID, String name, String email, String major) {
        super(studID, name, email, major);
    }

    @Override
    public void printInfo(Course[] coursesList) {
        
        System.out.println("Student Info: ");
        System.out.println(("Student: " + this.getName() + ", ID: " + this.getStudID() + ", Email: " + this.getEmail()));

        Course[] studentEnrolled = this.getCourses();
        boolean hasCoursesAvail = false;

        for (Course c : studentEnrolled) {
            if (c != null) {
                hasCoursesAvail = true;
                System.out.println("Courses enrolled in: " + c.getCourseName() + " (" + c.getCourseID() + "), Credits: " + c.getCredits() + ", Time: " + c.getTime());
            }
        }

        if (!hasCoursesAvail) {
            System.out.println("Student has no enrolled courses.");
        }
    }

    @Override
    public void addSchedule(){
        int count = 0;
        for (Course c : this.getCourses()) {
            if (this.getGrades()[count].getGradeID() != -1) {
                Schedule.put(c.getCourseName(), c.getTime());
            }
        }
    };

    @Override
    public String checkSchedule(){
        return "";
    };

    @Override
    public void deleteSchedule(int index){
    };

    @Override
    public void createRoadmap(String major) {
        for(Course c : coursesList) {
            if(c.getCourseName().contains(major)){
                roadmapCourseList.add(c);
            }
        }
    }

    // NEW Methods (no implementations)
    public void showCourseAvailability(){
        for (Course c : coursesList) {
            System.out.println(c.getCourseName());
        }
    }

    public void showCourseRoadmap(){
        for (Course c : roadmapCourseList) {
            System.out.println(c.getCourseName());
        }
    }
    
    //Method 1
    public void dropCourses() {
        final int MAX = 4;
        showCourseAvailability();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter up to " + MAX + " courses to drop. Press ENTER on course name to finish early.");
        int count = 0;
        while (count < MAX) {
            System.out.print("Course ID" + (count + 1) + ": ");
            String course = sc.nextLine().trim();
            if (course.isEmpty()) break;      
            if (checkIfCourseValid(course)) {
                System.out.println("Removed: " + course);
                this.getCourses()[count] = new Course();
                this.getGrades()[count] = new Grades();
            } else {
                System.out.println("That course is already in your schedule. Try a different one.");
                continue;
            }
            count++;
        }
        System.out.println("\nYou removed " + count + " course(s).");
    }

    // Method 2
    public void applyForCourses() {
        final int MAX = 4;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter up to " + MAX + " courses. Press ENTER on course name to finish early."); 
        int count = 0;
        while (count < MAX) {
            System.out.print("Course ID" + (count + 1) + ": ");
            String course = sc.nextLine().trim();
            if (course.isEmpty()) break;      
            if (checkIfCourseValid(course)) {
                System.out.println("That course is already in your schedule. Try a different one.");
                continue;
            }
    
            this.getCourses()[count] = getCourseObjectFromCourseID(course);
            System.out.println("Added: " + course);
            count++;
        }
        System.out.println("\nYou added " + count + " course(s).");
    }
    
    //Method 3
    public void changeMajor() {
        if (this.getGPA() >= 3.2) {
            final java.util.Set<String> allowed = java.util.Set.of("CS", "CMPE", "ENGR");
            java.util.Scanner sc = new java.util.Scanner(System.in);
    
            String major;
            while (true) {
                System.out.print("Enter the major you would like to switch to (CS, CMPE, ENGR): ");
                String input = sc.next().trim().toUpperCase();
                if (allowed.contains(input)) {
                    major = input;
                    break;
                }
                System.out.println("Invalid input. Please enter one of: CS, CMPE, ENGR.");
            }
    
            this.setMajor(major);
            System.out.println("Changing Student Roadmap...");
            roadmapCourseList.clear();
            this.createRoadmap(major);
        } else {
            System.out.println("Cannot switch major (GPA restriction not met)");
        }
    }

    // Method 4
    public void extraMethod2(){};

    

    public boolean checkIfCourseValid(String course) {
        for (Course g : this.getCourses()) {
            if (Integer.parseInt(course) == g.getCourseID()) {
                return true;
            }
        }
        return false;      
    }

    public Course getCourseObjectFromCourseID(String course) {
        for (Course c : coursesList) {
            if(c.getCourseID() == Integer.parseInt(course)){
                return c;
            }
        }
        return null;
    }


}
