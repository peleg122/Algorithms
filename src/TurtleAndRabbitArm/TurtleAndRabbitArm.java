package TurtleAndRabbitArm;

import LinkedListCycle.LinkedListCycle;
import LinkedListCycle.LinkedListCycle.Node;

import java.util.LinkedList;

public class TurtleAndRabbitArm {
    private LinkedList<Node> Arm;
    private LinkedListCycle<Node> Cycle;

    public TurtleAndRabbitArm() {
        Arm = new LinkedList<>();
        Cycle = new LinkedListCycle();
    }

    public void addArm(Node node) {
        if (Arm.isEmpty()) {
            Arm.add(node);
            node.setNext(Cycle.getHead());
        } else {
            Arm.get(Arm.size() - 1).setNext(node);
            Arm.add(node);
            node.setNext(Cycle.getHead());
        }
    }

    public void addCycle(Node node) {
        Cycle.addNode(node);
        if(Arm.get(Arm.size()-1).getNext()==null)
            Arm.get(Arm.size()-1).setNext(Cycle.getHead());
    }

    public void removeArm(Node node) {
        if (Arm.isEmpty()) {
            System.out.println("Empty Arm");
        } else {
            if (Arm.size() == 1) {
                Arm.get(0).setNext(Cycle.getHead());
            } else {
                for (Node node1 : Arm) {
                    if (node1.getNext() == node)
                        node1.setNext(Cycle.getHead());
                }
                Arm.remove(node);
            }
        }
    }

    public int ArmSize() {
        int ans = -1;
        boolean flag = true;
        boolean flag2 = false;
        Node Slow = Arm.get(0);
        Node Fast = Arm.get(0);

        while (flag) {
            if (Slow.getNext() == null || Fast.getNext() == null || Fast.getNext().getNext() == null) {
                System.out.println("no cycle");
                flag = false;
            } else {
                Slow = Slow.getNext();
                Fast = Fast.getNext().getNext();
                if (Slow.getData() == Fast.getData()) {
                    flag = false;
                    flag2 = true;
                }
            }
        }
        Fast = Arm.get(0);
        while (flag2) {
            ans++;
            if (Slow.getData() == Fast.getData()) {
                flag2 = false;
            } else {
                Slow = Slow.getNext();
                Fast = Fast.getNext();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TurtleAndRabbitArm TARA = new TurtleAndRabbitArm();
        TARA.addArm(new Node(1));
        TARA.addArm(new Node(2));
        TARA.addArm(new Node(3));
        TARA.addArm(new Node(4));
        TARA.addArm(new Node(5));
        TARA.addArm(new Node(6));
        TARA.addCycle(new Node(7));
        TARA.addCycle(new Node(8));
        TARA.addCycle(new Node(9));
        TARA.addCycle(new Node(10));
        TARA.addCycle(new Node(11));
        TARA.addCycle(new Node(12));
        System.out.println("Arm Size: "+TARA.ArmSize());//true
    }
}

