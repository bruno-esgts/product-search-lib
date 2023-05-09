package pt.brunojesus.productsearch.sources.pingodoce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PingoDoceSections {

    @JsonProperty("Favaios")
    private PingoDoceSection section;
}
