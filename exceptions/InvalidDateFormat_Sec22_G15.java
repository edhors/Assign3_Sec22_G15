/*
csc301 Section 22 Assignment 3 Group 15 
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
*/

package exceptions;

public class InvalidDateFormat_Sec22_G15 extends Exception {
    public InvalidDateFormat_Sec22_G15(String date) {
        super("Entered date " + date + " is invalid, use format YYYY-MM-DD");
    }
}
