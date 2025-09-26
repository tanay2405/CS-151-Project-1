package src;
import java.util.LinkedHashSet;
import java.util.Set;

public class Course {

    private Integer courseId;

    private String courseName;

    private Integer credits;

    private Set<Enrollment> enrollments = new LinkedHashSet<>();

    public Course() {}

    public Course(String courseName, Integer credits) {
        this.courseName = courseName;
        this.credits = credits;
    }

    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public Integer getCredits() { return credits; }
    public void setCredits(Integer credits) { this.credits = credits; }

    public Set<Enrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(Set<Enrollment> enrollments) { this.enrollments = enrollments; }

    public void addEnrollment(Enrollment e) {
        enrollments.add(e);
        e.setCourse(this);
    }

    public void removeEnrollment(Enrollment e) {
        enrollments.remove(e);
        e.setCourse(null);
    }
}
