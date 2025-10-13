# Academic Management System

Group Members: 
- Tanay Allaparti (ID: 017097795, Email: tanay.allaparti@sjsu.edu)
- Aarav Baphna (ID: 017305847, Email: aarav.baphna@sjsu.edu)
- Srihan Cheemangunta (ID: 017055766, Email: srihan.cheemangunta@sjsu.edu)

## Overview 
The Academic Management System is a comprehensive Java-based program designed to simulate and manage academic operations within a college environment. This system contains interactions between students, professors, and courses while providing functionality for enrollment management, grade tracking, schedule organization, and academic planning. The system supports two types of students (Full-Time student and Part-Time student) with different enrollment limits, allows professors to manage their own courses and student approvals, and provides students with tools to plan their overall academic roadmap, manage schedules, calculate GPAs, and track overall credit progress.

### Key Features:
- Student enrollment and course management while tracking grades for enrolled course
- Professor-student interaction for student approvals and drops after applying for courses
- GPA calculation supporting both letter grades and pass/fail courses
- Academic roadmap creation based on major requirements and functionality to change major depending on GPA
- Schedule management and conflict detection 
- Office hours coordination for professors
- Support for both full-time students (up to 6 courses) and part-time students (up to 4 courses) 


## Design

### Classes

1. Person Interface
- Serves as the central contract for all people in the system
- Defines the printInfo() method for displaying entity information
- Contains static instances of all students, professors, and courses for system-wide access
- Maintains three primary collections: studentsList, professorsList, and coursesList

2. Student Abstract Class (implements Person)

- Base class for all student types with shared functionality
- Manages student core data: ID, name, email, GPA, and major
- Contains arrays for grades, professors, and courses (maximum 6 slots)
- Implements GPA calculation with support for letter grades and pass/fail courses

  Abstract methods:
  
- addSchedule(): Populates a viewable schedule with enrolled courses and their time slots
- deleteSchedule(): Removes a course from the viewable schedule display
- checkSchedule(): Displays the current schedule with course times
- createRoadmap(): Generates a major-specific course planning guide

3. FullTimeStudent Class (extends Student)

- Supports enrollment in up to 6 courses (COURSE_LIMIT = 6)
- Implements all abstract methods from Student class

 Methods:

- applyForCourses(): Allows student to apply for a course
- dropCourses(): Unenrolls Student from the course
- changeMajor(): Switch majors with GPA validation (requires GPA ≥ 3.2)
- totalCredits(): Calculate the amount of credits that are being taken and amount of credits from only passing courses.

- Maintains a HashMap for schedule management and ArrayList for roadmap planning

4. PartTimeStudent Class (extends Student)

- Supports enrollment in up to 4 courses (COURSE_LIMIT = 4)
- Implements all abstract methods and identical methods to FullTimeStudent but with adjusted limits
- Shares the same core functionality with different capacity constraints

5. Professor Class (implements Person)

- Manages professor information: ID, name, email, and up to 3 assigned courses they can teach
- Uses HashMap to track office hours by their course

Methods:

- approveStudent(): Professor verify and approve student enrollment into their course
- dropStudent(): Professors remove students from their courses
- addOfficeHours(): Set office hours with any conflict detection with other course or office hour timings.
- removeOfficeHours(): Remove any existing office hours


- Implements verification system to ensure professor identity by inputting professorID before any actions
- Includes exception handling for invalid inputs

6. Course Class

- Represents individual courses with properties: ID, name, credits, time, and pass/fail status
- Immutable identifiers ensure data integrity
- Time slots represented as integers (e.g., 530 = 5:30, 1400 = 14:00/2:00 PM)
- Pass/fail boolean determines grading scheme

7. Grade Class

- Manages grade representation and conversion

**Grade ID system:**
- (-1): Not enrolled or Not approve yet
- (0-100): Numeric grade
- (>= 70): Passing grade

Methods:

- convertGradeID(): Converts numeric grades to letter grades
- convertGradeIDToPassFail(): Handles pass/fail conversion
- curveGrade(): Apply curve to grades
- extraCredit(): Adds extra credit points


### Exception Handling:

