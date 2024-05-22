package homework2;

public class ProcessQueue {
    private Process[] pq;
    private int length;

    public ProcessQueue() {
        pq = new Process[2];
        length = 0;
    }

    /* Add a new process into the priority queue */
    public void addProcess(Process process) {
        if (length + 1 == pq.length) {
            resize(2 * pq.length);
        }
        pq[++length] = process;
        swim(length);
    }

    /* Return and remove the next Process that should be run */
    public Process runNextProcess() {
        if (length == 0) {
            return null;
        }
        Process max = pq[1];
        swap(1, length--);
        pq[length + 1] = null;
        if (length > 0 && length == pq.length / 4) {
            resize(pq.length / 2);
        }
        sink(1);
        return max;
    }

    /* Return the next Process that should be run (but do not delete it) */
    public Process peekNextProcess() {
        if (length == 0) {
            return null;
        }
        return pq[1];
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= length) {
            int j = 2 * k;
            if (j < length && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    public int size() {
        return length;
    }

    /* Create a new internal array with a given capacity */
    private void resize(int capacity) {
        Process[] copy = new Process[capacity];
        for (int i = 1; i <= length; i++) {
            copy[i] = pq[i];
        }
        pq = copy;
    }

    private boolean less(int a, int b) {
        return pq[a].compareTo(pq[b]) < 0;
    }

    /* Swap the array elements at provided indexes */
    private void swap(int a, int b) {
        Process temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }
}