package lab_1.task_2;

import java.util.Random;

public class AgentProgram {

    public Action execute(Percept p) {// location, status
        //TODO
        Environment.LocationState locationState = p.getLocationState();
        Random random = new Random();
        int randomDirection = random.nextInt(4); // Randomize from 0 to 4

        if (locationState == Environment.LocationState.DIRTY) {
            return Environment.SUCK_DIRT;
        } else {
            switch (randomDirection) {
                case 0:
                    return Environment.MOVE_RIGHT;
                case 1:
                    return Environment.MOVE_LEFT;
                case 2:
                    return Environment.MOVE_DOWN;
                case 3:
                    return Environment.MOVE_UP;
                default:
                    return NoOpAction.NO_OP;
            }
        }
    }
}