package question1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * class Player is used to let each player could type axis in program
 * @author Ray
 */
public class Player {
	
    /**
     * input method could let each player input two number to be x axis and y axis, then store them in one HashMap
     * @return HashMap axis
     */
    public Map<String,Integer> input() {
                //build one HashMap object axis to store the input data of each user
		Map<String,Integer> axis = new HashMap<String,Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("please input one X axis of picture you want to expose");
		int xAxis = Integer.parseInt(sc.nextLine());
		System.out.println("please input one Y axis of picture you want to expose");
		int yAxis = Integer.parseInt(sc.nextLine());
                //set "x" and "y" as key of map axis and set xAxis and yAxis as their value respectively
		axis.put("x",xAxis);
		axis.put("y",yAxis);
		return axis;
	}
}
