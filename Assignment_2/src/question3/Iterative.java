
package question3;

/**
 * class Iterative is used to calculate the real value of different integer by a representation
 * @author ray
 */
public class Iterative {
    //method in calculating
	int thisIsIterative(int n) {
		if(n<0) {
			return -10;
		}else if(n==0){
			return 2;
		}else if(n==1) {
			return 5;
		}else {
                        //represent value when n is equal to 0
			int f0=2;
                        //represent value when n is equal to 1
			int f1=5;
                        //represent current value when n>1
			int currentValue=0;
                        //loop
			for(int i=2;i<=n;i++) {
                            //represent the current value in a specific representaion
				currentValue = f1+3*f0+2*i;
                                //transfer, let f1 represent the value of currentValue in last time
				f0= f1;
				f1 = currentValue;
			}
			return currentValue;
		}			
	}
}