import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Read one file and store it one arrayList
 * @author MSI-PC
 */
public class ReadJavaCode {

    /**
     * Read one file and store it one arrayList
     * @return arrayList used to Store one file 
     */
    public static ArrayList<String> read() {
        //built one arraylist 
            ArrayList<String> getFile = new ArrayList<String>();
            System.out.println("Please input the file URL:");
            Scanner sc = new Scanner(System.in);
            String getURL = sc.nextLine();
            //store information from one file by BufferReader
            try {
		int i = 0;
		String str = "";
		BufferedReader buff = new BufferedReader(new FileReader(getURL));
                while((str=buff.readLine())!=null) {
                    getFile.add(str);
                }
                buff.close();
            } catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("File is not exist");
            }
            return getFile;
	}
}
