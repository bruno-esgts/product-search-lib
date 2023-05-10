package pt.brunojesus.productsearch.sources.pingodoce.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PingoDoceSearchResponse {

    private Map<String, PingoDoceSection> sections;
    private List<PingoDoceCategory> categories;
    private List<PingoDoceBrand> brands;
}
