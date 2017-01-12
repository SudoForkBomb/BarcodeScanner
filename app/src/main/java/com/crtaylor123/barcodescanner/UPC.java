package com.crtaylor123.barcodescanner;

/**
 * Created by chris on 1/7/2017.
 */

import java.util.HashMap;
import java.util.Map;

public class UPC {

    private String valid;
    private String number;
    private String itemname;
    private String alias;
    private String description;
    private String avgPrice;
    private Integer rateUp;
    private Integer rateDown;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public UPC() {
    }

    /**
     *
     * @param valid
     * @param rateUp
     * @param avgPrice
     * @param alias
     * @param itemname
     * @param description
     * @param number
     * @param rateDown
     */
    public UPC(String valid, String number, String itemname, String alias, String description, String avgPrice, Integer rateUp, Integer rateDown) {
        super();
        this.valid = valid;
        this.number = number;
        this.itemname = itemname;
        this.alias = alias;
        this.description = description;
        this.avgPrice = avgPrice;
        this.rateUp = rateUp;
        this.rateDown = rateDown;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public UPC withValid(String valid) {
        this.valid = valid;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UPC withNumber(String number) {
        this.number = number;
        return this;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public UPC withItemname(String itemname) {
        this.itemname = itemname;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public UPC withAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UPC withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
    }

    public UPC withAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
        return this;
    }

    public Integer getRateUp() {
        return rateUp;
    }

    public void setRateUp(Integer rateUp) {
        this.rateUp = rateUp;
    }

    public UPC withRateUp(Integer rateUp) {
        this.rateUp = rateUp;
        return this;
    }

    public Integer getRateDown() {
        return rateDown;
    }

    public void setRateDown(Integer rateDown) {
        this.rateDown = rateDown;
    }

    public UPC withRateDown(Integer rateDown) {
        this.rateDown = rateDown;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public UPC withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "UPC{" +
                "valid='" + valid + '\'' +
                ", number='" + number + '\'' +
                ", itemname='" + itemname + '\'' +
                ", alias='" + alias + '\'' +
                ", description='" + description + '\'' +
                ", avgPrice='" + avgPrice + '\'' +
                ", rateUp=" + rateUp +
                ", rateDown=" + rateDown +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}