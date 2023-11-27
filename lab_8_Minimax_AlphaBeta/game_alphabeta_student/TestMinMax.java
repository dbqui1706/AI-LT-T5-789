package lab_8_Minimax_AlphaBeta.game_alphabeta_student;

public class TestMinMax {
    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E", 3);
        Node F = new Node("F", 12);
        Node G = new Node("G", 8);
        Node H = new Node("H", 2);
        Node I = new Node("I", 4);
        Node J = new Node("J", 6);
        Node K = new Node("K", 14);
        Node L = new Node("L", 5);
        Node M = new Node("M", 2);

        A.addChild(B);
        A.addChild(C);
        A.addChild(D);

        B.addChild(E);
        B.addChild(F);
        B.addChild(G);

        C.addChild(H);
        C.addChild(I);
        C.addChild(J);

        D.addChild(K);
        D.addChild(L);
        D.addChild(M);

//        ISearchAlgo algo = new MiniMaxSearchAlgo();
//        ISearchAlgo algo = new AlphaBetaSearchAlgo();
        ISearchAlgo algo = new MiniMaxSearchAlgo();
//        Node test = testSet1();
//        Node test = testSet2();
        Node test = testSet1();
        algo.execute(test);
//        System.out.println("Max A: " + test.getValue());

        System.out.println(algo.bestNextNode(A,false));
    }

    public static Node testSet1(){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E", 3);
        Node f = new Node("F", 12);
        Node g = new Node("G", 8);
        Node h = new Node("H", 2);
        Node i = new Node("I", 4);
        Node j = new Node("J", 6);
        Node k = new Node("K", 14);
        Node l = new Node("L", 5);
        Node m = new Node("M", 2);

        a.addChild(b);
        a.addChild(c);
        a.addChild(d);
        b.addChild(e);
        b.addChild(f);
        b.addChild(g);
        c.addChild(h);
        c.addChild(i);
        c.addChild(j);
        d.addChild(k);
        d.addChild(l);
        d.addChild(m);

        return a;
    }

    public static Node testSet2(){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D", 0);
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G", -5);
        Node h = new Node("H", 3);
        Node i = new Node("I", 8);
        Node j = new Node("J");
        Node k = new Node("K");
        Node l = new Node("L", 2);
        Node m = new Node("M");
        Node n = new Node("N", 4);
        Node o = new Node("O");
        Node p = new Node("P", 9);
        Node q = new Node("Q", -6);
        Node r = new Node("R", 0);
        Node s = new Node("S", 3);
        Node t = new Node("T", 5);
        Node u = new Node("U", -7);
        Node v = new Node("V", -9);
        Node w = new Node("W", -3);
        Node x = new Node("X", -5);

        addChild(a,b,c,d,e);
        addChild(b,f,g);
        addChild(c,h,i,j);
        addChild(e,k,l,m);
        addChild(f,n,o);
        addChild(j,p,q,r);
        addChild(k,s,t);
        addChild(m,u,v);
        addChild(o,w,x);

        return a;
    }
    public static Node testSet3(){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        Node k = new Node("K");
        Node l = new Node("L");
        Node m = new Node("M");
        Node n = new Node("N");
        Node o = new Node("O");
        Node p = new Node("P");
        Node q = new Node("Q");
        Node r = new Node("R");
        Node s = new Node("S");
        Node t = new Node("T");
        Node k1 = new Node("K1", 4);
        Node k2 = new Node("K2", 9);
        Node l1 = new Node("L1", 2);
        Node m1 = new Node("M1", 1);
        Node m2 = new Node("M2", 10);
        Node n1 = new Node("N1", 0);
        Node n2 = new Node("N2", 7);
        Node o1 = new Node("O1", 4);
        Node p1 = new Node("P1", 2);
        Node q1 = new Node("Q1", 1);
        Node q2 = new Node("Q2", 8);
        Node r1 = new Node("R1", 3);
        Node s1 = new Node("S1", 7);
        Node s2 = new Node("S2", 4);
        Node t1 = new Node("T1", 3);
        Node t2 = new Node("T2", 1);

        addChild(a,b,c,d);
        addChild(b,e,f);
        addChild(c,g,h);
        addChild(d,i,j);
        addChild(e,k,l);
        addChild(f,m,n);
        addChild(g,o);
        addChild(h,p,q);
        addChild(i,r,s);
        addChild(j,t);
        addChild(k,k1,k2);
        addChild(l,l1);
        addChild(m,m1,m2);
        addChild(n,n1,n2);
        addChild(o,o1);
        addChild(p,p1);
        addChild(q,q1,q2);
        addChild(r,r1);
        addChild(s,s1,s2);
        addChild(t,t1,t2);

        return a;
    }
    public static void addChild(Node parent, Node... children){
        for(Node child : children){
            parent.addChild(child);
        }
    }
}
