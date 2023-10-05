package lab_2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DeepLimitedSearch {
    public Node execute(Node root, String goal, int limitedDepth) {
        //TODO (Implement deep limited search algorithm)
        root.setDepth(0);
        return recursiveDLS(root, goal, limitedDepth);
    }

    private Node recursiveDLS(Node root, String goal, int limitedDepth) {
        if (root.getLabel().equals(goal)) return root;
        else if (limitedDepth == 0) return root;
        else {
            if (root.getDepth() <= limitedDepth) {
                for (Node child : root.getChildrenNodes()) {
                    child.setParent(root);
                    child.setDepth(root.getDepth() + 1);
                    Node result = recursiveDLS(child, goal, limitedDepth);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }
        return null;
    }

    public Node noRecursiveDLS(Node root, String goal, int limited) {
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        root.setDepth(0);
        Set<Node> explored = new HashSet<>();
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if (currentNode.getLabel().equals(goal)) return currentNode;
            explored.add(currentNode);
            if (currentNode.getDepth() <= limited) {
                for (Node child : currentNode.getChildrenNodes()) {
                    if (!stack.contains(child) && !explored.contains(child)) {
                        child.setParent(currentNode);
                        child.setDepth(currentNode.getDepth() + 1);
                        stack.add(child);
                    }
                }
            }
        }
        return null;
    }
}
