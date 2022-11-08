import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class findTLD {


    public findTLD(){}


    public void readInInternet(String locationOfInternet) throws FileNotFoundException{

    int counterCom=0, counterOrg=0, counterMs = 0;
    Pattern patternCom = Pattern.compile("\\.com");
    Pattern patternOrg = Pattern.compile("\\.org");
    Pattern patternMs = Pattern.compile("\\.ms");
    Matcher matcher;

    File userFile = new File(locationOfInternet);
    Scanner scn = new Scanner(userFile);

    while(scn.hasNextLine()){

        String line = scn.nextLine();
        matcher = patternCom.matcher(line);
        while(matcher.find()){

            counterCom++;

        }

        matcher = patternOrg.matcher(line);
        while(matcher.find()){

            counterOrg++;

        }

        matcher = patternMs.matcher(line);
        while(matcher.find()){

            counterMs++;

        }

    }

    scn.close();
    String matchResult = ".com: " + counterCom + "\n.ms: " + counterMs + "\n.org: " + counterOrg;
    System.out.println(matchResult);

    }

}

//==============Suggested Solution ==========================

/* import java.util.regex.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class findTLD {
    private int com;
    private int ms;
    private int org;

    private void findAdresses(String s) {
        String pattern = "\\*PAGE:(.*\\.(?:com|ms|org).*)";
        Pattern regex = Pattern.compile(pattern);
        Matcher m = regex.matcher(s);
        String url = "";

        if (m.find()) url = m.group(1);

        if (url.contains(".com")) com++;
        else if (url.contains(".ms")) ms++;
        else if(url.contains(".org")) org++;
    }

    public void readInInternet(String locationOfInternet) {
        try (Scanner input = new Scanner(new File(locationOfInternet))) {
            while (input.hasNext()) {
                String s = input.nextLine();
                findAdresses(s);
            }
            System.out.println(String.format(".com: %d\n.ms: %d\n.org: %d", com, ms, org));
        } catch (IOException e) {
            System.out.println("File not written in correctly");
        }
    }
} */