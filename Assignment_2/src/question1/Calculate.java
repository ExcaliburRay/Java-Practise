
package question1;

/**
 * class Calculate is used to count on the value of representation too+too+too+too=good
 * @author ray
 */
public class Calculate {

    /**
     * //main function is used to calculate this representation
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                //nested loop
		for(int t=1;t<10;t++) {
			for(int o=0;o<10;o++) {
				for(int g=0;g<10;g++) {
					for(int d=0;d<10;d++) {
                                                //cause too+too+too+too=good is equal to 4*too=good
						if((t*100+o*10+o)*4==g*1000+o*100+o*10+d&&(t!=o)&&(t!=g)&&(t!=d)&&(o!=g)&&(o!=d)&&(g!=d)) {
							System.out.println("t="+t+",o="+o+",g="+g+",d="+d);
						}
					}
				}
			}
		}
	}
}
