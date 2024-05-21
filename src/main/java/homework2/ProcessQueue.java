package homework2;

public class ProcessQueue {
    public Process[] pq = new Process[2];
    public int length = 0;

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
        Process max = pq[1];                               // 1
        swap(1, length--);                              // 2
        pq[length + 1] = null;                          // 3

        if (length > 0 && length == pq.length / 4) {    // 4
            resize(pq.length / 2);                      // 4
        }

        sink(1);                                        // 5
        return max;
    }

    /* Return the next Process that should be run (but do not delete it) */
    public Process peekNextProcess() {
        if(pq.length == 0){
            return null;
        }
        return pq[1];
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            swap(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= length) {                     // 1
            int j = 2 * k;                          // 2
            if (j < length && less(j, j + 1)) {     // 2
                j++;                                // 2
            }

            if (!less(k, j)) {                      // 3
                break;                              // 3
            }

            swap(k, j);                             // 4
            k = j;                                  // 5
        }
    }

    public int size() {
        return length;
    }

    /* Create a new internal array with a given capacity */
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Process[] copy = (Process[]) new Comparable[capacity];        // 1
        for (int i = 1; i <= length; i++) {                     // 2
            copy[i] = pq[i];                                    // 2
        }
        pq = copy;                                              // 3
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