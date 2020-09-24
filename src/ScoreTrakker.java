import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	public ScoreTrakker() {
		students = new ArrayList<Student>();
	}
	
	public void loadDataFromFile(String inputFile) throws FileNotFoundException {
		students = new ArrayList<Student>();
		FileReader reader = new FileReader(inputFile);
		Scanner in = new Scanner(reader);
		while(in.hasNextLine()) {
			String name = in.nextLine();
			String scoreString = in.nextLine();
			int score;
			try{
				score = Integer.parseInt(scoreString);
			}
			catch(Exception NumberFormatExecption) {
				System.out.println("\nIncorrect format for " +  name + "not a valid score: " + scoreString + "\n");		
				continue;
			}
			students.add(new Student(name,score));
			
		}
		in.close();
	}
	public void printInOrder() {
		//Sort the students
		Collections.sort(students);
		//Print them out
		System.out.println("Sutdent Score List");
		for(Student i : students) {
			System.out.println(i);
		}
	}
	public void processFiles() {
		for (String i : files) {
			try {
				loadDataFromFile(i);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				
				System.out.println("\nCan't open file: " + i);
				continue;
			}
			printInOrder();
		}
		
	}

	public static void main(String args[]) {
		ScoreTrakker st = new ScoreTrakker();
		st.processFiles();
	}

}
