package lab5;

import java.util.*;

/**
 * This class manages employees in a school and their lists/sets.
 * Your implementation of this class or methods should not contains:
 * 1. No System.out.println statements should appear here. Instead, you need to
 * return the result. 2. No Scanner operations should appear here (e.g.,
 * input.nextInt()). Instead, refer to the input parameters of this method.
 */

public class SchoolManager {
		// TODO: Your implementation starts here
		/*  Your implementation starts here
		 * Recall that :
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, you need to return the result.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
	private MyList overtimeList;
	private MySet seminarRegistrationList;
	
	public SchoolManager() {
		this.overtimeList = new MyList();
        this.seminarRegistrationList = new MySet();
		
	}
	public void addToOvertimeList (Employee employee) {
		this.overtimeList.add(employee);
	}
    public void addToSeminarRegistrationList (Employee employee) {
    	this.seminarRegistrationList.add(employee);
	}
    public int getOvertimeEmployeeCount() {
    	return overtimeList.getSize();
    	
    }
    public int getSeminarRegistrationsCount() {
    	return seminarRegistrationList.getSize();
    }
    public String displayOvertimeList() { 
    	if(this.getOvertimeEmployeeCount() == 0) {
    		return "Overtime List: No employees in the overtime list.";
    		    }
    		String output = "Overtime List: ";
    		output += this.overtimeList.toString();
    		return output;
       }
    public String displaySeminarRegistrationList() {
    		if(this.getSeminarRegistrationsCount() == 0) {
    			return "Registration List: No employees in the registration list.";
    		}
    		String output = "Registration List: ";
    		output += this.seminarRegistrationList.toString();
    		return output;
    	}
}

/**
 * 
 * This class represents an employee in the school management system.
 * Your implementation of this class or methods should not contains:
 * 1. No System.out.println statements should appear here. Instead, you need to
 * return the result. 2. No Scanner operations should appear here (e.g.,
 * input.nextInt()). Instead, refer to the input parameters of this method.
 */
class Employee {	
		// TODO: Your implementation starts here
		/* 
		 * Recall that :
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, you need to return the result.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
	private String name;
	private int age;
	private String employeeId;
	
	public Employee (String name, int age, String employeeId) {
		super();
		this.name = name;
        this.age = age;
        this.employeeId = employeeId;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public int hashCode() {
	return Objects.hash(age, employeeId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employee other = (Employee) obj;
		return age == other.age && Objects.equals(employeeId, other.employeeId) && Objects.equals(name, other.name);
		}		
	
	@Override
	public String toString() {
	return "{" + this.getName() + " (ID: " + this.getEmployeeId() +")}";
	}
	
}

/**
 * 
 * This class represents a container that stores objects in an array-like
 * structure. Your implementation of this class or methods should not contains:
 * 1. No System.out.println statements should appear here. Instead, you need to
 * return the result. 2. No Scanner operations should appear here (e.g.,
 * input.nextInt()). Instead, refer to the input parameters of this method.
 */
class Container {
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	/**
	 * The initial size of the container.
	 */
	protected final int INITIAL_SIZE = 10;

	/**
	 * The array that holds the objects.
	 */
	protected Object[] list = new Object[INITIAL_SIZE];

	/**
	 * The number of elements currently stored in the container.
	 */
	protected int size;

	// TODO: Your implementation starts here
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	private int capacity = INITIAL_SIZE;
	public void add (Object obj) {
		if(size >= capacity) {
			capacity = 2*capacity;
			Object[] newlist = new Object[capacity];
			for(int i=0; i<size; i++) {
				newlist[i] = list[i];
			}
			list = newlist;
			list[size] = obj;
			size++;
			}
			else {				
			list[size] = obj;		
			size++;
			}
			
	}
	public Object remove (Object object) {
		int index=-1;
		Object toremove = null;
		
		for(int i=0; i<this.size; i++) {
			if(list[i].equals(object)) {
				toremove = list[i];
				index = i;		
		}
		     }
		if(index>=0) {
			for(int j=index; j<this.size-2; j++) {
				list[j] =list[j+1];
		}
			this.list[this.size-1]=null;
			this.size--;
			return toremove;
		  }
		return toremove;
	}
	public int getSize() {
		return this.size;
	}
	public boolean isEmpty() {
		if(this.getSize() == 0) {
			return true;
			}
		return false;
	}
	public boolean contains(Object object) {
        for (int i = 0; i < size; i++) {
            if (list[i] == object) {
                return true;
            }
        }
        return false;
}

	public int countOccurrences(Object object) {
		int count = 0;
        for (int i = 0; i < this.size; i++) {
        	if (list[i].equals(object)) {
                count++;       
            }
        }
        return count;
    }
	@Override
	public String toString() {
		String arraylist = "[";
		for(int i=0; i<this.size; i++) {
			arraylist += this.list[i];
			if(i < this.size-1) {
			arraylist += ", ";
			 }	
		    }
		arraylist += "]";
		return arraylist;
		}
	}
	
		


/**
 * This class simulates an ArrayList concept, where you can add unlimited number
 * of elements to the list.
 */
class MyList extends Container {

	// TODO: Your implementation starts here
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	public MyList() {
		super();
	}
	@Override
	public void add(Object object) {
        super.add(object); // Call the add method of the parent class (Container)
    }
	@Override
	public Object remove(Object object) {
        //return super.remove(object); // Call the remove method of the parent class (Container)
		int index=-1;
		Object toremove = null;
		for(int i=0; i<this.size; i++) {
			if(list[i].equals(object)) {
				toremove = list[i];
				index = i;
				break;	
		}
	    	}
		if(index>=0) {
			for(int j=index; j<this.size-1; j++) {
				list[j] =list[j+1];
		}
			this.list[this.size-1]=null;
			this.size--;
			return toremove;
	    	}
		return toremove;
    }
	
	 public Object get(int index) {
	        if (index >= this.getSize()) {
	            throw new IndexOutOfBoundsException("Index is out of bounds.");
	        }
	        return super.list[index];
	    }	
}

/**
 * This class simulates a custom set that stores unique elements.
 */
class MySet extends Container {	

	// TODO: Your implementation starts here
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	public MySet() {
        super(); // Call the constructor of the parent class (Container)
    }
	@Override
	public void add(Object object) {
        if (this.countOccurrences(object) == 0) {
            super.add(object); // Call the add method of the parent class (Container) only if the element is not already in the set.
        }
    }
	@Override
	public Object remove(Object object) {
		int index=-1;
		Object toremove = null;
		for(int i=0; i<this.size; i++) {
			if(list[i].equals(object)) {
				toremove = list[i];
				index = i;
			break;
		    }
		}
		if(index>=0) {
			for(int j=index; j<this.size-1; j++) {
				list[j] =list[j+1];
		}			
			this.list[this.size-1]=null;
			this.size--;
			return toremove;
			  }
		return toremove;
		}


    }
	


