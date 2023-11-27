package lab_7;

import lab_7.Queen;

import java.util.*;

public class GA_NQueenAlgo {
    public static final int POP_SIZE = 100;//Population size
    public static final double MUTATION_RATE = 0.0001;
    public static final int MAX_ITERATIONS = 1000;
    List<Node> population = new ArrayList<Node>();
    Random rd = new Random();
    public static final int K = 5;

    // initialize the individuals of the population
    public void initPopulation() {
        for (int i = 0; i < POP_SIZE; i++) {
            Node ni = new Node();
            ni.generateBoard();
            population.add(ni);
        }
    }

    public Node execute(){
        // Enter your code here
        initPopulation();
        List<Node> newPopulation = new ArrayList<Node>();
        int count = 0;
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            for (int j = 0; j < POP_SIZE; j++) {
                Node x = this.getParentByTournamentSelection();
                Node y = this.getParentByTournamentSelection();
                Node child = this.reproduce(x, y);
                if (Math.random() < MUTATION_RATE) {
                    ++count;
                    mutate(child);
                }
                if (child.getH() == 0) {
                    newPopulation.add(child);
                    break;
                } else newPopulation.add(child);
            }
        }
//        System.out.println("MAX_ITERATIONS " + MAX_ITERATIONS + ": " + count + " mutate");
        population = newPopulation;
        Collections.sort(population, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getH() - o2.getH();
            }
        });
//        int min = Integer.MAX_VALUE;
//        Node result = null;
//        for (Node node : population) {
//            if (min > node.getH()) {
//                if (node.getH() == 0) return node;
//                min = Math.min(node.getH(), min);
//                result = node;
//            }
//        }
        return population.get(0);
    }

    // Mutate an individual by selecting a random Queen and
    // move it to a random row.
    public void mutate(Node node) {
        // Enter your code here
        int i = rd.nextInt(0, Node.N);
        node.setRow(i, node.getRow(i));
    }

    //Crossover x and y to reproduce a child
    public Node reproduce(Node x, Node y) {
        // Enter your code here
        int n = x.N;
        int c = rd.nextInt(0, n);
        Queen[] state = new Queen[Node.N];
        for (int i = 0; i <= c; i++) {
            state[i] = (Queen) x.getState()[i].clone();
        }
        for (int i = c + 1; i < n; i++) {
            state[i] = (Queen) y.getState()[i].clone();
        }
        return new Node(state);
    }

    // Select K individuals from the population at random and
    //select the best out of these to become a parent.
    public Node getParentByTournamentSelection() {
        List<Node> nodes = new ArrayList<>(K);
        // Enter your code here
        for (int i = 0; i < K; i++) {
            nodes.add(getParentByRandomSelection());
        }
        int min = Integer.MAX_VALUE;
        Node bestNode = null;
        for (Node node : nodes) {
            if (min > node.getH()) {
                min = Math.min(min, node.getH());
                bestNode = node;
            }
        }
        return bestNode;
    }

    //Select a random parent from the population
    public Node getParentByRandomSelection() {
        // Enter your code here
        return population.get(rd.nextInt(0, POP_SIZE));
    }
}
