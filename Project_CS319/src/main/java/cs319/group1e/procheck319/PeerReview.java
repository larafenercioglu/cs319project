package cs319.group1e.procheck319;
import java.util.List;

public class PeerReview {
    private List<Integer> points;
    private List<String> reviews;


    //Default constructor
    public PeerReview(List<Integer> points) {
        this.points = points;
    }

    //Constructor
    public PeerReview(List<Integer> points, List<String> reviews) {
        this.points = points;
        this.reviews = reviews;
    }

    //Getters
    public List<Integer> getPoints() {
        return points;
    }

    public List<String> getReviews() {
        return reviews;
    }

    //Setters
    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }
    //TODO: reviews da eklenecek
    public String toString(){
        String pointss = "";
        for(int i = 0;i<points.size();i++){
            pointss = pointss + " " + points.get(i) + " ";
        }
        return pointss;
    }
}
