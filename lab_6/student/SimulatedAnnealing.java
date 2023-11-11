package lab_6.student;

public class SimulatedAnnealing implements IAlgoQueen {
    private final double reduceTemperature = 0.1;

    @Override
    public Node execute(Node initialState) {
        return simulatedAnnealing(initialState, 100);
    }

    public Node simulatedAnnealing(Node initialState, int Temperature) {
        Node result = initialState;
        while (Temperature > 0.1) {
            Temperature *= reduceTemperature;
            Node next = result.selectNextRandomCandidate();
            if (next.getH() == 0) {
                return next;
            }
            double deltaE = next.getH() - result.getH();
            double prob = Math.exp(deltaE / Temperature);
            if (deltaE > 0 || prob > Math.random()) {
                result = next;
            }
        }
        return result;
    }
}
