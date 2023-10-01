package lab_1.task_3;

import java.util.Random;

public class Environment {
    private Agent agent;
    private int score = 0;
    private int row, col;
    private char map[][];
    private final double DIRT_RATE = 0.2;
    private final double WALL_RATE = 0.1;
    private Random random = new Random();

    public Environment(Agent agent, int row, int col) {
        this.agent = agent;
        this.col = col;
        this.row = row;
        this.map = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = '_'; // Initialize grid with empty cells
            }
        }
        createObstacles();
        printGrid();

    }

    private void createObstacles() {
        int numberDirt = (int) Math.round(col * row * DIRT_RATE);
        int numberWall = (int) Math.round(col * row * WALL_RATE);
        int bot = 1;
        System.out.printf("DIRT: %s, WALL: %d\n", numberDirt, numberWall);

        while (numberDirt > 0) {
            generateRandomObstacle('D', numberDirt);
            numberDirt--;
        }

        while (numberWall > 0) {
            generateRandomObstacle('X', numberWall);
            numberWall--;
        }
        while (bot > 0) {
            generateRandomObstacle('.', bot);
            bot--;
        }
    }

    private void generateRandomObstacle(char obstacleType, int remainingObstacles) {
        int i, j;
        if (obstacleType != '.') {
            do {
                i = random.nextInt(row);
                j = random.nextInt(col);
            } while (map[i][j] != '_');
            map[i][j] = obstacleType;
        } else {
            do {
                i = random.nextInt(row);
                j = random.nextInt(col);
            } while (map[i][j] == 'X');
            agent.setRow(i);
            agent.setCol(j);
            if (map[i][j] == 'D') {
                map[i][j] = '*'; // agent stand on Dirty
                agent.setState(1);
            } else {
                map[i][j] = obstacleType;
                agent.setState(0);
            }
        }
    }

    public void printGrid() {
        for (int row = 0; row < this.row; row++) {
            for (int col = 0; col < this.col; col++) {
                System.out.print(map[row][col] + " ");
            }
            System.out.println();
        }
    }


    private boolean isDone() {
        for (char[] row : this.map) {
            for (int value : row) {
                if (value == 'D' || value == '*') {
                    return false;
                }
            }
        }
        return true;
    }

    public void move(String direction) {
        int newRow = agent.getRow();
        int newCol = agent.getCol();
        if (map[agent.getRow()][agent.getCol()] == 'D' || map[agent.getRow()][agent.getCol()] == '*') {
            map[agent.getRow()][agent.getCol()] = '_';
            agent.setState(0);
            score += 500;
        } else {
            switch (direction) {
                case "LEFT":
                    newCol = agent.getCol() - 1;
                    break;
                case "RIGHT":
                    newCol = agent.getCol() + 1;
                    break;
                case "DOWN":
                    newRow = agent.getRow() + 1;
                    break;
                case "UP":
                    newRow = agent.getRow() - 1;
                    break;
            }

            // Check if the new position is within the grid boundaries and not a wall ('X')
            if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && map[newRow][newCol] != 'X') {
                // Move the agent
                if (map[agent.getRow()][agent.getCol()] == '*') {
                    map[agent.getRow()][agent.getCol()] = 'D';
                } else {
                    map[agent.getRow()][agent.getCol()] = '_';
                }

                agent.setRow(newRow);
                agent.setCol(newCol);

                char targetCell = map[newRow][newCol];
                if (targetCell == 'D') {
                    map[newRow][newCol] = '*'; // Agent stands on dirty
                    agent.setState(1);
                } else {
                    map[newRow][newCol] = '.'; // Agent stands on an empty cell
                    agent.setState(0);
                }
                score -= 10;
            } else {
                score -= 100;
            }
        }
    }

    public void action() {
        int step = 0;
        while (isDone() == false) {
            // Generate a random direction (LEFT, RIGHT, UP, DOWN)
            String[] directions = {"LEFT", "RIGHT", "UP", "DOWN"};
            String randomDirection = directions[random.nextInt(directions.length)];
            // Move in the random direction
            move(randomDirection);
            System.out.println("Step: " + step++ + " Score: " + score);
            printGrid();
        }
        System.out.println("FINISHED CLEAR");
        printGrid();
    }

}
