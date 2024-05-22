package homework2;

import java.util.ArrayList;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        ProcessQueue pq = new ProcessQueue();
        int currentTime = 0;
        int processIndex = 0;
        Process currentProcess = null;
        int totalWaitingTime = 0;
        int[] waitingTimes = new int[processes.size()];

        System.out.println("Time | Process");
        System.out.println("---------------");

        while (processIndex < processes.size() || pq.size() > 0 || currentProcess != null) {
            // Add new processes that have arrived at the current time
            while (processIndex < processes.size() && processes.get(processIndex).getArrivalTime() <= currentTime) {
                pq.addProcess(processes.get(processIndex));
                processIndex++;
            }

            // Check if we need to preempt the current process
            if (currentProcess == null || (pq.peekNextProcess() != null && pq.peekNextProcess().compareTo(currentProcess) > 0)) {
                if (currentProcess != null) {
                    pq.addProcess(currentProcess); // Re-add the current process back to the queue
                }
                currentProcess = pq.runNextProcess(); // Get the next highest priority process

                if (currentProcess != null) {
                    // Calculate waiting time for the current process
                    int processId = getProcessIndex(processes, currentProcess);
                    waitingTimes[processId] = currentTime - currentProcess.getArrivalTime() - (currentProcess.getOriginalBurstTime() - currentProcess.getBurstTime());
                }
            }

            // Run the current process
            if (currentProcess != null) {
                System.out.printf("%4d | %s%n", currentTime, currentProcess.getProcessName());
                currentProcess.decrementBurstTime();
                if (currentProcess.getBurstTime() == 0) {
                    currentProcess = null;
                }
            } else {
                System.out.printf("%4d | %s%n", currentTime, "Idle");
            }

            currentTime++;
        }

        System.out.println("---------------");
        System.out.println("Total time: " + currentTime);

        // Calculate and print average waiting time
        for (int waitingTime : waitingTimes) {
            totalWaitingTime += waitingTime;
        }
        double averageWaitingTime = (double) totalWaitingTime / processes.size();
        System.out.printf("Average waiting time: %.2f%n", averageWaitingTime);
    }

    // Helper method to find the index of a process in the original list
    private static int getProcessIndex(ArrayList<Process> processes, Process process) {
        for (int i = 0; i < processes.size(); i++) {
            if (processes.get(i).equals(process)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();

        processes.add(new Process("P1", 1, 4, 0));
        processes.add(new Process("P2", 2, 3, 0));
        processes.add(new Process("P3", 1, 7, 6));
        processes.add(new Process("P4", 3, 4, 11));
        processes.add(new Process("P5", 2, 2, 12));

        scheduleAndRun(processes);
    }
}
