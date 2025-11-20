public class Event{

  String name;
  int time;
  int date;

public Event (String name, int time,int date){
  this.name = name;
  this.date = date;
  this.time = time;

    }

  @Overriide
  publuc String toString(){
    return "Name: "+this.name+"\nDate:"+this.date+"\nTime:"+this.time;
  }
}
}

  
