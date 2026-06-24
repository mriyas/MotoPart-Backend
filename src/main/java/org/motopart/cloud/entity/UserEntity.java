package org.motopart.cloud.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "app_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "hide_phone_number")
    private String hidePhoneNumber = "0";

    @Column(name = "email")
    private String email;

    @Column(name = "location_id")
    private String locationId;

    @Column(name = "location")
    private String location;

    @Column(name = "type")
    private String type;

    @Column(name = "doc1")
    private String doc1;

    @Column(name = "doc2")
    private String doc2;

    @Column(name = "profile_url")
    private String profileUrl;

    @Column(name = "status")
    private String status = "1";

    @Column(name = "app_id")
    private String appId;

    @Column(name = "token", columnDefinition = "text")
    private String token;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    @Column(name = "last_updated")
    private Instant lastUpdated = Instant.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public String getHidePhoneNumber() { return hidePhoneNumber; }
    public void setHidePhoneNumber(String hidePhoneNumber) { this.hidePhoneNumber = hidePhoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getLocationId() { return locationId; }
    public void setLocationId(String locationId) { this.locationId = locationId; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getDoc1() { return doc1; }
    public void setDoc1(String doc1) { this.doc1 = doc1; }
    public String getDoc2() { return doc2; }
    public void setDoc2(String doc2) { this.doc2 = doc2; }
    public String getProfileUrl() { return profileUrl; }
    public void setProfileUrl(String profileUrl) { this.profileUrl = profileUrl; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getAppId() { return appId; }
    public void setAppId(String appId) { this.appId = appId; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public Instant getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(Instant lastUpdated) { this.lastUpdated = lastUpdated; }
}
