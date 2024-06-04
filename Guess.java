import java.util.Random;
import java.util.Scanner;


public class Guess {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 2;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totScore = 0;

        System.out.println("GUESS THE NUMBER -GAME");
        //System.out.println("Total Number Of Rounds : 3");
        System.out.println(" No of Attempts To Guess a Number In Each Round : 10\n");
        for (int i = 1; i <= MAX_ROUNDS; i++) {
            int number = random.nextInt(MAX_RANGE) + MIN_RANGE;
            int attempts = 0;

            System.out.printf("ROUND %d:\n Guess the number between %d and %d in %d attempts.\n", i, MIN_RANGE, MAX_RANGE,
                    MAX_ATTEMPTS);
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess : ");
                int guess_number = scanner.nextInt();
                attempts = attempts + 1;

                if (guess_number == number) {
                    int score = MAX_ATTEMPTS - attempts;
                    totScore = totScore + score;
                    System.out.printf("  ******************Hurray! YOU HAVE GUESSED THE CORRECT NUMBER. **************************\n Round Score = %d\n",
                             score);
                    break;
                }

                else if (guess_number < number) {
                    System.out.printf("The number is greater than %d. Attempts Left = %d.\n", guess_number,
                            MAX_ATTEMPTS - attempts);
                }

                else if (guess_number > number) {
                    System.out.printf("The number is less than %d. Attempts Left = %d.\n", guess_number,
                            MAX_ATTEMPTS - attempts);
                }

            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.printf("\nRound = %d\n", i);
                System.out.println("Attempts = 0");
                System.out.printf("The Random Number Is : %d\n\n", number);
            }
        }
        System.out.printf(" Total Score = %d\n", totScore);
        System.out.printf("*GAME OVER*");

        scanner.close();
    }
}