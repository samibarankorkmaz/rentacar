package com.samibarankorkmaz.internship.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String name;
    private String originCountry;
    private String headquartersLocation;
    //@ElementCollection
    private List<String> popularModels;
    private String parentCompany;
    private String logoImageURL;
    private String websiteURL;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private List<Model> models;


}
