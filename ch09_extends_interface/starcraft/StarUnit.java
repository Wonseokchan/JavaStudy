package source.ch09_extends_interface.starcraft;

//Marine, Zealot, HighTemplar 클래스에서 공통으로 쓰이는 필드변수 및 메소드를 가짐
public class StarUnit {
    private String name;
    private int hp;
    private int damage;
    private int attackSpeed;
    private int mineral;

    public StarUnit() {
    }

    public StarUnit(String name, int hp, int damage, int attackSpeed, int mineral) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.mineral = mineral;
    }

    @Override
    public String toString() {
        return "StarUnit{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                ", attackSpeed=" + attackSpeed +
                ", mineral=" + mineral +
                '}';
    }

    public void move(int x, int y){
        System.out.println(x + ", " + y + "로 이동");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getMineral() {
        return mineral;
    }

    public void setMineral(int mineral) {
        this.mineral = mineral;
    }
}
