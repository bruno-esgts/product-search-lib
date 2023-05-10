package pt.brunojesus.productsearch.exception;

/**
 * Exception to be thrown when there's no {@link pt.brunojesus.productsearch.sources.ProductSource}
 * for the required {@link pt.brunojesus.productsearch.api.model.Store}
 *
 * @author Bruno Jesus
 * @version 1.1
 * @since 2023-05-10
 */
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
