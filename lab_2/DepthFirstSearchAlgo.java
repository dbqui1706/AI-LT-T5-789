package lab_2;

import java.util.*;

public class DepthFirstSearchAlgo implements ISearchAlgo {
    @Override
    public Node execute(Node root, String goal) {
        Stack<Node> frontier = new Stack<>();
        frontier.add(root);

        Set<Node> explored = new HashSet<>();

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.pop();
            if (currentNode.getLabel().equals(goal)) {
                return currentNode;
            }
            explored.add(currentNode);
            List<Node> children = currentNode.getChildrenNodes();
            Collections.reverse(children);
            for (Node child : children) {
                if (child != null && !frontier.contains(child) && !explored.contains(child)) {
                    frontier.add(child);
                    child.setParent(currentNode);
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

    public Node executeTreeSearch(Node root, String goal) {
        Stack<Node> queue = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.pop();
            if (currentNode.getLabel().equals(goal)) return currentNode;
            for (Node child : currentNode.getChildrenNodes()) {
                child.setParent(currentNode);
                queue.add(child);
            }
        }
        return null;
    }
    public Node executeTreeSearch(Node root, String start, String goal) {
        Node startNode = executeTreeSearch(root, start);
        startNode.setParent(null);

        return executeTreeSearch(startNode, goal);
    }
}
