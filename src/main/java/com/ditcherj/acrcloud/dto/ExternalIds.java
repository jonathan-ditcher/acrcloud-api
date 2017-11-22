package com.ditcherj.acrcloud.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Jonathan Ditcher on 22/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ExternalIds {

    private String isrc;
    private String upc;

    public ExternalIds() {
    }

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    @Override
    public String toString() {
        return "ExternalIds{" +
                "isrc='" + isrc + '\'' +
                ", upc='" + upc + '\'' +
                '}';
    }
}
