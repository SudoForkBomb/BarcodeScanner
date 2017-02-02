package com.crtaylor123.barcodescanner;

/**
 * Created by chris on 1/7/2017.
 */

import android.content.Intent;
import android.os.Parcel;

import java.util.HashMap;
import java.util.Map;

public class UPC {

        private String valid;
        private String number;
        private String itemname;
        private String alias;
        private String description;
        private String avg_price;
        private Integer rate_up;
        private Integer rate_down;

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

    public String getAvg_price() {
        return avg_price;
    }

    public void setAvg_price(String avg_price) {
        this.avg_price = avg_price;
    }

    public Integer getRate_up() {
        return rate_up;
    }

    public void setRate_up(Integer rate_up) {
        this.rate_up = rate_up;
    }

    public Integer getRate_down() {
        return rate_down;
    }

    public void setRate_down(Integer rate_down) {
        this.rate_down = rate_down;
    }

    @Override
    public String toString() {
        return "UPC{" +
                "valid='" + valid + '\'' +
                ", number='" + number + '\'' +
                ", itemname='" + itemname + '\'' +
                ", alias='" + alias + '\'' +
                ", description='" + description + '\'' +
                ", avg_price='" + avg_price + '\'' +
                ", rate_up=" + rate_up +
                ", rate_down=" + rate_down +
                '}';
    }
}