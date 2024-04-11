package source.ch08_class.quiz;

public class Movie {
    private String title;
    private String talk;
    private String a;
    public Movie() {
    }

    public Movie(String title, String talk, String a) {
        this.title = title;
        this.talk = talk;
        this.a = a;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", talk='" + talk + '\'' +
                ", a='" + a + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
