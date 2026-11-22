package basketball;

public class RosterFullException extends Exception { // Checked exception
    public RosterFullException(String message) {
        super(message);
    }
}