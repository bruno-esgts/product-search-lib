package pt.brunojesus.productsearch.sources.pingodoce.http;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import pt.brunojesus.productsearch.sources.pingodoce.model.PingoDoceSearchResponse;

public class PingoDoceSearchResponseHandler implements HttpClientResponseHandler<PingoDoceSearchResponse> {

	private final ObjectMapper objectMapper;

	public PingoDoceSearchResponseHandler() {
		this.objectMapper = new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public PingoDoceSearchResponseHandler(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public PingoDoceSearchResponse handleResponse(ClassicHttpResponse response) throws IOException {
		if (response.getCode() < 200 || response.getCode() > 299) {
			return null;
		}

		try (InputStream body = response.getEntity().getContent()) {
			return this.objectMapper.readValue(body, PingoDoceSearchResponse.class);
		}
	}

}