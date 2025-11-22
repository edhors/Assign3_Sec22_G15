package nodes;
public class Event_Sec22_G15 implements Comparable<Event_Sec22_G15> {
    private String name;
    private String category;
    private String location;
    private String region;
    private String date;
    private String startTime;
    private String endTime;

    public Event_Sec22_G15(String name, String category, String location, String region, String date, String startTime, String endTime) {
        this.name = name;
        this.category = category;
        this.location = location;
        this.region = region;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Event_Sec22_G15 other) {
        if (this.date.compareTo(other.date) != 0) {
            return this.date.compareTo(other.date);
        }
        
        if (this.startTime.compareTo(other.startTime) != 0) {
            return this.startTime.compareTo(other.startTime);
        }
        
        return this.name.compareTo(other.name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String toString() {
        return "Event: " + name + " (" + category + ") in " + location + " [" + region + "] on " + date + " at " + startTime + " - " + endTime;
    }
}