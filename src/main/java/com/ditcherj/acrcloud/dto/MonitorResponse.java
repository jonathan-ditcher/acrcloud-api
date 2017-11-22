package com.ditcherj.acrcloud.dto;

import com.ditcherj.acrcloud.response.IdentifyResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Jonathan Ditcher on 22/11/2017.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class MonitorResponse extends IdentifyResponse {

    public MonitorResponse() {
    }

}
