package lab_4;

import java.util.*;

public class AStarSearchAlgo implements IInformedSearchAlgo {
    private Comparator<Node> nodeComparatorByH_G() {
        return new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                Double hg1 = o1.getG() + o1.getH();
                Double hg2 = o2.getG() + o2.getH();
                int result = hg1.compareTo(hg2);
                if (result == 0) {
                    return o1.getLabel().compareTo(o2.getLabel());
                }
                return result > 0 ? 1 : -1;
            }
        };
    }

    @Override
    public Node execute(Node root, String goal) {
        root.setG(0);
        root.setParent(null);
        PriorityQueue<Node> frontier = new PriorityQueue<>(nodeComparatorByH_G());
        frontier.add(root);
        List<Node> explored = new LinkedList<>();
        while (!frontier.isEmpty()) {
            Node parent = frontier.poll();
            if (parent.getLabel().equals(goal)) {
                explored.add(parent);
                System.out.print("Explored AStart: " + explored + "\t|\t");
                return parent;
            }
            explored.add(parent);

            for (Edge edge : parent.getChildren()) {
                Node child = edge.getEnd();
                double newG = parent.getG() + edge.getWeight();
                if(!explored.contains(child)){
                    if(frontier.contains(child) && child.getG() > newG){
                        frontier.remove(child);
                    }
                    if(!frontier.contains(child)){
                        child.setG(newG);
                        child.setParent(parent);
                        frontier.add(child);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        return null;
    }
}
