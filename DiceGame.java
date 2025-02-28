import java.util.Scanner;

/**
* The DiceGame program generates a random number between 1 and 6.
* It will then ask the user to guess the number.
* It will keep track of the number of guesses,
* until the user gets the right answer. If the guess is wrong,
* the program will tell the user if the guess was too high or too low.
* It will then tell the user how many guesses it took to get the right answer.

*
* @author Noah Smith
* @version 1.0
* @since 2025-02-26
*/

final class DiceGame {

    /**
    * The maximum value that can be guessed.
    */
    public static final double MAXIMUM_VALUE = 6;

    /**
    * The minimum value that can be guessed.
    */
    public static final double MINIMUM_VALUE = 1;

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private DiceGame() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        // Using Scanner for getting input from user
        Scanner scanner = new Scanner(System.in);

        // Initialize guesses to 1
        int guesses = 1;

        // Initialize user guess to 0
        int userGuess = 0;

        // Greet user
        System.out.println("Welcome to the dice game program!");

        // Generate random number between 1 and 6 inclusive
        // Source: https://www.w3schools.com/java/java_howto_random_number.asp
        int randomInt = (int) (Math.random() * (MAXIMUM_VALUE) + 1);

        do {
            // Ask the user to choose their number
            System.out.println("Guess an integer between 1 and 6 inclusive.");

            try {
                // Get the user's guess from the user as an int
                userGuess = scanner.nextInt();

                if (userGuess <= MAXIMUM_VALUE && userGuess >= MINIMUM_VALUE) {
                    if (userGuess == randomInt) {
                        System.out.println(userGuess
                        + " is the correct answer.");
                        System.out.println("It took you " + guesses
                        + " guesses to get the right answer.");
                    } else {
                        guesses = guesses + 1;
                        if (userGuess < randomInt) {
                            System.out.println("Your guess is incorrect.");
                            System.out.println("Guess higher next time.");
                        } else {
                            System.out.println("Your guess is incorrect.");
                            System.out.println("Guess lower next time.");
                        }
                    }
                } else {
                    System.out.println(
                        "Please enter an integer between 1 and 6 inclusive.");
                }
            } catch (Exception exception) {
                // If the user does not enter an integer
                System.out.println("Please enter an integer.");
                System.out.println("Try again.");

                // Move on to the next line of input
                // to prevent potential infinite loop
                scanner.nextLine();
            }
        } while (userGuess != randomInt);

        // Closing Scanner
        scanner.close();
    }
}
