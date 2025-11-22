import trees.SawwahTree_Sec22_G15;

import java.util.Iterator;
import java.util.Scanner;
import nodes.Event_Sec22_G15;
import java.util.ArrayList;

public class Main_Sec22_G15 {
    private static SawwahTree_Sec22_G15 sawwahTree = new SawwahTree_Sec22_G15();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Sawwah System!");
        initializeTree();
        int choice = -1;
        while (choice != 0) {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    updateEvent();
                    break;
                case 3:
                    deleteEvent();
                    break;
                case 4:
                    filterEvents();
                    break;
                case 5:
                    printEventsInChronologicalOrder();
                    break;
                case 6:
                    printEventsInReverseChronologicalOrder();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("1. Add Event");
        System.out.println("2. Update Event");
        System.out.println("3. Delete Event");
        System.out.println("4. Filter Events");
        System.out.println("5. Print Events in Chronological Order");
        System.out.println("6. Print Events in Reverse Chronological Order");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }


    public static void addEvent() {
        System.out.println("--------------------------------");
        int key = -1;
        while (key != 0) {
            try {
                System.out.println("Enter event name: ");
                String name = scanner.nextLine();
                System.out.println("Enter event category: ");
                String category = scanner.nextLine();
                System.out.println("Enter event location: ");
                String location = scanner.nextLine();
                System.out.println("Enter event region: ");
                String region = scanner.nextLine();
                System.out.println("Enter event date: ");
                String date = scanner.nextLine();
                System.out.println("Enter event start time: ");
                String startTime = scanner.nextLine();
                System.out.println("Enter event end time: ");
                String endTime = scanner.nextLine();
                Event_Sec22_G15 event = new Event_Sec22_G15(name, category, location, region, date, startTime, endTime);
                sawwahTree.add(event);
                System.out.println("Event added successfully");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            key = scanner.nextInt();
            try {
                if (key != 1 && key != 0) {
                    throw new Exception("Invalid input");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("--------------------------------");
    }

    public static void updateEvent() {
        System.out.println("--------------------------------");
        int key = -1;
        while (key != 0) {
            try {
                System.out.println("Enter event name to update: ");
                scanner.nextLine();
                String nameToFind = scanner.nextLine();
                System.out.println("Enter event date to update: ");
                String dateToFind = scanner.nextLine();
                System.out.println("Enter event start time to update: ");
                String startTimeToFind = scanner.nextLine();
                
                //find the event to update
                Event_Sec22_G15 eventToUpdate = null;
                for (Event_Sec22_G15 event : sawwahTree) {
                    if (event.getName().equals(nameToFind) && 
                        event.getDate().equals(dateToFind) && 
                        event.getStartTime().equals(startTimeToFind)) {
                        eventToUpdate = event;
                        break;
                    }
                }
                
                if (eventToUpdate == null) {
                    System.out.println("Event not found");
                } else {
                    System.out.println("Enter new event name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter new event category: ");
                    String category = scanner.nextLine();
                    System.out.println("Enter new event location: ");
                    String location = scanner.nextLine();
                    System.out.println("Enter new event region: ");
                    String region = scanner.nextLine();
                    System.out.println("Enter new event date: ");
                    String date = scanner.nextLine();
                    System.out.println("Enter new event start time: ");
                    String startTime = scanner.nextLine();
                    System.out.println("Enter new event end time: ");
                    String endTime = scanner.nextLine();
                    
                    //create updated event
                    Event_Sec22_G15 updatedEvent = new Event_Sec22_G15(name, category, location, region, date, startTime, endTime);
                    
                    //update in tree
                    if (sawwahTree.update(updatedEvent)) {
                        System.out.println("Event updated successfully");
                    } else {
                        System.out.println("Failed to update event");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Enter 1 to update another event, 0 to return to menu: ");
            key = scanner.nextInt();
            try {
                if (key != 1 && key != 0) {
                    throw new Exception("Invalid input");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("--------------------------------");
    }
    
    public static void deleteEvent() {
        System.out.println("--------------------------------");
        int key = -1;
        while (key != 0) {
            try {
                System.out.println("Enter event name to delete: ");
                scanner.nextLine();
                String nameToFind = scanner.nextLine();
                System.out.println("Enter event date to delete: ");
                String dateToFind = scanner.nextLine();
                System.out.println("Enter event start time to delete: ");
                String startTimeToFind = scanner.nextLine();
                
                //find the event to delete
                Event_Sec22_G15 eventToDelete = null;
                for (Event_Sec22_G15 event : sawwahTree) {
                    if (event.getName().equals(nameToFind) && 
                        event.getDate().equals(dateToFind) && 
                        event.getStartTime().equals(startTimeToFind)) {
                        eventToDelete = event;
                        break;
                    }
                }
                
                if (eventToDelete == null) {
                    System.out.println("Event not found");
                } else {
                    if (sawwahTree.remove(eventToDelete)) {
                        System.out.println("Event deleted successfully");
                    } else {
                        System.out.println("Failed to delete event");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Enter 1 to delete another event, 0 to return to menu: ");
            key = scanner.nextInt();
            try {
                if (key != 1 && key != 0) {
                    throw new Exception("Invalid input");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("--------------------------------");
    }

    public static void filterEvents() {
        System.out.println("--------------------------------");
        int key = -1;
        while (key != 0) {
            try {
                System.out.println("Enter category to filter (or press Enter to skip): ");
                scanner.nextLine();
                String category = scanner.nextLine();
                System.out.println("Enter region to filter (or press Enter to skip): ");
                String region = scanner.nextLine();
                System.out.println("Enter date to filter (or press Enter to skip): ");
                String date = scanner.nextLine();
                
                ArrayList<Event_Sec22_G15> filteredEvents = sawwahTree.filter(category, region, date);
                
                if (filteredEvents.isEmpty()) {
                    System.out.println("No events found matching the criteria");
                } else {
                    System.out.println("Filtered events (" + filteredEvents.size() + " found):");
                    for (Event_Sec22_G15 event : filteredEvents) {
                        System.out.println(event);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Enter 1 to filter again, 0 to return to menu: ");
            key = scanner.nextInt();
            try {
                if (key != 1 && key != 0) {
                    throw new Exception("Invalid input");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("--------------------------------");
    }

    public static void printEventsInChronologicalOrder() {
        System.out.println("--------------------------------");
        sawwahTree.printInChronologicalOrder();
        System.out.println("--------------------------------");
    }

    public static void printEventsInReverseChronologicalOrder() {
        System.out.println("--------------------------------");
        sawwahTree.printInReverseChronologicalOrder();
        System.out.println("--------------------------------");
    }

    public static void initializeTree() {
        Event_Sec22_G15[] events = {
            new Event_Sec22_G15("Discover the Future", "science", "Al Nahyan Convention Center", "Abu Dhabi", "2025-01-02", "12:00", "18:00"),
            new Event_Sec22_G15("Taste of Dubai", "food", "Dubai Marina Food Hall", "Dubai", "2025-01-14", "12:30", "17:30"),
            new Event_Sec22_G15("Grand Movie Night", "entertainment", "Emirates Cinema Complex", "Abu Dhabi", "2025-01-14", "19:00", "22:00"),
            new Event_Sec22_G15("Chemistry Expo", "Science", "Sharjah Science Museum", "Sharjah", "2025-01-15", "16:00", "17:00"),
            new Event_Sec22_G15("Tech Innovation Summit", "technology", "Dubai Tech Hub", "Dubai", "2025-01-15", "18:00", "19:00"),
            new Event_Sec22_G15("Science Fair", "Science", "Ras Al Khaimah Exhibition Hall", "Ras Al Khaimah", "2025-01-16", "20:00", "21:00"),
            new Event_Sec22_G15("Al Alain vs. Al Ahly", "sports", "Zayed Sports City Stadium", "Abu Dhabi", "2025-01-16", "13:40", "17:40"),
            new Event_Sec22_G15("Math Olympiad", "science", "Dubai International Academy", "Dubai", "2025-01-17", "10:00", "11:00"),
            new Event_Sec22_G15("Fujairah Food Festival", "food", "Fujairah Corniche Plaza", "Fujairah", "2025-01-18", "14:00", "20:00"),
            new Event_Sec22_G15("Ajman Heritage Week", "entertainment", "Ajman Museum Grounds", "Ajman", "2025-01-18", "10:00", "18:00"),
            new Event_Sec22_G15("Umm Al Quwain Marathon", "sports", "Umm Al Quwain Beach", "Umm Al Quwain", "2025-01-19", "06:00", "10:00"),
            new Event_Sec22_G15("Dubai Art Exhibition", "entertainment", "Dubai Art Gallery", "Dubai", "2025-01-19", "15:00", "19:00"),
            new Event_Sec22_G15("Abu Dhabi Robotics Competition", "technology", "Abu Dhabi Innovation Center", "Abu Dhabi", "2025-01-20", "09:00", "17:00"),
            new Event_Sec22_G15("Sharjah Book Fair", "entertainment", "Sharjah Expo Center", "Sharjah", "2025-01-20", "10:00", "22:00"),
            new Event_Sec22_G15("Ras Al Khaimah Music Festival", "entertainment", "RAK Concert Hall", "Ras Al Khaimah", "2025-01-20", "19:00", "23:00"),
            new Event_Sec22_G15("Dubai Food Truck Festival", "food", "Dubai Festival City", "Dubai", "2025-01-21", "12:00", "21:00"),
            new Event_Sec22_G15("Fujairah Diving Championship", "sports", "Fujairah Marine Club", "Fujairah", "2025-01-21", "08:00", "16:00"),
            new Event_Sec22_G15("Ajman Tech Startup Expo", "technology", "Ajman Business Center", "Ajman", "2025-01-22", "11:00", "18:00"),
            new Event_Sec22_G15("Umm Al Quwain Cultural Night", "entertainment", "Umm Al Quwain Cultural Center", "Umm Al Quwain", "2025-01-22", "18:00", "22:00"),
            new Event_Sec22_G15("Abu Dhabi Science Conference", "science", "Abu Dhabi University", "Abu Dhabi", "2025-01-23", "09:00", "16:00"),
            new Event_Sec22_G15("Dubai Fashion Week", "entertainment", "Dubai Fashion District", "Dubai", "2025-01-23", "14:00", "20:00"),
            new Event_Sec22_G15("Sharjah Astronomy Night", "science", "Sharjah Planetarium", "Sharjah", "2025-01-24", "19:00", "23:00"),
            new Event_Sec22_G15("Ras Al Khaimah Desert Safari", "sports", "RAK Desert Camp", "Ras Al Khaimah", "2025-01-24", "15:00", "19:00"),
            new Event_Sec22_G15("Fujairah Beach Volleyball", "sports", "Fujairah Beach Arena", "Fujairah", "2025-01-25", "16:00", "20:00"),
            new Event_Sec22_G15("Ajman Cooking Masterclass", "food", "Ajman Culinary Institute", "Ajman", "2025-01-25", "10:00", "14:00"),
            new Event_Sec22_G15("Umm Al Quwain Tech Workshop", "technology", "Umm Al Quwain Innovation Lab", "Umm Al Quwain", "2025-01-26", "13:00", "17:00"),
            new Event_Sec22_G15("Abu Dhabi Food & Wine", "food", "Abu Dhabi Grand Hotel", "Abu Dhabi", "2025-01-26", "18:00", "22:00"),
            new Event_Sec22_G15("Dubai Science Museum Tour", "science", "Dubai Science Center", "Dubai", "2025-01-27", "10:00", "15:00"),
        };
        for (Event_Sec22_G15 event : events) {
            sawwahTree.add(event);
        }
    }
}
