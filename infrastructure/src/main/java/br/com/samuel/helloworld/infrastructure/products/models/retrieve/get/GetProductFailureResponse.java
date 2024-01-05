package br.com.samuel.helloworld.infrastructure.products.models.retrieve.get;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetProductFailureResponse(
        @JsonProperty("mensagem") String message
) implements GetProductResponse {
}
