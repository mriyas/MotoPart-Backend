package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.motopart.cloud.entity.UserEntity;

public class UserData {
    @JsonProperty("id") public String id;
    @JsonProperty("username") public String username;
    @JsonProperty("mobile") public String mobile;
    @JsonProperty("hide_phone_number") public String hidePhoneNumber;
    @JsonProperty("email") public String email;
    @JsonProperty("locationid") public String locationid;
    @JsonProperty("location") public String location;
    @JsonProperty("type") public String type;
    @JsonProperty("doc1") public String doc1;
    @JsonProperty("doc2") public String doc2;
    @JsonProperty("profileurl") public String profileurl;
    @JsonProperty("status") public String status;
    @JsonProperty("createdAt") public String createdAt;
    @JsonProperty("lastUpdated") public String lastUpdated;

    public static UserData from(UserEntity u) {
        UserData d = new UserData();
        d.id = String.valueOf(u.getId());
        d.username = u.getUsername();
        d.mobile = u.getMobile();
        d.hidePhoneNumber = u.getHidePhoneNumber();
        d.email = u.getEmail();
        d.locationid = u.getLocationId();
        d.location = u.getLocation();
        d.type = u.getType();
        d.doc1 = u.getDoc1();
        d.doc2 = u.getDoc2();
        d.profileurl = u.getProfileUrl();
        d.status = u.getStatus();
        d.createdAt = String.valueOf(u.getCreatedAt());
        d.lastUpdated = String.valueOf(u.getLastUpdated());
        return d;
    }
}
