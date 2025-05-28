import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name player 1:");
        Player player1 = new Player(scanner.nextLine());

        System.out.println("What is your name player 2:");
        Player player2 = new Player(scanner.nextLine());

        printStats(player1,player2);

        gameLoop(player1,player2,scanner);

        System.out.println("gg");
    }

    public static int getRandom(int range){
        return ((int)(Math.random()*range) + 1);
    }

    public static void gameLoop(Player player1, Player player2, Scanner scanner){
        int fiftyfifty = getRandom(101);
        int index = 0;
        ArrayList<Player> players = new ArrayList<>();

        if(fiftyfifty > 50) {
            players.add(player1);
            players.add(player2);
        }
        else {
            players.add(player2);
            players.add(player1);
        }

        System.out.println(players.getFirst().getName() + " goes first");

        while (player1.getHealthStat() > 0 && player2.getHealthStat() > 0) {
            System.out.println();

            int PlayerInput = get_input("would you like to kill " + players.getLast().getName(), scanner);

            if(PlayerInput == 1) {
                if(index == 0) {
                    players.get(index).attack(players.get(index + 1));
                }
                else {
                    players.get(index).attack(players.get(index - 1));
                }
            }

            if(index == 1) index = 0;
            else index++;

            printStats(player1,player2);
        }


    }

    public static void printStats(Player player1, Player player2){
        System.out.println(player1.getName() + " health: " + player1.getHealthStat());
        System.out.println(player2.getName() + " health: " + player2.getHealthStat());
    }


    public static int get_input(String text, Scanner s){
        System.out.println( text + " (y/n): ");

        String option = s.nextLine();

        if(Objects.equals(option, "y")) {
            return 1;
        }
        else if (Objects.equals(option,"n")){
            return 0;
        }
        else
            return 153245;
    }
}