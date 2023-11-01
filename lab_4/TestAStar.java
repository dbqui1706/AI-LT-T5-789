package lab_4;

public class TestAStar {
    public static void main(String[] args) {
        Node s = new Node("S", 6);
        Node b = new Node("B", 4);
        Node a = new Node("A", 4);
        Node c = new Node("C", 4);
        Node d = new Node("D", 3.5);
        Node e = new Node("E", 1);
        Node f = new Node("F", 1);
        Node g = new Node("G", 0);

        s.addEdge(b, 3);
        s.addEdge(a, 2);
        a.addEdge(c, 3);
        b.addEdge(d, 3);
        b.addEdge(c, 4);
        c.addEdge(e, 3);
        c.addEdge(d, 1);
        d.addEdge(f, 2);
        f.addEdge(g, 1);
        e.addEdge(g, 2);

		IInformedSearchAlgo greedyBFS = new GreedyBestFirstSearchAlgo();
//		Node res = greedyBFS.execute(s, "G");
//		System.out.println("Greedy BFS: " + NodeUtils.printPath(res));
//        System.out.println("Admissible: " + greedyBFS.isAdmissible(s, "G"));
        IInformedSearchAlgo aStar = new AStarSearchAlgo();
        Node resAStart = aStar.execute(s, g.getLabel());
        System.out.println("AStart: " + NodeUtils.printPath(resAStart));

    }
}
