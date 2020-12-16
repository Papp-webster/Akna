package mine;

import javax.swing.JFrame;
import java.awt.*;

public class Course {

    Tile[][] board = new Tile[8][10];

    public Course() {

        JFrame frame = new JFrame("Minedetector");
        frame.setSize(60,55);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(8,10));
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                Tile t= new Tile(row, col);
                frame.add(t);
                board[row][col] = t;
            }
        }

        frame.setVisible(true);


    }
}
