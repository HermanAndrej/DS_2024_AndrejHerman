package homework2;

public class Process implements Comparable<Process> {

    private String processName;
    private int priority;
    private int burstTime;
    private int originalBurstTime; // Added field to store the original burst time
    private int arrivalTime;

    public String getProcessName() {
        return this.processName;
    }

    public int getBurstTime() {
        return this.burstTime;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getOriginalBurstTime() {
        return this.originalBurstTime; // Getter for the original burst time
    }

    public void decrementBurstTime() {
        if (this.burstTime > 0) {
            this.burstTime--;
        }
    }

    public Process(String processName, int priority, int burstTime, int arrivalTime) {
        this.processName = processName;
        this.priority = priority;
        this.burstTime = burstTime;
        this.originalBurstTime = burstTime; // Initialize the original burst time
        this.arrivalTime = arrivalTime;
    }

    @Override
    public int compareTo(Process o) {
        if (this.priority > o.priority) {
            return -1;
        } else if (this.priority < o.priority) {
            return 1;
        } else {
            return Integer.compare(this.arrivalTime, o.arrivalTime);
        }
    }
}
