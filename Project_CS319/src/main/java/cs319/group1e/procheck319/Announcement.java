package cs319.group1e.procheck319;

public class Announcement {
    private String context;
    private String title;

    public Announcement(String context, String title) {
        this.context = context;
        this.title = title;
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
}
