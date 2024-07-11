package quiz;

public class Charactor {
    int health;
    int defensivePower;
    int attackPower;

    Charactor() {
        health = 100;
        defensivePower = (int)(Math.random()*10+1);
    }

    void attack(int damage){
        if(damage > defensivePower){
            health = health-(damage-defensivePower);
        }else {
            health -= 1;
        }
    }
    void heal(int heal){
        this.health += heal;
    }
}
