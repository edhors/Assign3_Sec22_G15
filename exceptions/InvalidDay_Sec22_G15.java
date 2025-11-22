package exceptions;

public class InvalidDay_Sec22_G15 extends Exception {
    public InvalidDay_Sec22_G15(int day) {
        super("Entered day " + day + " is invalid");
    }
    
}
