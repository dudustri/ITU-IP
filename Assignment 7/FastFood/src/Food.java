public class Food {

    protected String name;
    protected int price;

    public Food (String foodName, int foodPrice){

        name = foodName;
        price = foodPrice;

    }    

    public int getPrice(){

        return price;

    }

    public void display(){

        System.out.print(this.price + " kr " + this.name);

    }
}
