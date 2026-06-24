package org.motopart.cloud.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Matches the original create-post payload. Note "tittle" spelling is intentional. */
public class PostRequest {
    @JsonProperty("userId") public String userId;
    public String condition;
    public String type;
    public String year;
    public String makerId;
    public String modelId;
    public String partId;
    public String subpartId;
    public String usage;
    public String tittle;
    public String description;
    public String price;
    public String img1;
    public String img2;
    public String img3;
    public String img4;
    public String img5;
    public String img6;
    public int status = 1;
    public String partNumber;
    public int sellBuy = 0;
    public String city;
}
