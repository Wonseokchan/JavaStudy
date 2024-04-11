package source.ch09_extends_interface.ramen;

public class TenRamen extends Ramen {
    private String name;
    private int price;
    private String company;

    public TenRamen() {
        super("열라면",800, "오뚜기");
    }

    @Override
    public void printRecipe(){
        System.out.println("끓는 물에 면과 스프를 넣고 3분 후 잘 저어 드셔요");
    }

    @Override
    public String toString() {
        return "TenRamen" + super.toString();
    }

}
