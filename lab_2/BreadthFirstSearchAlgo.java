package lab_2;

import java.util.*;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(root);
        while (!frontier.isEmpty()) {
            Node currNode = frontier.poll();
            if (currNode.getLabel().equals(goal)) return currNode;
            for (Node child : currNode.getChildrenNodes()) {
                frontier.add(child);
                child.setParent(currNode);
            }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        Node startNode = execute(root, start);
        startNode.setParent(null);
        frontier.add(startNode);
        while (!frontier.isEmpty()) {
            Node currNode = frontier.poll();
            if (currNode.getLabel().equals(goal)) return currNode;
            for (Node child : currNode.getChildrenNodes()) {
                frontier.add(child);
                child.setParent(currNode);
            }
        }
        return null;
    }
}
