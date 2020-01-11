package ParkingLot;

import java.util.LinkedList;

public class CycleLinkedList {
    LinkedList<Character> cars;
    int size;
    int markings;
    final char v = 'v';
    final char w = 'w';

    CycleLinkedList(int _size, int _markings) {
        cars = new LinkedList<>();
        size = _size;
        markings = _markings;
        if (_markings > size) {
            markings = _markings % size;
        }
        addCars();
    }

    private void addCars() {
        for (int i = 0; i < size; i++) {
            if (Math.random() >= 0.5 && markings != 0) {
                cars.add(v);
                markings--;
            } else if (markings == size - i) {
                cars.add(v);
                markings--;
            } else {
                cars.add('n');// random char other than w or v
            }
        }
    }

    public int carCount() {
        int count = 1;
        int i;
        if (cars.getFirst() != v)
            cars.set(0, v);
        int index = 1;
        boolean flag = true;
        while (flag) {
            if (index==size) {
                index=0;
            }
            if (cars.get(index) == v) {
                cars.set(index, w);
                i = count;
                if(index==0)
                    i=0;
                while (i > 0) {
                    index--;
                    i--;
                }
                if (cars.get(index) == w) {
                    flag = false;
                } else {
                    count = 1;
                    index = 1;
                }
            } else {
                index++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CycleLinkedList cycleLinkedList = new CycleLinkedList(23, 5);
        int carsCount = cycleLinkedList.carCount();
        System.out.println(carsCount);
    }
}
