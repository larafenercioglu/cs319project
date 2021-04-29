package cs319.group1e.procheck319;

public class ArtifactReview {
    private String context;
    //TODO: getter setter eklenecek

    public ArtifactReview() {
    }

    public ArtifactReview(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    @Override
    public String toString() {
        return context;
    }

}