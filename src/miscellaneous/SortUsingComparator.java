package miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Design a student object that can be sorted by GPA and Name. Make use of comparators.
 * @author Tahir
 *
 */
public class SortUsingComparator {

	public static void main(String[] args) {

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("B", 3.9));
		studentList.add(new Student("A", 3.5));
		studentList.add(new Student("E", 3.7));
		studentList.add(new Student("Z", 3.1));
		studentList.add(new Student("E", 4.0));
		
		// Print as in list
		System.out.println("Printing without sorting...");
		Iterator<Student> iter = studentList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("Printing after sorting by Name...");
		Collections.sort(studentList, new NameComparator());
		iter = studentList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("Printing after sorting by GPA in ascending order...");
		Collections.sort(studentList, new GpaComparator());
		iter = studentList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}

class Student {
	public String name;
	public double gpa;
	
	//Constructor
	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}
	
	@Override
	public String toString() {
		return this.name + ", "+ this.gpa;
	}

}

class GpaComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {

		return (int) (10*s1.gpa - 10*s2.gpa);
	}
	
}

class NameComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {

		return s1.name.compareTo(s2.name);
	}
	
}