package com.iipay.price.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product_prices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "regular_price", nullable = false)
    private BigDecimal regularPrice;

    @Column(name = "manager_price", nullable = false)
    private BigDecimal managerPrice;

    /**
     * Returns the appropriate price based on the user type
     *
     * @param userType the type of user
     * @return the price for the given user type
     */
    public BigDecimal getPriceForUserType(User.UserType userType) {
        return User.UserType.MANAGER.equals(userType) ? managerPrice : regularPrice;
    }
}
