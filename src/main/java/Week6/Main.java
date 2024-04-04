package Week6;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 2, -1, 8, 3, 9, 10, 11 ,7};

        Sort.quickSort(arr);

        for(int i : arr){
            System.out.println(i);
        }
    }
}
