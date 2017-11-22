package com.ditcherj.acrcloud.response;

import com.ditcherj.acrcloud.dto.Metadata;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Jonathan Ditcher on 22/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class IdentifyResponse extends Response {

    private Metadata metadata;

    public IdentifyResponse() {
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "IdentifyResponse{" +
                "metadata=" + metadata +
                "} " + super.toString();
    }
}
