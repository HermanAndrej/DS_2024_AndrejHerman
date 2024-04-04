package Week6;

import java.util.Random;

public class Sort {

    public static void quickSort(int[] arr){
        shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private static void shuffle(int[] arr){
        Random random = new Random();
        for (int i = 0; i < arr.length; i++){
            int r = i + random.nextInt(arr.length - 1);
        }
    }

    private static void sort(int[] arr, int low, int high){
        if(high <= low){
            return;
        }
        int p = partition(arr, low, high);
        sort(arr, low, p-1);
        sort(arr, p+1, high);
    }

    private static int partition(int[] arr, int low, int high){
        int i = low;
        int j = high + 1;

        while (true){
            while (arr[++i] < arr[low]){
                if (i == high){
                    break;
                }
            }

            while (arr[--j] >= arr[low]){
                if (j == low){
                    break;
                }
            }

            if (j <= i){
                break;
            }

            swap(arr, i, j);
        }
        swap(arr, j, low);
        return j;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;

    }
}
