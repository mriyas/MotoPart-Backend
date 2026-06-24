package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.motopart.cloud.entity.Maker;

public class MakerData {
    @JsonProperty("id") public String id;
    @JsonProperty("maker_name") public String makerName;
    @JsonProperty("maker_image_url") public String makerImageUrl;
    @JsonProperty("createdAt") public String createdAt;

    public static MakerData from(Maker m) {
        MakerData d = new MakerData();
        d.id = String.valueOf(m.getId());
        d.makerName = m.getMakerName();
        d.makerImageUrl = m.getMakerImageUrl();
        d.createdAt = String.valueOf(m.getCreatedAt());
        return d;
    }
}
