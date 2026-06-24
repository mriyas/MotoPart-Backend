package org.motopart.cloud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "suggestion")
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "search", nullable = false)
    private String search;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSearch() { return search; }
    public void setSearch(String search) { this.search = search; }
}
