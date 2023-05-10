package pt.brunojesus.productsearch.sources.pingodoce.http;


import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import pt.brunojesus.productsearch.sources.pingodoce.model.PingoDoceSearchResponse;

public class PingoDoceClient {

    private final static String searchUrlFormat =
            "https://mercadao.pt/api/catalogues/6107d28d72939a003ff6bf51/products/search?query=%s&from=%d&size=%d&esPreference=0";

    private final PingoDoceSearchResponseHandler responseHandler;

    public PingoDoceClient() {
        this.responseHandler = new PingoDoceSearchResponseHandler();
    }

    public PingoDoceClient(PingoDoceSearchResponseHandler responseHandler) {
        super();
        this.responseHandler = responseHandler;
    }

    public PingoDoceSearchResponse search(String searchExpression, int offset, int limit) throws IOException {
        final String url = String.format(
                searchUrlFormat,
                URLEncoder.encode(searchExpression, StandardCharsets.UTF_8),
                offset,
                limit
        );

        final HttpGet request = createHttpGet(url);

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            return client.execute(request, responseHandler);
        }
    }

    private HttpGet createHttpGet(String url) {
        final HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Content-type", "application/json");
        return httpGet;
    }
}