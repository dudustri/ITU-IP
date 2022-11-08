import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        
     f(true);

        
    }

    public static void f(boolean b) {
        try { System.out.print("A");
                 if(b) { throw new IllegalArgumentException(); }
                 System.out.print("B");
         }
        catch (IllegalArgumentException e) { System.out.print("C"); }
   
        catch (RuntimeException e) { System.out.print("D"); }
   
        finally { System.out.print("E"); }
   
        System.out.print("F");
    }
}
