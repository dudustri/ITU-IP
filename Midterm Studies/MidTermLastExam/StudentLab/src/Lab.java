import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Lab {

    private String name;
    private int capacity;
    private List<Student> students;
    private Set<String> availableEquipment;
    private Map<Student, HashSet<String>> studentEquipment;


    public Lab(String name, int capacity){

        this.name = name;
        this.capacity = capacity;
        students = new ArrayList<>();
        availableEquipment = new HashSet<>();
        studentEquipment = new HashMap<>();
    }

    public boolean register(Student student){

        if(students.size() < this.capacity){

            return students.add(student);

        }
        else return false;


    }


    public boolean remove(Student student){

        if(students.contains(student)){
            int studentsSize = students.size();

            Iterator<Student> it = students.iterator();

            while(it.hasNext()){

                if(it.next().equals(student)){

                    it.remove();
                    return true;
                }
                return students.size() < studentsSize ? true : false;
            }
        }
        return false;

    }

    public void addEquipment(){

        Scanner scn = new Scanner(System.in);

        Integer lineNumber;

        List<String> lineList = new ArrayList<>();
        while(scn.hasNextLine()){
        //for(int u = 0; u < 4 ; u++){

         lineList.add(scn.nextLine());  

        }

        lineNumber = Integer.valueOf(lineList.get(0));

        for (int i=0; i<lineNumber; i++){

            availableEquipment.add(lineList.get(i+1));

        }

        scn.close();

    }

    public boolean bookEquipment(Student student, String equipmentName){


        if (studentEquipment.containsKey(student)) {

            if (availableEquipment.contains(equipmentName)) {

                Iterator<String> rmit = availableEquipment.iterator();

                while (rmit.hasNext()) {

                    if (rmit.next().equals(equipmentName)) {

                        rmit.remove();

                    }

                }

                return studentEquipment.get(student).add(equipmentName);

            } else {
                throw new IllegalArgumentException("Equipment not available!");
            }
        }
        else{

            if (availableEquipment.contains(equipmentName)) {

                Iterator<String> rmit = availableEquipment.iterator();

                while (rmit.hasNext()) {

                    if (rmit.next().equals(equipmentName)) {

                        rmit.remove();

                    }

                }

                HashSet<String> eqpBooked = new HashSet<>();
                eqpBooked.add(equipmentName);

                studentEquipment.put(student, eqpBooked);
                return true;


            }
            else{
                throw new IllegalArgumentException("Equipment not available!");
            }
        }

    }

    public void returnEquipment(Student student){


        if(!studentEquipment.get(student).isEmpty()){

        HashSet<String> eqpStudentCopy = studentEquipment.get(student);

        Iterator<String> its = eqpStudentCopy.iterator();

        while(its.hasNext()){

            availableEquipment.add(its.next());

        }

        studentEquipment.get(student).clear();

    }
}

}
