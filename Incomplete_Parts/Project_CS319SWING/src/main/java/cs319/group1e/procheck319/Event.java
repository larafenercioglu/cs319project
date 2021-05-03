package cs319.group1e.procheck319;

public class Event {
    /*
        ATTRIBUTES OF GROUP
    */
    String title;
    String date;

    //Default Constructor
    public Event() {
    }

    //Constructor
    public Event( String title, String date ) {
        this.title = title;
        this.date = date;
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    //Setters
    public void setTitle( String title ) {
        this.title = title;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    //Other Methods
    public void editEvent(String title, String date) {
        this.title = title;
        this.date = date;
    }
}
