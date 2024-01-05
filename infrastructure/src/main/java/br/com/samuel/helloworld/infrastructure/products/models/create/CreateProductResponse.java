package br.com.samuel.helloworld.infrastructure.products.models.create;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateProductResponse(
        @JsonProperty("id") String productId
) {
}
