package lab_1.task_3;

public class Agent {
    private int row;
    private int col;
    private int state;
    public Agent(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }
    public int getState() {
        return row;
    }
    public void setState(int state) {
        this.row = row;
    }
    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
