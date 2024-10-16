import java.util.*;
public class Game {
    public static Scanner user_input;
    public static Random random_move;
    public static String[] nordic_words = {"ekenabben", "vittsjo", "oxberg", "fjallbo", "jattesta"};
    public static void main(String[] args) {
        user_input = new Scanner(System.in);
        random_move = new Random();
        System.out.println("You'll be prompted to enter 'y' to play a round or 'n' to exit the game. \nIf you choose to play, you and the computer (which will randomly pick an option) \nwill have five possible moves to choose from: \n \nFjallbo, which defeats Jattesta and Vittsjo. \nOxberg, which defeats Ekenabben and Fjallbo. \nVittsjo, which defeats Oxberg and Jattesta. \nJattesta, which defeats Ekenabben and Oxberg. \nEkenabben, which defeats Vittsjo and Fjallbo. \nIn the case of a tie, the computer wins the round. \n\nAfter each round, the result, the user's choice, and the computer's choice will be displayed. \nIf you choose to end the game, the program will show the total number of rounds played, \nas well as the win counts for both the user and the computer.\n");
        player_vs_pc_round();
    }

    public static void player_vs_pc_round() {
        int rounds_played = 0;
        int player_score = 0;
        int computer_score = 0;
        String play_again;

        do {
            System.out.print("Do you want to play a round? Y for yes and N for no: ");
             play_again = user_input.nextLine();
        } while (!play_again.equalsIgnoreCase("y") && !play_again.equalsIgnoreCase("n"));
        

        while (play_again.equalsIgnoreCase("y")) {
            String player_move = player_turn();
            String computer_move = computer_turn();
            System.out.printf("Computer move: %s\n", computer_move);
            rounds_played += 1;

            if (computer_move.equals("ekenabben") && (player_move.equalsIgnoreCase("Vittsjo") || player_move.equalsIgnoreCase("Fjallbo") || player_move.equalsIgnoreCase("Ekenabben"))) {
                computer_score += 1;
            } else if (computer_move.equals("vittsjo") && (player_move.equalsIgnoreCase("Oxberg") || player_move.equalsIgnoreCase("Jattesta") || player_move.equalsIgnoreCase("Vittsjo"))) {
                computer_score += 1;
            } else if (computer_move.equals("oxberg") && (player_move.equalsIgnoreCase("Ekenabben") || player_move.equalsIgnoreCase("Fjallbo") || player_move.equalsIgnoreCase("Oxberg"))) {
                computer_score += 1;
            } else if (computer_move.equals("fjallbo") && (player_move.equalsIgnoreCase("Vittsjo") || player_move.equalsIgnoreCase("Jattesta") || player_move.equalsIgnoreCase("Fjallbo"))) {
                computer_score += 1;
            } else if (computer_move.equals("jattesta") && (player_move.equalsIgnoreCase("Ekenabben") || player_move.equalsIgnoreCase("Oxberg") || player_move.equalsIgnoreCase("Jattesta"))) {
                computer_score += 1;
            } else {
                player_score += 1;
            }
            
            if (Math.max(player_score, computer_score) == computer_score) {
                System.out.println("The computer won this round.");
            } else {
                System.out.println("The player won this round.");
            }
            do { 
                System.out.print("\nDo you want to play again? Y for yes and N for no: ");
                play_again = user_input.nextLine();
            } while (!play_again.equalsIgnoreCase("y") && !play_again.equalsIgnoreCase("n"));
            
        }
        
        if (play_again.equalsIgnoreCase("n")) {
            System.out.printf("Rounds played: %d \nPlayer wins: %d \nComputer wins: %d", rounds_played, player_score, computer_score);
        }
    }

    public static String player_turn() {
        String player_move;
        do {
            System.out.print("Type your move: ");
            player_move = user_input.nextLine().toLowerCase();
        } while (!Arrays.asList(nordic_words).contains(player_move));
            return player_move;
    }

    public static String computer_turn() {
        String computer_move = nordic_words[random_move.nextInt(5)];
        return computer_move;
    }
}