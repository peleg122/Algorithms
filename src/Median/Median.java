package Median;

public class Median {
    public int upperMeidan(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length-1 && i < 63; i = i + 2) {
            if (array[i] > array[i + 1]) {
                if (max < array[i]) max = array[i];
            } else {
                if (max < array[i + 1]) max = array[i + 1];
            }
        }
        return max;
    }
}
