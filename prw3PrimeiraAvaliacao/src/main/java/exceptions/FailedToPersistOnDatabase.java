package exceptions;

public class FailedToPersistOnDatabase extends RuntimeException {
    public FailedToPersistOnDatabase(String message) {
        super(message);
    }
}
