package pt.brunojesus.productsearch.sources.pingodoce;

import pt.brunojesus.productsearch.api.Product;
import pt.brunojesus.productsearch.exception.ProductFetchException;
import pt.brunojesus.productsearch.sources.ProductSource;
import pt.brunojesus.productsearch.sources.pingodoce.http.PingoDoceClient;
import pt.brunojesus.productsearch.sources.pingodoce.http.PingoDoceSearchResponseHandler;
import pt.brunojesus.productsearch.sources.pingodoce.mapper.PingoDoceProductToProductDTO;
import pt.brunojesus.productsearch.sources.pingodoce.model.PingoDoceProduct;
import pt.brunojesus.productsearch.sources.pingodoce.model.PingoDoceProductWrapper;
import pt.brunojesus.productsearch.sources.pingodoce.model.PingoDoceSearchResponse;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class PingoDoce implements ProductSource {

    final PingoDoceClient pingoDoceClient;
    final Function<PingoDoceProduct, Product> mapper;

    public PingoDoce() {
        pingoDoceClient = new PingoDoceClient();
        mapper = new PingoDoceProductToProductDTO();
    }

    public PingoDoce(PingoDoceClient pingoDoceClient, Function<PingoDoceProduct, Product> mapper) {
        this.pingoDoceClient = pingoDoceClient;
        this.mapper = mapper;
    }

    @Override
    public List<Product> search(String name) throws ProductFetchException {
        List<Product> result = null;
        try {
            result = pingoDoceClient.search(name, 0, 10)
                    .getSections().getSection().getProducts()
                    .stream()
                    .map(PingoDoceProductWrapper::get_source)
                    .map(mapper)
                    .toList();
        } catch (IOException e) {
            throw ProductFetchException.searchError(name, "Pingo Doce", e);
        }

        return result;
    }
}
