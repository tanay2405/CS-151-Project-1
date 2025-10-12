package src;

import java.util.Scanner;

public class FullTimeStudent extends Student {

    public static final int COURSE_LIMIT = 6;

    protected FullTimeStudent(Integer studID, String name, String email, String major) {
        super(studID, name, email, major);
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

    public void showCourseRoadmap(){
        for (Course c : roadmapCourseList) {
            System.out.println(c.getCourseName());
        }
    }
    
    public void showCourseAvailability(){
        for (Course c : coursesList) {
            System.out.println(c.getCourseName());
        }
    }

    //Method 1
    public void dropCourses() {
        final int MAX = 6;
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
                courses[count] = new Course();
                grades[count] = new Grade();
            } else {
                System.out.println("That course is not in your schedule. Try a different one.");
                continue;
            }
            count++;
        }
        System.out.println("\nYou removed " + count + " course(s).");
    }
    
    //Method 2
    public void applyForCourses() {
        final int MAX = 6;
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
            courses[count] = getCourseObjectFromCourseID(course);
            System.out.println("Added: " + course);
            count++;
        }
        System.out.println("\nYou added " + count + " course(s).");
    }
    
    // Method 3
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
    
    //Method 4
    public void extraMethod2(){};


    // Helper Methods
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
