import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Robot {
    
private String name;
List<Box> transferList;
Map<String,Integer> labelPriorities;
    
    public Robot(String robotName){

        this.name = robotName;
        this.labelPriorities = new TreeMap<>();  
        this.transferList = new ArrayList<>();

    }

    public static void main(String[] args) {
     
        Robot wally = new Robot("wally");
        Box box1 = new Box(8, "blueBox");
        Box box2 = new Box(5,"redBox");
        Box box3 = new Box(2,"greenBox");
        Box box4 = new Box(5,"yellowBox");
        Box box5 = new Box(5,"blackBox");

        wally.addToTransferList(box1);
        wally.addToTransferList(box2);
        wally.addToTransferList(box3);
        wally.addToTransferList(box4);
        wally.addToTransferList(box5);

        wally.printTransferList();
        System.out.println("\n");
        wally.removeFromTransferList2("yellowBox");
        wally.printTransferList();
        wally.getBoxPriority("purpleBox");

    }


    public boolean addToTransferList (Box reveivedBox){

        int prevSize = this.transferList.size();
        this.transferList.add(reveivedBox);
        if(this.transferList.size() > prevSize){
            return true;
        }
        else{
            return false;
        }
    }

    public void printTransferList(){

        for(int i=0; i<this.transferList.size(); i++){

            System.out.println(this.transferList.get(i).toString());

        }

    }

    public void moveForward(Box box, int steps){

        int currentSteps = steps;
        while(!(box.getPosition()<box.getDestination() && currentSteps !=0)){
        
            box.forward();
            currentSteps--;

        }

    }

    public void setLabelPriority(String label, int priority){

        if(label != null){

            this.labelPriorities.put(label,priority);

        }
    }

    public int getBoxPriority(String boxLabel) {//throws IllegalArgumentException{

        if(labelPriorities.containsKey(boxLabel)){
            return this.labelPriorities.get(boxLabel);
        }
        else {
            throw new IllegalArgumentException("Invalid label");            
        }
    }


    public Box selectNextBox(){

        if(this.labelPriorities.isEmpty()){
            return null;
        }
        
        Set<String> keyList = new TreeSet<>();  
        keyList = this.labelPriorities.keySet();
        int priorityBoxWeight = -50000;
        int priorityCurrentPosition;
        String selectedBoxLabel = null;
        int selectedIndex = -1;

        for (String labelBoxeSet : keyList){

            priorityCurrentPosition = getBoxPriority(labelBoxeSet);
            if(priorityCurrentPosition > priorityBoxWeight){
                selectedBoxLabel = labelBoxeSet;
            }
        }

        for(int k=0; k<transferList.size(); k++) {

            if(this.transferList.get(k).getLabel().equals(selectedBoxLabel)){    

                selectedIndex = k;

                break;
            }

        }   

        if(selectedIndex == -1){
            return null;
        }
        Box selectedBox = transferList.get(selectedIndex);
        transferList.remove(selectedIndex);
        return selectedBox;
    }


    public Box selectNextBox2(){





    }



    public void removeFromTransferList(String labelRem){

        int currentIndex = 0;
        int initialSizeList = transferList.size();


        for(int i = 0; i<transferList.size(); i++){
            currentIndex = i;

            if(transferList.get(i).getLabel().equals(labelRem)){

                transferList.remove(i);
                break;

            }

        }
        if(currentIndex != (initialSizeList-1)){
        removeFromTransferList(labelRem);
            }
    }


    public void removeFromTransferList2(String labelRem){

        Iterator<Box> it = transferList.iterator();

        while(it.hasNext()){

            if(it.next().getLabel().equals(labelRem)){
                it.remove();
            }

        }



    }

}
