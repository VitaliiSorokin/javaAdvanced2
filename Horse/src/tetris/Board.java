package tetris;

public class Board {
    private boolean[][] board = new boolean[10][8];


    public Board() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = false;
            }
        }
    }

}
