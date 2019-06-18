package com.hx.entity;

import com.hx.annotation.Column;
import com.hx.annotation.Id;

public class Countries {

    @Id(name="country_id")
    @Column(name = "country_id")
    private String countryId;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "region_id")
    private Integer regionId;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "countryId='" + countryId + '\'' +
                ", countryName='" + countryName + '\'' +
                ", regionId=" + regionId +
                '}';
    }
}