package br.com.samuel.helloworld.infrastructure.products.models.delete;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DeleteProductFailureResponse(
        @JsonProperty("mensagem") String message
) implements DeleteProductResponse {
}
