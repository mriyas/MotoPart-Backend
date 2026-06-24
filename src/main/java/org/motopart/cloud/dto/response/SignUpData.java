package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.motopart.cloud.entity.UserEntity;

public class SignUpData {
    @JsonProperty("token") public String token;
    @JsonProperty("userId") public String userId;
    @JsonProperty("userType") public String userType;
    @JsonProperty("emailId") public String emailId;
    @JsonProperty("userName") public String userName;
    @JsonProperty("locName") public String locName;
    @JsonProperty("profileUrl") public String profileUrl;

    public static SignUpData from(UserEntity u) {
        SignUpData d = new SignUpData();
        d.token = u.getToken();
        d.userId = String.valueOf(u.getId());
        d.userType = u.getType();
        d.emailId = u.getEmail();
        d.userName = u.getUsername();
        d.locName = u.getLocation();
        d.profileUrl = u.getProfileUrl();
        return d;
    }
}
