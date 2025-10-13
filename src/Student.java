package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Student implements Person {

    public static final int MAX_SLOTS = 6;
    private final Integer studID;
    private String name;
    private String email;
    private Double GPA;
    private String major;

    public final Grade[] grades = {new Grade(), new Grade(), new Grade(), new Grade(), new Grade(), new Grade()};
    public final Professor[] professors = { new Professor(), new Professor(), new Professor(), new Professor(), new Professor(), new Professor()};
    public final Course[] courses = {new Course(), new Course(), new Course(), new Course(), new Course(), new Course()};

    public Map<String, Integer> Schedule = new HashMap<>();
    public List<Course> roadmapCourseList = new ArrayList<>(); 

    protected Student(Integer studID, String name, String email, String major) {
        if (studID == null) throw new IllegalArgumentException("studID cannot be null");
        this.studID = studID;
        this.name = name;
        this.email = email;
        this.GPA = 0.0;
        this.major = major;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        Aarav.printInfo();
        Aarav.applyForCourses();
        DrSmith.approveStudent();
        Aarav.printInfo();  
        Aarav.changeMajor();
        Aarav.printInfo();
        Aarav.totalCredits();

        
           

        
    }

    public void showCourseAvailability(){
        for (Course c : coursesList) {
            System.out.println(c.getCourseName() + " - " + c.getCourseID());
        }
    }

    //Method 1
    public double calculateGPA() {
        int count = 0;
        double total = 0.0;
        List<Double> list = new ArrayList<>();
        for (Grade g : grades) {
            if (g == null) continue;
            String t = g.convertGradeID(g.getGradeID(), this.getCourses()[count]);
            // Treat "Pass"/"Fail" (or any non-letter) as not counted for GPA
            Double pts = letterToPoints(t);
            if (pts != null ) {
                list.add(pts);
            }
            count++;
        }
        for (Double pointer : list) {
            
            total += pointer;
        }
        this.setGPA(total/list.size());
        return total/list.size();
    }

    // Method 2
    public abstract void addSchedule();

    // Method 3
    public abstract void deleteSchedule(int index);

    // Method 4
    public abstract void createRoadmap(String major);

    
    public abstract String checkSchedule();
    
    
    
    @Override
    public void printInfo() {
        System.out.println("Student Info: ");
        System.out.println(("Student: " + this.getName() + ", ID: " + this.getStudID() + ", Email: " + this.getEmail() + ", Major: " + this.getMajor()));

        Course[] studentEnrolled = this.getCourses();
        Professor[] studentProfessors = this.getProfessors();
        Grade[] studentGrades = this.getGrades();   
        boolean hasCoursesAvail = false;
        int i = 0;

        for (Course c : studentEnrolled) {
            if (c != null) {
                hasCoursesAvail = true;

                String proftoStudent = "N/A";
                if (studentProfessors != null && i < studentProfessors.length && studentProfessors[i] != null) {
                    proftoStudent =  studentProfessors[i].getProfessorName() + " (ID: " + studentProfessors[i].getProfessorID() + ")";
                }

                String gradetoStudent = "N/A";
                if (studentGrades != null && i < studentGrades.length && studentGrades[i] != null) {
                    Integer gradeValue = studentGrades[i].getGradeID();
                    gradetoStudent = gradeValue.toString();
                    
                }

                System.out.println("Courses enrolled in: " + c.getCourseName() + " (" + c.getCourseID() + "), " 
                + "Credits: " + c.getCredits() + ", Time: " + c.getTime() + ", "
                + "Professor: " + proftoStudent + 
                  ", Grade: " + gradetoStudent);

            }
            i++;
        }
        if (!hasCoursesAvail) {
            System.out.println("Student has no enrolled courses.");
        }
        this.calculateGPA();
        System.out.println("GPA: " + this.getGPA());
    }


    private Double letterToPoints(String letter) {
        if (letter == null) return null;
        switch (letter) {
            case "A":  return 4.0;
            case "A-": return 3.7;
            case "B+": return 3.3;
            case "B":  return 3.0;
            case "B-": return 2.7;
            case "C+": return 2.3;
            case "C":  return 2.0;
            case "C-": return 1.7;
            case "D+": return 1.3;
            case "D":  return 1.0;
            case "D-": return 0.7;
            case "F":  return 0.0;
            case "Pass": return null;
            case "Fail": return 0.0;
            default:   return null; // not a letter grade we count
        }
    }

    public Integer getStudID() { return studID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Double getGPA() {return GPA; }
    public String getMajor() {return major; }
    public void setMajor(String major) {this.major = major;}
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setGPA(Double GPA) {this.GPA = GPA; } 

    public Grade[] getGrades() { return Arrays.copyOf(grades, grades.length); }
    public Professor[] getProfessors() { return Arrays.copyOf(professors, professors.length); }
    public Course[] getCourses() { return Arrays.copyOf(courses, courses.length); }
}
