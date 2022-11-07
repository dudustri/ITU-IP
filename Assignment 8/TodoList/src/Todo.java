import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Todo {

    private ArrayList<Task> taskList;
    private int totalWorkHoursDone;

    public Todo(){

        this.taskList = new ArrayList<>();
        this.totalWorkHoursDone = 0;

    }
    
    public void addTask(String description, int priority, int minutes){
        int checkvalid = 0;
        if(priority<1 || priority > 4){

            System.out.println(description + " has invalid priority");
            checkvalid++;
        }
        if(minutes < 0){

            System.out.println(description + " has invalid workload");  
            checkvalid++;
        }
        if (checkvalid == 0){

            Task newtask = new Task(description, priority, minutes);
            this.taskList.add(newtask);

        }
    }

    public void print(){

        System.out.println("Todo:\n"+"-----");
        if(!this.taskList.isEmpty()){
            for (int i = 0; i < this.taskList.size(); i++) {

                System.out.println(this.taskList.get(i).toString());
                // System.out.println(taskList.get(i).getTask());

            }
        }
        else{
            System.out.println("You're all done for today! #TodoZero");
        }
        if(totalWorkHoursDone > 0){
            System.out.println(totalWorkHoursDone + " minutes of work done!");
        }
    
    
    
    }

    public void completeTask(int index){
    
        if(index >= 0 && index < (taskList.size())){
        totalWorkHoursDone += taskList.get(index).getWorkload();
        taskList.remove(index);
        }
        else System.out.println("Invalid index");

    }

    public void printPriority(int limit){

        int localCheck = 0;

        System.out.println("Filtered todo:\n"+"--------------");
        
        if(!this.taskList.isEmpty()){

            for (int i = 0; i < this.taskList.size(); i++) {

                if(this.taskList.get(i).getPriority()<=limit){

                    System.out.println(this.taskList.get(i).toString());
                    // System.out.println(taskList.get(i).getTask());

                    localCheck++;

                }
            }
        }

        if(localCheck == 0){
            System.out.println("No tasks with given priority");
        }

    }

    public void printPrioritized() {

        if(!taskList.isEmpty()){
        ArrayList<Task> orderedTaskList = taskList;

        //orderedTaskList.sort(Comparator.comparing(Task::getPriority).thenComparing(Task::getWorkload));

        Collections.sort(orderedTaskList, new Comparator<Task>(){

            @Override
            public int compare(Task o1, Task o2) {
                if(o1.getPriority() == o2.getPriority()){
                return (o1.getWorkload() - o2.getWorkload());
                }
                return (o1.getPriority() - o2.getPriority());
            }

        });
        

        System.out.println("Prioritized todo:\n" + "-----------------");


            for (int i = 0; i < orderedTaskList .size(); i++) {

                System.out.println(orderedTaskList.get(i).toString());
                // System.out.println(taskList.get(i).getTask());

            }
        }


    }


}




/* class taskComparator implements Comparable<Task>{

    public int compare(Task a, Task b){

        if(a.getPriority() == b.getPriority()){

            return a.getWorkload().compareTo(b.getWorkload());

        }
        return b.getWorkload() - a.getWorkload();

    }
 



}
*/
