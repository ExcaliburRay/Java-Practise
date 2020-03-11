import java.util.ArrayList;
import java.util.Stack;

/**
 * Compare Parentheses whether valid in one file 
 * @author MSI-PC
 */
public class Compare {

    /**
     * compare method used to compare different kinds of Parentheses
     * @param list file information store in arrayList
     * @return true or false
     */
    public static boolean match(ArrayList<String> list){
        //build one stack used to store left Parentheses
	Stack<Character> stack = new Stack<Character>();
	boolean state = true;
        //traversal this arraylist
	for(int i = 0;i < list.size();i++) {
            String str = list.get(i);
            char [] charArray = str.toCharArray(); 
            for(char c: charArray){ 
                //let left Parentheses push in stack
		if(c=='{'||c=='['||c=='('){  
                    stack.push(c);  					}
                else if(c=='}'||c==']'||c==')') {
                    if(stack.isEmpty())
                        state = false;
                    //let left Parentheses push out stack and compare with the catching Parentheses
                    Character outStack = stack.pop();	
                    switch(c){  
			case ')': 
                            if(outStack!='(') {
                                state = false;
                            }
                            break;
			case ']': 
                            if(outStack!='[') {
				state = false; 
                            }
                            break; 
			case '}': 
                            if(outStack!='{') {
				state = false; 
                            }
                            break; 
                    }
		}    
            }
        }
        //judge compare state
	if(state == true)
	return true;
	else return false;
    }
}
