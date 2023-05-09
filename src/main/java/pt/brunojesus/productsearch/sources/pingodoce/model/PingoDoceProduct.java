package pt.brunojesus.productsearch.sources.pingodoce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PingoDoceProduct {

    private String firstName;
    private String secondName;
    private String thirdName;
    private String longDescription;
    private String shortDescription;
    private String sku;
    private Integer imagesNumber;
    private Integer grossWeight;
    private String capacity;
    private Double netContent;
    private String netContentUnit;
    private Integer averageWeight;
    private String onlineStatus;
    private String status;
    private String slug;
    private List<String> tags;
    private List<PingoDoceCategory> categories;
    private List<String> eans;
    private PingoDoceBrand brand;
    private String catalogueId;
    private List<String> categoriesArray;
    private List<PingoDoceCategory> leafCategories;
    @JsonProperty("isPerishable")
    private Boolean isPerishable;
    private List<String> ancestorsCategoriesArray;
    private Double regularPrice;
    private Double campaignPrice;
    private Double buyingPrice;
    private Double unitPrice;
    private PingoDocePromotion promotion;
    private Integer minimumOrderableQuantity;
    private Integer maximumOrderableQuantity;
    private List<Object> qualitativeIcons; //TODO: type
    private List<String> countriesOfOrigin;
    private String additionalInfo;
    private Integer durabilityDays;
    private boolean activePromotion;
}
