/**
 * The first step in the development process is to create a class that represents each Course that you
will take. Every course has a three letter abbreviation (ex. CSC), a three digit number (202), a
name of the course (ex. Computer Science II), the semester you took the course (Fall 2016), and
the grade that you received in the course. This class should be developed using object-oriented
methodology by making its instance variables private while providing appropriate accessor and
mutator methods to allow access mutation of the attributes of the Course class. This class should
also override the toString method and equals method from the Object class. The toString method
should return in String form the value of each instance variable. The equals method should
return true if the three letter abbreviation, three digit number and the name of the course are all
the same otherwise it should return false. 
 */
public class Course {
	//instance variables
	private String courseAbbreviation;
	private int courseNumber;
	private String courseName;
	private String semester;
	private char grade;
	
	//constructor
	public Course() {
		courseAbbreviation = " ";
		courseNumber = 0;
		courseName = " ";
		semester = " ";
		grade = ' ';
	}
	//accessor and mutator methods
	public void setCourseAbbreviation(String newCourseNumber) {
		courseAbbreviation = newCourseNumber;
	}
	public String getCourseAbbreviation() {
		return courseAbbreviation;
	}
	public void setCourseNumber(int newCourseNumber) {
		if(newCourseNumber > 0 && newCourseNumber < 300) {
			courseNumber = newCourseNumber;
		}
	}
	public int getCourseNumber() {
			return courseNumber;
	}
	public void setCourseName(String newCourseName) {
		courseName = newCourseName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setSemester(String newSemester) {
		semester = newSemester;
	}
	public String getSemester() {
		return semester;
	}
	public void setGrade(char newGrade) {
		if(newGrade == 'A' || newGrade == 'B' || newGrade == 'C' || newGrade == 'D' || 
				newGrade == 'F') {
			grade = newGrade;
		}
	}
	public char getGrade() {
		return grade;
	}
	
	public String toString() {
		String allInfo = courseAbbreviation + " " + courseNumber + " " + courseName;
		
		if(!semester.equals(" ")) {
			allInfo = allInfo + "\n" + semester;
		}
		if(grade != ' ') {
			allInfo = allInfo + "\n" + grade;
		}
		return allInfo;
	}
	
	public boolean equals(Object otherObject) {
		boolean isEqual = false;
		if(otherObject != null && otherObject instanceof Course) {
			Course otherCourse = (Course)otherObject;
			if(this.courseAbbreviation.equals(otherCourse.courseAbbreviation) && this.courseNumber
					== otherCourse.courseNumber && this.courseName.equals(otherCourse.courseName)) {
				isEqual = true;
			}
		}
		return isEqual;
	}
	
	
	

}
