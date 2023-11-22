import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wordIndex = randomWord();
        String word = words[wordIndex];
        String[] shownWord = wordArray(word);
        int misses = 0;
        StringBuilder incorrectGuesses = new StringBuilder();

        while (misses < 6) {
            System.out.println("Guess The word");
            System.out.println(gallows[misses]);
            System.out.print("Word: ");
            System.out.println(String.join(" ", shownWord));
            System.out.println("Incorrect Guesses: " + incorrectGuesses.toString());
            System.out.print("\nGuess a letter: ");
            String letter = scan.nextLine().toLowerCase();

            if (letter.length() != 1 || !Character.isLetter(letter.charAt(0))) {
                System.out.println("Please enter a valid single letter.");
                continue;
            }

            if (word.contains(letter)) {
                updateShownWord(word, shownWord, letter);
                if (String.join("", shownWord).equals(word)) {
                    System.out.println("Congratulations! You guessed the word: " + word);
                    System.exit(1);
                }
            } else {
                if (!incorrectGuesses.toString().contains(letter)) {
                    incorrectGuesses.append(letter).append(" ");
                    misses++;
                } else {
                    System.out.println("You've already guessed that letter. Try again.");
                }
            }
        }

        System.out.println("Sorry, you've run out of attempts. The word was: " + word);
    }

    public static int randomWord() {
        Random random = new Random();
        return random.nextInt(words.length - 1);
    }

    public static String[] wordArray(String word) {
        String[] charArray = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            charArray[i] = "_";
        }
        return charArray;
    }

    public static void updateShownWord(String word, String[] shownWord, String letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter.charAt(0)) {
                shownWord[i] = letter;
            }
        }
    }
}
