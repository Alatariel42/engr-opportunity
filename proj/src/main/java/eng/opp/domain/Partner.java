package eng.opp.domain;

public class Partner {
    private String location;
    private User contact;
    private Event events[];
    private boolean archived;

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return the archived
     */
    public boolean isArchived() {
        return archived;
    }

    /**
     * @param archived the archived to set
     */
    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    /**
     * @return the events
     */
    public Event[] getEvents() {
        return events;
    }

    /**
     * @param events the events to set
     */
    public void setEvents(Event events[]) {
        this.events = events;
    }

    /**
     * @return the contact
     */
    public User getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(User contact) {
        this.contact = contact;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
}