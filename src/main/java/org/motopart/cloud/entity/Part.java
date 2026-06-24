package org.motopart.cloud.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "year")
    private String year;

    @Column(name = "maker_id")
    private String makerId;

    @Column(name = "model_id")
    private String modelId;

    @Column(name = "part_name", nullable = false)
    private String partName;

    @Column(name = "part_name_arabic", nullable = false)
    private String partNameArabic;

    @Column(name = "part_image_url")
    private String partImageUrl;

    @Column(name = "part_description", columnDefinition = "text")
    private String partDescription;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMakerId() {
        return makerId;
    }

    public void setMakerId(String makerId) {
        this.makerId = makerId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartImageUrl() {
        return partImageUrl;
    }

    public void setPartImageUrl(String partImageUrl) {
        this.partImageUrl = partImageUrl;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getPartNameArabic() {
        return partNameArabic;
    }

    public void setPartNameArabic(String partNameArabic) {
        this.partNameArabic = partNameArabic;
    }
}
