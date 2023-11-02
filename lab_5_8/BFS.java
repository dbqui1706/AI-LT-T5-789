package lab_5_8;

import java.util.*;

public class BFS implements IPuzzleAlgo {
    @Override
    public Node execute(Puzzle model) {
        Queue<Node> frontier = new ArrayDeque<>();
        Set<Node> explored = new HashSet<>();
        frontier.add(model.getInitialState());
        int count = 0;
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.remove();
            count++;
            if (count % 10000 == 0) System.out.println(count);
            if (currentNode.equals(model.getGoalState())) return currentNode;
            explored.add(currentNode);
            for (Node child : model.getSuccessors(currentNode)) {
                if (child != null) {
                    if (!frontier.contains(child) && !explored.contains(child)) {
                        frontier.add(child);
                    }
                }
            }
        }
        return null;
    }
}
