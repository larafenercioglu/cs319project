package cs319.group1e.procheck319;

public class Request {

    /*
        ATTRIBUTES OF GROUP
    */
    private Group receiver;
    private Student sender;
    private boolean isAccepted;
    private String title;
    private String content;

    //default constructor
    public Request(Group receiver, Student sender){
        this.receiver = receiver;
        this.sender = sender;
        this.isAccepted = false;
        this.title = null;
        this.content = null;
    }

    //Constructor
    public Request(Group receiver, Student sender, boolean isAccepted, String title, String content) {
        this.receiver = receiver;
        this.sender = sender;
        this.isAccepted = isAccepted;
        this.title = title;
        this.content = content;
    }
    public Group getReceiver() {
        return receiver;
    }

    //Getters
    public Student getSender() {
        return sender;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    //Setters
    public void setReceiver(Group receiver) {
        this.receiver = receiver;
    }

    public void setStudent(Student sender) {
        this.sender = sender;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String toString(){
        String req = "";
        req = sender + " has sent and invitation to your group: "+receiver;
        return req;
    }
}
