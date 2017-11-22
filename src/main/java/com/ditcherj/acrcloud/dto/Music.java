package com.ditcherj.acrcloud.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Jonathan Ditcher on 22/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Music {

    @JsonProperty("external_ids")
    private ExternalIds externalIds;

    @JsonProperty("sample_begin_time_offset_ms")
    private Integer sampleBeginTimeOffsetMs;
    private String label;

    @JsonProperty("external_metadata")
    private ExternalMetadatas externalMetadatas;

    @JsonProperty("play_offset_ms")
    private Integer playOffsetMs;
    private List<Artist> artists;

    @JsonProperty("sample_end_time_offset_ms")
    private Integer sampleEndTimeOffsetMs;

    @JsonProperty("release_date")
    private String releaseDate;
    private String title;

    @JsonProperty("db_end_time_offset_ms")
    private Integer dbEndTimeOffsetMs;

    @JsonProperty("duration_ms")
    private Integer durationMs;
    private Album album;
    private String acrid;

    @JsonProperty("result_from")
    private Integer resultFrom;

    @JsonProperty("db_begin_time_offset_ms")
    private Integer dbBeginTimeOffsetMs;

    private Integer score;

    public Music() {
    }

    public ExternalIds getExternalIds() {
        return externalIds;
    }

    public void setExternalIds(ExternalIds externalIds) {
        this.externalIds = externalIds;
    }

    public Integer getSampleBeginTimeOffsetMs() {
        return sampleBeginTimeOffsetMs;
    }

    public void setSampleBeginTimeOffsetMs(Integer sampleBeginTimeOffsetMs) {
        this.sampleBeginTimeOffsetMs = sampleBeginTimeOffsetMs;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ExternalMetadatas getExternalMetadatas() {
        return externalMetadatas;
    }

    public void setExternalMetadatas(ExternalMetadatas externalMetadatas) {
        this.externalMetadatas = externalMetadatas;
    }

    public Integer getPlayOffsetMs() {
        return playOffsetMs;
    }

    public void setPlayOffsetMs(Integer playOffsetMs) {
        this.playOffsetMs = playOffsetMs;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Integer getSampleEndTimeOffsetMs() {
        return sampleEndTimeOffsetMs;
    }

    public void setSampleEndTimeOffsetMs(Integer sampleEndTimeOffsetMs) {
        this.sampleEndTimeOffsetMs = sampleEndTimeOffsetMs;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDbEndTimeOffsetMs() {
        return dbEndTimeOffsetMs;
    }

    public void setDbEndTimeOffsetMs(Integer dbEndTimeOffsetMs) {
        this.dbEndTimeOffsetMs = dbEndTimeOffsetMs;
    }

    public Integer getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Integer durationMs) {
        this.durationMs = durationMs;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getAcrid() {
        return acrid;
    }

    public void setAcrid(String acrid) {
        this.acrid = acrid;
    }

    public Integer getResultFrom() {
        return resultFrom;
    }

    public void setResultFrom(Integer resultFrom) {
        this.resultFrom = resultFrom;
    }

    public Integer getDbBeginTimeOffsetMs() {
        return dbBeginTimeOffsetMs;
    }

    public void setDbBeginTimeOffsetMs(Integer dbBeginTimeOffsetMs) {
        this.dbBeginTimeOffsetMs = dbBeginTimeOffsetMs;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Music{" +
                "external_ids=" + externalIds +
                ", sample_begin_time_offset_ms='" + sampleBeginTimeOffsetMs + '\'' +
                ", label='" + label + '\'' +
                ", external_metadata=" + externalMetadatas +
                ", play_offset_ms=" + playOffsetMs +
                ", artists=" + artists +
                ", sample_end_time_offset_ms='" + sampleEndTimeOffsetMs + '\'' +
                ", release_date='" + releaseDate + '\'' +
                ", title='" + title + '\'' +
                ", db_end_time_offset_ms='" + dbEndTimeOffsetMs + '\'' +
                ", duration_ms=" + durationMs +
                ", album=" + album +
                ", acrid='" + acrid + '\'' +
                ", result_from=" + resultFrom +
                ", db_begin_time_offset_ms='" + dbBeginTimeOffsetMs + '\'' +
                ", score=" + score +
                '}';
    }
}
