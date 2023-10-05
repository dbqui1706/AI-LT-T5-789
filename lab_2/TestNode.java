package lab_2;

public class TestNode {
    public static void main(String[] args) {
        Node nodeS = new Node("S");
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        nodeS.addEdge(nodeA, 5);
        nodeS.addEdge(nodeB, 2);
        nodeS.addEdge(nodeC, 4);
        nodeA.addEdge(nodeD, 9);
        nodeA.addEdge(nodeE, 4);
        nodeB.addEdge(nodeG, 6);
        nodeC.addEdge(nodeF, 2);
        nodeD.addEdge(nodeH, 7);
        nodeE.addEdge(nodeG, 6);
        nodeF.addEdge(nodeG, 1);
        BreadthFirstSearchAlgo algo1 = new BreadthFirstSearchAlgo();
        DepthFirstSearchAlgo algo2 = new DepthFirstSearchAlgo();
        UniformCostSearchAlgo algo3 = new UniformCostSearchAlgo();
        DeepLimitedSearch algo4 = new DeepLimitedSearch();


        Node ex2 = NodeUtils.dummy();
        System.out.println("No recursive DLS: " + NodeUtils.printPath(algo4.noRecursiveDLS(ex2,"Goal", 9)));
//        System.out.println("DLS: " + NodeUtils.printPath(algo3.execute(ex2, "Goal")));
//        System.out.println("UniformCost: " + NodeUtils.printPath(algo3.execute(nodeS, "G")));
//        System.out.println("UniformCost: " + NodeUtils.printPath(algo3.execute(nodeS, "G")));

//        System.out.println("Deep limited search: " + NodeUtils.printPath(algo4.execute(nodeS, "G", 3)));
//        System.out.println("BFS: " + NodeUtils.printPath(algo1.execute(nodeS, "G")));
//        System.out.println("BFS: " + NodeUtils.printPath(algo1.execute(nodeS, "A", "H")));
//        System.out.println("DFS: " + NodeUtils.printPath(algo2.execute(nodeS, "G")));
//        System.out.println("DFS: " + NodeUtils.printPath(algo2.execute(nodeS, "A", "H")));
//        System.out.println(nodeS.getChildren());
    }
}
