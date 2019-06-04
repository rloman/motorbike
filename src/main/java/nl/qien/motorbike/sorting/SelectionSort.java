package nl.qien.motorbike.sorting;

public class SelectionSort {

    public static void sort(int[] numbers) {

        for(int i = 0;i<numbers.length;i++){
            for(int j = i+1;j<numbers.length;j++) {
                if(numbers[j] < numbers[i]) {
                    //swap
                    int temp = numbers[i];
                    numbers[i]= numbers[j];
                    numbers[j]=temp;
                }
            }
        }

    }
}
