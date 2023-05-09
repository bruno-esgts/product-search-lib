package pt.brunojesus.productsearch.sources.pingodoce.model;

import lombok.Data;

import java.util.List;

@Data
public class PingoDoceSection {

    private Integer total;
    private List<PingoDoceProductWrapper> products;
}
