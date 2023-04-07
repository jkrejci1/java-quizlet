

/**
 * Model class that stores the text, choices, and answer for each question
 * @author Jack
 *
 */
public class Question {
	private String question;
	private String choiceA;
	private String choiceB;
	private String choiceC;
	private String choiceD;
	private String answer;
	
	//Generate getter/setter for question
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	//Generate getter/setter for ChoiceA
	public String getChoiceA() {
		return choiceA;
	}
	public void setChoiceA(String choiceA) {
		this.choiceA = choiceA;
	}
	
	//Generate getter/setter for ChoiceB
	public String getChoiceB() {
		return choiceB;
	}
	public void setChoiceB(String choiceB) {
		this.choiceB = choiceB;
	}
	
	//Generate getter/setter for ChoiceC
	public String getChoiceC() {
		return choiceC;
	}
	public void setChoiceC(String choiceC) {
		this.choiceC = choiceC;
	}
	
	//Generate getter/setter for ChoiceD
	public String getChoiceD() {
		return choiceD;
	}
	public void setChoiceD(String choiceD) {
		this.choiceD = choiceD;
	}
	
	//Generate getter/setter for answer
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	//Generate non-default constructor
	public Question() {
		question = "";
		choiceA = "";
		choiceB = "";
		choiceC = "";
		choiceD = "";
		answer = "";
				
	}
	
	//Generate default constructor
	public Question(String question, String choiceA, String choiceB, String choiceC, String choiceD, String answer) {
		setQuestion(question);
		setChoiceA(choiceA);
		setChoiceB(choiceB);
		setChoiceC(choiceC);
		setChoiceD(choiceD);
		setAnswer(answer);
	}
	
	//Generate the toString function for each question
	@Override 
	public String toString() {
		return String.format("%s %s %s %s %s %s", question, choiceA, choiceB, choiceC, choiceD, answer);
	}
	
}
