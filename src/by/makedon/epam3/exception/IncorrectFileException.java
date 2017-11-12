package by.makedon.epam3.exception;

public class IncorrectFileException extends Exception {
    public IncorrectFileException() {}
    public IncorrectFileException(String message) {
        super(message);
    }
    public IncorrectFileException(String message, Throwable th) {
        super(message, th);
    }
    public IncorrectFileException(Throwable th) {
        super(th);
    }
}