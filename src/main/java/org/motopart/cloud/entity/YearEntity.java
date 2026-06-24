package org.motopart.cloud.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "model_year")
public class YearEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year", nullable = false)
    private String year;

    @Column(name = "arabic")
    private String arabic;

    @Column(name = "type")
    private String type;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }
    public String getArabic() { return arabic; }
    public void setArabic(String arabic) { this.arabic = arabic; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
