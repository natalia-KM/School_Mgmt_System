package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;

public class View extends Registry {
	
	//max chars for full name = 20
	//max numbers of grades = 4
//3+24+3x15  = 27+45 = 72
	public static void getView(Registry r, ArrayList<Subject> allSubjects) {
		
		String space = " ";
		String dash = "-";
		
		System.out.print("ID "  + "Full name " + space.repeat(15));    //Full name - 9 chars, so 24 (20 is max for name and 4 as a additional space), so 24-9=15
		for(int i=0;i<allSubjects.size(); i++) {
			System.out.print(allSubjects.get(i).subjectName + space.repeat(15-allSubjects.get(i).subjectName.length()));
		}
		System.out.println();
		System.out.println(dash.repeat(100));
		for(Entry<Integer, String> pair : r.students.entrySet()) {
			System.out.print(pair.getKey() + "  " + pair.getValue() + " ");  //prints studentId and full name
			System.out.print(space.repeat(24-pair.getValue().length()));   //space
			

			for(int i=0;i<allSubjects.size(); i++) {
				if(allSubjects.get(i).grades.get(pair.getKey()) == null) {
					
					System.out.print(space.repeat(15));
				} else {
				System.out.print(allSubjects.get(i).grades.get(pair.getKey()).toString().replace("[", "").replace("]", ""));  //prints grades
				System.out.print(space.repeat(15-allSubjects.get(i).grades.get(pair.getKey()).toString().replace("[", "").replace("]", "").length()));
				}
			}
			
			System.out.println();
			
		}
		
	}
	
	
public static void toFile(Registry r, ArrayList<Subject> allSubjects) {
	Scanner in = new Scanner(System.in);
	System.out.println("Name of a file? : ");
	String filename = in.nextLine();
	//change it to your own path, like Desktop, otherwise it will throw an Exception 
	File myFile = new File("C:\\"+ filename +".txt");
	try {
		FileWriter fw = new FileWriter(myFile);
	
		
		String space = " ";
		String dash = "-";
		
		fw.write("ID "  + "Full name " + space.repeat(15));
		for(int i=0;i<allSubjects.size(); i++) {
			fw.write(allSubjects.get(i).subjectName + space.repeat(15-allSubjects.get(i).subjectName.length()));
		}
		fw.write("\n");
		fw.write(dash.repeat(100));
		fw.write("\n");
		for(Entry<Integer, String> pair : r.students.entrySet()) {
			fw.write(pair.getKey() + "  " + pair.getValue() + " ");
			fw.write(space.repeat(24-pair.getValue().length()));

			for(int i=0;i<allSubjects.size(); i++) {
				if(allSubjects.get(i).grades.get(pair.getKey()) == null) {
					fw.write(space.repeat(17));
				} else {
					fw.write(allSubjects.get(i).grades.get(pair.getKey()).toString().replace("[", "").replace("]", ""));
					fw.write(space.repeat(17-allSubjects.get(i).grades.get(pair.getKey()).toString().length()));
				}
			}
			fw.write("\n");
			
		}
		fw.close();
		System.out.println("Finished. The file is under the name: " + filename + ".txt");
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}}