- Input validation with InputMismatchException handling
- NoSuchElementException catching for scanner operations
- Added speific error messages for user guidance

### Data Structures:

- Arrays for fixed-size collections (courses, grades, professors)
- HashMap for key-value mappings (schedules, office hours)
- ArrayList for dynamic collections (roadmap courses, entity lists)
- Lists in the Person interface (all students, all courses, all professors)

### Important Access Control:
- Professor methods require ID verification before execution
- Students cannot approve their own enrollments
- Course limits enforced at application time
- Major changes require minimum GPA of 3.2


## Installation Instructions
Requirements:
- Java Development Kit (JDK) 8 or higher
- A Java IDE (VS Code)

Installation Steps:
1. Clone or Download the Project
   ```git clone https://github.com/tanay2405/CS-151-Project-1.git```
   ```cd CS-151-Project-1```
2. Make sure the project directory appears like this:

- CS-151-Project-1/
    - src/
        - Course.java
        - Grade.java
        - Person.java
        - Student.java
        - FullTimeStudent.java
        - PartTimeStudent.java
        - Professor.java
   
3. Import project into IDE and Build/Compile the project 
4. Run the Program:
   - Right click on Student.java
   - Select "Run Java"


## Usage

## Usage

### Running the Program
1. Open the project in your IDE (e.g., VS Code).
2. Run the **Student.java** file.
3. The console will display options for interacting with students and professors.

### Console Menu Options

**Main Menu:**
- `e` – Enroll a new student (default Student ID: 1111111)
- `t` – Access professor methods
- `s` – Access existing student information

**Student Actions (after enrolling or selecting a student):**
1. Applying/Dropping Courses
   - `1` – Apply for courses
     - Enter professor IDs to request approval.
   - `2` – Drop courses
   - `3` – View student info
2. Managing Class Schedule
   - `1` – View current schedule
   - `2` – Add courses to schedule
   - `3` – Delete courses from schedule
3. Graduation Info and Management
   - `1` – Create and view academic roadmap
   - `2` – View total credits earned
   - `3` – View GPA
4. Personal/Student Info
   - `1` – Change major (requires GPA check)
   - `2` – Display student information

**Professor Actions:**
- Enter professor ID to verify identity.
- Options after login:
  1. Drop office hours
  2. Add office hours
  3. Drop student from a course
  4. View professor info

**Navigation Tips:**
- After each action, the program will prompt:
  - Enter `CONT` to continue
  - Enter `EXIT` to return to the main menu

### Example Usage

Main Menu:
- Enter 'e' to enroll a student
- Enter 't' for professor methods
- Enter 's' to access students

> e
- Enter Student name: John
- Enter Student email: john@example.com
- Enter Student major: ComputerScience
- Enter Student type (1=PartTime, 2=FullTime): 2

Student enrolled successfully.
Select an action:
1 – Apply/Drop Courses
2 – Manage Schedule
3 – Graduation Info
4 – Personal Info

> 1
- Apply for courses or drop courses
- Enter course info...



## Contributions
### Tanay Allaparti
- Developed the **Professor** class including all its methods: approveStudent, dropStudent, add/remove office hours, and verification system.
- Designed the **UML diagram** for the project.
- Wrote and formatted the **README**.
- Implemented **totalCredits()** method in FullTimeStudent and PartTimeStudent classes.
- Created the **professor list** used in the Person interface.
- Made necessary edits across other classes to ensure integration and functionality.

### Srihan Cheemangunta
- Developed the **Course** and **Grade** classes including grading logic and conversions.
- Wrote **JUnit tests** for validating class functionality.
- Implemented the **printInfo()** method in the Person interface.
- Implemented **exception handling** across the system (InputMismatchException, NoSuchElementException, and other input validation).
- Made necessary edits across other classes to ensure integration and functionality.

### Aarav Baphna
- Developed the abstract **Student** class, including core student data and GPA calculations.
- Implemented **FullTimeStudent** and **PartTimeStudent** classes with their respective methods.
- Developed the **changeMajor()** method in both student classes.
- Created the **main class** for running the overall Academic Management System.
-  Created the **student list** and **course list** used in the Person interface.
- Made necessary edits across other classes to ensure integration and functionality.


