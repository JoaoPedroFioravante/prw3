package exceptions;

public class FailedToRemoveOfDatabase extends RuntimeException {
    public FailedToRemoveOfDatabase(String message) {
        super(message);
    }
}
