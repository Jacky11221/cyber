import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static String currentOpposer;
    private static String currentPlayer;
    private static final ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name player 1:");
        Player player1 = new Player(scanner.nextLine());

        System.out.println("What is your name player 2:");
        Player player2 = new Player(scanner.nextLine());

        printStats(player1,player2);

        Card.generateCards();
        gameLoop(player1,player2,scanner);

        System.out.println("gg");
    }

    public static int getRandom(int range){
        return ((int)(Math.random()*range) + 1);
    }

    public static void doFiftyFifty(Player player1, Player player2){
        int coinTossNotAScam = getRandom(101);

        if(coinTossNotAScam > 50) {
            players.add(player1);
            players.add(player2);
        }
        else {
            players.add(player2);
            players.add(player1);
        }

        System.out.println("\n" + players.getFirst().getName() + " goes first\n");
    }

    public static void gameLoop(Player player1, Player player2, Scanner scanner){
        int index = 0;

        doFiftyFifty(player1, player2);

        while (player1.getHealthStat() > 0 && player2.getHealthStat() > 0) {
            index = speedCheck(index);
            switchRoles(index);

            printOptions();
            int playerInput = get_input(scanner);

            switch (playerInput) {
                case 1 -> attackSequence(index);
                case 2 -> players.get(index).addCard(Card.getCard());
                case 0 -> System.out.println("You failed to flee");
//                case 3 -> System.out.println("Shows inventory");
                default -> System.out.println("Not a valid option, forfeited turn");
            }
            System.out.println("\n\n");

            player1.statCheck();
            player2.statCheck();

            if(index == 1) index = 0;
            else index++;

            System.out.println("________________________________________________________");
            printStats(player1,player2);

        }
    }

    public static void attackSequence(int index){
        if(index == 0) {
            players.get(index).attack(players.get(index + 1));
        }
        else {
            players.get(index).attack(players.get(index - 1));
        }
    }

    public static void printOptions(){
        System.out.println();
        System.out.println(currentPlayer + ", here are your options:");
        System.out.println("1. hit " + currentOpposer);
        System.out.println("2. draw card");
        System.out.println("3. flee");
//        System.out.println("4. show inventory");
    }

    public static int speedCheck(int index){
        if (players.getLast().getSpeed() > players.getFirst().getSpeed()){
            players.addFirst(players.getLast());
            players.removeLast();
            index = 0;
        }
        return index;
    }

    public static void switchRoles(int index){
        if(index == 0) {
            currentOpposer = players.getLast().getName();
            currentPlayer = players.getFirst().getName();
        }
        else {
            currentOpposer = players.getFirst().getName();
            currentPlayer = players.getLast().getName();
        }
    }

    public static void printStats(Player player1, Player player2){
        System.out.println(player1.getStats());
        System.out.println(player2.getStats());
    }

    public static int get_input(Scanner s){
        System.out.print("Choose (numeric values only): ");
        String option = s.nextLine();

        return switch (option) {
            case "1" -> 1;
            case "2" -> 2;
            case "3" -> 0;
            case "4" -> 3;
            case null, default -> 153245;
        };
    }
}