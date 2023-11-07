public class Event {
    private String eventName;
    private String imageLink;
    private String eventInfo;
    private String eventPrice;
    private String seats;

    public Event(String eventName, String imageLink, String eventInfo, String eventPrice, String seats) {
        this.eventName = eventName;
        this.imageLink = imageLink;
        this.eventInfo = eventInfo;
        this.eventPrice = eventPrice;
        this.seats = seats;
    }

    public String getEventName() {
        return eventName;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public String getEventPrice() {
        return eventPrice;
    }

    public String getSeats() {
        return seats;
    }
}
