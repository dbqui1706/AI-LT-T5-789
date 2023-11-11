package lab_6.student;


public class HillClimbing implements IAlgoQueen {

    @Override
    public Node execute(Node initialState) {
        int min = Integer.MAX_VALUE;
        Node neighbor = null;
        while (true) {
            boolean flag = false;
            for (Node node : initialState.generateAllCandidates()) {
                if (min > node.getH()) {
                    neighbor = node;
                    min = Math.min(min, node.getH());
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return neighbor;
    }

    public Node executeHillClimbingRandomRestart(Node initialState) {
        Node tmp = execute(initialState);
        while (true) {
            tmp = new Node();
            tmp = execute(tmp);
            if (tmp.getH() == 0){
                break;
            }
        }
        return tmp;
    }
}
