package br.com.samuel.helloworld.infrastructure.products.models.retrieve.get;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetProductRequest(
        @JsonProperty("id") String id
) {
}
