import java.util.ArrayList;

/**
 * main method to execute program
 * @author MSI-PC
 */
public class Main {

    /**
     * execute the readFile analysis program
     * @param args the commend line arguments
     */
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadJavaCode reader = new ReadJavaCode();
		ArrayList<String> javaDoc = reader.read();
		if(Compare.match(javaDoc)){
                    System.out.println("Parentheses is valid");
                }else{
                    System.out.println("Parentheses is invalid");
                }
	}

}
