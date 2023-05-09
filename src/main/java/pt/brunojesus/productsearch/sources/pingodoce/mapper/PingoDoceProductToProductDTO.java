package pt.brunojesus.productsearch.sources.pingodoce.mapper;


import pt.brunojesus.productsearch.api.model.Currency;
import pt.brunojesus.productsearch.api.model.Product;
import pt.brunojesus.productsearch.sources.pingodoce.model.PingoDoceProduct;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class PingoDoceProductToProductDTO implements Function<PingoDoceProduct, Product> {
    @Override
    public Product apply(PingoDoceProduct pingoDoceProduct) {
        final String storeName = "Pingo Doce";

        final List<String> productNames = Arrays.asList(pingoDoceProduct.getFirstName(),
                pingoDoceProduct.getSecondName(), pingoDoceProduct.getThirdName());

        final String name = String.join(" ", productNames);

        final String brand = pingoDoceProduct.getBrand() == null ? null : pingoDoceProduct.getBrand().getName();

        return Product.builder()
                .name(name.trim())
                .brand(brand == null ? null : brand.trim())
                .image(imageUrl(pingoDoceProduct))
                .url(productUrl(pingoDoceProduct))
                .ean(pingoDoceProduct.getEans())
                .sku(pingoDoceProduct.getSku())
                .currentPrice(pingoDoceProduct.getBuyingPrice())
                .currency(Currency.EUR)
                .available("AVAILABLE".equals(pingoDoceProduct.getOnlineStatus()))
                .store(storeName)
                .lastUpdatedDate(LocalDateTime.now())
                .build();
    }

    private static String imageUrl(PingoDoceProduct pingoDoceProduct) {
        final String pre = "https://res.cloudinary.com/fonte-online/image/upload/c_fill,h_600,q_auto,w_600/v1/PDO_PROD/";
        return pre + pingoDoceProduct.getSku() + "_1";
    }

    private static String productUrl(PingoDoceProduct pingoDoceProduct) {
        final String pre = "https://mercadao.pt/store/pingo-doce/product/";
        return pre + pingoDoceProduct.getSlug();
    }
}
