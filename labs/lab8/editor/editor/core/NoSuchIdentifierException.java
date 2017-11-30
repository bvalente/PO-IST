package editor.core;


/**
 * Exception for representing cases where an identifier does not correspond to a domain entity
 *
 * @author Programação com Objectos
 * @version 3.1
 */
public class NoSuchIdentifierException extends Exception {
    private final int _identifierNotFound;
    /**
     * Serial number for serialization.
     */
    private static final long serialVersionUID = 4577917255267517902L;

    /**
     * Constructor.
     */
    public NoSuchIdentifierException(int id) {
        _identifierNotFound = id;
    }

    /**
     * Constructor.
     *
     * @param message error string.
     */
    public NoSuchIdentifierException(int id, String message) {
        super(message);
        _identifierNotFound = id;
    }

    public final int getIdentifierNotFound() {
        return _identifierNotFound;
    }
}
