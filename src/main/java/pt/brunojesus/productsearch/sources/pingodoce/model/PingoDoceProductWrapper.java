package pt.brunojesus.productsearch.sources.pingodoce.model;

import lombok.Data;

@Data
public class PingoDoceProductWrapper {

    private String _index;
    private String _type;
    private String _id;
    private Integer _score;
    private PingoDoceProduct _source;

}
