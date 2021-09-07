package Exceptions;

public class InvalidArgumentException extends ParsingException {

    public InvalidArgumentException(String message) {
        super(message);
    }

    public InvalidArgumentException (String instructionName, String expectedType, String providedValue) {
        super("Invalid parameter for instruction "+instructionName+". (Expected: "+expectedType+"; Provided: "+providedValue+ ")");
    }
}
