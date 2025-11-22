package trees;
import java.util.TreeSet;

import nodes.Event_Sec22_G15;

import java.util.ArrayList;

public class SawwahTree_Sec22_G15 extends TreeSet<Event_Sec22_G15> {
    public SawwahTree_Sec22_G15() {
        super();
    }
    
    //add event to the tree, validate the event
    @Override
    public boolean add(Event_Sec22_G15 event) {
        if (event.getDate() == null) {
            return false;
        }
        if (event.getStartTime() == null) {
            return false;
        }
        if (event.getEndTime() == null) {
            return false;
        }
        return super.add(event);
    }

    //update event in the tree
    public boolean update(Event_Sec22_G15 event) {
        if (contains(event)) {
            remove(event);
            add(event);
            return true;
        }
        return false;
    }

    //filter events by category, region, and date
    public ArrayList<Event_Sec22_G15> filter(String category, String region, String date) {
        ArrayList<Event_Sec22_G15> filteredEvents = new ArrayList<>();
        for (Event_Sec22_G15 event : this) {
            if ((category == null || category.equals("") || event.getCategory().toLowerCase().equals(category.toLowerCase())) 
                && (region == null || region.equals("") || event.getRegion().toLowerCase().equals(region.toLowerCase())) 
                && (date == null || date.equals("") || event.getDate().equals(date))) {
                filteredEvents.add(event);
            }
        }
        return filteredEvents;
    }


    //print events in the tree, sorted by date and time in chronological order
    //TreeSet is already sorted by the compareTo method in the Event class
    public void printInChronologicalOrder() {
        for (Event_Sec22_G15 event : this)
            System.out.println(event);
    }

    //print events in the tree, sorted by date and time in reverse chronological order
    //use descendingSet() method to get the events in reverse chronological order
    public void printInReverseChronologicalOrder() {
        for (Event_Sec22_G15 event : this.descendingSet())
            System.out.println(event);
    }


}