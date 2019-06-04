package nl.qien.motorbike.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class SelectionSortTest {


    @Test
    public void testSelectionSort() {
        int[] numbers = {3,1,2};
        SelectionSort.sort(numbers);

        Assert.assertEquals(1, numbers[0]);
        Assert.assertEquals(2, numbers[1]);
        Assert.assertEquals(3, numbers[2]);

    }

    @Test
    public void longTestSelectionSort() {

        int[] randoms = randomFill(100, 200);


        SelectionSort.sort(randoms);
        int selected = randoms[0];

        for(int i = 1;i<randoms.length;i++) {
            Assert.assertFalse(selected > randoms[i]);
            selected = randoms[i];
        }

    }

    private int[] randomFill(int length, int bound ) {
        Random random = new Random();
        int[] numbers = new int[length];
        for(int i = 0;i<numbers.length;i++) {
            numbers[i]= random.nextInt(bound);
        }

        return numbers;
    }
}
