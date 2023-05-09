package pt.brunojesus.productsearch.exception;

public class NoSuchStoreException extends Exception {

    public NoSuchStoreException() {
        super();
    }

    public NoSuchStoreException(String message) {
        super(message);
    }

    public NoSuchStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
