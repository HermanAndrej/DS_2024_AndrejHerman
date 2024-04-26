package MidtermPrep;

public class SelectionSort {

    /* Selection sort algorithm */
    public static void sort(int[] elements) {
        for(int i = 0; i < elements.length; i++){
            for(int j = i + 1; j < elements.length; j++){
                if(less(elements[j], elements[i])){
                    swap(elements, j, i);
                }
            }
        }
    }

    /**
     * Helper methods.
     * No need to modify these two methods.
     */

    /* Returns whether the first element is less than the second one */
    public static boolean less(int v, int w) {
        return v < w;
    }

    /* Swaps the two elements in an array */
    public static void swap (int[] elements, int a, int b) {
        int tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }
}
