package src;

import java.util.*;
import java.util.LinkedHashSet;

public class professors {

    private int professorID;
    private String professorName;
    private String department;
    private String email;
    private Set<Course> assignProfessor = new LinkedHashSet<>();

    public professors(int professorID, String professorName, String department, String email) {
        this.professorID = professorID;
        this.professorName = professorName;
        this.department = department;
        this.email = email;
    }
    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }
    public int getProfessorID() {
        return professorID;
    }
    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
    public String getProfessorName() {
        return professorName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDepartment() {
        return department;
    } 
    public Set<Course> getCourses() {
        return assignProfessor;
    }  

    public void addProfessor(Course c)
    {
        if (c == null)
        {
            return;
        }
        assignProfessor.add(c);
        c.setProfessorID(this.professorID);
        }
        
    }

    public void removeProfessor(Course c)
    {
        if (c != null && assignProfessor.contains(c))
        {
            assignProfessor.remove(c);
            c.setProfessorID(-1);
        }   
    }

     public boolean professorExists(int professorID) {
        for (Course c : assignProfessor) {
            if (c.getProfessorID() == professorID) {
                return true;
            }
        }
        return false;
    }
    
}

