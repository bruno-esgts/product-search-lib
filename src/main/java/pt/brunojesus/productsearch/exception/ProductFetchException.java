package pt.brunojesus.productsearch.exception;

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
}
