package pt.brunojesus.productsearch.api.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a product fetched from a source
 *
 * @author Bruno Jesus
 * @version 1.1
 */
@Data
@Builder
public class Product implements Serializable {

    private String name;
    private String brand;
    private String image;
    private String url;
    private List<String> ean;
    private String sku;
    private Double currentPrice;
    private Currency currency;
    private LocalDateTime lastUpdatedDate;
    private String store;
    private boolean available;
}
