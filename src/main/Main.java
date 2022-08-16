package main;


import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Registry r = new Registry();
		ArrayList<Subject> allSubjects = Autofill.addBasicSubjects();
		Autofill.addSomeInfo(r, allSubjects);

		
		System.out.println("Welcome! This is a student grading system. \n A few students have been inserted already.");
		
		try (Scanner ins = new Scanner(System.in)) {
			char opt;

			
			do {
			Menu.mainMenu();
			opt = ins.next().toLowerCase().charAt(0);
			
			switch(opt) {
			case 'a' : View.getView(r, allSubjects); break;
			case 'b' : Menu.mAddStudent(r); break;
			case 'c' : Menu.mAddGrade(r, allSubjects); break;
			case 'd' : Menu.mAddGrades(r, allSubjects); break;
			case 'e' : Menu.mChangeGrade(r, allSubjects); break;
			case 'f' : Menu.mRemoveGrade(r, allSubjects); break;
			case 'g' : Menu.mRemoveGrades(r, allSubjects); break;
			case 'h' : View.toFile(r, allSubjects); break;
			case 'x' : break;
			default : System.out.println("Please enter a correct character."); break;
			
			}
			

			
			}while(opt!='x');
		} catch(Exception e) {
			System.out.println("Wrong input.");
		}
		
		

	}

}
