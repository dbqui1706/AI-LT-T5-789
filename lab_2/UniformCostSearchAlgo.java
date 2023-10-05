package lab_2;

import java.util.*;

public class UniformCostSearchAlgo implements ISearchAlgo {
    private Comparator<Node> comparatorPathCost() {
        return new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Double.compare(o1.getPathCost(), o2.getPathCost());
            }
        };
    }

    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(comparatorPathCost());
        root.setPathCost(0);
        priorityQueue.add(root);
        Set<Node> explored = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            if (currentNode.getLabel().equals(goal)) return currentNode;

            explored.add(currentNode);

            for (Edge child : currentNode.getChildren()) {
                Node childNode = child.getEnd();
                double oldCost = childNode.getPathCost();
                childNode.setPathCost(currentNode.getPathCost() + child.getWeight());
                childNode.setParent(currentNode);
                double newCost = childNode.getPathCost();

                if (!priorityQueue.contains(childNode) || !explored.contains(childNode)) {
                    priorityQueue.add(childNode);
                } else if (priorityQueue.contains(childNode) && newCost < oldCost) {
                    priorityQueue.remove(childNode);
                    priorityQueue.add(childNode);
                }

            }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(comparatorPathCost());
        root.setPathCost(0);
        Node startNode = execute(root, start);
        startNode.setParent(null);
        startNode.setPathCost(0);

        return execute(startNode, goal);
    }
}
