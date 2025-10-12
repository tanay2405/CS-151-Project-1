package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Person {

    public static FullTimeStudent Aarav   = new FullTimeStudent(10044556, "Aarav", "aarav.baphna@gmail.com", "CMPE");
    public static FullTimeStudent Tanay   = new FullTimeStudent(10044558, "Tanay", "tanay.patel@example.com", "CMPE");
    public static FullTimeStudent Srihan  = new FullTimeStudent(10044559, "Srihan", "srihan.rao@example.com", "CS");
    public static FullTimeStudent Maya    = new FullTimeStudent(10044560, "Maya", "maya.kapoor@example.com", "ENGR");
    public static FullTimeStudent Priya   = new FullTimeStudent(10044561, "Priya", "priya.shah@example.com", "CS");
    public static FullTimeStudent Jordan  = new FullTimeStudent(10044562, "Jordan", "jordan.lee@example.com", "ENGR");
    public static FullTimeStudent Alex    = new FullTimeStudent(10044563, "Alex", "alex.kim@example.com", "CS");
    public static FullTimeStudent Sam     = new FullTimeStudent(10044564, "Sam", "sam.nguyen@example.com", "ENGR");
    public static FullTimeStudent Nikhil  = new FullTimeStudent(10044565, "Nikhil", "nikhil.desai@example.com", "CS");
    public static FullTimeStudent Anya    = new FullTimeStudent(10044566, "Anya", "anya.singh@example.com", "CMPE");
    public static FullTimeStudent Zoe     = new FullTimeStudent(10044567, "Zoe", "zoe.martinez@example.com", "CMPE");
    public static FullTimeStudent Liam    = new FullTimeStudent(10044568, "Liam", "liam.johnson@example.com", "CS");
    public static PartTimeStudent Noah    = new PartTimeStudent(10044569, "Noah", "noah.roberts@example.com", "CS");
    public static PartTimeStudent Emma    = new PartTimeStudent(10044570, "Emma", "emma.brown@example.com", "ENGR");
    public static PartTimeStudent Olivia  = new PartTimeStudent(10044571, "Olivia", "olivia.davis@example.com", "ENGR");
    public static PartTimeStudent Ethan   = new PartTimeStudent(10044572, "Ethan", "ethan.wilson@example.com", "CS");
    public static PartTimeStudent Mia     = new PartTimeStudent(10044573, "Mia", "mia.torres@example.com", "ENGR");
    public static PartTimeStudent Sophia  = new PartTimeStudent(10044574, "Sophia", "sophia.garcia@example.com", "CS");
    public static PartTimeStudent Ava     = new PartTimeStudent(10044575, "Ava", "ava.clark@example.com", "CMPE");
    public static PartTimeStudent Lucas   = new PartTimeStudent(10044576, "Lucas", "lucas.ramirez@example.com", "CMPE");
    public static PartTimeStudent Isabel  = new PartTimeStudent(10044577, "Isabel", "isabel.lopez@example.com", "CS");
    public static PartTimeStudent Mateo   = new PartTimeStudent(10044578, "Mateo", "mateo.hernandez@example.com", "CS");
    public static PartTimeStudent Chloe   = new PartTimeStudent(10044579, "Chloe", "chloe.king@example.com", "ENGR");
    public static PartTimeStudent Arjun   = new PartTimeStudent(10044580, "Arjun", "arjun.mehta@example.com", "CS");

    public static Course c1  = new Course(1001, "CMPE 120", 3, 530, true);
    public static Course c2  = new Course(1002, "CMPE 121", 4, 800, true);
    public static Course c3  = new Course(1003, "CMPE 122", 3, 930, true);
    public static Course c4  = new Course(1004, "CMPE 123", 4, 1100, true);
    public static Course c5  = new Course(1005, "CMPE 124", 3, 1230, false);
    public static Course c6  = new Course(1006, "CMPE 125", 4, 1400, true);
    public static Course c7  = new Course(1007, "CMPE 126", 3, 1530, true);
    public static Course c8  = new Course(1008, "CS 120", 3, 800, false);
    public static Course c9  = new Course(1009, "CS 121", 3, 930, true);
    public static Course c10 = new Course(1010, "CS 122", 4, 1100, true);
    public static Course c11 = new Course(1011, "CS 123", 3, 1230, true);
    public static Course c12 = new Course(1012, "CS 124", 4, 1400, false);
    public static Course c13 = new Course(1013, "CS 125", 3, 1530, true);
    public static Course c14 = new Course(1014, "CS 126", 4, 800, true);
    public static Course c15 = new Course(1015, "ENGR 120", 3, 930, false);
    public static Course c16 = new Course(1016, "ENGR 121", 4, 1100, true);
    public static Course c17 = new Course(1017, "ENGR 122", 3, 1230, true);
    public static Course c18 = new Course(1018, "ENGR 123", 4, 1400, true);
    public static Course c19 = new Course(1019, "ENGR 124", 3, 1530, false);
    public static Course c20 = new Course(1020, "ENGR 125", 4, 800, true);
    public static Course c21 = new Course(1021, "ENGR 126", 4, 900, true);

    public static Professor DrSmith    = new Professor(10001, "Dr. Smith",   "smith@univ.edu",   1001, 1002, 1003);
    public static Professor DrAlice    = new Professor(10002, "Dr. Alice",   "alice@univ.edu",   1004, 1005, 1006);
    public static Professor DrBrown    = new Professor(10003, "Dr. Brown",   "brown@univ.edu",   1007, 1008, 1009);
    public static Professor DrWilson   = new Professor(10004, "Dr. Wilson",  "wilson@univ.edu",  1010, 1011, 1012);
    public static Professor DrPatel    = new Professor(10005, "Dr. Patel",   "patel@univ.edu",   1013, 1014, 1015);
    public static Professor DrNguyen   = new Professor(10006, "Dr. Nguyen",  "nguyen@univ.edu",  1016, 1017, 1018);
    public static Professor DrGarcia   = new Professor(10007, "Dr. Garcia",  "garcia@univ.edu",  1019, 1020, 1021);

    
    
    public static Course[] coursesList = {
        c1, c2, c3, c4, c5,
        c6, c7, c8, c9, c10,
        c11, c12, c13, c14, c15,
        c16, c17, c18, c19, c20
    };
    public static List<Student> studentsList = new ArrayList<>(Arrays.asList( Aarav, Tanay, Srihan, 
    Maya, Priya, Jordan, Alex, Sam, Nikhil, Anya, Zoe, Liam, Noah, Emma, Olivia, Ethan, Mia, Sophia, 
    Ava, Lucas, Isabel, Mateo, Chloe, Arjun));

    public static List<Professor> professorsList = new ArrayList<>(Arrays.asList(
    DrSmith, DrAlice, DrBrown, DrWilson, DrPatel, DrNguyen,
    DrGarcia ));


    
    /**
     * Print identifying info about the person (e.g., name, role).
     */
    public void printInfo();

    /**
     * Perform the act of submitting an assignment.
     */
    public void submitAssignment(int index);
}
