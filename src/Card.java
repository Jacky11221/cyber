import java.util.ArrayList;

public class Card {
    private final String name;
    private final int attackBuff;
    private final int defenseBuff;
    private int healthRecovery;
    private boolean healthRecoveryGone;
    private final int rarity;

    private static final ArrayList<Card> normalCards = new ArrayList<>();
    private static final ArrayList<Card> rareCards = new ArrayList<>();
    private static final ArrayList<Card> goodCards = new ArrayList<>();


    public Card(String name, int attackBuff, int defenseBuff, int healthRecovery, int rarity){
        this.name = "{" + name + "}";
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
        normalCards.add(new Card("Spoofing", 4, 0, 0, 1));
        normalCards.add(new Card("Social Engineering", 5, 0, 0, 1));
        normalCards.add(new Card("Denial of Service", 7, 0, 0, 1));

        rareCards.add(new Card("Distributed Denial of Service", 14, 0, 0, 2));
        rareCards.add(new Card("XSS", 16, 2, 0, 2));
        rareCards.add(new Card("SQLi", 16, 0, 2, 2));

        goodCards.add(new Card("Zero-Day Exploit", 25, 5, 0, 3));
        goodCards.add(new Card("Focused Attack Vector", 40, -40, -20, 3));



        //(Mostly) Defense related buffs
        normalCards.add(new Card("Secure Configuration", 0, 2, 0, 1));
        normalCards.add(new Card("Antivirus Software", 0, 3, 0, 1));
        normalCards.add(new Card("Building Security I", 0, 2, 2, 1));

        rareCards.add(new Card("Security Training", 0, 8, 0, 2));
        rareCards.add(new Card("Network Monitoring", 0, 2, 7, 2));
        rareCards.add(new Card("Building Security II", 0, 6, 6, 2));

        goodCards.add(new Card("Advanced Firewalls and Protection", -20, 20, 0, 3));
        goodCards.add(new Card("Data Backup", 0, 0, 30, 3));
        goodCards.add(new Card("Building Security III", 0, 15, 15, 3));


        //Suffer lmao
        normalCards.add(new Card("Insecure Wifi", 0, -3, 0, 1));
        normalCards.add(new Card("Down Internet", -3, 0, 0, 1));
        normalCards.add(new Card("Malfunctioning Hardware", -2, -2, -2, 1));

        rareCards.add(new Card("Weak Security", 0, -8, -2, 2));
        rareCards.add(new Card("Weak Door", 0, -10, 0, 2));
        rareCards.add(new Card("Eradication of Exploitations", -10, 0, 0, 2));

        goodCards.add(new Card("Coursera", -20, -20, -20, 3));
        goodCards.add(new Card("Awareness Void", 0, -1000, 10, 3));
    }
}
