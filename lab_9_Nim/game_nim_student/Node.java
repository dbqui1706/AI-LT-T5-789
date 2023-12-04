package lab_9_Nim.game_nim_student;

import java.util.*;

public class Node {
    private List<Integer> data = new ArrayList<Integer>();

    public void add(Integer val) {
        this.data.add(val);
    }

    public void addAll(List<Integer> data) {
        this.data.addAll(data);
    }

    // Get children of the current nodes
    public List<Node> getSuccessors() {
        // Enter your code here
        if (isTerminal()) return new ArrayList<>();
        Collections.sort(data,DESCOMPARATOR);
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            int curr = data.get(i);
            if (curr > 2){
                int divide = curr / 2;
                for (int j = 1; j <= divide; j++) {
                    int x = curr - j;
                    int y = curr - x;
                    if (x != y) {
                        ArrayList<Integer> clone = (ArrayList<Integer>) ((ArrayList<Integer>) data).clone();
                        clone.remove(i);
                        Node node = new Node();
                        clone.addAll(Arrays.asList(x, y));
                        node.addAll(clone);
                        if (!nodes.contains(node)){
                            nodes.add(node);
                        }
                    }
                }
            }
        }
        return nodes;
    }

    // Check whether a node is terminal or not
    public boolean isTerminal() {
        // Enter your code here
        Collections.sort(data, DESCOMPARATOR);
        if (data.get(0) < 3) return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(data, node.data);
    }

    public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };

    @Override
    public String toString() {
        Collections.sort(this.data, DESCOMPARATOR);
        return this.data.toString();
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.addAll(Arrays.asList(3,4));
        System.out.println(node.getSuccessors());
    }
}
