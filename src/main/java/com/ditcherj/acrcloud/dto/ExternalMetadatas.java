package com.ditcherj.acrcloud.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Jonathan Ditcher on 22/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ExternalMetadatas {

    private ExternalMetadata spotisfy;
    private ExternalMetadata deezer;
    private ExternalMetadata lyricfind;
    private YouTubeExternalMetadata youtube;

    public ExternalMetadatas() {
    }

    public ExternalMetadata getSpotisfy() {
        return spotisfy;
    }

    public void setSpotisfy(ExternalMetadata spotisfy) {
        this.spotisfy = spotisfy;
    }

    public ExternalMetadata getDeezer() {
        return deezer;
    }

    public void setDeezer(ExternalMetadata deezer) {
        this.deezer = deezer;
    }

    public ExternalMetadata getLyricfind() {
        return lyricfind;
    }

    public void setLyricfind(ExternalMetadata lyricfind) {
        this.lyricfind = lyricfind;
    }

    public YouTubeExternalMetadata getYoutube() {
        return youtube;
    }

    public void setYoutube(YouTubeExternalMetadata youtube) {
        this.youtube = youtube;
    }

    @Override
    public String toString() {
        return "ExternalMetadatas{" +
                "spotisfy=" + spotisfy +
                ", deezer=" + deezer +
                ", lyricfind=" + lyricfind +
                ", youtube=" + youtube +
                '}';
    }
}
