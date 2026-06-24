package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppRegData {
    @JsonProperty("appId") public String appId;

    public AppRegData(String appId) { this.appId = appId; }
}
