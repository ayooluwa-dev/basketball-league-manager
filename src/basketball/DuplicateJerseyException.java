package basketball;

public class DuplicateJerseyException extends RuntimeException { // Unchecked exception
    public DuplicateJerseyException(String message) {
        super(message);   
    }
}

