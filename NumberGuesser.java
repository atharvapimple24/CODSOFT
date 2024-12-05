import java.util.Scanner;
import java.util.Random;

public class NumberGuesser {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        while(playAgain){
            int lb = 1;
            int ub = 100;
            int randomNumber = random.nextInt(ub - lb +1)+lb;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrect = false;

            System.out.println("The generated number is between "+lb+" to "+ub);
            System.out.println("You have "+maxAttempts+" guess the number correctly");

            while(attempts<maxAttempts && !guessedCorrect){
                System.out.println("Enter to guess a number:");
                int userNumber = scanner.nextInt();
                attempts++;

                if(userNumber == randomNumber){
                    guessedCorrect = true;
                    System.out.println("Congratulations, you have guess the number in "+attempts+" attempts");
                    totalScore = (maxAttempts - attempts + 1);
                }
                else if(userNumber < randomNumber){
                    System.out.println("You are low, try again");
                }
                else{
                    System.out.println("You are high, try again");
                }
            }
            if(!guessedCorrect){
                System.out.println("Sorry, but you have lost the correct number was :"+randomNumber);
            }
            System.out.println("Your current score is "+totalScore);

            System.out.println("Do you want another round (y/n):");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("y");
        }
        System.out.println("Thank you for playing, your final score is "+totalScore);
        scanner.close();
    }
}
