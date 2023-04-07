import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * View class that has functions for printing a question as part of a quiz
 * and for printing all the questions and their answers both to the screen and 
 * to an xml file, which is used at the end of the program
 * @author Jack
 *
 */
public class QuestionPrinter {
	
	/**
	 * Function that prints a key for the questions
	 * @param readQuestions - The array of question data
	 */
	public static void viewQuestions(ArrayList<Question> readQuestions) {
		String correctAnswer;
		
		//Create a loop that prints out every question with correct answer and format and write to xml file
		for (Question quest : readQuestions) {
			//Need to track what the correct answer is for the right question from its letter, use the Quizzer class function for this
			correctAnswer = Quizzer.trackCorrectAnswer(quest);
			System.out.printf("q:\t%s\n%s:\t%s\n\n", quest.getQuestion(), quest.getAnswer(), correctAnswer);
			
			//Write this to an xml file
		}
		
	}
	
/**
 * Function that sends the key for the questions to an xml file names questions.xml
 * @param readQuestions - The array of question data
 */
public static void writeQuestionsToXml(ArrayList<Question> readQuestions) {
	String correctAnswer;
	try {
			//For the writing of the xml file
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new File("questions.xml"))));
			
			//Loop to write the c
			for (Question quest : readQuestions) {
				//Need to track what the correct answer is for the right question from its letter, use the Quizzer class function for this
				correctAnswer = Quizzer.trackCorrectAnswer(quest);
				//Write this to an xml file
				enc.writeObject("q:\t" + quest.getQuestion() + "\n" + quest.getAnswer() + ":\t" + correctAnswer);
				
			}
			//Close the file when finished
			enc.close();
		
		} catch (Exception ex) {
			System.out.println("Failed!");
		}
	}
}
