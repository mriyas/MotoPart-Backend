package org.motopart.cloud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "custom_ad")
public class CustomAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adurl")
    private String adurl;

    @Column(name = "status")
    private String status = "1";

    @Column(name = "outurl")
    private String outurl;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAdurl() { return adurl; }
    public void setAdurl(String adurl) { this.adurl = adurl; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getOuturl() { return outurl; }
    public void setOuturl(String outurl) { this.outurl = outurl; }
}
