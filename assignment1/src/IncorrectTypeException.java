/**
 * Exception thrown to indicate that the given type specifier is incorrect.
 */
public class IncorrectTypeException extends Exception {
    public IncorrectTypeException() {}

    /**
     * Constructor of IncorrectTypeException with the specified error message.
     * @param message the error message
     */
    public IncorrectTypeException(String message) {super(message);}
}
