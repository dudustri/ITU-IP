public class App {
    public static void main(String[] args) throws Exception {
        
        Todo test1 = new Todo();
        test1.addTask("Midterm studies", 1, 200);
        test1.addTask("listen music", 4, 30);
        test1.addTask("tometome", 2, 50);
        test1.addTask("vapovapo", 3, 16);
        test1.addTask("daleGremioo", 1, 8000);
        test1.print();
        test1.printPriority(2);
        //test1.completeTask(1);
        //test1.print();
        test1.printPrioritized();
        test1.completeTask(-1);
        test1.completeTask(0);
        test1.completeTask(0);
        test1.print();

    }


}
