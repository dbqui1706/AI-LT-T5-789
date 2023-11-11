package lab_6.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
    public static final int N = 8;
    private Queen[] state;

    public Node() {
        state = new Queen[N];
        generateBoard();
    }

    public Node(Queen[] state) {
        this.state = new Queen[N];
        for (int i = 0; i < state.length; i++) {
            this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
        }
    }

    public Node(Node n) {
        this.state = new Queen[N];
        for (int i = 0; i < N; i++) {
            Queen qi = n.state[i];
            this.state[i] = new Queen(qi.getRow(), qi.getColumn());
        }
    }

    public void generateBoard() {
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            state[i] = new Queen(random.nextInt(N), i);
        }
    }

    public int getH() {
        int heuristic = 0;
        // Enter your code here
        for (int i = 0; i < state.length - 1; i++) {
            for (int j = i + 1; j < state.length; j++) {
                if (state[i].isConflict(state[j])) heuristic++;
            }
        }
        return heuristic;
    }

    private Queen[] copy() {
        Queen[] copy = new Queen[N];
        for (int i = 0; i < N; i++) {
            copy[i] = state[i];
        }
        return copy;
    }

    public List<Node> generateAllCandidates() {
        List<Node> result = new ArrayList<Node>();
        // Enter your code here
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                Queen[] curr = copy();
//                if (j != i) {
//                    curr[j].move();
//                    result.add(new Node(curr));
//                }
//            }
//        }
        for (int i = 0; i < N; i++) {
            Queen[] curr = copy();
            curr[i].move();
            result.add(new Node(curr));
        }
        return result;
    }

    public Node selectNextRandomCandidate() {
        // Enter your code here
        Random random = new Random();
        int i = random.nextInt(0, N);
        return generateAllCandidates().get(i);
    }

    public void displayBoard() {
        int[][] board = new int[N][N];
        // set queen position on the board
        for (int i = 0; i < N; i++) {
            board[state[i].getRow()][state[i].getColumn()] = 1;
        }
        // print board
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q" + " ");
                } else {
                    System.out.print("-" + " ");
                }
            }
            System.out.println();
        }
    }
}
