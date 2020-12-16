package mine;
import javax.swing.*;


public class Tile extends JButton{

    int rows,column; // A kocka poziciója
    int count;
    boolean isMine;



    public Tile(int row, int column) {
        this.rows = row;
        this.column = column;

    }

    public int getRow() {
        return rows;
    }

    public void setRow(int row) {
        this.rows = row;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
