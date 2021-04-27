package cs319.group1e.procheck319;

import java.util.List;

public class Submission {
    private double grade;
    private Assignment assignment;
    private InstructorFeedback feedback;
    private List<ArtifactReview> artifactReviews;
    //TODO: File nasıl eklenecek bilmiyom

    //Default Constructor
    public Submission() {
    }

    //Constructor
    public Submission(double grade, Assignment assignment, InstructorFeedback feedback, List<ArtifactReview> artifactReviews) {
        this.grade = grade;
        this.assignment = assignment;
        this.feedback = feedback;
        this.artifactReviews = artifactReviews;
    }

    //Getters
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

}
