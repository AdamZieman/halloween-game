
/**
 * Name: Adam Zieman
 * Course: CSCI 241 - Computer Science I
 * Section: 001
 * Assignment: 6
 *
 * Project/Class Description:
 * This is a two player game that contains five elements.
 * Each player will be given an element at random.
 * One of these elements will be superior to the other.
 * This is no limit on the amount of rounds played.
 * At the end of the tournament, a summary of player wins
 * will be printed for each player.
 *
 * Known bugs:
 * None
 */

// imports the scanner class
import java.util.Scanner;

public class HalloweenGame {
    public static void main(String args[]) {
        // Declares a variable to standard input
        Scanner keyboard = new Scanner(System.in);

        // Print the game "welcome" message and description of play
        printIntroduction();

        // Ask for two player names
        System.out.print("Please enter the name of player #1: ");
        String player1Name = keyboard.next();
        System.out.print("Please enter the name of player #2: ");
        String player2Name = keyboard.next();

        // Hold a count of the number of games each player wins
        int player1Wins = 0;
        int player2Wins = 0;

        // 
        char playAgain = 'y';

        // 
        while (playAgain == 'y' || playAgain == 'Y') {
            // Selects a random number between 1 and 5 
            int player1Element = draw();

            // Selects a different random number between 1 and 5
            int player2Element = drawDifferentElement(player1Element);

            // Print each players' name and their element
            printElement(player1Name, player1Element);
            printElement(player2Name, player2Element);
            System.out.println();

            // Determines the winner of the round
            int winningPlayer = determineWinner(player1Element, player2Element);
            
            // Increments the winning player's tournament score
            String winningPlayerName = "";
            int winningElement;
            int loosingElement;
            if (winningPlayer == 1) {
                player1Wins++;
                winningPlayerName = player1Name;
                winningElement = player1Element;
                loosingElement = player2Element;
            }
            else {
                player2Wins++;
                winningPlayerName = player2Name;
                winningElement = player2Element;
                loosingElement = player1Element;
            }

            // Prints the winner's phrase and who won
            reportResults(winningPlayerName, winningElement, loosingElement);
            System.out.println("==========================================");

            // Asks the user if they would like to play another round
            System.out.print("Want to play again (Y/N)? ");
            playAgain = keyboard.next().charAt(0);
        }

        // Calculate the amount of games played, won by each player, and their win percentage
        printSummary(player1Name, player1Wins, player2Name, player2Wins);
    }

    // Print the game "welcome" message and description of play
    public static void printIntroduction() {
        System.out.println("=================================================================");
        System.out.println("Welcome to the Boulder, Scroll, Knife, Witch's Brew, Monster Game!");
        System.out.println("This game requires 2 players.");
        System.out.println("You will be asked for each player's name.");
        System.out.println("Your tournament can contain as many games as you like.");
        System.out.println("=================================================================");
    }

    // Selects a random number between 1 and 5
    public static int draw() {
        // Generates the first random integer
        int randomNum = (int)(Math.random() * 5) + 1;

        return randomNum;
    }

    // Selects a different random number between 1 and 5
    public static int drawDifferentElement(int firstNum) {
        int randomNum2;

        // Generates the second random integer
        do {
            randomNum2 = draw();
        } while (firstNum == randomNum2);

        return randomNum2;
    }

    // Print the player's name and their element
    public static void printElement(String playerName, int elementNum) {
        String elementObj = "";

        // Assigns the appropriate element to the respective number
        switch (elementNum) {
            case 1: elementObj = "BOULDER";
            break;
            case 2: elementObj = "SCROLL";
            break;
            case 3: elementObj = "KNIFE";
            break;
            case 4: elementObj = "BREW";
            break;
            case 5: elementObj = "MONSTER";
        }

        System.out.println(playerName + " has the " + elementObj);
    }
    
    // Determines the winner of the round
    public static int determineWinner(int p1Element, int p2Element) {
        int roundWinner;
        
        // All possible solutions for player1 to win
        // boulder vs knife
        if (p1Element == 1 && p2Element == 3)
            roundWinner = 1;
        // boulder vs monster
        else if (p1Element == 1 && p2Element == 5)
            roundWinner = 1;
        // scroll vs boulder
        else if (p1Element == 2 && p2Element == 1)
            roundWinner = 1;
        // scroll vs brew
        else if (p1Element == 2 && p2Element == 4)
            roundWinner = 1;
        // knife vs scroll
        else if (p1Element == 3 && p2Element == 2)
            roundWinner = 1;
        // knife vs monster
        else if (p1Element == 3 && p2Element == 5)
            roundWinner = 1;
        // brew vs boulder
        else if (p1Element == 4 && p2Element == 1)
            roundWinner = 1;
        // brew vs knife
        else if (p1Element == 4 && p2Element == 3)
            roundWinner = 1;
        // monster vs scroll
        else if (p1Element == 5 && p2Element == 2)
            roundWinner = 1;
        // monster vs brew
        else if (p1Element == 5 && p2Element == 4)
            roundWinner = 1;
        // if player1 did not win, then player2 won
        else
            roundWinner = 2;
        
        return roundWinner;
    }
    
    // Prints the winner's phrase and who won
    public static void reportResults(String roundWinnerName, int winnerElement, int looserElement) {
        // boulder vs knife
        if (winnerElement == 1 && looserElement == 3)
            System.out.println("Boulder crushes knife!");
        // boulder vs monster
        else if (winnerElement == 1 && looserElement == 5)
            System.out.println("Boulder injures monster!");
        // scroll vs boulder
        else if (winnerElement == 2 && looserElement == 1)
            System.out.println("Scroll hides boulder!");
        // scroll vs brew
        else if (winnerElement == 2 && looserElement == 4)
            System.out.println("Scroll covers witch's brew!");
        // knife vs scroll
        else if (winnerElement == 3 && looserElement == 2)
            System.out.println("Knife cuts scroll!");
        // knife vs monster
        else if (winnerElement == 3 && looserElement == 5)
            System.out.println("Knife stabs monster!");
        // brew vs boulder
        else if (winnerElement == 4 && looserElement == 1)
            System.out.println("Boulder falls into witch's brew!");
        // brew vs knife
        else if (winnerElement == 4 && looserElement == 3)
            System.out.println("Witch's brew disintegrates knife!");
        // monster vs scroll
        else if (winnerElement == 5 && looserElement == 2)
            System.out.println("Monster eats scroll!");
        // monster vs brew
        else if (winnerElement == 5 && looserElement == 4)
            System.out.println("Monster drinks witch's brew!");
            
        System.out.println(roundWinnerName + " is the winner.");
    }
    
    // Calculate the amount of games played, won by each player, and their win percentage
    public static void printSummary(String p1NameParam, int p1WinsParam, String p2NameParam, int p2WinsParam) {
        // Calculate the total amount of games played
        double totalGames = p1WinsParam + p2WinsParam;
        
        // Calculate each players' win percentage
        double p1WinPercent = (p1WinsParam / totalGames) * 100;
        double p2WinPercent = (p2WinsParam / totalGames) * 100;
        
        // 
        System.out.println("\n*************************************************");
        System.out.println(Math.round(totalGames) + " total games were played during the tournament.");
        System.out.println("Number of games won by each player:");
        
        System.out.printf("%10s%s%4d%3s%.1f%s\n", p1NameParam, ":", p1WinsParam, "(", p1WinPercent, "%)");
        System.out.printf("%10s%s%4d%3s%.1f%s\n", p2NameParam, ":", p2WinsParam, "(", p2WinPercent, "%)");
    }
}
