package lab_6.student;

public class Test {
    public static void main(String[] args) {
        HillClimbing hillClimbing = new HillClimbing();
        Node init = new Node();
//        Node node = hillClimbing.executeHillClimbingRandomRestart(init);
//        node.displayBoard();
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
        int count = 0;
        for (int i = 0; i < 100; i++) {
            Node sa = simulatedAnnealing.execute(init);
            if (sa.getH() == 0) {
                System.out.printf("OK");
                count++;
            } else System.out.printf("Fail");
            System.out.println();
        }
        System.out.println(count);
    }
}
