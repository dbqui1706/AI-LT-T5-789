package lab_2_3;

import java.util.*;

public class UniformCostSearchAlgo implements ISearchAlgo {
    private Comparator<Node> comparatorPathCost() {
        return new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                double result = o1.getPathCost() - o2.getPathCost();
                if (result == 0) {
                    return o1.compareTo(o2);
                } else {
                    return (result > 0) ? (1) : (-1);
                }
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
                double newCost = childNode.getPathCost() + currentNode.getPathCost();

                if (!priorityQueue.contains(childNode) || !explored.contains(childNode)) {
                    childNode.setParent(currentNode);
                    childNode.setPathCost(currentNode.getPathCost() + child.getWeight());
                    priorityQueue.add(childNode);
                }
                if (priorityQueue.contains(childNode) && newCost < childNode.getPathCost()) {
                    priorityQueue.remove(childNode);
                    priorityQueue.add(childNode);
                }
            }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        Node startNode = execute(root, start);
        startNode.setParent(null);
//        startNode.setPathCost(0);
        return execute(startNode, goal);
    }
}
