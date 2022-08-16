package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Autofill {
	
	public static ArrayList<Subject> addBasicSubjects() {
		Subject Maths = new Subject("Maths");
		Subject Biol = new Subject("Biology");
		Subject Geo = new Subject("Geography");
		Subject Phs = new Subject("Physics");
		Subject Eng = new Subject("English");
		
		ArrayList<Subject> allSubjects = new ArrayList<>(Arrays.asList(Maths, Biol, Geo, Phs, Eng));
		return allSubjects;
	}
	
	public static void addSomeInfo(Registry r, ArrayList<Subject> allSubjects) {

		r.addStudent("Emily", "Rose");
		r.addStudent("Stephen", "Parks");
		r.addStudent("Remy", "Malik");   
		
		
		for(int i=0; i<allSubjects.size(); i++) {
			for(int j=1; j<4; j++) {
				int b = (int)(Math.random()*(6)+1);  
				allSubjects.get(i).addGrade(r, j, b);
			}
			
		}
	}

}
