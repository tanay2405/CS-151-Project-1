package src;

public class Grades {
    private int gradeID;

    public Grades(int gradeID) {
        this.gradeID = gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public int getGradeID() {
        return gradeID;
    }

    public String convertGradeID(int gradeID)
    {
        if (gradeID < 0 || gradeID > 100) {
            return "Invalid gradeID";
        } else if (gradeID >= 90) {
            return "A";
        } else if (gradeID >= 80) {
            return "B";
        } else if (gradeID >= 70) {
            return "C";
        } else if (gradeID >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public double curveGrade(int gradeID)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a decimal number for curving grade: ");
        double curveFactor = sc.nextDouble();
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a decimal number.");
            sc.next();
        }
        double curvedGrade = gradeID * curveFactor;
        sc.close();
        return curvedGrade;
    }

    public int extraCredit(int gradeID)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount of extra credit points: ");
        int extraPoints = sc.nextInt();
        while (!sc.hasNextInt()) {
            System.out.println("Please enter an integer number.");
            sc.next();
        }
        int newGrade = gradeID + extraPoints;
        sc.close();
        return newGrade;
    }

    public boolean convertToPassFail(int gradeID, Course courselink) 
    {
        if (!courselink.isPassFail()) {
            System.out.println(courselink.getCourseName() + "is not graded on a pass/fail scale.");
            return false;
        } 
        if (gradeID >= 60) {
            System.out.println("You passed the course: " + courselink.getCourseName());
            return true;
        } else {
            System.out.println("You failed the course: " + courselink.getCourseName());
            return false;
        }

    }





