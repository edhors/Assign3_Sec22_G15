package nodes;

import java.util.*;

public class EventManagement_Sec22_G15{
  Private Treemap<String,ArrayList<Event_Sec22_G15>> tree=new TreeMap<>();

  Public String CreateKey(String date , String time ){
    return "Date and Time:"+date+" "+time;
  }

Public voud addEvent(Event_Sec22_G15 k){
  String key= CreateKey(k.getDate(),k.getTime());
  if (!tree.containsKey(key)){
    tree.put(key,new ArrayList<>());
  }
  tree.get(key).add(k);
  System.out.printlin("Even added");
}

    }


  
    
   

    



  
}
