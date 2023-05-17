package pt.brunojesus.productsearch.exception;

/**
 * Exception to be thrown when there's a failure on the {@link pt.brunojesus.productsearch.sources.ProductSource}
 * implementation when trying to fetch the product list.
 *
 * @author Bruno Jesus
 * @version 1.1
 * @since 2023-05-11
 */
public class ProductFetchException extends Exception {
    public ProductFetchException(String message) {
        super(message);
    }

    public ProductFetchException(String message, Throwable cause) {
        super(message, cause);
    }

    public static ProductFetchException searchError(String query, String storeName, Throwable cause) {
        final String message = String.format("Error searching for '%s' on '%s'", query, storeName);
        return new ProductFetchException(message, cause);
    }

    public static ProductFetchException searchError(String query, String storeName, String details, Throwable cause) {
        final String message = String.format("Error searching for '%s' on '%s': %s", query, storeName, details);
        return new ProductFetchException(message, cause);
    }
}
