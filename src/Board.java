public class Board {

    private int size;
    private String[][] grid;
    private String token;

    public Board() {
        this.size = 8;
        this.grid = new String[size][size];
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                grid[i][j] = "-";
            }
        }
    }

    public String[][] getGrid() {
        return this.grid;
    }

    public int getSize() {
        return size;
    }

    // Prints the board.
    public void displayBoard() {
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    // Places a token in an empty spot.
    public void makeMove(int col, String token) {
        getGrid();
        for (int i = size-1; i >= 0; i--) {
            if (grid[i][col].equals("-")) {
                grid[i][col] = token;
                break;
            }
        }
    }

    // Checks to see if column is not full.
    public boolean colIsNotFull(int col) {
        if(grid[0][col].equals("-")) {
            return true;
        }
        return false;
    }

    public boolean determineWin(String token) {
        boolean ver = determineWinVertical(token);
        boolean hor = determineWinHorizontal(token);
        //boolean diag = determineWinDiagonal(token);
        return ver || hor ;
                //|| diag;
    }

    public boolean determineWinVertical(String token) {
        for(int col=0; col<size; col++) {
            for(int row=0; row<5; row++) {
                if(grid[row][col].equals(token) &&
                        grid[row+1][col].equals(token) &&
                        grid[row+2][col].equals(token) &&
                        grid[row+3][col].equals(token)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean determineWinHorizontal(String token) {
        for(int col=0; col<5; col++) {
            for(int row=0; row<size; row++) {
                if(grid[row][col].equals(token) &&
                        grid[row][col+1].equals(token) &&
                        grid[row][col+2].equals(token) &&
                        grid[row][col+3].equals(token)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* ALBY STUFF
    public boolean checkWin(String token) {
        boolean v = checkWinVertical(token);
        boolean h = checkWinHorizontal(token);
        boolean d = checkWinDiagonal(token);

        return v || h || d;
    }

    public boolean checkWinVertical(String token) {

        for(int col = 0; col < 8; col++) {
            for(int row = 0; row < 5; row++){

                if(grid[row][col].equals(token) &&
                    grid[row+1][col].equals(token) &&
                    grid[row+2][col].equals(token) &&
                    grid[row+3][col].equals(token)) {

                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinHorizontal(String token) {
        return false;
    }

    public boolean checkWinDiagonal(String token) {
        return false;
    }
     */
}