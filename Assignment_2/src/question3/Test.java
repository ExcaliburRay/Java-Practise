
package question3;

import java.util.Scanner;

/**
 * class Test is used to test the method in class Iterative
 * @author ray
 */
public class Test {

    /**
     * execute and test the method in class Iterative 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                // build on object it in type Iterative
		Iterative it = new Iterative();
                //loop and print
//		for(int i=-20; i<20;i++) {
//			System.out.println(it.thisIsIterative(i));
//		}
                try{
                    Scanner sc = new Scanner(System.in);
                    int num = Integer.parseInt(sc.nextLine());
                    System.out.println(it.thisIsIterative(num));
                }catch(NumberFormatException e){
                    System.out.println(e.getMessage() + " is invalid input!");
                    System.out.println("Please Restart!");
                }
                
	}
}
