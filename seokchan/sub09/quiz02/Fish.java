package source.seokchan.sub09.quiz02;

public class Fish {
    private String name;
    private int price;

    public Fish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Fish(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fish{" +
                " " + name + '\'' +
                ", 가치 : " + price +
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
}
