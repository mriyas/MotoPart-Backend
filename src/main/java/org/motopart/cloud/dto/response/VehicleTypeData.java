package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.motopart.cloud.entity.VehicleType;

public class VehicleTypeData {
    @JsonProperty("id") public String id;
    @JsonProperty("type_name") public String typeName;
    @JsonProperty("createdAt") public String createdAt;

    public static VehicleTypeData from(VehicleType t) {
        VehicleTypeData d = new VehicleTypeData();
        d.id = String.valueOf(t.getId());
        d.typeName = t.getTypeName();
        d.createdAt = String.valueOf(t.getCreatedAt());
        return d;
    }
}
