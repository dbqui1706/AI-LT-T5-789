package lab_5_8;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class AStart implements IPuzzleAlgo {

    @Override
    public Node execute(Puzzle model) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByF);
        List<Node> explored = new LinkedList<>();
        frontier.add(model.getInitialState());
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();
            if (currentNode.equals(model.getGoalState())) {
                return currentNode;
            }
            explored.add(currentNode);
            for (Node child : model.getSuccessors(currentNode)) {
                if (!frontier.contains(child) && !explored.contains(child)) {
                    child.setG(currentNode.getG() + 1);
                    child.setParent(currentNode);
                    frontier.add(child);
                }
            }
            System.out.println(currentNode);
        }
        return null;
    }
}
