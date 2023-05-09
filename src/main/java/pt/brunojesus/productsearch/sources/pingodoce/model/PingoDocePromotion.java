package pt.brunojesus.productsearch.sources.pingodoce.model;

import lombok.Data;

import java.util.Date;

@Data
public class PingoDocePromotion {

    private String type;
    private Integer amount;
    private Integer takeAmount;
    private Double payAmount;
    private Date beginDate;
    private Date endDate;
}
