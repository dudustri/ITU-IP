public class Student {

    private String name;
    private int age;

    public Student(String name, int age){

        this.name = name;
        this.age = age;

    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }

    public boolean signUp(Lab lab){

        return lab.register(this);

    }


    public boolean signOff(Lab lab){

        return lab.remove(this);

    }


}

