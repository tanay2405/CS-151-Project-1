
package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class Student implements Person {

    static Student Aarav   = new FullTimeStudent(10044556, "Aarav", "aarav.baphna@gmail.com");
    static Student Tanay   = new FullTimeStudent(10044558, "Tanay", "tanay.patel@example.com");
    static Student Srihan  = new FullTimeStudent(10044559, "Srihan", "srihan.rao@example.com");
    static Student Maya    = new FullTimeStudent(10044560, "Maya", "maya.kapoor@example.com");
    static Student Priya   = new FullTimeStudent(10044561, "Priya", "priya.shah@example.com");
    static Student Jordan  = new FullTimeStudent(10044562, "Jordan", "jordan.lee@example.com");
    static Student Alex    = new FullTimeStudent(10044563, "Alex", "alex.kim@example.com");
    static Student Sam     = new FullTimeStudent(10044564, "Sam", "sam.nguyen@example.com");
    static Student Nikhil  = new FullTimeStudent(10044565, "Nikhil", "nikhil.desai@example.com");
    static Student Anya    = new FullTimeStudent(10044566, "Anya", "anya.singh@example.com");
    static Student Zoe     = new FullTimeStudent(10044567, "Zoe", "zoe.martinez@example.com");
    static Student Liam    = new FullTimeStudent(10044568, "Liam", "liam.johnson@example.com");
    static Student Noah    = new PartTimeStudent(10044569, "Noah", "noah.roberts@example.com");
    static Student Emma    = new PartTimeStudent(10044570, "Emma", "emma.brown@example.com");
    static Student Olivia  = new PartTimeStudent(10044571, "Olivia", "olivia.davis@example.com");
    static Student Ethan   = new PartTimeStudent(10044572, "Ethan", "ethan.wilson@example.com");
    static Student Mia     = new PartTimeStudent(10044573, "Mia", "mia.torres@example.com");
    static Student Sophia  = new PartTimeStudent(10044574, "Sophia", "sophia.garcia@example.com");
    static Student Ava     = new PartTimeStudent(10044575, "Ava", "ava.clark@example.com");
    static Student Lucas   = new PartTimeStudent(10044576, "Lucas", "lucas.ramirez@example.com");
    static Student Isabel  = new PartTimeStudent(10044577, "Isabel", "isabel.lopez@example.com");
    static Student Mateo   = new PartTimeStudent(10044578, "Mateo", "mateo.hernandez@example.com");
    static Student Chloe   = new PartTimeStudent(10044579, "Chloe", "chloe.king@example.com");
    static Student Arjun   = new PartTimeStudent(10044580, "Arjun", "arjun.mehta@example.com");
    private static final List<Student> studentsList = new ArrayList<>(Arrays.asList( Aarav, Tanay, Srihan, Maya, Priya, Jordan, Alex, Sam, Nikhil, Anya, Zoe, Liam, Noah, Emma, Olivia, Ethan, Mia, Sophia, Ava, Lucas, Isabel, Mateo, Chloe, Arjun));
    public static final int MAX_SLOTS = 6;

    private final Integer studID;
    private String name;
    private String email;
    private Double GPA;

    private final Grades[] grades = new Grades[MAX_SLOTS];
    private final Professor[] professors = new Professor[MAX_SLOTS];
    private final Course[] courses = new Course[MAX_SLOTS];

    protected Student(Integer studID, String name, String email) {
        if (studID == null) throw new IllegalArgumentException("studID cannot be null");
        this.studID = studID;
        this.name = name;
        this.email = email;
        this.GPA = 0.0;
    }
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    //Method 1
    public double calculateGPA() {
        int count = 0;
        double total = 0.0;
        List<Double> list = new ArrayList<>();
        for (Grades g : grades) {
            if (g == null) continue;
            String t = g.convertGradeID(g.getGradeID(), this.getCourses()[count]);
            // Treat "Pass"/"Fail" (or any non-letter) as not counted for GPA
            Double pts = letterToPoints(t);
            if (pts != null) {
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
    public abstract String checkSchedule();

    // Method 4
    public abstract void deleteSchedule(int index);
    
    
    public void submitAssignment(int index, Student[] studentsList) {
        validateIndex(index);
        if (courses[index] == null) {
            throw new IllegalStateException("No course scheduled at index: " + index);
        }
        Scanner sc = new Scanner(System.in);
        Integer points = null;
        while (points == null) {
            System.out.print("Enter amount of points earned for the assignment: ");
            if (sc.hasNextInt()) {
                points = sc.nextInt();
            }
            else {
                System.out.println("Please enter an integer number.");
                sc.next();
            }
        }
        if (grades[index] == null) {
            grades[index] = new Grades();
            grades[index].setGradeID(points);  

        }
        else {
            Integer currentGrade = grades[index].getGradeID();
            if (currentGrade == null || currentGrade == -1) {
                currentGrade = 0;
            }
            int newGrade = currentGrade + points;
            grades[index].setGradeID(newGrade);
        }
    } 

    private void validateIndex(int i) {
        if (i < 0 || i >= MAX_SLOTS) throw new IndexOutOfBoundsException("index must be 0..5");
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
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setGPA(Double GPA) {this.GPA = GPA; } 

    public Grades[] getGrades() { return Arrays.copyOf(grades, grades.length); }
    public Professor[] getProfessors() { return Arrays.copyOf(professors, professors.length); }
    public Course[] getCourses() { return Arrays.copyOf(courses, courses.length); }
}
