package question3;

import java.util.HashMap;

/**
 * class RewriteCheque is used to transfer number in one invoice to English words
 * @author ray
 */
public class RewriteCheque {
	private HashMap<Integer,String> rewrite = new HashMap<Integer,String>();

    /**
     * main function is used to insert transfer code and start transfer
     * @param args the command line arguments
     */
    public static void main(String[] args){
		RewriteCheque rewriteCheque = new RewriteCheque();
		rewriteCheque.add();
		rewriteCheque.start(rewriteCheque);
	}
 	
    /**
     * add method is used to insert matching code to one HashMap
     * @return matching code HashMap
     */
    public HashMap<Integer,String> add(){
        //insert matching code to one HashMap
		this.rewrite.put(0, "ZERO");
		this.rewrite.put(1, "ONE");
		this.rewrite.put(2, "TWO");
		this.rewrite.put(3, "THREE");
		this.rewrite.put(4, "FOUR");
		this.rewrite.put(5, "FIVE");
		this.rewrite.put(6, "SIX");
		this.rewrite.put(7, "SEVEN");
		this.rewrite.put(8, "EIGHT");
		this.rewrite.put(9, "NINE");
		this.rewrite.put(10, "TEN");
		this.rewrite.put(11, "ELEVEN");
		this.rewrite.put(12, "TWELVE");
		this.rewrite.put(13, "THIRTEEN");
		this.rewrite.put(14, "FOURTEEN");
		this.rewrite.put(15, "FIFTEEN");
		this.rewrite.put(16, "SIXTEEN");
		this.rewrite.put(17, "SEVENTEEN");
		this.rewrite.put(18, "EIGHTEEN");
		this.rewrite.put(19, "NINETEEN");
		this.rewrite.put(20, "TWENTY");
		this.rewrite.put(30, "THIRTY");
		this.rewrite.put(40, "FOURTY");
		this.rewrite.put(50, "FIFTY");
		this.rewrite.put(60, "SIXTY");
		this.rewrite.put(70, "SEVENTY");
		this.rewrite.put(80, "EIGHTTY");
		this.rewrite.put(90, "NINETY");
		this.rewrite.put(100, "HUNDRED");
		this.rewrite.put(1000, "THOUSAND");
		return rewrite;
	}
 	
    /**
     * method judge is used to judge whether number is greater than 1000 or less than 1000
     * and give changing method respectively
     * @param num input information
     * @return number in specific format
     */
    public String judge(String num) {
        //make one StringBuild object 
 		StringBuilder finalNumber = new StringBuilder();
                //change type from string to int
 		int number = Integer.parseInt(num);
 		if(number>=1000) {
                    //get the number before thousands digit
 			int i = number/1000;
                        //insert that number in specific format and insert thousand
 			finalNumber.append(changeNum(i)).append(rewrite.get(1000)).append(" ");
                        //get the remainder of number divided by 1,000
 			number %= 1000;
 		}
                //insert that number in specific format 
 		if(number<1000) {
 			finalNumber.append(changeNum(number));
 		}
 		return finalNumber.toString();
 	}
 	
    /**
     * method changeNum is used to change number to words 
     * @param number input information
     * @return number in specific format
     */
    public String changeNum(int number) {
        //make one StringBuild object 
 		StringBuilder finalNumber = new StringBuilder();
 		if(number>100) {
                    //get the number before one hundred digit
 			int i = number/100;
                        //insert number in specific code by rewrite format
 			finalNumber.append(rewrite.get(i)).append(" ").append(rewrite.get(100)).append(" ");
 			number %= 100;
 		}
 		if(number>20) {
                    //get the number in tenth digits
 			int number1 = (number/10)*10;
                    //get the number in units digits
 			int number2 = number%10;
                    //insert number in specific code by rewrite format
 			finalNumber.append(rewrite.get(number1)).append(" ").append(rewrite.get(number2)).append(" ");
 		}else {
 			finalNumber.append(rewrite.get(number));
 		}
 		return finalNumber.toString();
 	}
 	
    /**
     * change the decimal digits in one format
     * @param str String
     * @return decimal in one specific format
     */
    public String changeDecimal(String str) {
 		if(str.length()==1) {
 			str = str+"0/100";
 		}else {
 			str = str+"/100";
 		}
 		return str;
 	}
 	
    /**
     * method splitInput is used to split "."
     * @param str
     * @return specific format of decimal part
     */
    public String[] splitInput(String str) {
 		return  str.split("\\.");
 	}
 	
    /**
     * method start is used to execute this program
     * @param rewriteCheque
     */
    public void start(RewriteCheque rewriteCheque) {
 		System.out.println("Please enter a dollar amount");
                //create one new object user
		User user = new User();
		String input = user.input();
                //give one limited range
		if(Double.parseDouble(input)>=0&&Double.parseDouble(input)<1000000) {
                    //split input by "."
			String[] getInput = rewriteCheque.splitInput(input);
			String getInteger = getInput[0];
			String getDecimals = getInput[1];
                        //get specific format integer part and decimal part
			String integerPart = rewriteCheque.judge(getInteger);
			String decimalsPart = rewriteCheque.changeDecimal(getDecimals);
			System.out.println("Dollar amount in words: "+integerPart+" and "+decimalsPart);
			
		}else {
			System.out.println("Invaild Invoice Input");
		}
 	}
}
