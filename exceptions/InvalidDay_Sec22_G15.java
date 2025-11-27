/*
csc301 Section 22 Assignment 3 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/

package exceptions;

public class InvalidDay_Sec22_G15 extends Exception {
    public InvalidDay_Sec22_G15(int day) {
        super("Entered day " + day + " is invalid");
    }
    
}
