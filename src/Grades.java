package src;

public class Grades {
    private int gradeID;
    private String letterGrade;
    private double GPA;
    private String studentID;

    public Grades(int gradeID, String letterGrade, double GPA) {
        this.gradeID = gradeID;
        this.letterGrade = letterGrade;
        this.GPA = GPA;
    }
    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }
    public String getLetterGrade() {
        return letterGrade;
    }
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    public double getGPA() {
        return GPA;
    }
    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }
    public int getGradeID() {
        return gradeID;
    }

    public void assignStudentGrade(int studentID, String letterGrade) {

        if (this.studentID.equals(studentID)) {
            this.letterGrade = letterGrade;
        } 
        else 
        {
            System.out.println("Error: Could not find student ID.");
        }

    }

    
}
