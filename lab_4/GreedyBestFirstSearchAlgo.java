package lab_4;

import java.util.*;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {
    private double hReal;

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
        startNode.setH(0);
        return execute(startNode, goal);
    }

    @Override
    public boolean isAdmissible(Node root, String goal) {
        List<Node> result = new LinkedList<>() {
        };
        Node node = execute(root, goal);
        result.add(node);
        Node tmp;
        while ((tmp = node.getParent()) != null) {
            hReal += tmp.getH();
            result.add(tmp);
            node = tmp;
        }
        Collections.reverse(result);
        for (Node n: result){
            if (n.getH() > hReal) return false;
        }
        return true;
    }
}
