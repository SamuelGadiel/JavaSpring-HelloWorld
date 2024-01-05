package br.com.samuel.helloworld.infrastructure.products.models.delete;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DeleteProductSuccessResponse(
        @JsonProperty("id") String productId
        
) implements DeleteProductResponse {
}
