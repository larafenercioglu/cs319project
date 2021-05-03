package cs319.group1e.procheck319;

public class Request {

    /*
        ATTRIBUTES OF GROUP
    */
    private int receiverGroupId;
    private int senderStudentId;
    private boolean isAccepted;
    private String title;
    private String content;

    //default constructor
    public Request(int receiverGroupId, int senderStudentId){
        this.receiverGroupId = receiverGroupId;
        this.senderStudentId = senderStudentId;
        this.isAccepted = false;
        this.title = null;
        this.content = null;
    }

    //Constructor
    public Request(int receiverGroupId, int senderStudentId, boolean isAccepted, String title, String content) {
        this.receiverGroupId = receiverGroupId;
        this.senderStudentId = senderStudentId;
        this.isAccepted = isAccepted;
        this.title = title;
        this.content = content;
    }
    public int getReceiverGroupId() {
        return receiverGroupId;
    }

    //Getters
    public int getSenderStudentId() {
        return senderStudentId;
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
    public void setReceiverGroup(int receiverGroupId) {
        this.receiverGroupId = receiverGroupId;
    }

    public void setSenderStudentId(int sender) {
        this.senderStudentId = senderStudentId;
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
        req = senderStudentId + " has sent and invitation to your group: " + receiverGroupId;
        return req;
    }
}
