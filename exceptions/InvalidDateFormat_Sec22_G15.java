package exceptions;

public class InvalidDateFormat_Sec22_G15 extends Exception {
    public InvalidDateFormat_Sec22_G15(String date) {
        super("Entered date " + date + " is invalid, use format YYYY-MM-DD");
    }
}
