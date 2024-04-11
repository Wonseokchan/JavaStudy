package source.ch09_extends_interface.ramen;

public class Buldak extends Ramen {
    private String name;
    private int price;
    private String company;

    public Buldak() {
        super("불닭볶음면",1500, "삼양");
    }
    @Override
    public void printRecipe(){
        System.out.println("끓는 물에 4분 끓인 뒤 물을 버리고 소스를 넣어 볶아 드세요");
    }

    @Override
    public String toString() {
        return "Buldak" + super.toString();

    }

}
