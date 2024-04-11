package source.ch09_extends_interface.ramen;

public class RamenMain {
    public static void main(String[] args) {
        Buldak buldak = new Buldak();
        System.out.println(buldak);
        buldak.printRecipe();

        TenRamen tenRamen = new TenRamen();
        System.out.println(tenRamen);
        tenRamen.printRecipe();

        Ramen ramen = new Ramen() {
            @Override
            public void printRecipe() {
                System.out.println("컵라면");
            }
        };
        System.out.println(ramen);
        ramen.printRecipe();
    }
}
