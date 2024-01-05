package br.com.samuel.helloworld.infrastructure.products.models.retrieve.get;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record GetProductSuccessResponse(
        @JsonProperty("id") String id,
        @JsonProperty("nome") String name,
        @JsonProperty("preco") Double price,
        @JsonProperty("estoque") Integer stock,
        @JsonProperty("created_at") Instant createdAt,
        @JsonProperty("updated_at") Instant updatedAt
) implements GetProductResponse {
}
