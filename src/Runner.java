import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        // Instances of game.
        Human human = new Human("Eliot", "x");
        Computer computer = new Computer("o");
        Scanner sc = new Scanner(System.in);

        System.out.println("What is your name?");
        String username = sc.nextLine();
        computer.board.displayBoard();
        System.out.println("Hello " + username + ". Welcome to Connect 4! A - represents an empty spot. " +
                "x's are your tokens, and o's are the computer's tokens. Please write a number of the column to place your token in.");

        int[] colCount = new int[8];

        // Checks to see if computer won.
        while(!computer.board.determineWin(computer.token)) {

            boolean legalCol = false;
            int moveCol = -1;

            // Human's move.
            while(!legalCol) {

                System.out.println("Enter a column down below.");

                if(sc.hasNextInt()) {
                    moveCol = sc.nextInt()-1;
                    legalCol = true;

                    if(moveCol>7 || moveCol<0) {
                        System.out.println("This is not a valid column. Please enter a new, valid column.");
                        legalCol = false;
                    }

                    if(moveCol<8 && moveCol>0 && !computer.board.colIsNotFull(moveCol)) {
                        System.out.println("This column is full.");
                        legalCol = false;
                    }
                }else{
                    System.out.println("This is not a valid column. Please enter a new, valid column. This has to be an integer from 1-8 (inclusive).");
                    sc.next();
                }

                if(legalCol && computer.board.colIsNotFull(moveCol)) {
                    computer.board.makeMove(moveCol, human.token);
                }
            }

            // Counts the human's number of tokens in each column.
            colCount[moveCol]++;

            // Checks to see if it's a tie.
            boolean tie = true;

            for(int i=0; i<8; i++) {
                if(computer.board.colIsNotFull(i)) {
                    tie = false;
                }
            }
            if(tie) {
                System.out.println("It's a tie.");
                break;
            }

            // Displays board.
            computer.board.displayBoard();
            System.out.println();

            // Checks to see if human won.
            if(computer.board.determineWin(human.token)) {
                break;
            }

            // Computer's move.
            int computerMove = computer.determineMove(moveCol);

            int fullestCol = -1;

            if(computer.board.colIsNotFull(moveCol)) {
                computer.board.makeMove(computerMove, computer.token);
            }else{
                // Keeps track of the fullest column.
                for(int j=0; j<8; j++) {
                    if(colCount[j]>fullestCol && computer.board.colIsNotFull(j)) {
                        fullestCol = j;
                    }
                }
                computer.board.makeMove(fullestCol, computer.token);
            }

            // Counts the computer's number of tokens in each column.
            if(fullestCol!=-1) {
                colCount[fullestCol]++;
            }else{
                colCount[computerMove]++;
            }

            // Displays board.
            computer.board.displayBoard();
        }

        System.out.print("Game over!");
    }
}