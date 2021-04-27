package cs319.group1e.procheck319;

import java.util.List;
import java.util.Date;
import java.util.Random;

public class Assignment {

    private int assignmentNo;
    private List<Submission> submissionList;
    private int weight;
    private boolean visibility;
    private Date deadline; //Date olmayabilir
    private Date startDate; //Date olmayabilir
    private Date artifactReviewDeadline; //Date olmayabilir
    private String title;

    //Default Constructor
    public Assignment() {
    }

    //Constructor
    public Assignment(int assignmentNo, List<Submission> submissionList, int weight, boolean visibility, Date deadline, Date startDate, Date artifactReviewDeadline, String title) {
        this.assignmentNo = assignmentNo;
        this.submissionList = submissionList;
        this.weight = weight;
        this.visibility = visibility;
        this.deadline = deadline;
        this.startDate = startDate;
        this.artifactReviewDeadline = artifactReviewDeadline;
        this.title = title;
    }

    //Getter
    public int getAssignmentNo() {
        return assignmentNo;
    }

    public List<Submission> getSubmissionList() {
        return submissionList;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getArtifactReviewDeadline() {
        return artifactReviewDeadline;
    }

    public String getTitle() {
        return title;
    }

    //Setter
    public void setAssignmentNo(int assignmentNo) {
        this.assignmentNo = assignmentNo;
    }

    public void setSubmissionList(List<Submission> submissionList) {
        this.submissionList = submissionList;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setArtifactReviewDeadline(Date artifactReviewDeadline) {
        this.artifactReviewDeadline = artifactReviewDeadline;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addSubmission(Submission submission){
        submissionList.add(submission);
    }

    public boolean isDeadlineOver(){ //Date objesi ile doldurulacak *** RETURN DEĞİŞTİR
        Date date = new Date();

        //Date date1 = new Date(a-1900, b-1, c);
        //"a" hocanın gireceği yıl
        //"b" hocanın gireceği ay
        //"c" hocanın gireceği gün

        return date.after(deadline);
    }

    public boolean isARtifactReviewDeeadlineOver(){
        Date date = new Date();
        return date.after(artifactReviewDeadline);
    }

    //TODO: BUNUN İÇİ DOLACAK
    public void sendSubmissionToDatabase(Group g, Submission s){

    }

    public Submission getRandomSubmission(){
        Random rand = new Random();
        return submissionList.get(rand.nextInt(submissionList.size()));
    }

}
