package exceptions;

public class InvalidTimeFormat_Sec22_G15 extends Exception {
    public InvalidTimeFormat_Sec22_G15(String time) {
        super("Entered time " + time + " is invalid, use format HH:MM");
    }
}
