package MaxMaxInArray;

import java.util.Stack;

public class MaxMaxArray {//O(n+log(n)-1)
    // building Nodes for every element is O(n) + running log(n) times to find the max numbers

    public class Node {
        private int data;
        private Stack<Integer> stack;

        public Node(int _data) {
            this.data = _data;
            stack = new Stack<>();
        }

        public Stack<Integer> getStack() {
            return stack;
        }

        public int getData() {
            return data;
        }
    }

    public int MaxMax(Node[] array, int low, int high) {
        if (low < high) {
            int index = 0;
            int middle = (low + high) / 2;
            int i = MaxMax(array, low, middle);
            int j = MaxMax(array, middle + 1, high);
            if (array[i].getData() > array[j].getData()) {
                array[i].getStack().add(array[j].getData());
                index = i;
            } else {
                array[j].getStack().add(array[i].getData());
                index = j;
            }
            return index;
        } else {
            return low;
        }
    }

    public void MaxMax(int[] array) {
        Node[] nodes = new Node[array.length];
        for (int i = 0; i < array.length; i++) {
            nodes[i] = new Node(array[i]);
        }
        int index = MaxMax(nodes, 0, nodes.length - 1);
        int Max1 = nodes[index].getData();
        int Max2 = nodes[index].getStack().pop();
        int temp;
        while (!nodes[index].getStack().empty()) {
            temp = nodes[index].getStack().pop();
            if (temp > Max2) {
                Max2 = temp;
            }
        }
        System.out.println("Max1: " + Max1 + ", Max2: " + Max2);
    }

    public static void main(String[] args) {
        MaxMaxArray maxMaxArray = new MaxMaxArray();
        int[] array2 = {456, 231846, 5, 15, 564, 846, 15, 15846, 315, 15, 6456, 4684, 156315, 684684, 1515, 51};
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        maxMaxArray.MaxMax(array2);
        maxMaxArray.MaxMax(array);
    }
}
