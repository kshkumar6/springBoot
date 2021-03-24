package com.example.mobDemo.mobile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MobileRepository
        extends JpaRepository<Mobile,Long> {

    Optional<Mobile> findMobileByModelName(String ModelName);
    Optional<Mobile> findMobileByBrandName(String ModelName);
    Optional<Mobile> findMobileBySellerName(String SellerName);

    List<Mobile> findAllByBrandName(String BrandName);
    List<Mobile> findAllByModelName(String ModelName);
    List<Mobile> findAllBySellerName(String sellerName);
}
