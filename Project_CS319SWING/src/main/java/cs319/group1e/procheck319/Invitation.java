package cs319.group1e.procheck319;

public class Invitation {

    /*
        ATTRIBUTES OF GROUP
    */
    private int receiverStudentId;
    private int senderGroupId;
    private boolean isAccepted;
    private String title;

    public Invitation(int receiverStudentId, int senderGroupId) {
        this.receiverStudentId = receiverStudentId;
        this.senderGroupId = senderGroupId;
        this.isAccepted = false;
        this.title = "Group " + senderGroupId + " Invitation";
    }

    //Constructor
    public Invitation( int receiverStudentId, int senderGroupId, boolean isAccepted, String title) {
        this.receiverStudentId = receiverStudentId;
        this.senderGroupId = senderGroupId;
        this.isAccepted = isAccepted;
        this.title = title;
    }

    //Getters
    public int getReceiverStudentId() {
        return receiverStudentId;
    }

    public int getSenderId() {
        return senderGroupId;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public String getTitle() {
        return title;
    }

    //Setters
    public void setReceiverStudentId(int receiverStudentId) {
        this.receiverStudentId = receiverStudentId;
    }

    public void setSenderGroupId(int senderGroupId) {
        this.senderGroupId = senderGroupId;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        String inv = senderGroupId + " has sent an invitation to you " + receiverStudentId;
        return inv;
    }
}
