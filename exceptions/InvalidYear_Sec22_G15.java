package exceptions;

public class InvalidYear_Sec22_G15 extends Exception {
    public InvalidYear_Sec22_G15(int year) {
        super("Entered year " + year + " is invalid");
    }
    
}
