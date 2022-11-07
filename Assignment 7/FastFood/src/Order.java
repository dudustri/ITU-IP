import java.util.ArrayList;
import java.util.List;

public class Order {
    
    protected List<Food> ordered;

    public Order(){

        ordered = new ArrayList<>();
        ordered.clear();

    }

    public void addFood(Food food){

        ordered.add(food);

    }

    public int total(){
        int totalprice = 0;
        for (Food nham : ordered){

            totalprice += nham.getPrice();

        }

        return totalprice;
    }

    public void display(){

        for (Food Nhami : ordered){

            Nhami.display();
            System.out.println("\n");

        }
        
    System.out.println(total() + " kr TOTAL\n");

    }

    public boolean payWith(CreditCard card){

        if(!card.withdraw(total())){
            System.out.println("ERROR: Payment failed\n");
        }

        return card.withdraw(total());

    }

}
