public class GradStudent extends Student{

    private int maxClasses;
    private int currentClasses;

    public GradStudent(String name, int age){

        super(name, age);
        this.maxClasses = 3;
        this.currentClasses = 0;
    }

    public boolean signUp(Lab lab){

        if(this.currentClasses < this.maxClasses){
       
            this.currentClasses++;
            return super.signUp(lab);
        }
        else {
            System.out.println("This student are already registered in 3 classes!");
            return false;

        }
    }

    public boolean signOff(Lab lab){

        if(super.signOff(lab)){
            this.currentClasses--;
            return true;
        }
        else return false;

    }
    

}
