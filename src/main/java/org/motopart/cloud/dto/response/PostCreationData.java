package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostCreationData {
    @JsonProperty("postId") public String postId;

    public PostCreationData(String postId) { this.postId = postId; }
}
