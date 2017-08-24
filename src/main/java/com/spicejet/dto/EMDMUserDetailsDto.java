package com.spicejet.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EMDMUserDetailsDto {
    @JsonRawValue
    private Integer statusCode;
    @JsonRawValue
    private String message;
    @JsonRawValue
    private String status;
    private List<EmdmUserDetails> data;

    @JsonProperty("StatusCode")
    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("Data")
    public List<EmdmUserDetails> getData() {
        return data;
    }

    public void setData(List<EmdmUserDetails> data) {
        this.data = data;
    }
}
