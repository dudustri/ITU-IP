import java.util.List;
import java.util.ArrayList;

public class Forest {

    private List<Tree> avocado;

    public Forest(){

        avocado = new ArrayList<>();

    }

    public void addTree(int growthPct){

        Tree smallPlant = new Tree(growthPct);

        avocado.add(smallPlant);

        //delete smallPlant;

    }

    public String toString(){

        String Bamboo = "Forest(";

        for (int i = 0; i < this.avocado.size(); i++){
            
            Bamboo = Bamboo + this.avocado.get(i).toString();

        }
        Bamboo = Bamboo + ")";

        return Bamboo;

    }

    public void growOneYear(){

        for (int i = 0; i < this.avocado.size(); i++){
            
            this.avocado.get(i).growOneYear();

        }

    }
    
}
