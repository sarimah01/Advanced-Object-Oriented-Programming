package lab7;

import java.util.*;


/**
 * An abstract class representing a student
 * that extends Comparable and includes methods and fields 
 * related to student information and courses. 
 * It also implements the Comparable interface to 
 * enable comparison between Student objects based on their IDs.
 * 
 * This class provides basic properties and methods to manage student information and courses.
 * Note that when you implement Comparable, it is possible that a warning
 * is given, which you should ignore for now, until we discuss Generic. 
 */
public abstract class Student implements Comparable {
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	protected int id;
	protected String name;
	protected ArrayList<Course> courses;
	
	public Student(int id, String name) {
		 this.id = id;
	     this.name = name;
	     this.courses = new ArrayList<>();
		
	}
	public abstract void addCourse(Course course) throws RegistrationException, PrerequisiteException;
	public abstract void dropCourse(Course course);
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Course> getCourses(){
		return courses;
	}
	
    public int compareTo(Student student) {
        if (this.equals(student)) {
            return 0;
        } else if (this.id < student.id) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, courses);
    }

}
	



/**
 * A class representing a registered student.
 * This class extends the abstract class Student and provides methods and properties
 * specific to registered students and their course registrations.
 */
class RegisteredStudent extends Student {
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	// Constructor
    public RegisteredStudent(int id, String name) {
        super(id, name);
    }

    // Add course method
//    @Override
//    public void addCourse(Course course) throws Exception {
//        if (course.getPrerequisite() != null && !courses.contains(course.getPrerequisite())) {
//            throw new PrerequisiteException("Prerequisite not fulfilled for course: " + course.getName());
//        }
//        courses.add(course);
//    }
    @Override
    public void addCourse(Course course) throws RegistrationException, PrerequisiteException {
        if (course.getPrerequisite() != null && !courses.contains(course.getPrerequisite())) {
            throw new PrerequisiteException("Prerequisite not fulfilled for course: " + course.getName());
        }
        courses.add(course);
    }
  
    @Override
    public void dropCourse(Course course) {
        courses.remove(course);
    }

    // Equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        RegisteredStudent that = (RegisteredStudent) obj;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(courses, that.courses);
    }

    // Hash code method
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), courses);
    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}




/**
 * A class representing a course.
 * This class contains information about a course, including its name, prerequisite,
 * and whether it is currently offered.
 */
class Course {
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	protected String name;
	protected boolean offered;
	protected Course prerequisite;
	
	public Course (String name, boolean offered) {
		//Course course = new Course(name, offered);
		this.name = name;
        this.offered = offered;
	}
	public Course (String name, Course prerequisite, boolean offered) {
		//Course course = new Course(name, prerequisite, offered);
		this.name = name;
        this.prerequisite = prerequisite;
        this.offered = offered;
	}
	public String getName() {
		return name;
	}
	public void setName (String name) {
		this.name = name;
	}
	public Course getPrerequisite() {
		return prerequisite;
	}
	public void setPrequisite(Course prerequisite) {
		this.prerequisite = prerequisite;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, offered, prerequisite);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(name, other.name) && offered == other.offered
				&& Objects.equals(prerequisite, other.prerequisite);
	}
	
    
    
}




/**
 * A custom exception class representing an exception related to course registration.
 * This exception can be used to handle registration-related errors.
 */
class RegistrationException extends Exception {
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	// Constructor without message
    public RegistrationException() {
        super();
    }

    // Constructor with message
    public RegistrationException(String message) {
        super(message);
     }
}

/**
 * A custom exception class representing an exception related to course prerequisites.
 * This exception can be used to handle errors related to course prerequisites.
 */
class PrerequisiteException extends RegistrationException {
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	// Constructor without message
	public PrerequisiteException() {
        super();
    }

    public PrerequisiteException(String message) {
        super(message);
    }
}