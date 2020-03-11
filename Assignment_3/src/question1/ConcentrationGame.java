package question1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * class Concentration is used to create one game Purble Pairs
 * @author Ray
 */
public class ConcentrationGame {

    /**
     *  main function is invoking several methods to execute this game
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		// TODO Auto-generated method stub
                // create one two-dimentional arrays to store characters in this game
		String[][] screen = new String[5][5];
		Card[] card = new Card[16];
		for(int i = 0 ;i<16;i++) {
			card[i] = new Card();
		}
                //invoking four methods to execute this game
		start(card);
		initial(screen,card);
		showScreen(screen);
		showFinal(screen,card);
	}
	
    /**
     * Class start is used to add 16 pictures in one Arraylist and 
     * put them in a random order to represent each card face, 
     * use * represent each back of card
     * @param card object in storing card information
     * @return object Card[]
     */
    public static Card[] start(Card[] card) {
		ArrayList<String> list = new ArrayList<String>();
                //add 16 pictures in one Arraylist
		list.add("A");
		list.add("A");
		list.add("Q");
		list.add("Q");
		list.add("K");
		list.add("K");
		list.add("J");
		list.add("J");
		list.add("2");
		list.add("2");
		list.add("5");
		list.add("5");
		list.add("6");
		list.add("6");
		list.add("9");
		list.add("9");
		int[] randomList = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Random random = new Random();
		for(int i = 0 ;i<1000;i++) {
                //let temp1 and temp2 be each index of this arraylist 
                //in a random order, if temp1 do not equal to temp1,
                //exchange the value of them.
			int temp1 = random.nextInt(16);
			int temp2 = random.nextInt(16);
			int temp3;
			if(temp1!=temp2) {
				temp3 = randomList[temp1];
				randomList[temp1] = randomList[temp2];
				randomList[temp2] = temp3;
			}
		}
                //set each back of card as *
		for(int i = 0 ;i<16;i++) {
			card[i].setCardFace(list.get(randomList[i]));
			card[i].setCardBack("$");
		}
		return card;
	}
	
    /**
     * class initial is used to create the initial screen of this game
     * @param screen object in storing display information
     * @param card object in storing card information
     * @return object screen[][]
     */
    public static String[][] initial(String[][] screen,Card[] card) {
                //let left-top show nothing
		screen[0][0] = " ";
		int k=0;
                //let left border and top border show axis
		for(int i = 1;i<5;i++) {
			screen[0][i] = String.valueOf(i);
			screen[i][0] = String.valueOf(i);
                        //let inside of this screen shows *
			for(int j = 1;j<5;j++) {
				screen[i][j] = card[k].getCardBack();
				card[k].setStatus(false);
				k++;
			}
		}
		return screen;
	}
    
    
    /**
     * method showScreen is used to display this game in present status
     * @param screen object in storing card information
     */
    public static void showScreen(String[][] screen) {
		for(int i =0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(screen[i][j]+' ');
			}
			System.out.println();
		}
	}
	
    /**
     * class expose is used to expose each card and check whether card exposing 
     * in the first and the second time is same or not.
     * @param screen object in storing card information
     * @param card object in storing card information
     * @return two-dimensional array
     */
    public static String[][] expose(String[][] screen,Card[] card){
                //represent x and y axis in the first and second time
		int xAxisOne;
		int yAxisOne;
		int xAxisTwo;
		int yAxisTwo;
                //create one ray object in Player type
		Player ray = new Player();
                //let Map getInputOne point to Map created by Player
		Map<String,Integer> getInputOne = new HashMap<String,Integer>();
                //expose the first card
		getInputOne = ray.input();
                //get value of index in "x" and "y"
		xAxisOne = getInputOne.get("x");
		yAxisOne = getInputOne.get("y");
                //if player exposed one card in back status,get its card face
		if(screen[xAxisOne][yAxisOne]==card[0].getCardBack()) {
			screen[xAxisOne][yAxisOne] = card[4*(xAxisOne-1)+yAxisOne-1].getCardFace();
			card[4*(xAxisOne-1)+yAxisOne-1].setStatus(true);
			showScreen(screen);
                //give the hint and re-execuate method expose
		}else {
			System.out.println("This card is already exposed!");
			expose(screen,card);
		}
		Map<String,Integer> getInputTwo = new HashMap<String,Integer>();
                //expose the second card
		getInputTwo = ray.input();
                //get value of index in "x" and "y"
		xAxisTwo = getInputTwo.get("x");
		yAxisTwo = getInputTwo.get("y");
                //set one infinite loop until user exposed one card in back status,
                //and then get its card face
		while(true) {
			if(screen[xAxisTwo][yAxisTwo]==card[0].getCardBack()) {
				screen[xAxisTwo][yAxisTwo] = card[4*(xAxisTwo-1)+yAxisTwo-1].getCardFace();
				card[4*(xAxisTwo-1)+yAxisTwo-1].setStatus(true);
				showScreen(screen);
                                //break out of this infinite loop
				break;
			}else {
                            //give hint and let player input data again
				System.out.println("This card is already exposed!");
				getInputTwo = ray.input();
				xAxisTwo = getInputTwo.get("x");
				yAxisTwo = getInputTwo.get("y");
			}
		}
                //let current thread sleep 3 seconds, it needs execption handling
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                //let current screen out of view
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
                System.out.println();
		System.out.println();
                //if the first and second expose shows the same card face, do not
                //let their back show anymore
		if(screen[xAxisOne][yAxisOne].equals(screen[xAxisTwo][yAxisTwo])) {
			showScreen(screen);
		}else {
                    //show their back if first and second expose shows the different card face
			screen[xAxisOne][yAxisOne] = card[4*(xAxisOne-1)+yAxisOne-1].getCardBack();
			card[4*(xAxisOne-1)+yAxisOne-1].setStatus(false);
			screen[xAxisTwo][yAxisTwo] = card[4*(xAxisTwo-1)+yAxisTwo-1].getCardBack();
			card[4*(xAxisTwo-1)+yAxisTwo-1].setStatus(false);
			showScreen(screen);
		}
		return screen;
	}
	
    /**
     * class check is used to examine whether user expose both cards
     * @param screen object in storing display information
     * @param card object in storing card information
     * @return total number of count
     */
    public static int check(String[][] screen,Card[] card) {
		int count = 0;
                //count the number of card displaying card face
		for(int i = 0 ;i<16;i++) {
			if(card[i].isStatus()==true) {
				count++;
			}
		}
		return count;
	}
	
    /**
     * class showFinal is used to display the final result of this game
     * @param screen object in storing screen information
     * @param card object in storing card information
     */
    public static void showFinal(String[][] screen, Card[] card) {
		try {
                    //set one infinite loop,expose card until all cards exposed
			while(true){
				if(check(screen,card)!=16) {
					expose(screen,card);
				}else {
					System.out.println("You win!");
					break;
				}
			}
                        //give the hint and end this game
		}catch(Exception e) {
			System.out.println("invalid input!Please Restart This Game!");
		}
	}
	
}
