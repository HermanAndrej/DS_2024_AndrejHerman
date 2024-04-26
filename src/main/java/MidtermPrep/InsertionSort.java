package MidtermPrep;

public class InsertionSort {

    /* Insertion sort algorithm */
    public static void sort(int[] elements) {
        for(int i = 0; i < elements.length; i++){
            for(int j = i; j > 0; j--){
                if(less(elements[j], elements[j-1])){
                    swap(elements, j, j-1);
                }else{
                    break;
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
