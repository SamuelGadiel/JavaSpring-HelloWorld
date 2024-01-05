package br.com.samuel.helloworld.infrastructure.products.models.update;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateProductSuccessResponse(
        @JsonProperty("id") String id
) implements UpdateProductResponse {
}
