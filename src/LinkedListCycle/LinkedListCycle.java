package LinkedListCycle;

import java.util.LinkedList;

public class LinkedListCycle<T> {
    private LinkedList<Node<T>> List;

    public boolean isEmpty() {
        return List.isEmpty();
    }

    public Node getHead() {
        if(List.isEmpty())
            return null;
        else
            return List.get(0);
    }

    public static class Node<T> {
        T data;
        Node next;

        public Node(T _data) {
            data = _data;
            next = null;
        }

        public Node getNext() {
            return next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public LinkedListCycle() {
        List = new LinkedList<>();
    }

    public void addNode(Node node) {
        if (List.isEmpty()) {
            List.add(node);
        } else if (List.size() == 1) {
            List.add(node);
            List.get(0).next = node;
            node.next = List.get(0);
        } else {
            node.next = List.get(List.size() - 1).next;
            List.get(List.size() - 1).next = node;
            List.add(node);
        }
    }
    public void removeNode(Node node){
        if (List.isEmpty()) {
            System.out.println("Empty List!");
        } else if (List.size() == 1) {
            List.remove(node);
        } else {
            List.get(List.size() - 1).next = node.next ;
            List.remove(node);
        }
    }

}
