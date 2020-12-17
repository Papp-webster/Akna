package mine;

import javax.swing.*;
import java.awt.*;


public class Course extends JPanel  {

    Tile[][] board = new Tile[8][10];


    /**
     * Ez a metodus 10 aknát generál
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
          board[row][col].isMine = true;
          count++;
      }


    }

    /**
     * Megszámolja a hány akna van a közelben
     */


    public void CountMines(int rows, int column) {
        if(!board[rows][column].isMine) return;

        for (int  row = rows - 1; row <= rows + 1; row++){
            for (int  columns = column - 1; columns <= column + 1; columns++){
                try {
                    board[row][columns].count++;
                } catch(Exception e) {
                    //Semmit nem csínál ha túl lépi a határt.
                }
        }
        }
    }

    public void MineCount() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                CountMines(row, col);
               }
            }

    }

    /**
     * Megmutatja az aknákat és hogy mennyi akna van a közelben
     */

    public void ShowMines() {
        for (Tile[] tiles : board) {
            for (int col = 0; col < board[0].length; col++) {
                if (tiles[col].isMine) {
                    tiles[col].setIcon(new ImageIcon("mine.png"));


                } else if (tiles[col].count == 0) {

                    tiles[col].setEnabled(false);
                } else {
                    tiles[col].setText(tiles[col].getCount() + "");
                }
            }
        }
       repaint(); // ez a metodus kitisztítja az előző ablakot és felülírja

    }


    public Course() {

        JFrame frame = new JFrame("Aknakereső");
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


        Mines();
        MineCount();
        ShowMines();
        frame.setVisible(true);



    }


}
