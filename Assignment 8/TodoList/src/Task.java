import java.util.HashMap;
import java.util.Map;

public class Task {

    
    private static Map<Integer, String> priorityMap;
    private String task;
    private int workload, priority;
    private static int checkMapinit = 0;
    

    public Task(String task, int priority, int workload){

        this.task = task;
        this.priority = priority;
        this.workload = workload;

        if (checkMapinit == 0){
            priorityMap = new HashMap<>();
            initMap();    
            checkMapinit++;

        }

    }


    public String toString(){

        return (this.task + " takes " + this.workload + " minutes and has priority " + priorityMap.get(this.priority));

    }

    public static void initMap(){

        priorityMap.put(1, "very important");
        priorityMap.put(2,"important");
        priorityMap.put(3,"unimportant");
        priorityMap.put(4, "after learn Portuguese");

    }

    public String getTask() {
        return task;
    }

    public int getPriority() {
        return priority;
    }
    
    public int getWorkload() {
        return workload;
    }

}