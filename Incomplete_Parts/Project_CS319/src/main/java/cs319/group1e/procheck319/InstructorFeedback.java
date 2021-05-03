package cs319.group1e.procheck319;

public class InstructorFeedback {
    private String context;
    private String author;

    public InstructorFeedback() {
    }

    public InstructorFeedback(String context, String author){
        this.context = context;
        this.author = author;
    }

    public String getContext() {
        return context;
    }

    public String getAuthor(){
        return author;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String toString(){
        return "Instructor's feedback: " + getContext();
    }
}
