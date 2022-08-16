package main;

public class Checker {
	
	public static boolean isGradeCorrect(int grade) {
		if(grade>=0 && grade<7) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean studentExists(Registry r, int studentId) {
		if(r.students.containsKey(studentId)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean containsOnlyLetters(String str) {
		int j=0;
		String[] sepStr = str.split(" ");
		for(int i=0; i<sepStr.length;i++) {
			if(sepStr[i].matches("[a-zA-Z]+")) {
				j+=1;
			}
		}
		if(j==sepStr.length) {
			return true;
		} 
		return false;
	}  
	
	public static boolean isCorrectSize(String str) {
		if(str.length()>4 && str.length()<21) {
			return true;
		} else {
			return false;
		}
	}



}
