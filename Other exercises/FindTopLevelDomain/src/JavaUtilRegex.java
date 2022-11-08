import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaUtilRegex {

    public JavaUtilRegex(){}


    public static void matchJavaUtil(){

        Scanner scn = new Scanner(System.in);

        Pattern pattern = Pattern.compile(".*\\s*java\\.util\\.regex\\.*.*");
        Matcher matcher;
        
        
        while(scn.hasNextLine()){

        matcher = pattern.matcher(scn.nextLine());
        if(matcher.matches()){
            System.out.println("yes");
        }
        else System.out.println("no");

        }
        
        scn.close();

    }

    public static void main(String[] args) throws Exception {
        matchJavaUtil();
    }

}
