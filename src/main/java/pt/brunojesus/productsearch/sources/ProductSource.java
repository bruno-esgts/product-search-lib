package pt.brunojesus.productsearch.sources;

import pt.brunojesus.productsearch.api.model.Product;
import pt.brunojesus.productsearch.exception.ProductFetchException;

import java.util.List;

/**
 * Defines the methods required in order to implement support to a {@link pt.brunojesus.productsearch.api.model.Store}
 *
 * @author Bruno Jesus
 * @version 1.1
 * @since 2023-05-10
 */
@FunctionalInterface
public interface ProductSource {

    /**
     * Searches for products in the store
     *
     * @param name The name of the product to search for
     * @return a {@link List} of {@link Product}
     * @throws ProductFetchException if there's an issue while fetching the products
     */
    List<Product> search(String name) throws ProductFetchException;
}
