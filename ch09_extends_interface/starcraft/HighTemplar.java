package source.ch09_extends_interface.starcraft;

//중복되는 필드 변수들에 대해 하나의 클래스에 묶어준 뒤 각 클래스들에게 상속시킨다.(= 중복 코드를 묶어준다)
//중복코드를 묶어주면 수정에 용이
public class HighTemplar extends StarUnit{
    private int shield;
    private int gas;

    public HighTemplar() {
        this("하이템플러", 0, 40, 40, 0 ,50,150);
    }

    public HighTemplar(String name, int damage, int hp, int shield, int attackSpeed, int mineral, int gas) {
        super(name, damage, hp, attackSpeed, mineral);
        this.shield = shield;
        this.gas = gas;
    }

    public void psionicStorm(){
        System.out.println("스톰!!");
    }

    @Override
    public String toString() {
        return "HighTemplar" + super.toString();
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }
}
