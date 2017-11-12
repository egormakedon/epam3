package by.makedon.epam1.exception;

public class WrongDataException extends Exception {
    public WrongDataException() {}
    public WrongDataException(String message) {
        super(message);
    }
    public WrongDataException(String message, Throwable th) {
        super(message, th);
    }
    public WrongDataException(Throwable th) {
        super(th);
    }
}