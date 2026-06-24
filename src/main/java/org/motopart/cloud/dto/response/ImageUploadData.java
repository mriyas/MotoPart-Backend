package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageUploadData {
    @JsonProperty("url") public String url;

    public ImageUploadData(String url) { this.url = url; }
}
