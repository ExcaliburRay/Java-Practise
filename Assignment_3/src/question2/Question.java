package question2;

/**
 * class question is used to store the different characters
 * @author ray
 */
public class Question {
	private String question, answer;
	private int complexityLevel;
//-----------------------------------------------------------------
// Sets up the question with a default complexity.
//-----------------------------------------------------------------

    /**
     * constructors with two parameters
     * @param query question title
     * @param result question answer
     */
	public Question (String query, String result)
	{
		question = query;
		answer = result;
		complexityLevel = 1;
	}
//-----------------------------------------------------------------
// Sets the complexity level for this question.
//-----------------------------------------------------------------
        
    /**
     * set question complexity
     * @param level question difficult level
     */
	public void setComplexity (int level)
	{
		complexityLevel = level;
	}
//-----------------------------------------------------------------
// Returns the complexity level for this question.
//-----------------------------------------------------------------

    /**
     * obtain the difficulty of question
     * @return question complexity level
     */
	public int getComplexity()
	{
		return complexityLevel;
	}
//-----------------------------------------------------------------
// Returns the question.
//-----------------------------------------------------------------3

    /**
     * obtain question title
     * @return question title
     */
	public String getQuestion()
	{
		return question;
	}
//-----------------------------------------------------------------
// Returns the answer to this question.
//-----------------------------------------------------------------
        
    /**
     * set the question content
     * @param question question content
     */
    public void setQuestion(String question) {
		this.question = question;
	}
	
    /**
     * obtain the answer of question
     * @return the answer of question
     */
	public String getAnswer()
	{
		return answer;
	}
//-----------------------------------------------------------------
// Returns true if the candidate answer matches the answer.
//-----------------------------------------------------------------
        
    /**
     * set the question answer
     * @param answer the answer of question 
     */
    public void setAnswer(String answer) {
		this.answer = answer;
	}
    /**
     * judge the question answer right or not
     * @param candidateAnswer
     * @return true represent right, false represent wrong
     */
	public boolean answerCorrect (String candidateAnswer)
	{
		return answer.equals(candidateAnswer);
	}
//-----------------------------------------------------------------
// Returns this question (and its answer) as a string.
//-----------------------------------------------------------------
	public String toString()
	{
		return question + "\n" + answer;
	}
}