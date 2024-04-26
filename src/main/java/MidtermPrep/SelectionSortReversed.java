package MidtermPrep;

import java.util.Arrays;

public class SelectionSortReversed {

    public static void main(String[] args) {
        testSort();
    }

    public static void testSort() {
        int[] array = {5, 2, 9, 1, 5, 6};
        int[] expected = {9, 6, 5, 5, 2, 1}; // Expected result after sorting in descending order

        SelectionSortReversed.sort(array);

        // Check if the array is sorted correctly
        if (Arrays.equals(array, expected)) {
            System.out.println("Test Passed: Array sorted correctly.");
        } else {
            System.out.println("Test Failed: Array not sorted correctly.");
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual: " + Arrays.toString(array));
        }
    }

    /* Selection sort algorithm (reverse sorting) */
    public static void sort(int[] elements) {
        for(int i = elements.length - 1; i > 0; i--){
            int min = i;
            for(int j = i - 1;  j >= 0; j--){
                if(less(elements[j], elements[min])){
                    min = j;
                }
            }
            swap(elements, i, min);
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