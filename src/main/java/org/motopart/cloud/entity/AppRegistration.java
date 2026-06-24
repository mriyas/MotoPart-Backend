package org.motopart.cloud.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "app_registration")
public class AppRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "os_info")
    private String osInfo;

    @Column(name = "model_info")
    private String modelInfo;

    @Column(name = "client_version")
    private String clientVersion;

    @Column(name = "device_token", columnDefinition = "text")
    private String deviceToken;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
    public String getOsInfo() { return osInfo; }
    public void setOsInfo(String osInfo) { this.osInfo = osInfo; }
    public String getModelInfo() { return modelInfo; }
    public void setModelInfo(String modelInfo) { this.modelInfo = modelInfo; }
    public String getClientVersion() { return clientVersion; }
    public void setClientVersion(String clientVersion) { this.clientVersion = clientVersion; }
    public String getDeviceToken() { return deviceToken; }
    public void setDeviceToken(String deviceToken) { this.deviceToken = deviceToken; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
