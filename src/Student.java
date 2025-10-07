package src;

import java.util.LinkedHashSet;
import java.util.Set;

public class Student {

    private Integer studentId;

    private String name;

    private String email;

    private Set<Enrollment> enrollments = new LinkedHashSet<>();

    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Set<Enrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(Set<Enrollment> enrollments) { this.enrollments = enrollments; }

    public void addEnrollment(Enrollment e) {
        enrollments.add(e);
        e.setStudent(this);
    }

    public void removeEnrollment(Enrollment e) {
        enrollments.remove(e);
        e.setStudent(null);
    }
    
    public boolean enrollCourse(Course course) {
        Enrollment newEnrollment = new Enrollment(this, course);
        if (enrollments.size() >= 6) {  
            System.out.println("Enrollment Error: Max Courses Exceeded");
            return false;
        }
        if (enrollments.contains(newEnrollment)) {
            System.out.println("Enrollment Error: Already Enrolled");
            return false;
        }
        addEnrollment(newEnrollment);
        System.out.println("Enrolled Successfully!");
        return true;
    }
    
    public boolean dropCourse(Course course) {
        for (Enrollment e : enrollments) {
            if (e.getCourse().equals(course)) {
                removeEnrollment(e);
                System.out.println("Course Dropped Successfully!");
                return true;
            }
        }
        System.out.println("Course Not Found");
        return false;
    }

    public void listEnrolledCourses() {
        if (enrollments.isEmpty()) {
            System.out.println(" Not enrolled in any courses.");
            return;
        }
        System.out.println("Enrolled Courses:");
        for (Enrollment e: enrollments) {
            Course c = e.getCourse();
            if (c != null) {
                System.out.println(c.getCourseName() + " (" + c.getCredits() + " credits)");
            }
        }
    }
}
