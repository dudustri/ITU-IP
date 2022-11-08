import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LazyMatch {

    public LazyMatch(){}



    public static void readInFile(String fileName){

        Pattern pattern = Pattern.compile("if\\s*\\(.*\\(*\\)*)+");

        Scanner scn = new Scanner(new File(fileName));

        while(scn.hasNextLine()){

            Matcher matcher = pattern.matcher(scn.nextLine());
            
        }
    
    }
    
    
}

