package cs319.group1e.procheck319;

import java.util.List;
public class Calendar {

    /*
        ATTRIBUTES OF GROUP
    */
    private List<Event> events;

    //Default Constructor
    public Calendar() {
    }

    //Constructor
    public Calendar(List<Event> events) {
        this.events = events;
    }

    //Getters
    public List<Event> getEvents() {
        return events;
    }

    //Setters
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    //Other Methods
    public void addEvent(Event event) {
        events.add(event);
    }

    public void deleteEvent(Event event) {

        //For loop to find event
        for(int i = 0; i < events.size(); i++) {
            if(events.get(i).getTitle().equals(event.getTitle())) {
                events.remove(events.get(i));
            }
        }
    }
}
