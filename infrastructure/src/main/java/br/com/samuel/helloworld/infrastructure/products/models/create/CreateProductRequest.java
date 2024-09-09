package br.com.samuel.helloworld.infrastructure.products.models.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateProductRequest(
        @JsonProperty("nome")
        @NotBlank(message = "Campo [nome] é requerido")
        String name,

        @JsonProperty("preco")
        @NotNull(message = "Campo [preco] é requerido")
        @Positive(message = "Campo [preco] deve ser positivo")
        Double price,

        @JsonProperty("estoque")
        @NotNull(message = "Campo [estoque] é requerido")
        @Min(value = 0, message = "Campo [preco] deve ser positivo")
        Integer stock
) {
}
