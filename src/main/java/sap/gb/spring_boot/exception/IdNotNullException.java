package sap.gb.spring_boot.exception;

public class IdNotNullException extends RuntimeException {
    private final String MESSAGE = "Id not allowed for create method.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
