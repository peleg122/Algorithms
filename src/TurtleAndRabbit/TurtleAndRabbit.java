package TurtleAndRabbit;

import LinkedListCycle.LinkedListCycle;
import LinkedListCycle.LinkedListCycle.Node;

public class TurtleAndRabbit<T> {
    private LinkedListCycle<T> List;

    public TurtleAndRabbit() {
        List = new LinkedListCycle<T>();
    }

    public boolean isCycle() {
        boolean flag = true;
        boolean ans = false;
        LinkedListCycle.Node Slow = List.getHead();
        LinkedListCycle.Node Fast = List.getHead();

        while (flag && !List.isEmpty()) {
            if (Slow.getNext()==null || Fast.getNext()==null || Fast.getNext().getNext() == null){
                System.out.println("No Cycle");
                flag = false;
                ans = false;
            }else {
                Slow = Slow.getNext();
                Fast = Fast.getNext().getNext();
                if (Slow.getData()==Fast.getData()){
                    System.out.println("Cycle Found");
                    flag = false;
                    ans = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TurtleAndRabbit<Integer> list = new TurtleAndRabbit<Integer>();
        list.List.addNode(new Node(5));
        list.List.addNode(new Node(4));
        list.List.addNode(new Node(6));
        list.List.addNode(new Node(7));
        list.List.addNode(new Node(8));
        list.isCycle();
    }
}
