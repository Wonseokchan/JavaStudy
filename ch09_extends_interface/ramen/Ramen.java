package source.ch09_extends_interface.ramen;

//추상 메소드를 하나라도 가지고 있는 클래스는 public 과 class 사이에 abstract를 붙여 추상 클래스로 만들어 주어야 한다.
public abstract class Ramen {
    public String name;
    public int price;
    public String company;

    public Ramen() {
    }

    public Ramen(String name, int price, String company) {
        this.name = name;
        this.price = price;
        this.company = company;
    }

    //Ramen을 상속받는 클래스들은 printRecipe 메소드를 가짐
    //하지만 실행 코드는 다름 -> 추상 메소드로 만들어주기
    //1. 추상메소드는 중괄호 블록이 없고, 끝에 세미콜론을 붙인다.
    //2. 접근제어자와 리턴타입 사이에 abstract 를 붙인다
    // (이때 빨간줄이 생긴다면 해당 클래스가 추상 클래스로 선언되어 있는지 확인 필요)
    public abstract void printRecipe();



    @Override
    public String toString() {
        return "Ramen{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", company='" + company + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
