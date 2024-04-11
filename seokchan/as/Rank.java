package source.seokchan.as;

public class Rank {
    private String name;
    private float reactime;


    public Rank(String name, float reactime) {
        this.name = name;
        this.reactime = reactime;
    }

    @Override
    public String toString() {
        return "[" + name  +
                ",\t\t\t" + reactime + " 초" +
                ']';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getReactime() {
        return reactime;
    }

    public void setReactime(float reactime) {
        this.reactime = reactime;
    }
}
