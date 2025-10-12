package src;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class PartTimeStudent extends Student {
    // Attributes
    public static final int COURSE_LIMIT = 4;  // part-time limit (informational)
    public Map<String, Integer> Schedule = new HashMap<>();
    
    private static Course c1  = new Course(1001, "CMPE120", 3, 530, true);
    private static Course c2  = new Course(1002, "CMPE121", 4, 800, true);
    private static Course c3  = new Course(1003, "CMPE122", 3, 930, true);
    private static Course c4  = new Course(1004, "CMPE123", 4, 1100, true);
    private static Course c5  = new Course(1005, "CMPE124", 3, 1230, false);
    private static Course c6  = new Course(1006, "CMPE125", 4, 1400, true);
    private static Course c7  = new Course(1007, "CMPE126", 3, 1530, true);
    private static Course c8  = new Course(1008, "CMPE127", 3, 800, false);
    private static Course c9  = new Course(1009, "CMPE128", 3, 930, true);
    private static Course c10 = new Course(1010, "CMPE129", 4, 1100, true);
    private static Course c11 = new Course(1011, "CMPE130", 3, 1230, true);
    private static Course c12 = new Course(1012, "CMPE131", 4, 1400, false);
    private static Course c13 = new Course(1013, "CMPE132", 3, 1530, true);
    private static Course c14 = new Course(1014, "CMPE133", 4, 800, true);
    private static Course c15 = new Course(1015, "CMPE134", 3, 930, false);
    private static Course c16 = new Course(1016, "CMPE135", 4, 1100, true);
    private static Course c17 = new Course(1017, "CMPE136", 3, 1230, true);
    private static Course c18 = new Course(1018, "CMPE137", 4, 1400, true);
    private static Course c19 = new Course(1019, "CMPE138", 3, 1530, false);
    private static Course c20 = new Course(1020, "CMPE139", 4, 800, true);
    private static Course[] coursesList = {
        c1, c2, c3, c4, c5,
        c6, c7, c8, c9, c10,
        c11, c12, c13, c14, c15,
        c16, c17, c18, c19, c20
    };
    
    //int courseID, String courseName, int credits, int time, boolean passFail

    // super() attribute (constructor delegates to Student)
    protected PartTimeStudent(Integer studID, String name, String email) {
        super(studID, name, email);
    }

    @Override
    public void printInfo(Course[] coursesList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printInfo'");
    }

    @Override
    public void addSchedule(Course course, Professor professor){
    };

    @Override
    public String checkSchedule(){
        return "";
    };

    @Override
    public void deleteSchedule(int index){
    };

    // NEW Methods (no implementations)
    public void showCourseAvailability(){
        for (Course c : coursesList) {
            System.out.println(c.getCourseName());
        }
    }
    

    //Method 2
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
                this.getCourses()[count] = null;
                this.getGrades()[count] = null;
            } else {
                System.out.println("That course is already in your schedule. Try a different one.");
                continue;
            }
            count++;
        }
        System.out.println("\nYou removed " + count + " course(s).");
    }
    
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
    

    // “+2” extra method placeholders

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

    public void extraMethod1(){};
    public void extraMethod2(){};


}
