import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class OOQuizTool {


	/**
	 * Main function that repeatedly presents quizzes to the user until they no longer want to continue
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fname, continues = "c";
		int questionCounter = 0, maxNum = 0;
		double correctCounter = 0.0, totalRight, totalCorrectCounter = 0.0, finalScore;
		
		//Create initial menu layout
		System.out.println("************************************************************");
		System.out.println("              Object-Oriented Theory Quiz Tool              ");
		System.out.println("************************************************************\n");
		
		//Tell user to enter the questions.txt file
		System.out.print("Enter name of questions file: ");
		fname = sc.nextLine();
		
		//Read in the questions and when they've been read ask the user if they're really up for the challenge
		ArrayList<Question> readQuestions = QuestionReader.readQuestionsFromTextFile(fname);
		System.out.println("The questions have been read. Are you ready to show how smart you are?\n");
		
		//Bring the questions into the quizzer class to be quiz the user and keep asking if they want to continue
		while (continues.equalsIgnoreCase("c")) {
			
			//Ask the user how many questions they want to answer in this round
			System.out.print("How many questions do you want? ");
			maxNum = sc.nextInt();
			System.out.print("\n");
			
			//Update the counters with all needed information
			totalRight = Quizzer.quizTheUser(readQuestions, questionCounter, correctCounter, maxNum);
			totalCorrectCounter += totalRight;
			questionCounter += maxNum;
			
			//Ask if the user wants to continue or quit
			System.out.print("Enter c to continue or q to quit: ");
			continues = sc.next();
			System.out.print("\n");
			
		}
		
		//Give the total of right and wrong and a percentage to the user of their final scores
		finalScore = (totalCorrectCounter / questionCounter) * 100;
		System.out.printf("You got %.0f correct out of %d.\nThat is good for %.2f percent.\n\n", totalCorrectCounter, questionCounter, finalScore);
		
		//Send the text file Question array to printReader to print it's information to screen
		System.out.println("Before you go, here are all the questions and answers.");
		QuestionPrinter.viewQuestions(readQuestions);
		
		//Convert the question question data to an xml file
		QuestionPrinter.writeQuestionsToXml(readQuestions);
		System.out.println("We've also written all the questions to an xml file named questions.xml.\n");
		
		//Say goodbye to the user
		System.out.println("We hope you feel as smart as we are. Good bye.");
		
		//Read check for xml file
		
	}
}
