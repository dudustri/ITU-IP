import java.util.ArrayList;
import java.util.List;

public class Pizza extends Food{

    protected List<String> toppings;

    public Pizza(){

        super("Pizza", 45);
        toppings = new ArrayList<>();

    }

    public void addTopping(String topping){

        toppings.add(topping);
        super.price += 10;

    }

    public void display(){
        String Wonderfulextras = "{ ";
    
            for (String extracheese : toppings){

                if(!toppings.get(toppings.size()-1).equals(extracheese)){
                    Wonderfulextras += extracheese + ", ";
                }
                else{
                 Wonderfulextras += extracheese +  " ";
                }
            }

            Wonderfulextras += "}";

        super.display();
        System.out.println(" " + Wonderfulextras);

    }

    public void setName(String name){

        this.name = name;

    }

    
}
