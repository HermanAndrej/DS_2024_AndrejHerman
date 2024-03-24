package Week4;

public class InsertionSort extends AbstractSort{

    public static void sort(int arr[]){
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(less(arr[j], arr[j-1])){
                    swap(arr, j, j-1);
                } else{
                    break;
                }
            }
        }
    }
}
