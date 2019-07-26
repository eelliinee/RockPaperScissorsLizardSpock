
package rockpaperscissorslizardspock;

/**
 *
 * @author Eline
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class RockPaperScissorsLizardSpock {
    // initialize variables for the game options and the hashmap for game logic.
    private static final String ROCK = "rock"; 
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";
    private static final String LIZARD = "lizard";
    private static final String SPOCK = "spock";
    private static final HashMap<String, String[]> WIN = new HashMap<String, String[]>();
    
    // randomly calculate the computer choice
    public static String getComputerChoice() {
        int num = (int) Math.floor(Math.random() * 5);//1.0
        switch (num) {
            case 0:
                return ROCK;
            case 1:
                return PAPER;
            case 2:
                return SCISSORS;
            case 3:
                return LIZARD;
            case 4:
                return SPOCK;
            default:
                return "error";
        }
    }
    
    public static void computerWon() {
        System.out.println("Computer won!");
    }
    
    public static void userWon() {
        System.out.println("You won!");
    }
    
    // determine the winner using computer choice and user choice (with easter egg)
    public static void determineWinner(String userChoice, String computerChoice) {
       
        if (userChoice.equals("bom")) {
            System.out.println("You annihilated the computer!");
        } else if (!WIN.containsKey(userChoice)) {
            System.out.println("Error");
        } else if (userChoice.equals(computerChoice)){
            System.out.println("It\'s a tie!");
        } else if (Arrays.asList(WIN.get(userChoice)).contains(computerChoice)) {
            userWon();
        } else {
            computerWon();
        } 
        
        
    }
    
    
    
    
    public static void main(String[] args) {
        // put game logic in hashmap
        WIN.put(ROCK, new String[] {SCISSORS, LIZARD});
        WIN.put(PAPER, new String[] {ROCK, SPOCK});
        WIN.put(SCISSORS, new String[] {PAPER, LIZARD});
        WIN.put(LIZARD, new String[] {SPOCK, PAPER});
        WIN.put(SPOCK, new String[] {SCISSORS, ROCK});
        System.out.println(WIN);
        // print instruction for user
        System.out.println("Enter \"exit\" to stop game.");
        
        // game behavior
        while (true) {
            String computerChoice = getComputerChoice();
            Scanner input = new Scanner(System.in);    
            System.out.print("Enter rock, paper, scissors, lizard or spock: ");
            String userInput = input.next();
            if (userInput.equals("exit")) {
                break;
            }
            System.out.println("Computer chose: " + computerChoice);
            determineWinner(userInput, computerChoice);
            
        }
    }
}
