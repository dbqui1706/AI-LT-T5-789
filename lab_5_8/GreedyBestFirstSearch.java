package lab_5_8;

import java.util.*;

public class GreedyBestFirstSearch implements IPuzzleAlgo {


    @Override
    public Node execute(Puzzle model) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
        List<Node> explored = new LinkedList<>();
        frontier.add(model.getInitialState());
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.remove();
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
