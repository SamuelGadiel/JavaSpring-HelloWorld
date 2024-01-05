package br.com.samuel.helloworld.infrastructure.products.models.update;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateProductFailureResponse(
        @JsonProperty("mensagem") String message
) implements UpdateProductResponse {
}
