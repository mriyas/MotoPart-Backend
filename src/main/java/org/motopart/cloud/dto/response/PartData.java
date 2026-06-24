package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.motopart.cloud.entity.Part;

public class PartData {
    @JsonProperty("id") public String id;
    @JsonProperty("type") public String type;
    @JsonProperty("year") public String year;
    @JsonProperty("maker_id") public String makerId;
    @JsonProperty("model_id") public String modelId;
    @JsonProperty("part_name") public String partName;
    @JsonProperty("part_image_url") public String partImageUrl;
    @JsonProperty("part_description") public String partDescription;
    @JsonProperty("createdAt") public String createdAt;

    public static PartData from(Part p) {
        PartData d = new PartData();
        d.id = String.valueOf(p.getId());
        d.type = p.getType();
        d.year = p.getYear();
        d.makerId = p.getMakerId();
        d.modelId = p.getModelId();
        d.partName = p.getPartName();
        d.partImageUrl = p.getPartImageUrl();
        d.partDescription = p.getPartDescription();
        d.createdAt = String.valueOf(p.getCreatedAt());
        return d;
    }
}
