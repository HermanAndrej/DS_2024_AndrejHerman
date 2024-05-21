package homework2;

public class Process implements Comparable<Process>{

    private String processName;
    private int priority;
    private int burstTime;
    private int arrivalTime;

    public Process(String processName, int priority, int burstTime, int arrivalTime) {
        this.processName = processName;
        this.priority = priority;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }


    @Override
    public int compareTo(Process o) {
        if(this.priority < o.priority){
            return -1;
        } else if(this.priority > o.priority){
            return 1;
        } else {
            if(this.arrivalTime < o.arrivalTime){
                return -1;
            } else if(this.arrivalTime > o.arrivalTime){
                return 1;
            }
        }
        return -1;
    }
}
