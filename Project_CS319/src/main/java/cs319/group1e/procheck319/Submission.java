package cs319.group1e.procheck319;

import java.sql.Array;
import java.util.List;
import java.util.ArrayList;

public class Submission {
    private String title;
    private double grade;
    private Assignment assignment;
    private InstructorFeedback feedback;
    private List<ArtifactReview> artifactReviews;
    private int groupId;
    private boolean isGraded;
    //TODO: File nasıl eklenecek bilmiyom

    //Default Constructor
    public Submission() {
        this.title = groupId + "_" + assignment.getTitle();
    }

    public Submission(Assignment assignment) {
        this.assignment = assignment;
        this.title = groupId + "_" + assignment.getTitle();
        artifactReviews = new ArrayList<>();
    }

    //Constructor
    public Submission(int groupId, double grade, Assignment assignment, InstructorFeedback feedback, List<ArtifactReview> artifactReviews) {
        this.groupId = groupId;
        this.grade = grade;
        this.assignment = assignment;
        this.feedback = feedback;
        this.artifactReviews = new ArrayList<>();
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public double getGrade() {
        return grade;
    }

    public Assignment getAssignment() {
        return assignment;
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

    //Setters
    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
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
}
