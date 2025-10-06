package src;

public class Grades {
    private int gradeID;
    private String letterGrade;
    private double GPA;
    private String studentID;

    public Grades(int gradeID, String letterGrade, double GPA, String studentID) {
        this.gradeID = gradeID;
        this.letterGrade = letterGrade;
        this.GPA = GPA;
        this.studentID = studentID;
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

    public int studentGrade(int score) 
    {
        if (score >= 90) 
        {
            return 'A';
        } 
        else if (score >= 80) 
        {
            return 'B';
        } 
        else if (score >= 70) 
        {
            return 'C';
        } 
        else if (score >= 60) 
        {
            return 'D';
        } 
        else 
        {
            return 'F';
        }
   }

    public double calculateGPA(char letterGrade) {

        if (letterGrade == 'A') 
        {
            return 4.0;
        } 
        else if (letterGrade == 'B') 
        {
            return 3.0;
        } 
        else if (letterGrade >= 'C') 
        {
            return 2.0;
        } 
        else if (letterGrade >= 'D') 
        {
            return 1.0;
        } 
        else 
        {
            return 0.0;
        }
    }

    public boolean isStudentPassing() {
        return GPA >= 2.0;
    }

    public void addGradeToStudent(String studentID, char grade) {
        if (studentID == null || studentID.isEmpty()) {
            throw new IllegalArgumentException("Invalid student ID");
        }
        grade = Character.toUpperCase(grade);
        letterGrade = String.valueOf(grade);
        GPA = calculateGPA(grade);
        
    }
    
}

