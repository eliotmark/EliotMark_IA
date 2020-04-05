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
                    System.out.println("Enter a column.");

                    if(moveCol>7 || moveCol<0) {
                        System.out.println("This is not a valid column. Please enter a new, valid column.");
                        legalCol = false;
                    }

                    if(moveCol<8 && moveCol>0 && !computer.board.colIsNotFull(moveCol)) {
                        System.out.println("This column is full.");
                        legalCol = false;
                    }
                }else{
                    System.out.println("This is not a valid column. Please enter a new, valid column.");
                    sc.next();
                }

                if(legalCol && computer.board.colIsNotFull(moveCol)) {
                    computer.board.makeMove(moveCol, human.token);
                }
            }

            // Checks to see if it's a tie. --- Is there a way to do think without having a really long if statement?
            if(computer.board.getGrid()[0][0].equals("x") || computer.board.getGrid()[0][moveCol].equals("o")) {
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
            computer.board.makeMove(computerMove, computer.token);

            // Displays board.
            computer.board.displayBoard();
        }

        System.out.print("Game over!");
    }
}