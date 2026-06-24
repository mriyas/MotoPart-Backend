package org.motopart.cloud.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.motopart.cloud.entity.Post;

/** Full listing payload. JSON keys exactly match the original API (incl. "item_tittle"). */
public class PostItemData {
    @JsonProperty("id") public String id;
    @JsonProperty("status") public String status;
    @JsonProperty("type") public String type;
    @JsonProperty("year") public String year;
    @JsonProperty("maker_id") public String makerId;
    @JsonProperty("model_id") public String modelId;
    @JsonProperty("part_id") public String partId;
    @JsonProperty("subpart_id") public String subPartId;
    @JsonProperty("part_number") public String partNumber;
    @JsonProperty("item_tittle") public String itemTittle;
    @JsonProperty("item_usage") public String itemUsage;
    @JsonProperty("item_condition") public String itemCondition;
    @JsonProperty("item_description") public String itemDescription;
    @JsonProperty("image_url_1") public String imageUrl1;
    @JsonProperty("image_url_2") public String imageUrl2;
    @JsonProperty("image_url_3") public String imageUrl3;
    @JsonProperty("image_url_4") public String imageUrl4;
    @JsonProperty("image_url_5") public String imageUrl5;
    @JsonProperty("image_url_6") public String imageUrl6;
    @JsonProperty("user_type") public String userType;
    @JsonProperty("user_id") public String userId;
    @JsonProperty("user_name") public String userName;
    @JsonProperty("location_id") public String locationId;
    @JsonProperty("location") public String location;
    @JsonProperty("createdAt") public String createdAt;
    @JsonProperty("lastUpdated") public String lastUpdated;
    @JsonProperty("price") public String price;
    @JsonProperty("phone_number") public String phoneNumber;
    @JsonProperty("maker_name") public String makerName;
    @JsonProperty("model_name") public String modelName;
    @JsonProperty("part_name") public String partName;
    @JsonProperty("subpart_name") public String subPartName;

    private static String nz(String s) { return s == null ? "" : s; }

    public static PostItemData from(Post p) {
        PostItemData d = new PostItemData();
        d.id = String.valueOf(p.getId());
        d.status = nz(p.getStatus());
        d.type = nz(p.getType());
        d.year = nz(p.getYear());
        d.makerId = nz(p.getMakerId());
        d.modelId = nz(p.getModelId());
        d.partId = nz(p.getPartId());
        d.subPartId = nz(p.getSubPartId());
        d.partNumber = nz(p.getPartNumber());
        d.itemTittle = nz(p.getItemTittle());
        d.itemUsage = nz(p.getItemUsage());
        d.itemCondition = nz(p.getItemCondition());
        d.itemDescription = nz(p.getItemDescription());
        d.imageUrl1 = nz(p.getImageUrl1());
        d.imageUrl2 = nz(p.getImageUrl2());
        d.imageUrl3 = nz(p.getImageUrl3());
        d.imageUrl4 = nz(p.getImageUrl4());
        d.imageUrl5 = nz(p.getImageUrl5());
        d.imageUrl6 = nz(p.getImageUrl6());
        d.userType = nz(p.getUserType());
        d.userId = nz(p.getUserId());
        d.userName = nz(p.getUserName());
        d.locationId = nz(p.getLocationId());
        d.location = nz(p.getLocation());
        d.createdAt = String.valueOf(p.getCreatedAt());
        d.lastUpdated = String.valueOf(p.getLastUpdated());
        d.price = nz(p.getPrice());
        d.phoneNumber = nz(p.getPhoneNumber());
        d.makerName = nz(p.getMakerName());
        d.modelName = nz(p.getModelName());
        d.partName = nz(p.getPartName());
        d.subPartName = nz(p.getSubPartName());
        return d;
    }
}
