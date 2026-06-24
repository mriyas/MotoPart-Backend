package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.motopart.cloud.entity.SubPart;

public class SubPartData {
    @JsonProperty("id") public String id;
    @JsonProperty("type") public String type;
    @JsonProperty("year") public String year;
    @JsonProperty("maker_id") public String makerId;
    @JsonProperty("model_id") public String modelId;
    @JsonProperty("part_id") public String partId;
    @JsonProperty("subpart_name") public String subPartName;
    @JsonProperty("subpart_image_url") public String subPartImageUrl;
    @JsonProperty("description") public String description;
    @JsonProperty("createdAt") public String createdAt;

    public static SubPartData from(SubPart s) {
        SubPartData d = new SubPartData();
        d.id = String.valueOf(s.getId());
        d.type = s.getType();
        d.year = s.getYear();
        d.makerId = s.getMakerId();
        d.modelId = s.getModelId();
        d.partId = s.getPartId();
        d.subPartName = s.getSubPartName();
        d.subPartImageUrl = s.getSubPartImageUrl();
        d.description = s.getDescription();
        d.createdAt = String.valueOf(s.getCreatedAt());
        return d;
    }
}
