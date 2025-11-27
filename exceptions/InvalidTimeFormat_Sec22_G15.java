/*
csc301 Section 22 Assignment 3 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/
package exceptions;

public class InvalidTimeFormat_Sec22_G15 extends Exception {
    public InvalidTimeFormat_Sec22_G15(String time) {
        super("Entered time " + time + " is invalid, use format HH:MM");
    }
}
