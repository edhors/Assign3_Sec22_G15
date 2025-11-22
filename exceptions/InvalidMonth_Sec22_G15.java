package exceptions;

public class InvalidMonth_Sec22_G15 extends Exception {
    public InvalidMonth_Sec22_G15(int month) {
        super("Entered month " + month + " is invalid");
    }
}
