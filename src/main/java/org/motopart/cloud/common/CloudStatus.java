package org.motopart.cloud.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Mirrors the original CloudStatus block: { "statusMessage": ..., "statusCode": ... }. */
public class CloudStatus {

    @JsonProperty("statusMessage")
    private String statusMessage;

    @JsonProperty("statusCode")
    private int statusCode;

    public CloudStatus() {
    }

    public CloudStatus(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
