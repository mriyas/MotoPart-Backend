package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.motopart.cloud.entity.YearEntity;

public class YearData {
    @JsonProperty("id") public String id;
    @JsonProperty("year") public String year;
    @JsonProperty("arabic") public String arabic;
    @JsonProperty("createdAt") public String createdAt;

    public static YearData from(YearEntity y) {
        YearData d = new YearData();
        d.id = String.valueOf(y.getId());
        d.year = y.getYear();
        d.arabic = y.getArabic() == null ? "" : y.getArabic();
        d.createdAt = String.valueOf(y.getCreatedAt());
        return d;
    }
}
