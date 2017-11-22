package com.ditcherj.acrcloud.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Jonathan Ditcher on 22/11/2017.
 *
 *
 Code	Description
 1001	No Result
 3001	Missing/Invalid Access Key
 3002	Invalid ContentType. valid Content-Type is multipart/form-data
 3003	Limit exceeded
 3006	Invalid parameters
 3011	metadata error
 3014	InvalidSignature
 3015	Could not generate fingerprint
 3016	The file you uploaded was too large, we sugguest you cut large file to smaller file, 10-20 seconds audio file is enough to identify

 2002	Metadata parse error
 2004	Unable to generate fingerprint
 2005	Timeout
 3000	Recognition service error（http error 500）
 2000	Recording error (device may not have permission)
 1001	No recognition result
 0	Recognition succeed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseStatus {

    private Integer code;
    private String msg;
    private String version;

    public ResponseStatus() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ResponseStatus{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
