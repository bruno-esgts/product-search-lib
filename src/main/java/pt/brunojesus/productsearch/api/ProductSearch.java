package pt.brunojesus.productsearch.api;

import pt.brunojesus.productsearch.api.model.Product;
import pt.brunojesus.productsearch.api.model.Store;
import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;
import pt.brunojesus.productsearch.sources.ProductSource;
import pt.brunojesus.productsearch.sources.pingodoce.PingoDoce;

import java.util.List;
import java.util.Map;

/**
 * Searches for products on supported stores
 *
 * @author Bruno Jesus
 *
 * @version 1.0
 */
public class ProductSearch {

    protected final Map<Store, ProductSource> sourceMap;

    public ProductSearch() {
        this.sourceMap = Map.of(
                Store.PINGO_DOCE, new PingoDoce()
        );
    }

    public ProductSearch(Map<Store, ProductSource> sourceMap) {
        this.sourceMap = sourceMap;
    }

    /**
     * Searches for a product by name on the specified store
     *
     * @param store       The store to use as the source
     * @param productName The name of the product to search for
     * @return A list with the found products
     *
     * @throws NoSuchStoreException if the implementation for the requested {@link Store} isn't present
     * @throws ProductFetchException if the {@link ProductSource} isn't able to fetch the product list
     */
    public List<Product> search(Store store, String productName) throws NoSuchStoreException, ProductFetchException {
        final ProductSource source = this.sourceMap.get(store);

        if (source == null) {
            throw new NoSuchStoreException("Store implementation not found: " + store.name());
        }

        return source.search(productName);
    }
}
