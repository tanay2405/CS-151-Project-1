package src;


public class Course {

    private int courseID;
    private String courseName;
    private int credits;
    private int time;
    private boolean passFail;


    public Course(int courseID, String courseName, int credits, int time, boolean passFail) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
        this.time = time;
        this.passFail = passFail;
    }

}
