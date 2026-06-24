package org.motopart.cloud.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "maker")
public class Maker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "maker_name", nullable = false)
    private String makerName;

    @Column(name = "maker_name_arabic", nullable = false)
    private String makerNameArabic;

    @Column(name = "maker_image_url")
    private String makerImageUrl;

    @Column(name = "type")
    private String type;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public String getMakerImageUrl() {
        return makerImageUrl;
    }

    public void setMakerImageUrl(String makerImageUrl) {
        this.makerImageUrl = makerImageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getMakerNameArabic() {
        return makerNameArabic;
    }

    public void setMakerNameArabic(String makerNameArabic) {
        this.makerNameArabic = makerNameArabic;
    }
}
