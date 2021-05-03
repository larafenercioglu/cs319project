package cs319.group1e.procheck319;

import java.sql.Array;
import java.util.List;
import java.util.ArrayList;

public class Submission {
    private String title;
    private double grade;
    //private Assignment assignment;
    private int assignmentNo;
    private String feedback;
    private List<ArtifactReview> artifactReviews;
    private int groupId;
    private boolean isGraded;
    private int artifactReviewCount;

    private String url;

    //Default Constructor
    public Submission() {
        this.title = groupId + "_" + assignmentNo;
        this.artifactReviewCount = 0;
        this.feedback = "";
    }

    //Constructor
    public Submission(Assignment assignment, String url) {
        this.assignmentNo = assignment.getAssignmentNo();
        this.title = groupId + "_" + assignment.getTitle();
        this.artifactReviews = new ArrayList<>();
        this.artifactReviewCount = 0;
        this.url = url;
        this.feedback = "";
    }

    //Constructor
    public Submission(int groupId, double grade, int assignmentNo, List<ArtifactReview> artifactReviews, String url, String feedback) {
        this.groupId = groupId;
        this.grade = grade;
        this.assignmentNo = assignmentNo;
        this.feedback = feedback;
        this.artifactReviews = new ArrayList<>();
        this.artifactReviewCount = 0;
        this.url = url;
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public double getGrade() {
        return grade;
    }

    public int getAssignmentNo() {
        return assignmentNo;
    }

    public String getFeedback() {
        return feedback;
    }

    public List<ArtifactReview> getArtifactReviews() {
        return artifactReviews;
    }

    public int getGroupId() {
        return groupId;
    }

    public boolean getIsGraded(){
        return isGraded;
    }

    public int getArtifactReviewCount() {
        return artifactReviewCount;
    }

    public String getUrl() {
        return url;
    }

    //Setters
    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setAssignmentNo(int assignmentNo) {
        this.assignmentNo = assignmentNo;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setArtifactReviews(List<ArtifactReview> artifactReviews) {
        this.artifactReviews = artifactReviews;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setIsGraded(boolean isGraded){
        this.isGraded = isGraded;
    }

    public void setArtifactReviewCount(int artifactReviewCount) {
        this.artifactReviewCount = artifactReviewCount;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //Set submission object to another
    public void setEqualsSubmission(Submission s) {
        this.title = s.getTitle();
        this.grade = s.getGrade();
        this.assignmentNo = s.getAssignmentNo();
        this.feedback = s.getFeedback();
        this.artifactReviews = s.getArtifactReviews();
        this.groupId = s.getGroupId();
        this.isGraded = s.getIsGraded();
        this.artifactReviewCount = s.getArtifactReviewCount();
    }
}
