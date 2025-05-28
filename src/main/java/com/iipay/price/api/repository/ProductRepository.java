package com.iipay.price.api.repository;

import com.iipay.price.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN p.prices pr " +
            "WHERE pr.country = :country " +
            "AND (p.name LIKE CONCAT('%' , :name, '%')" +
            "OR p.description LIKE CONCAT('%' , :name, '%'))")
    List<Product> findProductsByCountryAndNameOrDescription(@Param("name") String name, @Param("country") String country);
}