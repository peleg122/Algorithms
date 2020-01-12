package Median;

public class MedianMerge {
    public int[] mergeMedian(int[] arrayA, int[] arrayB) {
        int i = arrayA.length - 1;
        int j = arrayB.length - 1;
        int k = i;
        int[] arrayC = new int[arrayA.length];
        if (arrayA.length != arrayB.length) {
            return null;
        } else {
            arrayC[i] = Math.max(arrayB[j - i + 1], arrayA[i]);
            while (k >= 0) {
                if (arrayA[i] >= arrayB[j]) {
                    arrayC[k--] = arrayA[i--];
                } else {
                    arrayC[k--] = arrayB[j--];
                }
            }
        }
        return arrayC;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14, 16};
        int[] B = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 30};
        MedianMerge m = new MedianMerge();
        System.out.println(A.length + " " + B.length);
        int[] C = m.mergeMedian(A, B);
        for (Integer i : C) {
            System.out.print(i + ",");
        }
        System.out.println();
        Median median = new Median();
        System.out.println(median.upperMeidan(C));
    }
}
