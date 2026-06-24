package org.motopart.cloud.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "subpart")
public class SubPart {
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

    @Column(name = "part_id")
    private String partId;

    @Column(name = "subpart_name", nullable = false)
    private String subPartName;

    @Column(name = "subpart_name_arabic", nullable = false)
    private String subPartNameArabic;

    @Column(name = "subpart_image_url")
    private String subPartImageUrl;

    @Column(name = "description", columnDefinition = "text")
    private String description;

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

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getSubPartName() {
        return subPartName;
    }

    public void setSubPartName(String subPartName) {
        this.subPartName = subPartName;
    }

    public String getSubPartImageUrl() {
        return subPartImageUrl;
    }

    public void setSubPartImageUrl(String subPartImageUrl) {
        this.subPartImageUrl = subPartImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getSubPartNameArabic() {
        return subPartNameArabic;
    }

    public void setSubPartNameArabic(String subPartNameArabic) {
        this.subPartNameArabic = subPartNameArabic;
    }
}
