package MidtermPrep;

public class InsertionSortReversed {

    /* Insertion sort algorithm (reverse sorting) */
    public static void sort(int[] elements) {
        for(int i = 0; i < elements.length; i++){
            for(int j = i; j > 0; j--){
                if(less(elements[j-1], elements[j])){
                    swap(elements, j-1, j);
                }else{
                    break;
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