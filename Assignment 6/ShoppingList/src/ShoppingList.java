import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ShoppingList {
    
    static private ArrayList<String> linesList = new ArrayList<>();
    static private Queue<String> itemsReceiptQueue = new LinkedList<>();
    static private Queue<String> itemsShoppingQueue = new LinkedList<String>();
    static private Map<String, Integer> availableMap = new HashMap<>();
    static private Map<String, Integer> receiptMap = new HashMap<>();
    static private Map<String, Integer> shoppingMap = new TreeMap<>();
    static private boolean isReceipt;
    static private boolean isAvailable;
    //static private int receiptsNumber = 0;

    public static void main(String[] args) {
        
        Scanner userinput = new Scanner(System.in);
        //String checkInputEnd = "";
       while(userinput.hasNextLine()){
//        for(int i = 0; i < 10; i++){
            String lineProcess = userinput.nextLine();

            if(lineProcess != ""){

            linesList.add(lineProcess);
            
            }
        
        }

        userinput.close();

        for(int i = 0; i<linesList.size(); i++)

        if(linesList.get(i).contains("AVAILABLE")){
            isAvailable = true;
            isReceipt = false;
        }

        else if(linesList.get(i).contains("RECIPE")){
            isAvailable = false;
            isReceipt = true;
            //receiptsNumber++;
        }
        else{

            processItem(linesList.get(i));

        }

        doCalculationToFinalList();

        orderingStackbyName();

        String finalList = stringAssembler();
        
        System.out.println(finalList);

    }

    static public void processItem(String line){

        String[]  lineSplited = line.split(" ");
        String itemName = lineSplited[2];
        int itemQtd = Integer.parseInt(lineSplited[0]);
        if(lineSplited[1].contains("k")){
            itemQtd *= 1000;
        }

        if(isAvailable){
            if(availableMap.containsKey(itemName)){

                itemQtd += availableMap.get(itemName);
                availableMap.replace(itemName, itemQtd);

            }
            
            else availableMap.put(itemName, itemQtd);
            
        }

        if(isReceipt){
        
            if(receiptMap.containsKey(itemName)){

                itemQtd += receiptMap.get(itemName);
                receiptMap.replace(itemName, itemQtd);

            }

            else {
                receiptMap.put(itemName, itemQtd);
                itemsReceiptQueue.add(itemName);
            }            
        
        }

    }
    
    static public void doCalculationToFinalList(){
        
        int itemNeeded = 0;

        for(int v = 0; v<receiptMap.keySet().size(); v++){
            String mapReceiptItem = itemsReceiptQueue.remove();
            if(availableMap.containsKey(mapReceiptItem)){

                itemNeeded = receiptMap.get(mapReceiptItem) - availableMap.get(mapReceiptItem);
                if (itemNeeded>0){
                    shoppingMap.put(mapReceiptItem, itemNeeded);
                }
            }
            else {
                shoppingMap.put(mapReceiptItem,receiptMap.get(mapReceiptItem));
            }
        }


    }

    static public String stringAssembler(){

        String composedString = "Shopping List:\n";
        String stackItem;
        
        for(int h = 0; h<shoppingMap.keySet().size(); h++){
            
            String finalUnit;
            int finalValue;
            stackItem = itemsShoppingQueue.remove();

           /*  if(shoppingMap.get(stackItem) > 1000){

                finalUnit = "kg";
                finalValue = (shoppingMap.get(stackItem)/1000);
            }
            else {*/
                finalUnit = "g";
                finalValue = (shoppingMap.get(stackItem));
            //}
            composedString += finalValue + " " + finalUnit + " " + stackItem + "\n"; 

        }

        return composedString;

    }

    static public void orderingStackbyName(){

        Set<String> orderingStr = shoppingMap.keySet();

        for(String key : orderingStr){

            itemsShoppingQueue.add(key);

        }

    }

}
