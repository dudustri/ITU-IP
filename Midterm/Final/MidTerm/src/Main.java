public class Main {
    public static void main(String[] args) throws Exception {


        Invoice inv1 = new Invoice(100, 5, 10, "ABC");
        Invoice inv2 = new Invoice(102, 5, 12, "ABCD");
        Invoice inv3 = new Invoice(102, 6, 12, "ABCD");
        Invoice inv4 = new Invoice(102, 4, 12, "ABCD");
        inv1.printInvoice();
        inv2.printInvoice();

        ExpensesTracker eT = new ExpensesTracker(200);

        eT.addInvoice(inv2);
        eT.addInvoice(inv1);
        eT.addInvoice(inv3);
        eT.addInvoice(inv4);

        System.out.println(eT.monthExpenses(5));
        System.out.println(eT.monthSaving(5));



        System.out.println(eT.yearlyInvoices);

        eT.clearMonthInvoices(5);

        System.out.println(eT.yearlyInvoices);

        eT.readInvoice();

        System.out.println(eT.yearlyInvoices.toString());
        
    }
}
