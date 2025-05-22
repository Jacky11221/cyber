import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        while (player1.getHealthStat() > 0 && player2.getHealthStat() > 0) {
            int Player1Input = get_input("would you like to kill player 1");

            if(Player1Input == 1) {
                player1.attack(player2);
            }

            printStats(player1,player2);

            int Player2Input = get_input("would you like to kill player 2");

            if(Player2Input == 1) {
                player2.attack(player1);
            }

            printStats(player1,player2);
        }
    }

    public static int getRandom(int range){
        //get random then
        return 0;
    }

    public static void printStats(Player player1, Player player2){
        System.out.println("player 1 health: " + player1.getHealthStat());
        System.out.println("player 2 health: " + player2.getHealthStat());
    }


    public static int get_input(String text){
        Scanner scanner = new Scanner(System.in);
        System.out.println( text + " (y/n): ");

        String option = scanner.nextLine();


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