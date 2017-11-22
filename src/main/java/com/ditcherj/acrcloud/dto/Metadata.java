package com.ditcherj.acrcloud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by Jonathan Ditcher on 22/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Metadata {

    private List<Music> music;

    @JsonProperty("played_duration")
    private Integer playedDuration;

    @JsonProperty("timestamp_utc")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date timestampUtc;

    public Metadata() {
    }

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(List<Music> music) {
        this.music = music;
    }

    public Date getTimestampUtc() {
        return timestampUtc;
    }

    public void setTimestampUtc(Date timestampUtc) {
        this.timestampUtc = timestampUtc;
    }

    public Integer getPlayedDuration() {
        return playedDuration;
    }

    public void setPlayedDuration(Integer playedDuration) {
        this.playedDuration = playedDuration;
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "music=" + music +
                ", timestampUtc='" + timestampUtc + '\'' +
                ", played_duration=" + playedDuration +
                '}';
    }
}
