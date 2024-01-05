package br.com.samuel.helloworld.infrastructure.products.models.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

public record UpdateProductRequest(
        @JsonProperty("nome")
        String name,

        @JsonProperty("preco")
        @Positive Double price,
        
        @JsonProperty("estoque")
        @Min(0) Integer stock

) {
}
