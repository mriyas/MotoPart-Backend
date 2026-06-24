package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.motopart.cloud.entity.Suggestion;

public class SuggestionData {
    @JsonProperty("id") public String id;
    @JsonProperty("search") public String search;

    public static SuggestionData from(Suggestion s) {
        SuggestionData d = new SuggestionData();
        d.id = String.valueOf(s.getId());
        d.search = s.getSearch();
        return d;
    }
}
