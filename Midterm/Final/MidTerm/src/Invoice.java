public class Invoice {

    private int amount;
    private int month;
    private int day;
    private String payee;
 
    public Invoice(int amount, int month, int day, String payee){

        this.amount = amount;
        this.month = month;
        this.day = day;
        this.payee = payee;

    }

    public void printInvoice(){

        System.out.println("amount:" + this.amount + ", month:" + this.month + ", day:" + this.day + ", payee:" + this.payee);

    }

    public int getAmount() {
        return amount;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public String getPayee() {
        return payee;
    }
}
