package src;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class FullTimeStudent extends Student {
    // Attributes
    public static final int COURSE_LIMIT = 6;  // full-time limit (informational)
    public Map<String, Integer> Schedule = new HashMap<>();
    public List<String> coursesWanted = new ArrayList<>();

    // super() attribute (constructor delegates to Student)
    protected FullTimeStudent(Integer studID, String name, String email) {
        super(studID, name, email);
    }

    // INHERITED Methods (declare overrides; no implementations)
    @Override
    public boolean addSchedule(Course course, Professor professor){
        return true;
    };

    @Override
    public String checkSchedule(){
        return "";
    };

    @Override
    public boolean deleteSchedule(int index){
        return true;
    };

    // NEW Methods (no implementations)
    public void showCourseAvailability(){};
    public void applyForCourses(){};

    // “+2” extra method placeholders
    public void extraMethod1(){};
    public void extraMethod2(){};

    @Override
    public void printInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printInfo'");
    }
}
