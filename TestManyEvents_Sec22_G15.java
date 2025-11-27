/*
csc301 Section 22 Assignment 3 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/

import java.util.Random;
import nodes.Event_Sec22_G15;
import trees.SawwahTree_Sec22_G15;

public class TestManyEvents_Sec22_G15{
    public static void main(String[] args) {
        SawwahTree_Sec22_G15 tree = new SawwahTree_Sec22_G15();
        //test large amount
        for (int i = 1; i <= 1000; i++) {
            String date = randomDate();
            String[] timeRange = randomTimeRange();
            String startTime = timeRange[0];
            String endTime = timeRange[1];
            Event_Sec22_G15 event = new Event_Sec22_G15("Event" + i,"Category","Location","Region", date, startTime, endTime);
            tree.add(event);
        }

        
        //updating 
        Event_Sec22_G15 Event = tree.iterator().next();
        Event_Sec22_G15 updateEvent = new Event_Sec22_G15(  Event.getName() + " Updated event name", Event.getCategory(),Event.getLocation(), Event.getRegion(),   Event.getDate(),  Event.getStartTime(),   Event.getEndTime());
        boolean Result = tree.update(updateEvent);
      
        System.out.println("Total Number of events: " + tree.size() +"\nresult of updating: "+ Result);
        tree.printInChronologicalOrder();
    }

    public static String randomDate() {
        Random rand = new Random();

        int year = 1970 + rand.nextInt(61);  // 1970–2030
        int month = 1 + rand.nextInt(12);    // 1–12
        int day = 1 + rand.nextInt(28);      // 1–28 ALWAYS

        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static String[] randomTimeRange() {
    Random rand = new Random();

    int hour = rand.nextInt(22);    // 0–21 inclusive
    int minute = rand.nextInt(60);  // 0–59

    int startHour = hour;
    int startMinute = minute;

    int endHour = startHour;
    int endMinute = startMinute + 30;

    if (endMinute >= 60) {
        endMinute -= 60;
        endHour += 1;
    }

    String start = String.format("%02d:%02d", startHour, startMinute);
    String end   = String.format("%02d:%02d", endHour, endMinute);

    return new String[] { start, end };
}
}
