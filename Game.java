import java.util.*;

public class Game {
    private static Scanner user_input;
    private static Random random_move;
    public static void main(String[] args) {
        user_input = new Scanner(System.in);
        random_move = new Random();
        System.out.println("You'll be asked to enter y to play a round or n to quit the game. \nif you play a round, you and the computer (which will make \na random selection) will have 5 moves to choose from: \n \nFjallbo, which beats Jattesta and Vittsjo. \nOxberg, which beats Ekenabben and Fjallbo. \nVittsjo, which beats Oxberg and Jattesta. \nJattesta, which beats Ekenabben and Oxberg. \nEkenabben, which beats Vittsjo and Fjallbo. \nThe computer wins the round in the event of a tie. \n\nAt the end of each round, the round winner, the user input, and the \ncomputer input will be printed. If you decide to quit the game, \nthe program will print the number of rounds played, as well as \nthe number of times that the user or the computer won.\n");
        game_round();
    }

    public static String game_round() {
        int rounds_played = 0;
        int player_score = 0;
        int computer_score = 0;

        System.out.print("Do you want to play a round? Y for yes and N for no: ");
        String yes_or_no = user_input.nextLine();

        while (yes_or_no.equalsIgnoreCase("y")) {
            String player_move = player_turn();
            String computer_move = computer_turn();
            System.out.printf("Computer move: %s\n", computer_move);
            rounds_played += 1;

            //Ekenabben > Vittsjo, Fjallbo
            //Vittsjo > Oxberg, Jattesta
            //Oxberg > Ekenabben, Fjallbo
            //Fjallbo > Vittsjo, Jattesta
            //Jattesta > Ekenabben, Oxberg
            if (computer_move.equals("Ekenabben") && (player_move.equalsIgnoreCase("Vittsjo") || player_move.equalsIgnoreCase("Fjallbo") || player_move.equalsIgnoreCase("Ekenabben"))) {
                computer_score += 1;
            } else if (computer_move.equals("Vittsjo") && (player_move.equalsIgnoreCase("Oxberg") || player_move.equalsIgnoreCase("Jattesta") || player_move.equalsIgnoreCase("Vittsjo"))) {
                computer_score += 1;
            } else if (computer_move.equals("Oxberg") && (player_move.equalsIgnoreCase("Ekenabben") || player_move.equalsIgnoreCase("Fjallbo") || player_move.equalsIgnoreCase("Oxberg"))) {
                computer_score += 1;
            } else if (computer_move.equals("Fjallbo") && (player_move.equalsIgnoreCase("Vittsjo") || player_move.equalsIgnoreCase("Jattesta") || player_move.equalsIgnoreCase("Fjallbo"))) {
                computer_score += 1;
            } else if (computer_move.equals("Jattesta") && (player_move.equalsIgnoreCase("Ekenabben") || player_move.equalsIgnoreCase("Oxberg") || player_move.equalsIgnoreCase("Jattesta"))) {
                computer_score += 1;
            } else {
                player_score += 1;
            }
            
            if (Math.max(player_score, computer_score) == computer_score) {
                System.out.println("The computer won this round.");
            } else {
                System.out.println("The player won this round.");
            }
            System.out.print("\nDo you want to play a round? Y for yes and N for no: ");
            yes_or_no = user_input.nextLine();
        }
        
        if (yes_or_no.equalsIgnoreCase("n")) {
            System.out.printf("Rounds played: %d \nTimes the player won: %d \nTimes the computer won: %d", rounds_played, player_score, computer_score);
        }
        return yes_or_no;
    }

    public static String computer_turn() {
        int computer_move = random_move.nextInt(5);
        String nordic_word = "";

        if (computer_move == 0) {
            nordic_word = "Ekenabben";
        } else if (computer_move == 1) {
            nordic_word = "Vittsjo";
        } else if (computer_move == 2) {
            nordic_word = "Oxberg";
        } else if (computer_move == 3) {
            nordic_word = "Fjallbo";
        } else if (computer_move == 4) {
            nordic_word = "Jattesta";
        }
        return nordic_word;
        // 0 = Ekenabben, 1 = Vittsjo, 2 = Oxberg, 3 = Fjallbo, 4 = Jattesta
    }

    public static String player_turn() {
        String player_move;
        do {
            System.out.print("Type your move: ");
            player_move = user_input.nextLine();
        } while (!player_move.equalsIgnoreCase("Ekenabben") && !player_move.equalsIgnoreCase("Vittsjo") && !player_move.equalsIgnoreCase("Oxberg") && !player_move.equalsIgnoreCase("Fjallbo") && !player_move.equalsIgnoreCase("Jattesta"));
            return player_move;
    }
}