package question3;

import java.util.Scanner;

/**
 * class User is used to input information 
 * @author ray
 */
public class User {

    /**
     * method input is used to input information
     * @return input information
     */
    public String input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input your amount:");
		String num = sc.nextLine();
		return num;
	}
}
