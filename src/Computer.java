public class Computer extends Player {

    Board board;

    public Computer(String token) {
        super("Computer", token);
        this.board = new Board();
    }

    // Decides where the computer goes.
//    public int determineMove() {
//        int col = (int)(Math.random() * 8);
//        return col;
//    }

    // FIX THISSSS
    // Decides where the computer goes.
//    public int determineMove(Board board) {
//        int column = -1;
//        board.getGrid();
//        for (int col = 0; col < 8; col++) {
//            for (int row = 0; row < 8; row++) {
//                if (board.getGrid()[row][col].equals(token) &&
//                        board.getGrid()[row + 1][col].equals(token) &&
//                        board.getGrid()[row + 2][col].equals(token)) {
//                    board.getGrid()[row + 3][col] = token;
//                }
//            }
//        }
//        for (int col = 0; col < 8; col++) {
//            for (int row = 0; row < 8; row++) {
//                if (board.getGrid()[row][col].equals(token) &&
//                        board.getGrid()[row][col+1].equals(token) &&
//                        board.getGrid()[row][col+2].equals(token)) {
//                    board.getGrid()[row][col+3] = token;
//                }
//            }
//        }
//        return column;
//    }
    public int determineMove(int playerMove) {
        int colNum = -1;
        int rowNum = -1;
        for(int i=0; i<8; i++) {
            colNum = threeInARowVertical(i);
            // Do I need a different parameter?
            colNum = twoInARowVertical(i);
            rowNum = threeInARowHorizontal(i);
            rowNum = twoInARowHorizontal(i);
            if(colNum>-1) {
                break;
            }
            if(rowNum>-1) {
                break;
            }
        }

        //return the column
    }

    public int threeInARowVertical(int colNum) {
        for(int row=0; row<8; row++) {
            if(board.getGrid()[row][colNum].equals("x")) {
                if(row+1>6) {
                    return -1;
                }else if(board.getGrid()[row+1][colNum].equals("x")) {
                    if(row+2>7) {
                        return -1;
                    }else if(board.getGrid()[row+2][colNum].equals("x")) {
                        return colNum;
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }
            if(board.getGrid()[row][colNum].equals("o")) {
                return -1;
            }
        }
        return -1;
    }

    //New parameter different than colNum?
    public int twoInARowVertical(int colNum) {
        for(int row=0; row<8; row++) {
            if(board.getGrid()[row][colNum].equals("x")) {
                if(row+1>6) {
                    return -1;
                }else if(board.getGrid()[row+1][colNum].equals("x")) {
                    if(row+2>7) {
                        return -1;
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }
            if(board.getGrid()[row][colNum].equals("o")) {
                return -1;
            }
        }
        return -1;
    }

    public int threeInARowHorizontal(int rowNum) {
        for(int col=0; col<8; col++) {
            if(board.getGrid()[rowNum][col].equals("x")) {
                if(col+1>6) {
                    return -1;
                }else if(board.getGrid()[rowNum][col+1].equals("x")) {
                    if(col+2>7) {
                        return -1;
                    }else if(board.getGrid()[rowNum][col+2].equals("x")) {
                        return rowNum;
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }
            if(board.getGrid()[rowNum][col].equals("o")) {
                return -1;
            }
        }
        return -1;
    }

    //Different parameter here too?
    public int twoInARowHorizontal(int rowNum) {
        for(int col=0; col<8; col++) {
            if(board.getGrid()[rowNum][col].equals("x")) {
                if(col+1>6) {
                    return -1;
                }else if(board.getGrid()[rowNum][col+1].equals("x")) {
                    if(col+2>7) {
                        return -1;
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }
            if(board.getGrid()[rowNum][col].equals("o")) {
                return -1;
            }
        }
        return -1;
    }
}