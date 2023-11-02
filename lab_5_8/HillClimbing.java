package lab_5_8;

public class HillClimbing implements IPuzzleAlgo{

    @Override
    public Node execute(Puzzle model) {
        Node currentNode = model.getInitialState();

        while (currentNode != null){
            if (currentNode.equals(model.getGoalState())) return currentNode;
            boolean flag = false;
            for (Node child : model.getSuccessors(currentNode)){
                if(currentNode.getH() > child.getH()){
                    flag = true;
                    currentNode = child;
                }
            }
            if (!flag){
                return null;
            }
        }
        return null;
    }
}
