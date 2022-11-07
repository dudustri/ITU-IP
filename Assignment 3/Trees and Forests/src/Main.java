public class Main {
    public static void main(String[] args) throws Exception {
        
        
        Forest Amazonia = new Forest();

        Amazonia.addTree(3);

        Amazonia.growOneYear();

        Amazonia.addTree(1);
        Amazonia.addTree(11);

        Amazonia.growOneYear();

        System.out.println(Amazonia.toString());


    }
}
