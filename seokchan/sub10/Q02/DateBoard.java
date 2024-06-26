package source.seokchan.sub10.Q02;

public class DateBoard {
    private String title;
    private String date;

    public DateBoard(String title, String date) {
        this.title = title;
        this.date = date;
    }

    @Override
    public String toString() {
        return "DateBoard [title=" + title + ", date=" + date + "]";
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

}