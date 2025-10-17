package src;

public class Course {

    private int courseID;
    private String courseName;
    private int credits;
    private int time;
    private boolean passFail;

    public Course(int courseID, String courseName, int credits, int time, boolean passFail) {
        setCourseID(courseID);
        setCourseName(courseName);
        setCredits(credits);
        setTime(time);
        this.passFail = passFail;
    }

    public Course() {
        this(0, "NA", 0, 0, false);
    }

    public void setCourseID(int courseId) {
        if (courseId < 0) throw new IllegalArgumentException("Course ID cannot be negative.");
        this.courseID = courseId;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.isEmpty())
            throw new IllegalArgumentException("Course name cannot be null or empty.");
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCredits(int credits) {
        if (credits < 0 || credits > 6)
            throw new IllegalArgumentException("Credits must be between 0 and 6.");
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setTime(int time) {
        if (time < 0 || time > 2400)
            throw new IllegalArgumentException("Time must be a valid 24-hour integer.");
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setPassFail(boolean passFail) {
        this.passFail = passFail;
    }

    public boolean isPassFail() {
        return passFail;
    }

    public String getFormattedTime() {
        int hour = time / 100;
        int minute = time % 100;
        return String.format("%02d:%02d", hour, minute);
    }

    public double calculateGPAWeight(double gradePoint) {
        return credits * gradePoint;
    }

    public String getCourseLevel() {
        if (credits >= 5) return "Advanced";
        if (credits >= 3) return "Intermediate";
        return "Introductory";
    }

    public boolean isEveningClass() {
        return time >= 1700;
    }

    public String shortDescription() {
        return courseName + " (" + credits + " credits)";
    }

    @Override
    public String toString() {
        return String.format("Course[ID=%d, Name=%s, Credits=%d, Time=%s, PassFail=%b, Level=%s]",
                courseID, courseName, credits, getFormattedTime(), passFail, getCourseLevel());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Course)) return false;
        Course other = (Course) obj;
        return courseID == other.courseID && courseName.equalsIgnoreCase(other.courseName);
    }

    @Override
    public int hashCode() {
        return (courseID * 31) + courseName.hashCode();
    }
}
