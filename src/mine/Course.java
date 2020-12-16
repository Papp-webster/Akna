package mine;

import javax.swing.*;
import java.awt.*;

public class Course extends JPanel {

    Tile[][] board = new Tile[8][10];


    /**
     * Ez a methodus 10 bombát generál
     */
    public void Mines() {
      int count = 0;
      while(count < 10) {
          int row = (int)(Math.random()* board.length);
          int col = (int)(Math.random()* board[0].length);
          while (board[row][col].isMine) {
              row = (int)(Math.random()* board.length);
              col = (int)(Math.random()* board[0].length);
          }
          System.out.println("add mine: ");
          board[row][col].isMine = true;
          count++;
      }


    }

    public void ShowMines() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col].isMine) {
                    board[row][col].setIcon(new ImageIcon("mine.png"));


                }
            }
        }
       repaint();

    }


    public Course() {

        JFrame frame = new JFrame("Mine detector");
        frame.setSize(600,550);
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

        Mines();
        ShowMines();
    }
}
