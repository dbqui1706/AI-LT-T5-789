package lab_5_8;

import java.util.Arrays;
import java.util.List;

public class TestNode {

    public static void main(String[] args) {
        Puzzle p = new Puzzle();
        p.readInput("lab_5_8/file_test/PuzzleMap.txt", "lab_5_8/file_test/PuzzleGoalState.txt");

        Node initialState = p.getInitialState();
        Node tmp = new Node(initialState);
        System.out.println(initialState.equals(tmp));
//		Node goalState = p.getGoalState();
//		System.out.println(p.getInitialState());
        p.getInitialState().setH(p.computeH1(initialState));
        System.out.println("H: " + initialState.getH());
//		System.out.println(Arrays.toString(initialState.getWhiteTilePosition()));
//		System.out.println(p.getGoalState());
//        Node re = p.moveWhiteTile(initialState, 'u');
//
        System.out.println(initialState);
        IPuzzleAlgo greedyBFS= new GreedyBestFirstSearch();
        IPuzzleAlgo aStart = new AStart();
        IPuzzleAlgo dfs = new DFS();
        IPuzzleAlgo bfs = new BFS();
        IPuzzleAlgo hillClimbing = new HillClimbing();
        Long start = System.currentTimeMillis();
        // GreedyBFS
//        Node re = greedyBFS.execute(p);
//        System.out.println("H: " + re.getH());
//        System.out.println(re);
        // AStart
//        Node resAStart = aStart.execute(p);
//        System.out.println("H: " + resAStart.getH());
//        System.out.println(resAStart);
        // DFS
//        Node resDFS = dfs.execute(p);
//        System.out.println("H: " + resDFS.getH());
//        System.out.println(resDFS);
        // DFS
//        Node resBFS = bfs.execute(p);
//        System.out.println("H: " + resBFS.getH());
//        System.out.println(resBFS);

        Node hill = hillClimbing.execute(p);
        System.out.println("H: " + hill.getH());
        System.out.println(hill);
        System.out.println("Time: " + (System.currentTimeMillis() - start)+ "ms");
//		System.out.println(Arrays.toString(re.getWhiteTilePosition()));
//		System.out.println(p.computeH(init, goal));

        // System.out.println(p.getInitialState());
        // System.out.println(p.getGoalState());
        //
        // List<Node> children = p.getSuccessors(initialState);
        // System.out.println("Size: "+children.size());
        // for (Node child : children) {
        // System.out.println(child.getH()+" "+p.computeH(child) );
        // }
    }
}
