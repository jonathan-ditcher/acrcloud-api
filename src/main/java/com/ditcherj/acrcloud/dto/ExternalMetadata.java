package com.ditcherj.acrcloud.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Jonathan Ditcher on 22/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ExternalMetadata {

    private Album album;
    private List<Artist> artists;
    private Track track;

    public ExternalMetadata() {
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    @Override
    public String toString() {
        return "ExternalMetadata{" +
                "album=" + album +
                ", artists=" + artists +
                ", track=" + track +
                '}';
    }
}
