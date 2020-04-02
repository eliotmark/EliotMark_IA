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

    // FIX THIS
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

    // Are duplicates bad? They show up as an error in the code but seem okay?
    public int determineMove(int playerMove) {
        int colNum = -1;

        // Win if there are three in a row.
        for(int i=0; i<8; i++) {
            colNum = threeInARowVerticalWin(i);
            if(colNum != -1) {
                break;
            }
        }

        for(int j=0; j<8; j++) {
            colNum = threeInARowHorizontalWin(j);
            if(colNum != -1) {
                break;
            }
        }

        // Block if there are three human tokens in a row.
        for(int k=0; k<8; k++) {
            colNum = threeInARowVerticalBlock(k);
            if (colNum != -1) {
                break;
            }
        }

        for(int l=0; l<8; l++) {
            colNum = threeInARowHorizontalBlock(l);
            if (colNum != -1) {
                break;
            }
        }

        // Put down token if there are two in a row.
        for(int m=0; m<8; m++) {
            colNum = twoInARowVerticalWin(m);
            if (colNum != -1) {
                break;
            }
        }

        for(int n=0; n<8; n++) {
            colNum = twoInARowHorizontalWin(n);
            if (colNum != -1) {
                break;
            }
        }

        // Block if there are two human tokens in a row.
        for(int o=0; o<8; o++) {
            colNum = twoInARowVerticalBlock(i);
            if (colNum != -1) {
                break;
            }
        }

        for(int p=0; p<8; p++){
            colNum = twoInARowHorizontalBlock(p);
            if (colNum != -1) {
                break;
            }
        }
        return colNum;
    }

    // Methods to block human.
    public int threeInARowVerticalBlock(int colNum) {
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

    public int twoInARowVerticalBlock(int colNum) {
        for(int row=0; row<8; row++) {
            if(board.getGrid()[row][colNum].equals("x")) {
                if(row+1>6) {
                    return -1;
                }else if(board.getGrid()[row+1][colNum].equals("x")) {
                    if(row+2>7) {
                        return -1;
                    }else{
                        return colNum;
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

    public int threeInARowHorizontalBlock(int rowNum) {
        for(int col=0; col<8; col++) {
            if(board.getGrid()[rowNum][col].equals("x")) {
                if(col+1>6) {
                    return -1;
                }else if(board.getGrid()[rowNum][col+1].equals("x")) {
                    if(col+2>7) {
                        return -1;
                    }else if(board.getGrid()[rowNum][col+2].equals("x")) {
                        if(col+3<7) {
                            if(board.getGrid()[rowNum][col+3].equals("-") && !board.getGrid()[rowNum][col+3].equals("-")) {
                                return col+3;
                            }
                        }else if(col-1>0) {
                            if(board.getGrid()[rowNum][col-1].equals("-") && !board.getGrid()[rowNum][col-1].equals("-")) {
                                return col-1;
                            }
                        }
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

    public int twoInARowHorizontalBlock(int rowNum) {
        for(int col=0; col<8; col++) {
            if (board.getGrid()[rowNum][col].equals("x")) {
                if (col + 1 > 6) {
                    return -1;
                } else if (board.getGrid()[rowNum][col + 1].equals("x")) {
                    if (col + 2 > 7) {
                        return -1;
                    } else if (col + 2 < 7) {
                        if (board.getGrid()[rowNum][col + 2].equals("-") && !board.getGrid()[rowNum][col + 2].equals("-")) {
                            return col + 3;
                        }
                    } else if (col - 1 > 0) {
                        if (board.getGrid()[rowNum][col - 1].equals("-") && !board.getGrid()[rowNum][col - 1].equals("-")) {
                            return col - 1;
                        }
                    }
                }
            } else {
                return -1;
            }
            if (board.getGrid()[rowNum][col].equals("o")) {
                return -1;
            }
        }
        return -1;
    }

    // Methods to win against human.
    public int threeInARowVerticalWin(int colNum) {
        for(int row=0; row<8; row++) {
            if(board.getGrid()[row][colNum].equals("o")) {
                if(row+1>6) {
                    return -1;
                }else if(board.getGrid()[row+1][colNum].equals("o")) {
                    if(row+2>7) {
                        return -1;
                    }else if(board.getGrid()[row+2][colNum].equals("o")) {
                        return colNum;
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }
            if(board.getGrid()[row][colNum].equals("x")) {
                return -1;
            }
        }
        return -1;
    }

    public int twoInARowVerticalWin(int colNum) {
        for(int row=0; row<8; row++) {
            if(board.getGrid()[row][colNum].equals("o")) {
                if(row+1>6) {
                    return -1;
                }else if(board.getGrid()[row+1][colNum].equals("o")) {
                    if(row+2>7) {
                        return -1;
                    }else{
                        return colNum;
                    }
                }else{
                    return -1;
                }
            }
            if(board.getGrid()[row][colNum].equals("x")) {
                return -1;
            }
        }
        return -1;
    }

    //There are duplicates.. is this bad?
    public int threeInARowHorizontalWin(int rowNum) {
        for(int col=0; col<8; col++) {
            if(board.getGrid()[rowNum][col].equals("o")) {
                if(col+1>6) {
                    return -1;
                }else if(board.getGrid()[rowNum][col+1].equals("o")) {
                    if(col+2>7) {
                        return -1;
                    }else if(board.getGrid()[rowNum][col+2].equals("o")) {
                        if(col+3<7) {
                            if(board.getGrid()[rowNum][col+3].equals("-") && !board.getGrid()[rowNum][col+3].equals("-")) {
                                return col+3;
                            }
                        }else if(col-1>0) {
                            if(board.getGrid()[rowNum][col-1].equals("-") && !board.getGrid()[rowNum][col-1].equals("-")) {
                                return col-1;
                            }
                        }
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }
            if(board.getGrid()[rowNum][col].equals("x")) {
                return -1;
            }
        }
        return -1;
    }

    public int twoInARowHorizontalWin(int rowNum) {
        for(int col=0; col<8; col++) {
            if (board.getGrid()[rowNum][col].equals("o")) {
                if (col + 1 > 6) {
                    return -1;
                } else if (board.getGrid()[rowNum][col + 1].equals("o")) {
                    if (col + 2 > 7) {
                        return -1;
                    } else if (col + 2 < 7) {
                        if (board.getGrid()[rowNum][col + 2].equals("-") && !board.getGrid()[rowNum][col + 2].equals("-")) {
                            return col + 3;
                        }
                    } else if (col - 1 > 0) {
                        if (board.getGrid()[rowNum][col - 1].equals("-") && !board.getGrid()[rowNum][col - 1].equals("-")) {
                            return col - 1;
                        }
                    }
                }
            } else {
                return -1;
            }
            if (board.getGrid()[rowNum][col].equals("x")) {
                return -1;
            }
        }
        return -1;
    }
}