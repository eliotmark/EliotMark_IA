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
        boolean diag = determineWinDiagonal(token);
        return ver || hor || diag;
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

    public boolean determineWinDiagonal(String token) {
        // Top left down right.
        for(int row=0; row<5; row++) {
            for(int col=0; col<5; col++) {
                if(grid[row][col].equals(token) &&
                        grid[row+1][col+1].equals(token) &&
                        grid[row+2][col+2].equals(token) &&
                        grid[row+3][col+3].equals(token)) {
                    return true;
                }
            }
        }

        // Top right down left.
        for(int row=0; row<5; row++) {
            for(int col=7; col>2; col--) {
                if(grid[row][col].equals(token) &&
                        grid[row+1][col-1].equals(token) &&
                        grid[row+2][col-2].equals(token) &&
                        grid[row+3][col-3].equals(token)) {
                    return true;
                }
            }
        }

        // Bottom left up right.
        for(int row=7; row>5; row--) {
            for(int col=0; col<5; col++) {
                if(grid[row][col].equals(token) &&
                        grid[row-1][col+1].equals(token) &&
                        grid[row-2][col+2].equals(token) &&
                        grid[row-3][col+3].equals(token)) {
                    return true;
                }
            }
        }

        // Bottom right up left.
        for(int row=7; row>5; row--) {
            for(int col=7; col>2; col--) {
                if(grid[row][col].equals(token) &&
                        grid[row-1][col-1].equals(token) &&
                        grid[row-2][col-2].equals(token) &&
                        grid[row-3][col-3].equals(token)) {
                    return true;
                }
            }
        }

        return false;
    }
}