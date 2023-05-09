package pt.brunojesus.productsearch.sources.pingodoce.model;

import lombok.Data;

import java.util.List;

@Data
public class PingoDoceSearchResponse {

    private PingoDoceSections sections;
    private List<PingoDoceCategory> categories;
    private List<PingoDoceBrand> brands;
}
