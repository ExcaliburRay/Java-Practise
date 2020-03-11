
package question2;

/**
 * //class play is used to store several parameters of different players
 * @author ray
 */
public class Player {
	private String nameOne;
	private String nameTwo;
	private String nameThree;
	private double playerOneAccuracy;
	private double playerTwoAccuracy;
	private double playerThreeAccuracy;
	private Boolean playerOneState;
	private Boolean playerTwoState;
	private Boolean playerThreeState;

    /**
     * obtain the name of first player
     * @return the name of first player
     */
    public String getNameOne() {
		return nameOne;
	}

    /**
     * set the name of first player
     * @param nameOne
     */
    public void setNameOne(String nameOne) {
		this.nameOne = nameOne;
	}

    /**
     * obtain the name of second player
     * @return the name of second player
     */
    public String getNameTwo() {
		return nameTwo;
	}

    /**
     * set the name of second player
     * @param nameTwo
     */
    public void setNameTwo(String nameTwo) {
		this.nameTwo = nameTwo;
	}

    /**
     * obtain the name of third player
     * @return the name of third player
     */
    public String getNameThree() {
		return nameThree;
	}

    /**
     * set the name of third player
     * @param nameThree
     */
    public void setNameThree(String nameThree) {
		this.nameThree = nameThree;
	}
	
    /**
     * obtain the accuracy of first player
     * @return the accuracy of first player
     */
    public double getPlayerOneAccuracy() {
		return playerOneAccuracy;
	}

    /**
     * set the accuracy of first player
     * @param playerOneAccuracy
     */
    public void setPlayerOneAccuracy(double playerOneAccuracy) {
		this.playerOneAccuracy = playerOneAccuracy;
	}

    /**
     * obtain the accuracy of second player
     * @return the accuracy of second player
     */
    public double getPlayerTwoAccuracy() {
		return playerTwoAccuracy;
	}

    /**
     * set the accuracy of second player
     * @param playerTwoAccuracy
     */
    public void setPlayerTwoAccuracy(double playerTwoAccuracy) {
		this.playerTwoAccuracy = playerTwoAccuracy;
	}

    /**
     * obtain the accuracy of third player
     * @return the accuracy of third player
     */
    public double getPlayerThreeAccuracy() {
		return playerThreeAccuracy;
	}

    /**
     * set the accuracy of third player
     * @param playerThreeAccuracy
     */
    public void setPlayerThreeAccuracy(double playerThreeAccuracy) {
		this.playerThreeAccuracy = playerThreeAccuracy;
	}

    /**
     * obtain the living state of first player
     * @return the living state of first player
     */
    public Boolean getPlayerOneState() {
		return playerOneState;
	}

    /**
     * set the living state of first player
     * @param playerOneState
     */
    public void setPlayerOneState(Boolean playerOneState) {
		this.playerOneState = playerOneState;
	}

    /**
     * obtain the living state of second player
     * @return the living state of second player
     */
    public Boolean getPlayerTwoState() {
		return playerTwoState;
	}

    /**
     * set the living state of second player
     * @param playerTwoState
     */
    public void setPlayerTwoState(Boolean playerTwoState) {
		this.playerTwoState = playerTwoState;
	}

    /**
     * obtain the living state of third player
     * @return the living state of third player
     */
    public Boolean getPlayerThreeState() {
		return playerThreeState;
	}

    /**
     * set the living state of third player
     * @param playerThreeState
     */
    public void setPlayerThreeState(Boolean playerThreeState) {
		this.playerThreeState = playerThreeState;
	}

    /**
     * constructor with no parameter
     */
    public Player() {
		
	}

    //claculate the shooting accuracy,if random number equal to 1,represent shoot the target
    boolean ShootAtTarget(double i) {
		if(i==1) {
			return true;
		}
		else {
			return false;
		}		
	}
}