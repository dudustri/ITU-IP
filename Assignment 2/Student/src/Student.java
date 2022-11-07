public class Student{

private String name;
private int age;

public Student(String name, int age){
this.name = name;
this.age = age;
}

public String getName(){

return this.name;

}

public int getAge(){

return this.age;

}

public void setName(String name){

this.name = name;

}

public void setAge(int age){

if(age>=16 && age<=99){
this.age = age;
}
else if(age<16){
System.out.println("The university does not accept students below 16");
}
else if(age>99){
System.out.println("The university does not accept students that are older than 99");
}
}

public String toString(){

String studentinfo = "The name of the student is " + this.name + ". The student is "+ this.age + " years old.";
return studentinfo;

}

}