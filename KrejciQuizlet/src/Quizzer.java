import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Random;

/**
 * The class that asks the user a specified-number of questions at random from the list,
 * making sure not to repeat any questions in a round, and letting the user know what
 * they got correct and incorrect
 * @author Jack
 *
 */
public class Quizzer {
	
	/**
	 * Function to generate random list of integers to be used as the indicies of our question objects
	 * @param totalQuestions - The total number of questions the user wants to answer to use as a benchmark
	 * @return
	 */
	public static ArrayList<Integer> getRandomIndex(Integer totalQuestions) {
		Random randInt = new Random();
		int randomIndex;
		ArrayList<Integer> rangeIndex = new ArrayList<Integer>();
		
		//Loop to create random non repeating integers in required range for needed indecies
		for (int i = 0; i < totalQuestions; i++) {
			randomIndex = randInt.nextInt(20);
			
			//Loop that keeps setting randomIndex to a integer that hasn't been used
			while(rangeIndex.contains(randomIndex)) {
				randomIndex = randInt.nextInt(20);
			}
			//Add the correct random integer to the index list
			rangeIndex.add(randomIndex);
		}
		//Return the list of random indices for the questions to the quizTheUser function
		return rangeIndex;
	}
	
	/**
	 * Function in order to keep track of what the correct letter should be
	 * @param currentQuestion - The question the user is currently answering
	 * @return
	 */
	public static String trackCorrectAnswer(Question currentQuestion) { 
		String correctAnswer = null;
		
		//See where the answer string equals the string for either a, b, c, or d then return that letter
		if (currentQuestion.getAnswer().equals("a")) {
			correctAnswer = currentQuestion.getChoiceA();
		} else if (currentQuestion.getAnswer().equals("b")) {
			correctAnswer = currentQuestion.getChoiceB();
		} else if (currentQuestion.getAnswer().equals("c")) {
			correctAnswer = currentQuestion.getChoiceC();
		} else if (currentQuestion.getAnswer().equals("d")) {
			correctAnswer = currentQuestion.getChoiceD();
		}
		//Return the Question once found
		return correctAnswer; 
	}
	
	
	/**
	 * The function that is used to quiz the user and keep track of what they got right and wrong 
	 * @param readQuestions - The questions ArrayList from text file
	 * @param questionCounter - Used to count the total number of questions in one round of questions
	 * @param correctCounter - Used to count the total number of questions the user got right
	 * @param maxNum - Used as a reference point to how many questions the user wants to attempt to answer
	 * @return - Returns the total number of answers the user got correct in this round 
	 */
	public static double quizTheUser(ArrayList<Question> readQuestions, Integer questionCounter, double correctCounter, Integer maxNum) {
		Scanner sc = new Scanner(System.in);
		//Random randIndex = new Random();
		String userChoice, correctLetter, correctAnswer;
		double finalScore;
		Question currentQuestion = null;
		
		//Ask the user how many questions they want to answer randomly
//		System.out.print("How many questions do you want? ");
//		maxNum = sc.nextInt();
//		System.out.print("\n");
		
		//Create an array of random integers to act as the index of each question object to choose at random
		ArrayList<Integer> randIndexList = getRandomIndex(maxNum);
		
		//Run through a loop for all the questions formatting everything correctly
		for (Integer i = 0; i < maxNum; i++) {
			//Get a random question then remove the index option from the getRandomIndex list so it's not used again
			currentQuestion = readQuestions.get(randIndexList.get(i));
			
			//Print the question and possible answers 
			System.out.printf("%s\na.\t%s\nb.\t%s\nc.\t%s\nd.\t%s\n", currentQuestion.getQuestion(), currentQuestion.getChoiceA(), currentQuestion.getChoiceB(), currentQuestion.getChoiceC(), currentQuestion.getChoiceD());
		
			//Be able to keep track of what the correct letter choice would be in case we need to correct the user
			correctLetter = currentQuestion.getAnswer();
			
			//Be able to track the correct answer tied to the correct letter in case of a correction
			correctAnswer = trackCorrectAnswer(currentQuestion);
						
			//Tell user to give their answer
			System.out.print("Enter letter of your choice: ");
			userChoice = sc.next();
			
			//Acknowledge whether the user choice is right or wrong and keep track of how many they got right NOT DONE!!
			if (userChoice.equals(correctLetter)) {
				System.out.print("Congratulations! That is correct.\n\n");
				//Add to the counter for the amount of questions you got right
				correctCounter += 1;
			} else { 
				//Add to the counter for the amount of questions you are answering but not the amount of questions you got right
				System.out.printf("Sorry. The correct answer was (%s) %s\n\n", correctLetter, correctAnswer);
				
			}
		}
		//When the user is finished with their questions, tell them how many they got right out of the total, and give them a score
		if (maxNum <= 0) {
			finalScore = 0;
		} else {
			finalScore = (correctCounter / maxNum) * 100;
		}
	
		System.out.printf("You got %.0f correct out of %d.\nThat is good for %.2f percent.\n\n", correctCounter, maxNum, finalScore);

		//return how many the user got correct to main to count it
		return correctCounter;
		
	}
	
}
