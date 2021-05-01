package cs319.group1e.procheck319;

import java.util.List;
import java.util.ArrayList;

public class Submission {
    private String title;
    private double grade;
    private int assignmentNo;
    private InstructorFeedback feedback;
    private List<ArtifactReview> artifactReviews;
    private int groupId;
    private boolean isGraded;
    private int artifactReviewCount;

    //Default Constructor
    public Submission() {
        this.title = groupId + "_" + assignmentNo;
        this.artifactReviewCount = 0;
    }

    public Submission(Assignment assignment) {
        this.assignmentNo = assignment.getAssignmentNo();
        this.title = groupId + "_" + assignment.getTitle();
        this.artifactReviews = new ArrayList<>();
        this.artifactReviewCount = 0;
    }

    //Constructor
    public Submission(int groupId, double grade, int assignmentNo, InstructorFeedback feedback, List<ArtifactReview> artifactReviews) {
        this.groupId = groupId;
        this.grade = grade;
        this.assignmentNo = assignmentNo;
        this.feedback = feedback;
        this.artifactReviews = new ArrayList<>();
        this.artifactReviewCount = 0;
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

    public InstructorFeedback getFeedback() {
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

    //Setters
    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setAssignmentNo(int assignmentNo) {
        this.assignmentNo = assignmentNo;
    }

    public void setFeedback(InstructorFeedback feedback) {
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
}
