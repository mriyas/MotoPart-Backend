package org.motopart.cloud.entity;

import jakarta.persistence.*;
import java.time.Instant;

/**
 * A marketplace listing. Note: the original DB column is "item_tittle" (typo preserved
 * intentionally so the existing Flutter client keeps working unchanged).
 */
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status = "1";

    @Column(name = "type")
    private String type;

    @Column(name = "year")
    private String year;

    @Column(name = "maker_id")
    private String makerId;

    @Column(name = "model_id")
    private String modelId;

    @Column(name = "part_id")
    private String partId;

    @Column(name = "subpart_id")
    private String subPartId;

    @Column(name = "part_number")
    private String partNumber;

    // Preserves the original "item_tittle" misspelling at the DB + JSON layer.
    @Column(name = "item_tittle")
    private String itemTittle;

    @Column(name = "item_usage", columnDefinition = "text")
    private String itemUsage;

    @Column(name = "item_condition")
    private String itemCondition;

    @Column(name = "item_description", columnDefinition = "text")
    private String itemDescription;

    @Column(name = "image_url_1") private String imageUrl1;
    @Column(name = "image_url_2") private String imageUrl2;
    @Column(name = "image_url_3") private String imageUrl3;
    @Column(name = "image_url_4") private String imageUrl4;
    @Column(name = "image_url_5") private String imageUrl5;
    @Column(name = "image_url_6") private String imageUrl6;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "location_id")
    private String locationId;

    @Column(name = "location")
    private String location;

    @Column(name = "price")
    private String price;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "sell_buy")
    private Integer sellBuy = 0;

    // Denormalized display names, returned in the listing payload.
    @Column(name = "maker_name") private String makerName;
    @Column(name = "model_name") private String modelName;
    @Column(name = "part_name") private String partName;
    @Column(name = "subpart_name") private String subPartName;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    @Column(name = "last_updated")
    private Instant lastUpdated = Instant.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }
    public String getMakerId() { return makerId; }
    public void setMakerId(String makerId) { this.makerId = makerId; }
    public String getModelId() { return modelId; }
    public void setModelId(String modelId) { this.modelId = modelId; }
    public String getPartId() { return partId; }
    public void setPartId(String partId) { this.partId = partId; }
    public String getSubPartId() { return subPartId; }
    public void setSubPartId(String subPartId) { this.subPartId = subPartId; }
    public String getPartNumber() { return partNumber; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }
    public String getItemTittle() { return itemTittle; }
    public void setItemTittle(String itemTittle) { this.itemTittle = itemTittle; }
    public String getItemUsage() { return itemUsage; }
    public void setItemUsage(String itemUsage) { this.itemUsage = itemUsage; }
    public String getItemCondition() { return itemCondition; }
    public void setItemCondition(String itemCondition) { this.itemCondition = itemCondition; }
    public String getItemDescription() { return itemDescription; }
    public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }
    public String getImageUrl1() { return imageUrl1; }
    public void setImageUrl1(String imageUrl1) { this.imageUrl1 = imageUrl1; }
    public String getImageUrl2() { return imageUrl2; }
    public void setImageUrl2(String imageUrl2) { this.imageUrl2 = imageUrl2; }
    public String getImageUrl3() { return imageUrl3; }
    public void setImageUrl3(String imageUrl3) { this.imageUrl3 = imageUrl3; }
    public String getImageUrl4() { return imageUrl4; }
    public void setImageUrl4(String imageUrl4) { this.imageUrl4 = imageUrl4; }
    public String getImageUrl5() { return imageUrl5; }
    public void setImageUrl5(String imageUrl5) { this.imageUrl5 = imageUrl5; }
    public String getImageUrl6() { return imageUrl6; }
    public void setImageUrl6(String imageUrl6) { this.imageUrl6 = imageUrl6; }
    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getLocationId() { return locationId; }
    public void setLocationId(String locationId) { this.locationId = locationId; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public Integer getSellBuy() { return sellBuy; }
    public void setSellBuy(Integer sellBuy) { this.sellBuy = sellBuy; }
    public String getMakerName() { return makerName; }
    public void setMakerName(String makerName) { this.makerName = makerName; }
    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }
    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }
    public String getSubPartName() { return subPartName; }
    public void setSubPartName(String subPartName) { this.subPartName = subPartName; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public Instant getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(Instant lastUpdated) { this.lastUpdated = lastUpdated; }
}
