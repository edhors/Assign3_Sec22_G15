import trees.SawwahTree_Sec22_G15;
import nodes.Event_Sec22_G15;

public class TestClass{
    public static void main(String[] args) {
        SawwahTree_Sec22_G15 tree = new SawwahTree_Sec22_G15();
        //test large amount
        for (int i = 1; i <= 1000; i++) {
            Event_Sec22_G15 event = new Event_Sec22_G15("Event00" + i,"Category","Location","Region","2025-11-23", "11:00","13:00" );
            tree.add(event);
        }

        
        //updating 
        Event_Sec22_G15 Event = tree.iterator().next();
        Event_Sec22_G15 updatedEvent = new Event_Sec22_G15(  Event.getName() + " Updated event name", Event.getCategory(),Event.getLocation(), Event.getRegion(),   Event.getDate(),  Event.getStartTime(),   Event.getEndTime());
        boolean Result = tree.update(updatedEvent);
      
        System.out.println("Total Number of events: " + tree.size() +"\nresult of updating: "+ Result);
        tree.printInChronologicalOrder();
}}
