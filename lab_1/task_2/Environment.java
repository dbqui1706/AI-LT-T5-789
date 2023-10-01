package lab_1.task_2;

public class Environment {
    public static final Action MOVE_LEFT = new DynamicAction("LEFT");
    public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
    public static final Action SUCK_DIRT = new DynamicAction("SUCK");
    public static final Action MOVE_UP = new DynamicAction("UP");
    public static final Action MOVE_DOWN = new DynamicAction("DOWN");
    public static final String LOCATION_A = "A";
    public static final String LOCATION_B = "B";
    public static final String LOCATION_C = "C";
    public static final String LOCATION_D = "D";

    public enum LocationState {
        CLEAN, DIRTY
    }

    private EnvironmentState envState;
    private boolean isDone = false;// all squares are CLEAN
    private Agent agent = null;
    private int score = 0;

    public Environment(LocationState locAState, LocationState locBState, LocationState locCState
            , LocationState locDState) {
        envState = new EnvironmentState(locAState, locBState, locCState, locDState);
    }

    // add an agent into the environment
    public void addAgent(Agent agent, String location) {
        // TODO
        this.agent = agent;
        this.envState.setAgentLocation(location);
    }

    public EnvironmentState getCurrentState() {
        return this.envState;
    }

    // Update environment state when agent do an action
    public EnvironmentState executeAction(Action action) {
        // TODO
        String currentLocation = envState.getAgentLocation();
        LocationState currentLocationState = envState.getLocationState(currentLocation);

        if (action == SUCK_DIRT && currentLocationState == LocationState.DIRTY) {
            envState.setLocationState(currentLocation, LocationState.CLEAN);
            this.score += 500;
        } else {
            String newLocation = getNextLocation(currentLocation, action);
            if (newLocation != null) {
                envState.setAgentLocation(newLocation);
            } else {
                this.score -= 100;
            }
            this.score -= 10;
        }
        return envState;
    }

    private String getNextLocation(String currentLocation, Action action) {
        switch (currentLocation) {
            case LOCATION_A:
                return (action == MOVE_RIGHT) ? LOCATION_B : (action == MOVE_DOWN) ? LOCATION_C : null;
            case LOCATION_B:
                return (action == MOVE_LEFT) ? LOCATION_A : (action == MOVE_DOWN) ? LOCATION_D : null;
            case LOCATION_C:
                return (action == MOVE_UP) ? LOCATION_A : (action == MOVE_RIGHT) ? LOCATION_D : null;
            case LOCATION_D:
                return (action == MOVE_UP) ? LOCATION_B : (action == MOVE_LEFT) ? LOCATION_C : null;
            default:
                return null;
        }
    }


    // get percept<AgentLocation, LocationState> at the current location where agent
    // is in.
    public Percept getPercept() {
        // TODO
        String agentLocation = envState.getAgentLocation();
        LocationState locationState = envState.getLocationState(agentLocation);
        return new Percept(agentLocation, locationState);

    }

    public void step() {
        envState.display();
        String agentLocation = this.envState.getAgentLocation();
        Action anAction = agent.execute(getPercept());
        EnvironmentState es = executeAction(anAction);
        System.out.println("Agent Loc: " + agentLocation + "\tAction: " + anAction);

        if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
                && (es.getLocationState(LOCATION_B) == LocationState.CLEAN)
                && (es.getLocationState(LOCATION_C) == LocationState.CLEAN)
                && (es.getLocationState(LOCATION_D) == LocationState.CLEAN))
            isDone = true;// if both squares are clean, then agent do not need to do any action
        es.display();
    }

    public void step(int n) {
        for (int i = 0; i < n; i++) {
            step();
            System.out.println("Score:" + this.score);
            System.out.println("-------------------------");
        }
    }

    public void stepUntilDone() {
        int i = 0;

        while (!isDone) {
            System.out.println("step: " + i++);
            step();
            System.out.println("Score:" + this.score);
            System.out.println("-------------------------");
        }
    }
}