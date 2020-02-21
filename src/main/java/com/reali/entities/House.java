package com.reali.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class House {

    @Id
    private Long id;

    @NotNull
    @Size(max = 255)
    private String street;
    @NotNull
    @Size(max = 255)

    private String status;
    private Integer price;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer sq_ft;
    private Double lat;
    private Double lng;

    public House() {
    }

    public House(Long id, @NotNull @Size(max = 255) String street, String status, Integer price, Integer bedrooms, Integer bathrooms, Integer sq_ft, Double lat, Double lng) {
        this.id = id;
        this.street = street;
        this.status = status;
        this.price = price;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.sq_ft = sq_ft;
        this.lat = lat;
        this.lng = lng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getSq_ft() {
        return sq_ft;
    }

    public void setSq_ft(Integer sq_ft) {
        this.sq_ft = sq_ft;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
