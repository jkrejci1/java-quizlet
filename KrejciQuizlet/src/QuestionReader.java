import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * Model class that reads the questions from a text file; give information to question class
 * @author Jack
 *
 */
public class QuestionReader {
	
	
	/**
	 * Function to read in all the questions to the question array list
	 * @param fname - Name of the file given by the user
	 * @return
	 */
	public static ArrayList<Question> readQuestionsFromTextFile(String fname) {
		//Create the array list and read the file to get needed info
		try {
			ArrayList<Question> question = new ArrayList<Question>();
			String line, theQuestion = null, answerA = null, answerB = null, answerC = null, answerD = null, correctAnswer = null;
			String[] parts;
			Scanner fsc = new Scanner(new File(fname));
			Question currentQuestion = null;
			
			//Loop to read each line into its proper parts of the object
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split("\t");
				
				//If the first part of a q that indicates a question
				if (parts[0].equals("q")) {
					theQuestion = parts[1];
				} else if (parts[0].equals("a")) {	//If first part is an a you have answer a
					answerA = parts[1];
				} else if (parts[0].equals("b")) {	//If first part is a b you have answer b
					answerB = parts[1];
				} else if (parts[0].equals("c")) {	//If first part is a c you have answer c
					answerC = parts[1];
				} else if (parts[0].equals("d")) {	//If first part is a d you have answer d
					answerD = parts[1];
				} else if (parts[0].equals("?")) {	//If first part is a ? you have the correct answer
					correctAnswer = parts[1];
					currentQuestion = new Question(theQuestion, answerA, answerB, answerC, answerD, correctAnswer);
					question.add(currentQuestion);
				}
			}
			fsc.close();
			return question;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

}
