package cs319.group1e.procheck319;

public class Announcement {
    private String context;
    private String title;
    private String author;

    public Announcement(String context, String title, String author) {
        this.context = context;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String toString(){
        return "Title: " + getTitle() + "\nContext: " + getContext();
    }
}
