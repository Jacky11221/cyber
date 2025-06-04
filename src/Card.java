import java.util.ArrayList;


public class Card implements Cloneable{
    private final String name;
    private final int attackBuff;
    private final int defenseBuff;
    private int healthRecovery;
    private boolean healthRecoveryGone;
    private final int rarity;

    private static final ArrayList<Card> normalCards = new ArrayList<>();
    private static final ArrayList<Card> rareCards = new ArrayList<>();
    private static final ArrayList<Card> goodCards = new ArrayList<>();

    private static final String blue = "\u001B[32m";
    private static final String yellow = "\u001B[33m";
    private static final String purple = "\u001B[35m";
    private static final String reset_colour = "\u001B[0m";


    public Card(String name, int attackBuff, int defenseBuff, int healthRecovery, int rarity){
        if (rarity==1) {
            this.name = blue + "{" + name + "}" + reset_colour;
        }
        else if (rarity==2) {
            this.name = yellow +"{" + name + "}" + reset_colour;
        }
        else {
            this.name = purple + "{" + name + "}" + reset_colour;
        }

        this.attackBuff = attackBuff;
        this.defenseBuff = defenseBuff;
        this.healthRecovery = healthRecovery;
        this.rarity = rarity;
    }


    public String getName() {
        return name;
    }

    public int getAttackBuff() {
        return attackBuff;
    }

    public int getDefenseBuff() {
        return defenseBuff;
    }

    public int getHealthRecovery() {
        return healthRecovery;
    }

    public boolean getHealthRecoveryGone() {
        return healthRecoveryGone;
    }

    public void diminishHealthRecovery() {
        healthRecovery = 0;
        healthRecoveryGone = true;
    }

//    private static String getCardColor()

    public int getRarity() {return rarity;}

    public String getEffects() {
        return "{Attack Boost: " + attackBuff
                + " | Defense Boost: " + defenseBuff
                + " | HP Recovery: " + healthRecovery + "}";
    }

    public static Card getCard(){
        int rate = Main.getRandom(101);
        if(rate > 90){
            return goodCards.get(Main.getRandom(goodCards.size() - 1));
        }
        else if (rate > 60){
            return rareCards.get(Main.getRandom(rareCards.size() - 1));
        }
        else {
            return normalCards.get(Main.getRandom(normalCards.size() - 1));
        }
    }

    public static void generateCards(){
        //(Mostly) Attack related buffs
        normalCards.add(new Card("Spoofing (good)", 4, 0, 0, 1));
        normalCards.add(new Card("Social Engineering (good)", 5, 0, 0, 1));
        normalCards.add(new Card("Denial of Service (good)", 7, 0, 0, 1));

        rareCards.add(new Card("Distributed Denial of Service (good)", 14, 0, 0, 2));
        rareCards.add(new Card("XSS (good)", 16, 2, 0, 2));
        rareCards.add(new Card("SQLi(good)", 16, 0, 2, 2));

        goodCards.add(new Card("Zero-Day Exploit (good)", 25, 5, 0, 3));
        goodCards.add(new Card("Focused Attack Vector   (Good)", 40, -40, -20, 3));


        //(Mostly) Defense related buffs
        normalCards.add(new Card("Secure Configuration (Good)", 0, 2, 0, 1));
        normalCards.add(new Card("Antivirus Software (Good)", 0, 3, 0, 1));
        normalCards.add(new Card("Building Security I (UYAY)", 0, 2, 2, 1));
        normalCards.add(new Card("Post-Incident Recovery (YAY)", 0,0,15,1));


        rareCards.add(new Card("Security Training (good)", 0, 8, 0, 2));
        rareCards.add(new Card("Network Monitoring (good)", 0, 2, 7, 2));
        rareCards.add(new Card("Building Security II (good)", 0, 6, 6, 2));

        goodCards.add(new Card("Advanced Firewalls and Protection (kind of good?)", -10, 25, 0, 3));
        goodCards.add(new Card("Data Backup (good)", 0, 5, 30, 3));
        goodCards.add(new Card("Building Security III (good)", 0, 15, 15, 3));


        //Suffer lmao
        normalCards.add(new Card("Insecure Wifi (damn)", 2, -3, 0, 1));
        normalCards.add(new Card("Down Internet (:()", -3, 3, 0, 1));
        normalCards.add(new Card("Malfunctioning Hardware (not good)", -1, -1, -2, 1));

        rareCards.add(new Card("Weak Security (bad)", 0, -5, -2, 2));
        rareCards.add(new Card("Weak Door (bad)", 0, -8, 0, 2));
        rareCards.add(new Card("Eradication of Exploitations (bad)", -5, 0, 0, 2));

        goodCards.add(new Card("Coursera (REALLY bad)", -20, -20, -20, 3));
        goodCards.add(new Card("Awareness Void (oops no defense)", 0, -1000000, 100, 3));
    }

    @Override
    public Card clone() {
        try {
            Card clone = (Card) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            // create a new Card object with the same EXACT information as the current instance
            // basically, copy every instance variable data into the new Card object
            
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
