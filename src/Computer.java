public class Computer extends Player {

    Board board;

    public Computer(String token) {
        super("Computer", token);
        this.board = new Board();
    }

    // Decides where the computer goes.
    public int determineMove(int playerMove) {
        int colNum = -1;

        // Win if there are three in a row.
        for(int i=0; i<8; i++) {
            if(board.colIsNotFull(i)) {
                colNum = threeInARowVerticalWin(i);
            }
            if(colNum != -1) {
                return colNum;
            }
        }

        for(int j=0; j<8; j++) {
            colNum = threeInARowHorizontalWin(j);
            if(colNum != -1) {
                return colNum;
            }
        }

        // Block if there are three human tokens in a row.
        for(int k=0; k<8; k++) {
            if(board.colIsNotFull(k)) {
                colNum = threeInARowVerticalBlock(k);
            }
            if (colNum != -1) {
                return colNum;
            }
        }

        for(int l=0; l<8; l++) {
            colNum = threeInARowHorizontalBlock(l);
            if (colNum != -1) {
                return colNum;
            }
        }

        // Put down token if there are two in a row.
        for(int m=0; m<8; m++) {
            if(board.colIsNotFull(m)) {
                colNum = twoInARowVerticalWin(m);
            }
            if (colNum != -1) {
                return colNum;
            }
        }

        for(int n=0; n<8; n++) {
            colNum = twoInARowHorizontalWin(n);
            if (colNum != -1) {
                return colNum;
            }
        }

        // Block if there are two human tokens in a row.
        for(int o=0; o<8; o++) {
            if(board.colIsNotFull(o)) {
                colNum = twoInARowVerticalBlock(o);
            }
            if (colNum != -1) {
                return colNum;
            }
        }

        for(int p=0; p<8; p++){
            colNum = twoInARowHorizontalBlock(p);
            if (colNum != -1) {
                return colNum;
            }
        }

        int col = ((int)(Math.random() * 3)) + 1;
        if(col==1 && playerMove-1>-1) {
            return playerMove-1;
        }else if(col==1) {
            return playerMove;
        }
        if(col==2) {
            return playerMove;
        }
        if(col==3 && playerMove+1<8) {
            return playerMove+1;
        }else if(col==3) {
            return playerMove;
        }
        return 1;
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
        }
        return -1;
    }

    public int twoInARowVerticalBlock(int colNum) {
        for(int row=0; row<8; row++) {
            if(board.getGrid()[row][colNum].equals("x")) {
                if(row>6) {
                    return -1;
                }else if(board.getGrid()[row+1][colNum].equals("x")) {
                    if(row+1>7) {
                        return -1;
                    }else{
                        return colNum;
                    }
                }else{
                    return -1;
                }
            }
        }
        return -1;
    }

    public int threeInARowHorizontalBlock(int rowNum) {
        for (int col = 0; col < 8; col++) {
            if (board.getGrid()[rowNum][col].equals("x")) {
                if (col + 1 > 6) {
                    return -1;
                } else if (board.getGrid()[rowNum][col + 1].equals("x")) {
                    if (col + 2 > 7) {
                        return -1;
                    } else if (board.getGrid()[rowNum][col + 2].equals("x")) {
                        if (col + 3 < 7 && board.getGrid()[rowNum][col+3].equals("-")) {
                            if (board.getGrid()[rowNum][col + 3].equals("-") && rowNum==7 || board.getGrid()[rowNum][col + 3].equals("-") && !board.getGrid()[rowNum+1][col+3].equals("-")) {
                                return col + 3;
                            }
                        } else if (col - 1 > 0 && board.getGrid()[rowNum][col-1].equals("-")) {
                            if (board.getGrid()[rowNum][col - 1].equals("-") && rowNum==7 || board.getGrid()[rowNum][col - 1].equals("-") && !board.getGrid()[rowNum+1][col - 1].equals("-")) {
                                return col - 1;
                            }
                        }
                    }
                }
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
                    } else if (col + 2 < 7 && board.getGrid()[rowNum][col+2].equals("-")) {
                        if (board.getGrid()[rowNum][col + 2].equals("-") && rowNum==7 || board.getGrid()[rowNum][col+2].equals("-") && !board.getGrid()[rowNum+1][col+2].equals("-")) {
                            return col + 2;
                        }
                    } else if (col - 1 > 0 && board.getGrid()[rowNum][col-1].equals("-")) {
                        if (board.getGrid()[rowNum][col - 1].equals("-") && rowNum==7 || board.getGrid()[rowNum][col - 1].equals("-") && !board.getGrid()[rowNum+1][col - 1].equals("-")) {
                            return col - 1;
                        }
                    }
                }
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
        }
        return -1;
    }

    public int twoInARowVerticalWin(int colNum) {
        for(int row=0; row<8; row++) {
            if(board.getGrid()[row][colNum].equals("o")) {
                if(row>6) {
                    return -1;
                }else if(board.getGrid()[row+1][colNum].equals("o")) {
                    if(row+1>7) {
                        return -1;
                    }else{
                        return colNum;
                    }
                }else{
                    return -1;
                }
            }
        }
        return -1;
    }

    public int threeInARowHorizontalWin(int rowNum) {
        for(int col=0; col<8; col++) {
            if(board.getGrid()[rowNum][col].equals("o")) {
                if(col+1>6) {
                    return -1;
                }else if(board.getGrid()[rowNum][col+1].equals("o")) {
                    if(col+2>7) {
                        return -1;
                    }else if(board.getGrid()[rowNum][col+2].equals("o")) {
                        if(col+3<7 && board.getGrid()[rowNum][col+3].equals("-")) {
                            if(board.getGrid()[rowNum][col+3].equals("-") && rowNum==7 || board.getGrid()[rowNum][col+3].equals("-") && !board.getGrid()[rowNum+1][col+3].equals("-")) {
                                return col+3;
                            }
                        }else if(col-1>0 && board.getGrid()[rowNum][col-1].equals("-")) {
                            if(board.getGrid()[rowNum][col-1].equals("-") && rowNum==7 || board.getGrid()[rowNum][col-1].equals("-") && !board.getGrid()[rowNum+1][col-1].equals("-")) {
                                return col-1;
                            }
                        }
                    }
                }
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
                    } else if (col + 2 < 7 && board.getGrid()[rowNum][col+2].equals("-")) {
                        if (board.getGrid()[rowNum][col + 2].equals("-") && rowNum==7 || board.getGrid()[rowNum][col + 2].equals("-") && !board.getGrid()[rowNum+1][col + 2].equals("-")) {
                            return col + 2;
                        }
                    } else if (col - 1 > 0 && board.getGrid()[rowNum][col-1].equals("-")) {
                        if (board.getGrid()[rowNum][col - 1].equals("-") && rowNum==7 || board.getGrid()[rowNum][col - 1].equals("-") && !board.getGrid()[rowNum+1][col - 1].equals("-")) {
                            return col - 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

}