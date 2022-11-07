import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Peptalk {


private static List<Character> checkVowels;

public Peptalk(){

}

public static void readWords(){

Scanner scn = new Scanner(System.in);
String[] bufferString;
String output = "";

checkVowels = new ArrayList<>();
char[] chList = ("AEIOUaeiou").toCharArray();
Character buff;
for(char ch : chList){
    buff = ch;
    checkVowels.add(buff);
} 

while(scn.hasNext()){

    bufferString = scn.nextLine().split(" ");
    for (int i = 0; i < bufferString.length; i++){
    
    if(!(i == (bufferString.length - 1))){

        output += encodeToPep(bufferString[i] , vowelSize(bufferString[i]), returnInitString(bufferString[i])) + " ";

    }
    else  output += encodeToPep(bufferString[i] , vowelSize(bufferString[i]), returnInitString(bufferString[i]));
        
    }
    System.out.println(output);
    output = "";

}

scn.close();

}

public static String encodeToPep(String ls, int vowelsNumber, String initString){

    String patternString = "[AEIOUaeiou][^AEIOUaeiou\\s]*";  //"/[^aeiouAEIOU]*[aeiouAEIOU]+[^aeiouAEIOU]/gm"; //[bcdfghjklmnpqrstvxzBCDFGHJKLMNPQRSTVXZ]*[aeiouAEIOU]+[bcdfghjklmnpqrstvxzBCDFGHJKLMNPQRSTVXZ]
    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher;
    String strMatched = "", finalString = "", printString = initString;
    int strMatchLenght=0;
    int lenghtSubstring = 0;
    float roundN = 0;
    int count = 0;


    matcher = pattern.matcher(ls);

    while (matcher.find()) {
        count++;
        
        strMatched = matcher.group();
        strMatchLenght = strMatched.length();
        roundN = (float) strMatchLenght/2;
        lenghtSubstring = Math.round(roundN);

        if(!(vowelsNumber == count)){
        finalString = strMatched.substring(0, ((lenghtSubstring))) + "p"
                    + (strMatched.substring(0, ((lenghtSubstring)))).toLowerCase() + strMatched.substring(((lenghtSubstring)));
        }
        else{
            finalString = strMatched.substring(0, ((strMatchLenght))) + "p"
            + (strMatched.substring(0, ((strMatchLenght)))).toLowerCase();
        }
                 
        printString += finalString;

    }

    return printString;
     
}

public static int vowelSize(String ls){
    
    char[] ch = ls.toCharArray(); 
    int counter = 0;
    Character temp;
    for(char letter : ch){

        temp = letter;
        if(checkVowels.contains(temp)){

            counter ++;

        }

    }

    return counter;
}

public static String returnInitString(String ls){
    
    char[] ch = ls.toCharArray(); 
    String output = "";
    Character temp;
    for(char letter : ch){

        temp = letter;
        if(!(checkVowels.contains(temp))){

            output += temp;

        }
        else break;

    }

    return output;
}



    public static void main(String[] args) throws Exception {
        
       readWords(); 
        
    }


}