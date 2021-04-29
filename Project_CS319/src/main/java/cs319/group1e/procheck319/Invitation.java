package cs319.group1e.procheck319;

public class Invitation {

    /*
        ATTRIBUTES OF GROUP
    */
    private Student receiver;
    private Group sender;
    private boolean isAccepted;
    private String title;

    public Invitation(Student receiver, Group sender) {
        this.receiver = receiver;
        this.sender = sender;
        this.isAccepted = false;
        this.title = "Group " + sender.getGroupId()+ " Invitation";
    }

    //Constructor
    public Invitation(Student receiver, Group sender, boolean isAccepted, String title) {
        this.receiver = receiver;
        this.sender = sender;
        this.isAccepted = isAccepted;
        this.title = title;
    }

    //Getters
    public Student getReceiver() {
        return receiver;
    }

    public Group getSender() {
        return sender;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public String getTitle() {
        return title;
    }

    //Setters
    public void setReceiver(Student receiver) {
        this.receiver = receiver;
    }

    public void setSender(Group sender) {
        this.sender = sender;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String toString(){
        String inv = sender + " has sent an invitation to you "+ receiver;
        return inv;
    }
}
