/*
csc301 Section 22 Assignment 3 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/
package nodes;

import exceptions.InvalidDateFormat_Sec22_G15;
import exceptions.InvalidYear_Sec22_G15;
import exceptions.InvalidMonth_Sec22_G15;
import exceptions.InvalidDay_Sec22_G15;
import exceptions.InvalidTimeFormat_Sec22_G15;
import exceptions.InvalidTime_Sec22_G15;

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
        
        this.setDate(date);
        this.setStartTime(startTime);
        this.setEndTime(endTime);
    }

    //compare events by date and time
    //if date and time are the same, compare by name
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

    //validate date
    public void validateDate(String date) throws InvalidDateFormat_Sec22_G15, InvalidYear_Sec22_G15, InvalidMonth_Sec22_G15, InvalidDay_Sec22_G15 {
        //check format first
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new InvalidDateFormat_Sec22_G15(date);
        }
        int year = Integer.parseInt(date.substring(0, 4));
        if (year < -1) throw new InvalidYear_Sec22_G15(year);

        //extract and validate month (positions 5-6 in "YYYY-MM-DD")
        String monthStr = date.substring(5, 7);
        int month = Integer.parseInt(monthStr);
        if (month < 1 || month > 12) throw new InvalidMonth_Sec22_G15(month);
        
        //extract and validate day (positions 8-9 in "YYYY-MM-DD")
        String dayStr = date.substring(8, 10);
        int day = Integer.parseInt(dayStr);
        if (day < 1 || day > 31) throw new InvalidDay_Sec22_G15(day);
    }

    //validate time
    public void validateTime(String time) throws InvalidTimeFormat_Sec22_G15, InvalidTime_Sec22_G15 {
        if (!time.matches("\\d{2}:\\d{2}")) {
            throw new InvalidTimeFormat_Sec22_G15(time);
        }
        int hour = Integer.parseInt(time.substring(0, 2));
        if (hour < 0 || hour > 23) throw new InvalidTime_Sec22_G15(time);
        int minute = Integer.parseInt(time.substring(3, 5));
        if (minute < 0 || minute > 59) throw new InvalidTime_Sec22_G15(time);
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

    public void setDate(String date)  {
        try {
            validateDate(date);
        } catch (InvalidDateFormat_Sec22_G15 | InvalidYear_Sec22_G15 | InvalidMonth_Sec22_G15 | InvalidDay_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return;
        }
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        try {
            validateTime(startTime);
        } catch (InvalidTimeFormat_Sec22_G15 | InvalidTime_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return;
        }
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        try {
            validateTime(endTime);
        } catch (InvalidTimeFormat_Sec22_G15 | InvalidTime_Sec22_G15 e) {
            System.out.println(e.getMessage());
            return;
        }
        this.endTime = endTime;
    }

    public String toString() {
        return "Event: " + date + " at " + startTime + " - " + endTime + " | " + name + " (" + category + ") in " + location + " [" + region + "]";
    }
}