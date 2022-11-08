public class Box {

    private int position;
    private int destination;
    private String label;

    public Box(int boxDestination, String boxLabel){

        this.position = 0;
        this.destination = boxDestination;
        this.label = boxLabel;

    }


    public int getPosition(){
        return this.position;
    }

    public int getDestination(){
        return this.destination;
    }

    public String getLabel(){
        return this.label;
    }

    public void forward(){

        this.position += 1;

    }    

    public String toString(){

        String boxInfo = ("position: " + this.position + ", " + "label: "+ this.label);
        return boxInfo;

    }

    
    
}
