package question2;
import java.util.Scanner;
/**
 * class QuizTime is used execute Quiz process
 * @author ray
 */
public class QuizTime {

    /**
     * main function is used to create one quiz and execute it
     * @param args the command line argument
     */
    public static void main(String[] args) {
		Quiz quiz = new Quiz();
		createQuiz(quiz);
		display(quiz);
	}
	
    /**
     * method createQuiz is used to insert question to one Quiz
     * @param quiz one Quiz object
     * @return Quiz 
     */
    public static Quiz createQuiz(Quiz quiz) {
                //insert question title,question answer to on question object
		Question question1 = new Question("Are you with me!","yes");
                //set complexity to one question object
		question1.setComplexity(1);
                //add question object to quiz
		quiz.add(question1);
                //same as previous
		Question question2 = new Question("Are you with me?","no");
		question2.setComplexity(2);
		quiz.add(question2);
		Question question3 = new Question("Are you happy!","yes");
		question3.setComplexity(3);
		quiz.add(question3);
		Question question4 = new Question("Are you happy?","no");
		question4.setComplexity(4);
		quiz.add(question4);
		Question question5 = new Question("Are you good?","no");
		question4.setComplexity(5);
		quiz.add(question5);
                Question question6 = new Question("hahaha!","no");
		question6.setComplexity(6);
		quiz.add(question6);
		Question question7 = new Question("do you like here?","yes");
		question7.setComplexity(7);
		quiz.add(question7);
		Question question8 = new Question("To be honest!","Ok");
		question8.setComplexity(8);
		quiz.add(question8);
		Question question9 = new Question("where is the limit?","D");
		question9.setComplexity(9);
		quiz.add(question9);
		Question question10 = new Question("how about you now?","fine");
		question10.setComplexity(10);
		quiz.add(question10);
		return quiz;
	}
    
    /**
     * method display is used to show the test, let user input the complexity range
     * @param quiz one Quiz object
     */
    public static void display(Quiz quiz) {
        //let candidate input complexity range and do exception handling
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please input minimum complexity range");
			int min = Integer.parseInt(sc.nextLine());
			System.out.println("Please input maximum complexity range");
			int max = Integer.parseInt(sc.nextLine());
			quiz.giveQuiz(min,max);
		}catch(Exception e) {
			System.out.println("Invalid Input");
		}
	}
}
