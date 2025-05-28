public class Card {

    private String name;
    private int attackBuff;
    private int defenseBuff;
    private int healthRecovery;


    public Card(String name, int attackBuff, int defenseBuff, int healthRecovery){
        this.name = name;
        this.attackBuff = attackBuff;
        this.defenseBuff = defenseBuff;
        this.healthRecovery = healthRecovery;
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
}
