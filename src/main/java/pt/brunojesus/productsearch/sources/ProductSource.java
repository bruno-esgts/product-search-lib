package pt.brunojesus.productsearch.sources;

import pt.brunojesus.productsearch.api.Product;
import pt.brunojesus.productsearch.exception.ProductFetchException;

import java.util.List;

@FunctionalInterface
public interface ProductSource {

    List<Product> search(String name) throws ProductFetchException;
}
