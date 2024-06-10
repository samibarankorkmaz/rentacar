package com.samibarankorkmaz.internship.model;

import com.samibarankorkmaz.internship.common.utility.enums.EngineType;
import com.samibarankorkmaz.internship.common.utility.enums.MarketSegment;
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
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String name;
    private int seatingCapacity;
    private boolean ecoFriendly;
    @Enumerated(EnumType.STRING)
    private MarketSegment marketSegment;
    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    private List<Car> cars;

}
