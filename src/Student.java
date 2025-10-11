
package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Abstract Student class implementing the Person role.
 * 
 * Attributes:
 * - Grades[6], Professors[6], Courses[6]
 * - studID, name, email
 * 
 * Inherited (from Person): printInfo(), submitAssignment()
 * 
 * Methods provided:
 * - calculateGPA()
 * - addSchedule(course, professor)
 * - checkSchedule()
 * - deleteSchedule(index)
 * 
 * Utility extras:
 * - setGrade(index, grade)
 * - getGrade/indexed getters
 */
public abstract class Student implements Person {
    public static final int MAX_SLOTS = 6;

    private final Integer studID;
    private String name;
    private String email;

    private final Grades[] grades = new Grades[MAX_SLOTS];
    private final Professor[] professors = new Professor[MAX_SLOTS];
    private final Course[] courses = new Course[MAX_SLOTS];

    protected Student(Integer studID, String name, String email) {
        if (studID == null) throw new IllegalArgumentException("studID cannot be null");
        this.studID = studID;
        this.name = name;
        this.email = email;
    }
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        Student Kyle = new FullTimeStudent(10044556, "Aarav", "aarav.baphna@gmail.com");
    }

    // -------------------------
    // Required business methods
    // -------------------------

    /**
     * Compute GPA on a 4.0 scale from the current Grades array.
     * Letter grades contribute; Pass/Fail does not affect GPA.
     * Null entries are ignored.
     */
    public double calculateGPA() {
        double total = 0.0;
        List<Double> list = new ArrayList<>();

        for (Grades g : grades) {
            if (g == null) continue;
            String t = g.convertGradeID(g.getGradeID());

            // Treat "Pass"/"Fail" (or any non-letter) as not counted for GPA
            Double pts = letterToPoints(t);
            if (pts != null) {
                list.add(pts);
            }
        }
        for (Double pointer : list) {
            total += pointer;
        }
        
        return total/list.size();
    }

    /**
     * Add a course+professor to the first available slot.
     * Grade starts null. Returns true if added, false if schedule is full.
     */
    public abstract boolean addSchedule(Course course, Professor professor);
    

    /**
     * Returns a human-readable summary of all 6 slots.
     */
    public String checkSchedule() {
        return "";
    }

    /**
     * Remove the course/professor/grade at the given index (0..5).
     * Returns true if something was removed, false if it was already empty.
     */
    public abstract boolean deleteSchedule(int index);
    

    // -------------------------
    // Helpful utilities
    // -------------------------

    /**
     * Assign or replace a grade for a scheduled course.
     */
    public void submitAssignment(int index) {
        validateIndex(index);
        if (courses[index] == null) {
            throw new IllegalStateException("No course scheduled at index " + index);
        }
        grades[index].setGradeID(grades[index].getGradeID() + 10); // may be null to clear
    }

    private void validateIndex(int i) {
        if (i < 0 || i >= MAX_SLOTS) throw new IndexOutOfBoundsException("index must be 0..5");
    }

    /**
     * Map common letter grades to GPA points.
     * Returns null for non-letter (e.g., Pass/Fail).
     */
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

    

    // -------------------------
    // Getters / setters
    // -------------------------
    public Integer getStudID() { return studID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    public Grades[] getGrades() { return Arrays.copyOf(grades, grades.length); }
    public Professor[] getProfessors() { return Arrays.copyOf(professors, professors.length); }
    public Course[] getCourses() { return Arrays.copyOf(courses, courses.length); }
}
