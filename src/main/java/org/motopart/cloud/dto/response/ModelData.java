package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.motopart.cloud.entity.ModelEntity;

public class ModelData {
    @JsonProperty("id") public String id;
    @JsonProperty("type") public String type;
    @JsonProperty("year") public String year;
    @JsonProperty("maker_id") public String makerId;
    @JsonProperty("model_name") public String modelName;
    @JsonProperty("model_image_url") public String modelImageUrl;
    @JsonProperty("createdAt") public String createdAt;

    public static ModelData from(ModelEntity m) {
        ModelData d = new ModelData();
        d.id = String.valueOf(m.getId());
        d.type = m.getType();
        d.year = m.getYear();
        d.makerId = m.getMakerId();
        d.modelName = m.getModelName();
        d.modelImageUrl = m.getModelImageUrl();
        d.createdAt = String.valueOf(m.getCreatedAt());
        return d;
    }
}
