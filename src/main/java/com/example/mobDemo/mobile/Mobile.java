package com.example.mobDemo.mobile;

import javax.persistence.*;
import java.lang.management.MonitorInfo;
import java.util.Objects;

@Entity
public class Mobile {

    @Id
    @SequenceGenerator(
          name = "mobile_sequence",
          sequenceName = "mobile_sequence",
          allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "mobile_sequence"
    )

    private Long id;
    private String modelName;
    private String brandName;
    private String sellerName;
    private int launchYear;
    private String operatingSystem;
    private int price;
    private int count;

    Mobile(){}
    public Mobile(Long id, String modelName, String brandName, String sellerName, int launchYear, String operatingSystem, int price, int count) {
        this.id = id;
        this.modelName = modelName;
        this.brandName = brandName;
        this.sellerName = sellerName;
        this.launchYear = launchYear;
        this.operatingSystem = operatingSystem;
        this.price = price;
        this.count = count;
    }

    public Mobile(String modelName, String brandName, String sellerName, int launchYear, String operatingSystem, int price, int count) {
        this.modelName = modelName;
        this.brandName = brandName;
        this.sellerName = sellerName;
        this.launchYear = launchYear;
        this.operatingSystem = operatingSystem;
        this.price = price;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", ModelName='" + modelName + '\'' +
                ", BrandName='" + brandName + '\'' +
                ", SellerName='" + sellerName + '\'' +
                ", LaunchYear=" + launchYear +
                ", OperatingSystem='" + operatingSystem + '\'' +
                ", Price=" + price +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobile mobile = (Mobile) o;
        return launchYear == mobile.launchYear &&
                price == mobile.price &&
                count == mobile.count &&
                id.equals(mobile.id) &&
                Objects.equals(modelName, mobile.modelName) &&
                Objects.equals(brandName, mobile.brandName) &&
                Objects.equals(sellerName, mobile.sellerName) &&
                Objects.equals(operatingSystem, mobile.operatingSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelName, brandName, sellerName, launchYear, operatingSystem, price, count);
    }
}

