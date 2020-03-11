package question1;

import java.util.Map;

/**
 * class Card is used to store three characters of cards.
 * @author ray
 */
public class Card {
	private String cardFace;
	private String cardBack;
	private boolean status;

    /**
     * no-argument constructors of class Card
     */
    public Card() {
		
	}

    /**
     * obtain the face of Card
     * @return the face of Card
     */
    public String getCardFace() {
		return cardFace;
	}

    /**
     * set the face of Card
     * @param cardFace the face of card
     */
    public void setCardFace(String cardFace) {
		this.cardFace = cardFace;
	}

    /**
     * obtain the back of Card
     * @return the back of Card
     */
    public String getCardBack() {
		return cardBack;
	}

    /**
     * set the back of card
     * @param cardBack the back of card
     */
    public void setCardBack(String cardBack) {
		this.cardBack = cardBack;
	}

    /**
     * obtain the Card status
     * @return the card status
     */
    public boolean isStatus() {
		return status;
	}

    /**
     * set the status of card
     * @param status the status of card
     */
    public void setStatus(boolean status) {
		this.status = status;
	}

}
