package com.iipay.price.api.dto;

import com.iipay.price.api.model.ProductPrice;
import com.iipay.price.api.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO {
    private Long productId;
    private String productName;
    private String country;
    private BigDecimal price;

    /**
     * Create a PriceDTO from a ProductPrice entity, with the price adjusted for the user type
     *
     * @param productPrice the product price entity
     * @param userType     the type of user (REGULAR or MANAGER)
     * @return a new PriceDTO with the appropriate price for the user type
     */
    public static PriceDTO fromEntity(ProductPrice productPrice, User.UserType userType) {
        PriceDTO dto = new PriceDTO();
        dto.setProductId(productPrice.getProduct().getId());
        dto.setProductName(productPrice.getProduct().getName());
        dto.setCountry(productPrice.getCountry());
        dto.setPrice(productPrice.getPriceForUserType(userType));
        return dto;
    }
}