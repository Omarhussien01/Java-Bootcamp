import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");
        String ready = scan.nextLine();
        if (ready.equals("yes")) {
            System.out.println("Great\n");
            System.out.println("rock - paper - scissors , shoot!\n");
            String userChoice = scan.nextLine();
            String computerChoice = computerChoice();
            System.out.println("Computer chose: " + computerChoice);
           
            printResult(userChoice, computerChoice, result(computerChoice, userChoice));

        } else {
            System.out.println("Maybe next time!");
        }

        scan.close();
    }

    public static String computerChoice() {
        Random random = new Random();
        int randomNumber = random.nextInt(3); // Change to 3 to include 0, 1, and 2
        switch (randomNumber) {
            case 0:
                return "rock";

            case 1:
                return "paper";

            case 2:
                return "scissors";

            default:
                return "Invalid";
        }
    }

    public static String result(String computerChoices, String myChoice) {
        if ((myChoice.equals("rock") && computerChoices.equals("scissors")) ||
            (myChoice.equals("scissors") && computerChoices.equals("paper")) ||
            (myChoice.equals("paper") && computerChoices.equals("rock"))) {
            return "You win!";
        } else if ((computerChoices.equals("rock") && myChoice.equals("scissors")) ||
                   (computerChoices.equals("scissors") && myChoice.equals("paper")) ||
                   (computerChoices.equals("paper") && myChoice.equals("rock"))) {
            return "You lose!";
        } else if (computerChoices.equals(myChoice)) {
            return "It's a tie!";
        } else {
            return "Invalid";
        }
    }
    

    public static void printResult(String yourChoice, String computerChoice, String result) {
        System.out.println("You chose: " + yourChoice);
        System.out.println("The computer chose: " + computerChoice);
        System.out.println(result);
    }
}
