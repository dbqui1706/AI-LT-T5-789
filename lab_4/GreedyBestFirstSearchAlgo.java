package lab_4;

import java.util.*;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {
    private Comparator<Node> greedyBSFComparator() {
        return new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                Double h1 = o1.getH();
                Double h2 = o2.getH();
                int result = h1.compareTo(h2);
                if (result == 0)
                    return o1.getLabel().compareTo(o2.getLabel());
                else
                    return result;
            }
        };
    }

    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(greedyBSFComparator());
        List<Node> explored = new LinkedList<>();
        frontier.add(root);
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();
            if (currentNode.getLabel().equals(goal)) {
                explored.add(currentNode);
                System.out.print("Explored GreedyBFS: " + explored + "\t|\t");
                return currentNode;
            }
            explored.add(currentNode);
            for (Edge edge : currentNode.getChildren()) {
                Node child = edge.getEnd();
                child.setParent(currentNode);
                if (!frontier.contains(child) && !explored.contains(child)) {
                    frontier.add(child);
                }
            }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        Node startNode = execute(root, start);
        startNode.setParent(null);
        return execute(startNode, goal);
    }
}
