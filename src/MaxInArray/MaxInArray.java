package MaxInArray;

import java.util.ArrayList;

/**
 * Induction proof:
 * Base: let temp = a[0] - temporary max
 * assume: temp[n] to be the max of all a[0,...,n] (n numbers)
 * need to proof for : a[n+1]
 * by the assumption there are two cases:
 * 1) temp[n] >= a[n+1], so temp[n+1] is still the max value (n = n+1)
 * 2) temp[n] < a[n+1] , the new max will be temp = a[n+1]
 * by the transitive nature of numbers a[n+1] is bigger than all the predecessors of n.
 * running time = O(n)
 */
public class MaxInArray {
    public static int Max(ArrayList<Integer> array) {//O(n)
        int temp = array.get(0);
        for (Integer i : array) {// n loop
            if (temp < i)
                temp = i;
        }
        return temp;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(20);
        arrayList.add(70);
        arrayList.add(0);
        arrayList.add(6);
        arrayList.add(20);
        arrayList.add(60);
        System.out.println("Max in Array: " + Max(arrayList));
    }
}
