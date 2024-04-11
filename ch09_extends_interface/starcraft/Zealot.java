package source.ch09_extends_interface.starcraft;

public class Zealot extends StarUnit{
    private int shield;

    public Zealot() {
        this("질럿",16,100,60,1,100);
    }

    public Zealot(String name, int damage, int hp, int shield, int attackSpeed, int mineral) {
        super(name, hp, damage, attackSpeed, mineral);
        this.shield = shield;
    }

    @Override
    public String toString() {
        return "Zealot" + super.toString();
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }
}
