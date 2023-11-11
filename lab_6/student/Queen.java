package lab_6.student;

public class Queen {
    private int row;
    private int column;

    public Queen(int row, int column) {
        super();
        this.row = row;
        this.column = column;
    }

    public void move() {
        // Enter your code here
        setRow(row + 1);
        if (row == Node.N) {
            this.row = 0;
        }
    }

    // check whether this Queen can attack the given Queen (q)
    public boolean isConflict(Queen q) {
        // Enter your code here
        // check vertical
        if (this.column == q.getColumn()) return true;
        // check horizontal
        if (this.row == q.getRow()) return true;
        // check diagonal
        if (Math.abs(this.row - q.row) == Math.abs(this.column - q.column)) return true;
        return false;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
