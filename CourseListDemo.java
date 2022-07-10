/**
 * After completing these changes, develop a prototype that demonstrates that your program and
your List ADT work as intended. The prototype should have two separate lists. One list that
holds the required courses for the associate’s degree. The other should hold the courses that the
student has completed. Either list can have courses added or removed from it. There should be
another option to look at the remaining courses that you need to complete. This should only
show the courses that are required by the degree, but have not been completed by the student. If 
all requirements have been met then it should inform the student that they have completed all of
the requirements for the degree. Test your program by adding and removing from the courses
from each list and determine which courses are left for you to complete. There should be an
option to look at either of the lists. 
 * @author Joshua
 *
 */
import java.util.Scanner;
public class CourseListDemo {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		ListInterface<Course> coursesNeeded = new ArrayBasedList<Course>();
		ListInterface<Course> coursesCompleted = new ArrayBasedList<Course>();
		
		int option;
		
		do {
			System.out.println("Press 1 to add a required course.");
			System.out.println("Press 2 to add a completed course.");
			System.out.println("Press 3 to view all required courses.");
			System.out.println("Press 4 to view all completed courses.");
			System.out.println("Press 5 to view all remaining courses to complete degree.");
			System.out.println("Press 6 to end the program.");
			option = keyboard.nextInt();
			keyboard.nextLine();
			
			if(option == 1) {
				Course currentCourseNeeded = new Course();
				
				System.out.println("Enter the course department abbreviation of the course needed.");
				String abbreviation = keyboard.nextLine();
				currentCourseNeeded.setCourseAbbreviation(abbreviation);
				
				System.out.println("Enter the course number of the course needed.");
				int number = keyboard.nextInt();
				keyboard.nextLine();
				currentCourseNeeded.setCourseNumber(number);
				
				System.out.println("Enter the name of the course needed.");
				String name = keyboard.nextLine();
				currentCourseNeeded.setCourseName(name);
				
				coursesNeeded.add(currentCourseNeeded);
			}
			else if(option == 2) {
				Course currentCourseCompleted = new Course();
				
				System.out.println("Enter the course department abbreviation of the course completed.");
				String abbreviation = keyboard.nextLine();
				currentCourseCompleted.setCourseAbbreviation(abbreviation);
				
				System.out.println("Enter the course number.");
				int number = keyboard.nextInt();
				keyboard.nextLine();
				currentCourseCompleted.setCourseNumber(number);
				
				System.out.println("Enter the course name.");
				String name = keyboard.nextLine();
				currentCourseCompleted.setCourseName(name);
				
				System.out.println("Enter the semester the course was taken.");
				String semester = keyboard.nextLine();
				currentCourseCompleted.setSemester(semester);
				
				System.out.println("Enter the grade recieved.");
				char grade = keyboard.next().charAt(0);
 				currentCourseCompleted.setGrade(grade);
 				if(grade != 'F') {
 					coursesCompleted.add(currentCourseCompleted);
 				}
 				else {
 					System.out.println("Course Failed! Must retake again!!!You wasted your time and money!!");
 				}
			}
			else if(option == 3) {
				System.out.println(coursesNeeded.toString());
			}
			else if(option == 4) {
				System.out.println(coursesCompleted.toString());
			}
			else if(option == 5) {
				ListInterface<Course> remainingCourses = coursesNeeded.difference(coursesCompleted);
				if(remainingCourses.size() == 0) {
					System.out.println("You've completed all of the requirements for this degree. Congratulations!");
				}
				else {
					System.out.println(remainingCourses.toString());
				}
			}
			else if(option == 6) {
				System.out.println("Goodbye!");
			}
			else {
				System.out.println("Error!");
			}
			
			
			
		}while(option != 6);
		

	}

}
