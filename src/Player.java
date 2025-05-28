import java.util.ArrayList;

public class Player {
    private final String name;
    private double health = 100;
    private double attackStat = 10;
    private double defense = 5;
    private ArrayList<Card> cards = new ArrayList<>();

    public Player(String name){
        this.name = "[" + name + "]";
    }

    public void attack(Player player){

        player.subtractHealth(this.attackStat);

    }

    public void addCard(Card card){
        cards.add(card);
        if(cards.size() > 3){
            cards.removeFirst();
        }
    }

    public void subtractHealth(double attack){
        health -= (attack - this.defense);
    }

    public void multiplyAttack(double factor){
        this.attackStat *= factor;
    }

    public double getAttackStat(){
        return attackStat;
    }

    public double getHealthStat(){
        return health;
    }

    public String getName(){
        return name;
    }
}
