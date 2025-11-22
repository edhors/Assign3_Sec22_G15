package exceptions;

public class InvalidTime_Sec22_G15 extends Exception {
    public InvalidTime_Sec22_G15(String time) {
        super("Entered time " + time + " is invalid");
    }
    
}
