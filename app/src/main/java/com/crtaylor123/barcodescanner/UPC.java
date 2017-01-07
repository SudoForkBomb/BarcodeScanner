package com.crtaylor123.barcodescanner;

/**
 * Created by chris on 1/7/2017.
 */

public class UPC {
    private String valid;
    private String number;
    private String itemname;
    private String alias;
    private String description;
    private String avgPrice;
    private Integer rateUp;
    private Integer rateDown;

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Integer getRateUp() {
        return rateUp;
    }

    public void setRateUp(Integer rateUp) {
        this.rateUp = rateUp;
    }

    public Integer getRateDown() {
        return rateDown;
    }

    public void setRateDown(Integer rateDown) {
        this.rateDown = rateDown;
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
                '}';
    }
}
