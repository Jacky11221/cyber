import java.util.ArrayList;

public class Player {
    private final String name;
    private double health = 100;
    private double attack = 20;
    private double defense = 15;
    private double speed = 10;
    private final ArrayList<Card> cards = new ArrayList<>();

    public Player(String name){
        this.name = "[" + name + "]";
    }

    public void attack(Player player){

        player.subtractHealth(this.attack);

    }

    public void addCard(Card card){
        System.out.println("You got the card: " + card.getName());
        System.out.println("With the effects: " + card.getEffects());
        cards.add(card);

        if(cards.size() > 3){
            System.out.println("Too many cards, removing oldest card: " + cards.getFirst().getName());
            cards.removeFirst();
        }
    }

    public void statCheck(){
        statReset();

        for(Card card: cards){
            if (health - card.getHealthRecovery() < 0 && !card.getHealthRecoveryGone()) health = 1;
            else health += card.getHealthRecovery();
            card.diminishHealthRecovery();

            attack += card.getAttackBuff();
            if (attack < 0) attack = 0;

            defense += card.getDefenseBuff();
            if (defense < -10) defense = -10;

            speed -= card.getRarity();
        }
    }

    private void statReset(){
        attack = 20;
        defense = 15;
        speed = 10;
    }

    public void subtractHealth(double attack){
        if (!(this.defense > attack)) {
            health -= (attack - this.defense);
        }
    }

    public void multiplyAttack(double factor){
        this.attack *= factor;
    }

    public double getHealthStat(){
        return health;
    }

    public String getName(){
        return name;
    }

    public double getSpeed() {return speed;}

    public String getStats(){
        return name + " health: " + health
                + " | " + " attack: " + attack
                + " | " + " defense: " + defense
                ;
    }

    public void changeSpeed(double speed) {this.speed = speed; }
}
