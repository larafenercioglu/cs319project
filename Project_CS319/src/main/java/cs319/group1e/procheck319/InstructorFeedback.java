package cs319.group1e.procheck319;

public class InstructorFeedback {
    private String context;

    public InstructorFeedback() {
    }

    public InstructorFeedback(String context){
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
    public String toString(){
        return "Instructor's feedback: " + getContext();
    }
}
