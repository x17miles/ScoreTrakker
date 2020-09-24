import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students;
	
	public ScoreTrakker() {
		students = new ArrayList<Student>();
	}
	
	public void loadDataFromFile(String inputFile) throws FileNotFoundException {
		FileReader reader = new FileReader(inputFile);
		Scanner in = new Scanner(reader);
		while(in.hasNextLine()) {
			String name = in.nextLine();
			int score = in.nextInt();
			students.add(new Student(name,score));
			if(!in.hasNextLine()) {break;}
			in.nextLine();
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
		try {
			loadDataFromFile("scores.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printInOrder();
	}

	public static void main(String args[]) {
		ScoreTrakker st = new ScoreTrakker();
		st.processFiles();
	}

}
