package question2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * class Quiz is used to handle Quiz problem in add question and display question
 * @author ray
 */
public class Quiz{
	private ArrayList<Question> questionList = new ArrayList();
        //used to count right answer and wrong answer
	private int rightAnswer;
	private int wrongAnswer;

    /**
     * method add is used to judge number of question list and insert question in ArrayList 
     * @param question
     */
    public void add(Question question) {
                //if number of question less 26 or equal to 25,insert question
		if(this.questionList.size()<26) {
			this.questionList.add(question);
		}else {
			System.out.println("The question list is full");
		}
		
	}

    /**
     * method giveQuiz is used to display information and test right or wrong
     */
    public void giveQuiz() {
        //set an Iterator on ArrayList
		Iterator it = questionList.iterator();
		while(it.hasNext()) {
                    //get each question object from ArrayList
			Question question = (Question) it.next();
			System.out.println(question.getQuestion());
			System.out.println("Please input your answer");
                        //input information
                        try{
                            Scanner sc = new Scanner(System.in);
                            String candidateAnswer = sc.nextLine();
                            if(question.answerCorrect(candidateAnswer)) {
                                    rightAnswer++;
                            }else {
                                    wrongAnswer++;
                            }
                        }catch(Exception e){
                            System.out.println("Invalid Input,Please Restart!");
                        }
		}
		System.out.println(rightAnswer+" questions are right"+","+wrongAnswer+" questions are wrong");
	}
	
    /**
     *
     * @param min the earliest complexity
     * @param max the hardest complexity
     */
    public void giveQuiz(int min,int max) {
        //set an Iterator on ArrayList
		Iterator it = questionList.iterator();
		while(it.hasNext()) {
                    //get each question object from ArrayList
			Question question = (Question)it.next();
                        //if the complexity of question is on the given range,show it 
			if((question.getComplexity()>=min)&&(question.getComplexity()<=max)) {
				System.out.println(question.getQuestion());
				System.out.println("Please input your answer");
				Scanner sc = new Scanner(System.in);
				String candidateAnswer = sc.nextLine();
				if(question.answerCorrect(candidateAnswer)) {
					rightAnswer++;
				}else {
					wrongAnswer++;
				}
			}
		}
		System.out.println(rightAnswer+" questions are right"+","+wrongAnswer+" questions are wrong");
	}
}
