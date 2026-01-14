// importing the scanner and Random class
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    //Creating a scanner object for input
    static Scanner scan=new Scanner(System.in);
    //Creating a Random object for generating random numbers
    static Random random=new Random();

    //Method to take single character input from the user and converting it to a lower case
    static char choice(){
        return scan.next().toLowerCase().charAt(0);
    }
    //Method to generate a random number between 1 and 10
    static int random_1(){
        return random.nextInt(1,11);
    }
    // Method to let user guess the number
    static int guess(int random_num) {

        int number=0;
        int attempt=0;
        // Only two attempts
        for (int i = 0; i < 2; i++) {
            //Using loop to verify that user enters only numbers not letters or characters
            while (!scan.hasNextInt()) {
                System.out.print("Enter the number not letters or characters: ");
                scan.next();
            }
            number = scan.nextInt();
            attempt++;  //Counts the valid attempt

            //Checks if guessed number matches the random number
            if(number==random_num){
                break;
            }
            // Give hints to user if the number is high
            else if (number > random_num) {
                System.out.print("\nYour guessed number is too high.\n ");
            }
            //Give hints to user if the number is low
            else if (number < random_num) {
                System.out.print("\nYour guessed number is too low. \n");
            }
            //Display the number of attempts
            if(i<1){
                System.out.println("You have "+ attempt + " attempt remaining.");
                System.out.print("Guess again: ");
            }
        }
        return number;
    }

    public static void main(String[] args) throws InterruptedException {

        char choice_1;
        int random_num = 0;

        //Game description
        System.out.println("\nThis is a number guessing game where you have to guess the number from 1 to 10."
                + "\nThe numbers from 1 to 10 are generated randomly." +
                "\nYou have only two attempts.");
//Asking user to start the game and if they do not press y the game will not start
        do {
            System.out.print("\nEnter 'y' to start the game: ");
            choice_1 = choice(); //calling the method choice to take the input from the user
        }
        while (choice_1 != 'y');

        //Asking user to randomly generate the number and if they do not press r, it will keep asking to press r to generate the number

        do {
            System.out.print("\nEnter 'r' to randomly generate the number: ");
            choice_1 = choice(); //calling the method choice to take the input from the user
        }
        while (choice_1 != 'r');

//Condition if a person choose r, the code will generate random number between 1 and 10
        if (choice_1 == 'r') {
            random_num = random_1();
            System.out.println("\nThe random number has been generated #.");
        }
        System.out.println("You have two attempts remaining.");
        System.out.print("Guess the number: ");

        //Calling the guess method
        int guess_bermunda=guess(random_num);
        //Checks if user guessed correctly and prints congratulations message
        if (guess_bermunda == random_num) {

            System.out.println("\nCongratulations! You have guessed the number which is " + random_num + ".");

        } else {
            // Prints the message if user cannot guess the number after two attempts.
            System.out.println("\nYou lost. The random number is " + random_num + ".");
        }
    }
}
