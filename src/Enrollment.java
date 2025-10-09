package src;

public class Enrollment {

    private Integer enrollmentId;

    private Student student;

    private Professor professor;

    private Course course;

    private Grade grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Integer getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(Integer enrollmentId) { this.enrollmentId = enrollmentId; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Student getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) {
        this.grade = grade;
        if (grade != null) grade.setEnrollment(this);
    }
}
