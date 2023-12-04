package lab_9_Nim.game_nim_student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimaxAlgo {
    private List<Node> paths = new ArrayList<>();
    public void execute(Node node) {
        int v = minValue(node);
        System.out.println(v);
        paths.addFirst(node);
        System.out.println(paths);
    }

    // function MAX-VALUE(state) returns a utility value
    // if TERMINAL-TEST(state) then return UTILITY(state)
    // v <- Integer.MIN_VALUE
    // for each s in SUCCESSORS(state) do
    // v <- MAX(v, MIN-VALUE(s))
    // return v
    public int maxValue(Node node) {
        if (node.isTerminal()) {
            System.out.println("ok max " + node);
            return 0;
        }
        int v = Integer.MIN_VALUE;
        for (Node curr : node.getSuccessors()) {
            paths.add(curr);
            v = Math.max(v, minValue(curr));
            break;
        }
        return v;
    }

    // function MIN-VALUE(state) returns a utility value
    // if TERMINAL-TEST(state) then return UTILITY(state)
    // v <- Integer.MAX_VALUE
    // for each s in SUCCESSORS(state) do
    // v <- MIN(v, MAX-VALUE(s))
    // return v
    public int minValue(Node node) {
        if (node.isTerminal()) {
            System.out.println("ok min " + node);
            return 1;
        }
        int v = Integer.MAX_VALUE;
        for (Node curr : node.getSuccessors()) {
            paths.add(curr);
            v = Math.min(v, maxValue(curr));
            break;
        }
        return v;
    }
}
