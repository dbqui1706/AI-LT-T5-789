package lab_7;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        GA_NQueenAlgo algo = new GA_NQueenAlgo();
        int count = 0;
        for (int i = 0; i < 100; i++) {
            Node node = algo.execute();
            if (node.getH() == 0) {
                System.out.println("OK " + count++);
                node.displayBoard();
            }
        }
        System.out.println("Percent success: " + ((double) count) + "%");
    }
}
