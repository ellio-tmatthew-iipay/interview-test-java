package com.iipay.price.api.dto;

import com.iipay.price.api.model.Product;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PriceResponseDTO {

    private String productName;
    private BigDecimal price;

    public static PriceResponseDTO fromProduct(Product product) {
        return PriceResponseDTO.builder()
                .productName(product.getName())
                .price(product.getPrices().get(0).getManagerPrice())
                .build();
    }
}
