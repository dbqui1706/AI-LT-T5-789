package lab_1.task_1;

public class AgentProgram {

    public Action execute(Percept p) {// location, status
        //TODO
        if (p.getLocationState() == Environment.LocationState.DIRTY) {
            return Environment.SUCK_DIRT;
        } else if (p.getAgentLocation().equals(Environment.LOCATION_A)) {
            return Environment.MOVE_RIGHT;
        } else if (p.getAgentLocation().equals(Environment.LOCATION_B)) {
            return Environment.MOVE_RIGHT;
        }
        return NoOpAction.NO_OP;

    }
}