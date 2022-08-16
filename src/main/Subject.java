package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Subject extends Registry {
	
	int subjectID;
	String subjectName;
	
	Subject(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public Map<Integer, ArrayList<Integer>> grades = new LinkedHashMap<>();
	
	
	public void changeGrade(Registry r, int studentId, int newGrade, int oldGrade) {
		if(r.students.containsKey(studentId) && grades.get(studentId).contains(oldGrade)) {
			removeGrade(r,studentId,oldGrade);
			addGrade(r,studentId,newGrade);
		} else {
			System.out.println("Something went wrong..");
		}
	}
	
	public void addGrades(Registry r, int studentId, ArrayList<Integer> gradesToAdd) {
		if(gradesToAdd.size()>0 && r.students.containsKey(studentId)) {
			for(int i=0; i<gradesToAdd.size();i++) {
				addGrade(r, studentId, gradesToAdd.get(i));
			}
			System.out.println("Grades added successfully");
		} else {
			System.out.println("Something went wrong..");
		}
	}
	
	public void removeGrades(Registry r, int studentId, ArrayList<Integer> gradesToRemove) {
		if(gradesToRemove.size()>0 && r.students.containsKey(studentId)) {
			for(int i=0; i<gradesToRemove.size();i++) {
				removeGrade(r, studentId, gradesToRemove.get(i));
			}
			System.out.println("Finished");
		} else {
			System.out.println("Something went wrong..");
		}
	}
	
	public void removeGrade(Registry r, int studentId, int grade) {
			if(grades.containsKey(studentId) && grades.get(studentId).contains(grade)) {
				grades.get(studentId).remove(grades.get(studentId).indexOf(grade));
				System.out.println("Grade changed/removed.");
			} else {
				System.out.println("No student/grade found");
			}
		
	}
	
	
	
	public void addGrade(Registry r, int studentId, int grade) {
		if(r.students.containsKey(studentId)) {
			if(grades.containsKey(studentId)) {
				if(grades.get(studentId).size()<4) {
					grades.get(studentId).add(grade);
				} else {
					System.out.println("Maximum grades added.");
				}
				
			} else {
				grades.put(studentId, new ArrayList<Integer>(Arrays.asList(grade)));
			}
			
		} else {
			System.out.println("Student not found");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(grades, subjectID, subjectName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(grades, other.grades) && subjectID == other.subjectID
				&& Objects.equals(subjectName, other.subjectName);
	}

	
}
