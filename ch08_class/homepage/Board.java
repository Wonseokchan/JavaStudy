package source.ch08_class.homepage;

public class Board {
    private Integer num;
    private String title;
    private String name;
    private String contents;

    public Board() {
    }

    public Board(Integer num, String title, String name, String contents) {
        this.num = num;
        this.title = title;
        this.name = name;
        this.contents = contents;
    }

    public Board(Integer num, String title, String name) {
        this.num = num;
        this.title = title;
        this.name = name;
    }

    public Board(String title, String contents, String name) {
        this.title = title;
        this.contents = contents;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Board{" +
                " " + num + " | " +
                title + " | " +
                name  +
                '}';
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
