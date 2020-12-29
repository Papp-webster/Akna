package business_logic;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

//@Author: Papp László


public class Course extends JPanel  {

    Tile[][] board = new Tile[8][10];
    static final Logger naplo = AknaLogging.aknaLogger;

    /**
     * Ez a metodus 10 aknát generál
     */
    public void Mines() {
        naplo.info("Aknák metódus");
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
        naplo.info("Aknát számoló metódus");
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
        naplo.info("Aknát megjelenítő metódus");
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

    /**
     * Itt a pálya méretét beállítom és meghívom a metódusokat.
     */
    public Course() {
        naplo.info("Pálya metódus");
        JFrame frame = new JFrame("Aknakereső");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(8,10));

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                Tile t = new Tile(row, col);
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
