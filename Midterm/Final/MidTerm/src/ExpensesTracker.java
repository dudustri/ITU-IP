import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpensesTracker {

    private int income;
    List<Invoice> yearlyInvoices;

    public ExpensesTracker(int income){

        this.yearlyInvoices = new ArrayList<>();
        this.income = income;

        };


    public void addInvoice(Invoice invoice){

        this.yearlyInvoices.add(invoice);

    }

    public int monthExpenses(int monthNumber){

        Iterator<Invoice> it = this.yearlyInvoices.iterator();
        int sumExpensesMonth = 0;
         Invoice loopIV;
        while(it.hasNext()){
            loopIV = it.next();
            if(loopIV.getMonth() == monthNumber){

                sumExpensesMonth += loopIV.getAmount();

            }
            loopIV = null;
        } 

        //another way to solve it
        /*         if(!yearlyInvoices.isEmpty()){

            for(int i = 0; i < yearlyInvoices.size(); i++){

                if(yearlyInvoices.get(i).getMonth() == monthNumber){

                    sumExpensesMonth += yearlyInvoices.get(i).getAmount();
    
                }

            }

        } */

        return sumExpensesMonth;

    }

    public int monthSaving(int month){

        return (this.income - this.monthExpenses(month));

    }


    public void readInvoice(){

        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> buffer = new ArrayList<>(); 
        ArrayList<Integer> bufferInt = new ArrayList<>();

        for (int i = 0; i<4 ; i++){

            buffer.add(sc.nextLine());

        }

        for(int j = 0; j<buffer.size()-1; j++){

            bufferInt.add(Integer.valueOf(buffer.get(j)));

        }

        yearlyInvoices.add(new Invoice((int)bufferInt.get(0), (int)bufferInt.get(1), (int)bufferInt.get(2), buffer.get(3)));

        sc.close();

    }

    public void clearMonthInvoices(int month){

        Iterator<Invoice> itr = yearlyInvoices.iterator();

        while(itr.hasNext()){

            if(itr.next().getMonth() == month){

                itr.remove();

            }

        }

    }

    public Map<String,Integer> payeeAmount(){

        Map<String , Integer> returnedMap = new HashMap<>();

        for (int i = 0; i<yearlyInvoices.size(); i++){

            returnedMap.put(yearlyInvoices.get(i).getPayee(), yearlyInvoices.get(i).getAmount());

        }

        return returnedMap;

    }

}
    
