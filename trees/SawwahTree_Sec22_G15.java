package trees;
import java.util.TreeSet;

import nodes.Event_Sec22_G15;
import exceptions.InvalidDateFormat_Sec22_G15;
import exceptions.InvalidYear_Sec22_G15;
import exceptions.InvalidMonth_Sec22_G15;
import exceptions.InvalidDay_Sec22_G15;
import java.util.ArrayList;
import java.util.Iterator;

public class SawwahTree_Sec22_G15 extends TreeSet<Event_Sec22_G15> {
    

    public SawwahTree_Sec22_G15() {
        super();
    }
    
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
}