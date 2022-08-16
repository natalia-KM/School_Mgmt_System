package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	static Scanner in = new Scanner(System.in);
	
	
	public static void mainMenu() {
		System.out.println("Choose one of the options below.");
		System.out.println("--------------------------------------------");
		System.out.println("a) view the registry");
		System.out.println("b) add a student");
		System.out.println("c) add a grade");
		System.out.println("d) add many grades");
		System.out.println("e) change grade");
		System.out.println("f) remove a grade");
		System.out.println("g) remove many grades");
		System.out.println("h) export contents into a file");
		System.out.println("x) exit");
		System.out.println("--------------------------------------------");
	}

	

	public static void mAddStudent(Registry r) {
		System.out.println("Student first name: ");
			String fname = in.next();
			System.out.println("Student last name: ");
			String lname = in.next();
			
			String fullName = fname + " " + lname;
			
			if(Checker.containsOnlyLetters(fullName) && Checker.isCorrectSize(fullName)) {
				r.addStudent(fname, lname);
				System.out.println("Added " + fullName);
			}
		
	}
	
	public static void mChangeGrade(Registry r, ArrayList<Subject> allSubjects) {
		System.out.println("Student ID: ");
		int studentId = in.nextInt();
		in.nextLine();
		System.out.println("Subject? ");
		String subject = in.nextLine();
		
		int j = 20;
		if(Checker.studentExists(r, studentId)) {
			for(int i=0; i<allSubjects.size(); i++) {
				if(allSubjects.get(i).subjectName.equals(subject)) {
					j = i;
					break;
				}
			}
			if(j!=20) {
				//j is subject
				System.out.println("Grade to change: ");
				int oldGrade = in.nextInt();
				System.out.println("Enter new grade: ");
				int newGrade = in.nextInt();
				in.nextLine();
				if(Checker.isGradeCorrect(oldGrade)&&Checker.isGradeCorrect(newGrade)) {
					allSubjects.get(j).changeGrade(r, studentId, newGrade, oldGrade);
				} else {
					System.out.println("Incorrect input.");
				}
			} else {
				System.out.println("Subject does not exist");
			}
		}
	}
	
	public static void mRemoveStudent(Registry r) {

	//	try () {
	
			System.out.println("Student's first name: ");
			String fname = in.nextLine();
			System.out.println("Student's last name: ");
			String lname = in.nextLine();
			System.out.println("Student ID: ");
			int studentId = in.nextInt();
			
			
			r.removeStudent(r, studentId, fname, lname);
		
	//	} catch(Exception e) {
		//	System.out.println(e);
	//	}
		
	}


	public static void mRemoveGrade(Registry r, ArrayList<Subject> allSubjects) {
			System.out.println("Which subject? ");
			String subject = in.next();
			System.out.println("Which student(id)?");
			int studentId = in.nextInt();
			in.nextLine();
			System.out.println("Grade to remove:");
			int grade = in.nextInt();
			in.nextLine();
			
			int j = 20;
			if(Checker.studentExists(r, studentId) && Checker.isGradeCorrect(grade)) {
				for(int i=0; i<allSubjects.size(); i++) {
					if(allSubjects.get(i).subjectName.equals(subject)) {
						j = i;
						break;
					}
				}
				if(j!=20) {
					allSubjects.get(j).removeGrade(r, studentId, grade);
				} else {
					System.out.println("Subject does not exist");
				}
				
			} else {
				System.out.println("Wrong..");
			} 
	
		
	}
	

	public static void mAddGrade(Registry r, ArrayList<Subject> allSubjects) {
			System.out.println("Which subject? ");
			String subject = in.next();
			System.out.println("Which student(id)?");
			int studentId = in.nextInt();
			System.out.println("Grade to add:");
			int grade = in.nextInt();

			in.nextLine();
			int j = 20;
			if(Checker.studentExists(r, studentId) && Checker.isGradeCorrect(grade)) {
				for(int i=0; i<allSubjects.size(); i++) {
					if(allSubjects.get(i).subjectName.equals(subject)) {
						j = i;
						break;
					}
				}
				if(j!=20) {
					allSubjects.get(j).addGrade(r, studentId, grade);
				} else {
					System.out.println("Subject does not exist");
				}
				
			} else {
				System.out.println("Wrong..");
			}
			
		
		
	}
	
	
	public static void mRemoveGrades(Registry r,ArrayList<Subject> allSubjects) {
		

			System.out.println("Which subject? ");
			String subject = in.next();
			System.out.println("Which student(id)?");
			int studentId = in.nextInt();
			
			
			if(Checker.studentExists(r, studentId)) {
				int j=20;
				for(int i=0; i<allSubjects.size(); i++) {
					if(allSubjects.get(i).subjectName.equals(subject)) {
						j = i;
						break;
					}
				}
				if(j!=20) {
					System.out.println("Type grade to remove (1 to 6) or 7 to quit");
					try {
					int gradeToRemove = in.nextInt();
					in.nextLine();
					
					if(Checker.isGradeCorrect(gradeToRemove) == false) {
						System.out.println("Wrong input.");
						gradeToRemove=7;
						}
					while(gradeToRemove!=7) {
						allSubjects.get(j).removeGrade(r, studentId, gradeToRemove);
						System.out.println("Type grade to remove (1 to 6) or 7 to quit");
						try {
						gradeToRemove = in.nextInt();
						in.nextLine();
						if(Checker.isGradeCorrect(gradeToRemove) == false) {
							System.out.println("Wrong input.");
							break;
						}
						} catch (Exception e) {
							System.out.println("Something went wrong.");
							gradeToRemove=7;
						}
					}  
					} catch (Exception e) {
						System.out.println("Wrong input.");
					} 
					} else {
					System.out.println("Subject does not exist.");
				}
					
			} else {
				in.nextLine();
				System.out.println("Student does not exist.");
			}
		
	}
	
	
	public static void mAddGrades(Registry r, ArrayList<Subject> allSubjects) {

			System.out.println("Which subject? ");
			String subject = in.next();
			System.out.println("Which student(id)?");
			int studentId = in.nextInt();
			int maxToInput = 0;
			
			if(r.students.containsKey(studentId)) {
			
			int j=20;
			for(int i=0; i<allSubjects.size(); i++) {
				if(allSubjects.get(i).subjectName.equals(subject)) {
					j = i;
					break;
				}
			}
			if(j!=20) {
				if(!allSubjects.get(j).grades.containsKey(studentId)) {
					maxToInput =4;
				} else {
					maxToInput = 4 - allSubjects.get(j).grades.get(studentId).size();	
				}
			} else {
				System.out.println("Subject does not exist");
			}
			
			if(maxToInput == 0) {
				System.out.println("Maximum grades added.");
			} else {
				ArrayList<Integer> addThose = new ArrayList<>();
				System.out.println("You can enter up to " + maxToInput + " grades.");
				for(int x=0; x<maxToInput; x++) {
					System.out.println("Enter next grade(or enter 7 to stop): ");
					int a = in.nextInt();
					if(a==7) {
						in.nextLine();
						break;
					} else if(Checker.isGradeCorrect(a)) {
					addThose.add(a); 
					} else {
						System.out.println("Incorrect grade. (from 1 to 6)");
						x = x-1;
					}
				}
				if(addThose.size()>0) {
					allSubjects.get(j).addGrades(r, studentId, addThose);
				}
				
			}
			
} else {
			System.out.println("Student not found.");
}
} 
		}
	

