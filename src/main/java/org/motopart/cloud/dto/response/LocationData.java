package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.motopart.cloud.entity.Location;

public class LocationData {
    @JsonProperty("id") public String id;
    @JsonProperty("location_name") public String locationName;

    public static LocationData from(Location l) {
        LocationData d = new LocationData();
        d.id = String.valueOf(l.getId());
        d.locationName = l.getLocationName();
        return d;
    }
}
