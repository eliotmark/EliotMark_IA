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
                "x's are your tokens, and o's are the computer's tokens. Please indicate a column to place your token in.");


        // Checks to see if computer won.
        while(!computer.board.determineWin(computer.token)) {

            boolean legalCol = false;
            int moveCol = -1;

            // Human's move.
            while(!legalCol) {

                if(sc.hasNextInt()) {
                    moveCol = sc.nextInt()-1;
                    legalCol = true;

                    if(moveCol>8 || moveCol<0) {
                        System.out.println("This is not a valid column. Please enter a new, valid column.");
                        legalCol = false;
                        sc.next();
                    }

                    if(moveCol<8 && !computer.board.colIsNotFull(moveCol)) {
                        System.out.println("This column is full.");
                        legalCol = false;
                        sc.next();
                    }
                }else{
                    System.out.println("This is not a valid column. Please enter a new, valid column.");
                    sc.next();
                }

                if(legalCol && computer.board.colIsNotFull(moveCol)) {
                    computer.board.makeMove(moveCol, human.token);
                }
            }

            // Checks to see if human won.
            if(computer.board.determineWin(human.token)) {
                break;
            }

            // Computer's move.
            int cMove = computer.determineMove();
            computer.board.makeMove(cMove, computer.token);

            // Displays board.
            computer.board.displayBoard();
        }

        System.out.print("Game over!");
    }
}