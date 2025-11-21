package nodes;
public class Event_Sec22_G15 {
    private String name;
    private String category;
    private String date;
    private String time;
    private String location;

    public Event_Sec22_G15(String name, String date, String time, String location, String category, String description) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return "Event: " + name + " on " + date + " at " + time + " in " + location + " (" + category + ")";
    }
}