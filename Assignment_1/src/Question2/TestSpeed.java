package Question2;

/**
 * import java.util.Scanner package that let user could input something in
 * output layout
 *
 * @author Ray
 */
import java.util.Scanner;

/**
 * The TestSpeed class implements an application that simply test the speed of
 * printing string "I type very quickly" for each user
 *
 * @author Ray
 */
public class TestSpeed {

    /**
     * main method used to input information and output test results
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Are you ready to beat down Murli?Press enter when you are ready!");
        //create one object in type of Scanner
        Scanner symbol = new Scanner(System.in);
        //get and store the content of input in one line
        String getSymbol = symbol.nextLine();
        //make a decision whether getSymbol is equla to null, which means user press enter
        if (getSymbol.equals("")) {
            System.out.println("GO!");
            //create one object in type of Scanner
            Scanner sc = new Scanner(System.in);
            //store an instantaneous time when user started input information
            Long startMoment = System.currentTimeMillis();
            //get and store the content of input in one line
            String getStr = sc.nextLine();
            //make a decision whether data that input by user is equal to "I type very quickly"
            if (getStr.equals("I type very quickly")) {
                //store an instantaneous time when user finished input information
                Long endMoment = System.currentTimeMillis();
                //store the real input time
                Long time = endMoment - startMoment;
                System.out.println("your input time is " + time + " milliseconds!");
                //compare the real time with Murli's best score
                if (time < 6325) {
                    System.out.println("you win!");
                } else if (time > 6325) {
                    System.out.println("you lose!");
                } else {
                    System.out.println("deuce!");
                }
            } else {
                System.out.println("your input is incorrect!");
            }
        }
    }
}
