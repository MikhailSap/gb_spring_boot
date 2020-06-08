package sap.gb.spring_boot.exception;

public class NoSuchUserException extends RuntimeException{
    private final String MESSAGE = "No found such user.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
