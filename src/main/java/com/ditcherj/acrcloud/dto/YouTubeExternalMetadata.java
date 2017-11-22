package com.ditcherj.acrcloud.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Jonathan Ditcher on 22/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class YouTubeExternalMetadata extends ExternalMetadata {

    private String vid;

    public YouTubeExternalMetadata() {
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    @Override
    public String toString() {
        return "YouTubeExternalMetadata{" +
                "vid='" + vid + '\'' +
                "} " + super.toString();
    }
}
