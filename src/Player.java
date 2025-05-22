public class Player {
    private double health = 100;
    private double attackStat = 10;
    private double defense = 5;




    public void attack(Player player){
        player.subtractHealth(this.attackStat);

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
}
