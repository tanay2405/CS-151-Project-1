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
}