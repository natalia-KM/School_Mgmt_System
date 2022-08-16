package main;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Registry {

	
	int studentID;
	

public void addStudent(String fname, String lname) {
	studentID = students.size()+1;
		String fullName= fname + " " + lname;
		students.put(studentID, fullName);
	}

public void removeStudent(Registry r, int studentId, String fname, String lname) {   //both name and id to make sure
	String fullName = fname + " " + lname;
	if(r.students.containsKey(studentId) && r.students.get(studentId).equals(fullName)) {
		r.students.remove(studentId);
	}
}

	
	
	public Map<Integer, String> students = new TreeMap<>();
	

	@Override
	public int hashCode() {
		return Objects.hash(studentID, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registry other = (Registry) obj;
		return studentID == other.studentID && Objects.equals(students, other.students);
	}
	

	
	
}
