package source.ch09_extends_interface.starcraft;

public class Marine extends StarUnit {

    public Marine() {
        this("마린", 50,6,1,50);
    }

    public Marine(String name, int hp, int damage, int attackSpeed, int mineral) {
        super(name, hp, damage, attackSpeed, mineral);
    }

    //마린은 스팀팩 스킬을 사용할 수 있음
    public void stimpack(){
        System.out.println("스팀팩 사용!!");
        //스팀팩을 쓰면 체력 10감소, 공격속도 두배
        super.setHp(super.getHp() - 10);
        super.setAttackSpeed(super.getAttackSpeed() * 2);
    }

    /*public void attack(Zealot zealot){
        zealot.setHp(getHp() - this.getDamage());
    }

    public void attack(HighTemplar highTemplar){
        highTemplar.setHp(getHp() - this.getDamage());
    }*/

    //다형성을 이용한 attack
    public void attack(StarUnit target){
        target.setHp(target.getHp() - this.getDamage());
    }

    @Override
    public String toString() {
        return "Marine{" +
                "name='" + super.getName() + '\'' +
                ", hp=" + super.getHp() +
                ", damage=" + super.getDamage() +
                ", attackSpeed=" + super.getAttackSpeed() +
                ", mineral=" + super.getMineral() +
                '}';
    }

}
