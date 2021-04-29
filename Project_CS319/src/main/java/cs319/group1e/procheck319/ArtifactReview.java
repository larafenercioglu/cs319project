package cs319.group1e.procheck319;

public class ArtifactReview {
    private String context;

    public ArtifactReview() {
    }

    public void setContext(String context) {
        this.context = context;
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