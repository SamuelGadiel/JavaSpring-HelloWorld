package br.com.samuel.helloworld.infrastructure.products.models.retrieve.list;

import br.com.samuel.helloworld.infrastructure.products.models.retrieve.get.GetProductSuccessResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ListProductsResponse(
        @JsonProperty("products") List<GetProductSuccessResponse> products
) {
}
