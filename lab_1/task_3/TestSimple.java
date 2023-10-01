package lab_1.task_3;

public class TestSimple {
    public static void main(String[] args) {
        Agent agent = new Agent(0,1);
        Environment environment = new Environment(agent,5,5);
        environment.action();
    }
}