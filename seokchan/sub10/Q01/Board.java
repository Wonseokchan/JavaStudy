package source.seokchan.sub10.Q01;

public class Board {
    private int num;
    private String title;
    private String date;
    private String contents;

    public Board() {
    }

    public Board(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Board(int num, String title, String date, String contents) {
        this.num = num;
        this.title = title;
        this.date = date;
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "["+ num + ". | " + title + " | " + date + "]";
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
