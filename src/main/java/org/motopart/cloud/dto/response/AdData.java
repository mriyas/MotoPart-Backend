package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.motopart.cloud.entity.CustomAd;

public class AdData {
    @JsonProperty("id") public String id;
    @JsonProperty("adurl") public String adurl;
    @JsonProperty("status") public String status;
    @JsonProperty("outurl") public String outurl;

    public static AdData from(CustomAd a) {
        AdData d = new AdData();
        d.id = String.valueOf(a.getId());
        d.adurl = a.getAdurl();
        d.status = a.getStatus();
        d.outurl = a.getOuturl();
        return d;
    }
}
