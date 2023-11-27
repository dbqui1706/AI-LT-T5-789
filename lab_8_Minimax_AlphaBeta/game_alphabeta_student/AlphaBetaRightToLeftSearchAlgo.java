package lab_8_Minimax_AlphaBeta.game_alphabeta_student;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo {
    // function ALPHA-BETA-SEARCH(state) returns an action
    // inputs: state, current state in game
    // v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
    // return the action in SUCCESSORS(state) with value v
    @Override
    public void execute(Node node) {
        // Enter your code here
        node.setValue(maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Override
    public Node bestNextNode(Node node, boolean isMax) {
        if (isMax) {
            return maxNode(node);
        }
        return minNode(node);
    }

    // function MAX-VALUE(state, alpha, beta) returns a utility value
    // if TERMINAL-TEST(state) then return UTILITY(state)
    // v <- MIN_VALUE;
    // for each s in SUCCESSORS(state) do
    // v <- MAX(v, MIN-VALUE(s, alpha, beta))
    // if v >= beta then return v
    // alpha <- MAX(alpha, v)
    // return v

    public int maxValue(Node node, int alpha, int beta) {
        // Enter your code here
        if (node.isTerminal()) {
            System.out.println("Terminal: " + node.getLabel() + ", " + node.getValue());
            return node.getValue();
        }
        int v = Integer.MIN_VALUE;
        boolean flag = false;
        List<Node> children = node.getChildren();

        for (Node maxNode : node.getChildren().reversed()) {
            if (flag) {
                System.out.println("Puring: " + maxNode.getLabel());
            } else {
                v = Math.max(v, minValue(maxNode, alpha, beta));
                if (v >= beta) {
                    flag = true;
                    continue;
                }
                alpha = Math.max(alpha, v);
            }
        }
        System.out.println(node.getLabel() + ": " + v);
        return v;
    }
    // function MIN-VALUE(state, alpha , beta) returns a utility value
    // if TERMINAL-TEST(state) then return UTILITY(state)
    // v <- Integer.MAX_VALUE
    // for each s in SUCCESSORS(state) do
    // v <- MIN(v, MAX-VALUE(s, alpha , beta))
    // if v <= alpha then return v
    // beta <- MIN(beta ,v)
    // return v

    public int minValue(Node node, int alpha, int beta) {
        // Enter your code here
        if (node.isTerminal()) {
            System.out.println("Terminal: " + node.getLabel() + ", " + node.getValue());
            return node.getValue();
        }
        int v = Integer.MAX_VALUE;
        boolean flag = false;
        List<Node> children = node.getChildren();
        for (Node minNode : children.reversed()) {
            if (flag) {
                System.out.println("Puring: " + minNode.getLabel());
            } else {
                v = Math.min(v, maxValue(minNode, alpha, beta));
                if (v <= alpha) {
                    flag = true;
                    continue;
                }
                beta = Math.min(beta, v);
            }
        }
        System.out.println(node.getLabel() + ": " + v);
        return v;
    }

    public Node maxNode(Node node) {
        if (node.isTerminal()) return node;
        Node maxNode = null;
        int max = Integer.MIN_VALUE;
        for (Node curr : node.getChildren()) {
            int c = minValue(curr, Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (max < c) {
                maxNode = curr;
                max = c;
            }
        }
        return maxNode;
    }

    public Node minNode(Node node) {
        if (node.isTerminal()) return node;
        Node minNode = null;
        int min = Integer.MAX_VALUE;
        for (Node curr : node.getChildren()) {
            int c = minValue(curr, Integer.MAX_VALUE, Integer.MIN_VALUE);
            if (min > c) {
                minNode = curr;
                min = c;
            }
        }
        return minNode;
    }
}
