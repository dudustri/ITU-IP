import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProfanityFilter {

    private static Map <String, String> badMapWords = new HashMap<String, String>();
    private static ArrayList<String> finalPonctuation = new ArrayList<>();
    private static ArrayList<String> userInputedLines = new ArrayList<>();
 
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String userOutput;

        String badWords = input.nextLine();
        String badArray [] = badWords.split(" ");
        String wordUserProtection;


        for (String badBad : badArray){
           
           int j = 0;
           wordUserProtection = "";

           for(int i = 0; i < badBad.length(); i++){

            switch(j){

                case 0:
                wordUserProtection += "*";
                break;

                case 1:
                wordUserProtection += "&";
                break;

                case 2:
                wordUserProtection += "#";
                break;

                case 3:
                wordUserProtection += "$";
                break;

                case 4:
                wordUserProtection += "%";
                j = -1;
                break;

            }

            j++;

           } 

           badMapWords.put(badBad.toLowerCase(), wordUserProtection);

        }

        while(input.hasNextLine())
        {
        userInputedLines.add(input.nextLine());
        }
       
        for (String line : userInputedLines){
        finalPonctuation.clear();
        String [] checkarray = line.split(" ");
        userOutput = "";
    
        int k = 0;
        for (String word : checkarray){

            word = checkWordPonctuation(word);

            if (badMapWords.containsKey(word.toLowerCase()))
            {
                checkarray[k] = badMapWords.get(word.toLowerCase());
            }
            else{
                checkarray[k] = word;
            }

            k++;
        }

        for (int h = 0; h < checkarray.length; h++){

            if(userOutput == ""){
                userOutput = checkarray[h] + finalPonctuation.get(h);
            }
            else{
            userOutput += " " + checkarray[h] + finalPonctuation.get(h);
            }
        }

        System.out.println(userOutput);
        }

        input.close();
    }

    public static String checkWordPonctuation(String word){

        String newCleanWord = "";

        if(word.contains(".")){
            newCleanWord = word.replace(".", "");
            finalPonctuation.add(".");
        }
        else if(word.contains("!")){
            newCleanWord = word.replace("!", "");
            finalPonctuation.add("!");
        }
        else if(word.contains("?")){
            newCleanWord = word.replace("?", "");
            finalPonctuation.add("?");
        }
        else if(word.contains(":")){
            newCleanWord = word.replace(":", "");
            finalPonctuation.add(":");
        }
        else if(word.contains(";")){
            newCleanWord = word.replace(";", "");
            finalPonctuation.add(";");
        }
        else {
            finalPonctuation.add("");
            newCleanWord = word;
        }

        return newCleanWord;

    }
}
