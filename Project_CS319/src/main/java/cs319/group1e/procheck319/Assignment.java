package cs319.group1e.procheck319;

import java.util.List;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;

public class Assignment {

    private int assignmentNo;
    private List<Submission> submissionList;
    private int weight;
    private boolean visibility;
    private Date deadline;
    private Date startDate;
    //private Date artifactReviewDeadline; //Date olmayabilir
    private String title;
    private double average;
    //TODO:PDF eklenecek

    //Default Constructor
    public Assignment() {
        assignmentNo = 0;
        submissionList = new ArrayList<>();
        weight = 0;
        visibility = false;
        deadline = null;
        startDate = null;
        //artifactReviewDeadline = null;
        title = "";
        average = 0.0;
    }

    //Constructor
    public Assignment(int assignmentNo, int weight, boolean visibility, Date deadline, Date startDate, Date artifactReviewDeadline, String title, int average) {
        this.assignmentNo = assignmentNo;
        this.submissionList = new ArrayList<>();
        this.weight = weight;
        this.visibility = visibility;
        this.deadline = deadline;
        this.startDate = startDate;
        //this.artifactReviewDeadline = artifactReviewDeadline;
        this.title = title;
        this.average = average;
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

    /*
    public void setArtifactReviewDeadline(int year, int month, int day) {
        this.artifactReviewDeadline = new Date(year-1900, month-1, day);
    }

    public Date getArtifactReviewDeadline() {
        return artifactReviewDeadline;
    }
    */

    public String getTitle() {
        return title;
    }

    public double getAverage() {
        return average;
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

    public void setDeadline(int year, int month, int day) {
        this.deadline = new Date(year-1900, month-1, day);
    }

    public void setStartDate(int year, int month, int day) {
        this.startDate = new Date(year-1900, month-1, day);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    //TODO: buna bakalim
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

    /*
    public boolean isArtifactReviewDeadlineOver(){
        Date date = new Date();
        return date.after(artifactReviewDeadline);
    }
    */

    //TODO: BUNUN İÇİ DOLACAK
    public void sendSubmissionToDatabase(Group g, Submission s){

    }

    /*OUTDATED
    public Submission getRandomSubmission(){
        Random rand = new Random();
        if(submissionList != null){
            return submissionList.get(rand.nextInt(submissionList.size()));
        }
        return null;
    }
    */
}
