package MidtermPrep;

public class BubbleSortReversed {

    /* Bubble sort algorithm (reverse sorting) */
    public static void sort(int[] elements) {
        for(int i = 0; i < elements.length - 1; i++){
            for(int j = 0; j < elements.length - i - 1; j++ ){
                if(less(elements[j], elements[j + 1])){
                    swap(elements, j, j+1);
                }
            }
        }
    }

    /**
     * Helper methods.
     * You may modify them if necessary, or implement your own alternatives.
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
