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
public class Car {
    /*
    -motor tipine, mileage'e, manufactoringYear'a göre kiralama fiyatları da değişsin. buna bir logic yazılacak.
    -toString'de dönecek bilgileri belirle
    -

     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String plate;
    private int manufacturingYear;
    private String color;
    private double mileage;
    private double dailyRentalRate;
    private double weeklyRentalRate;
    private double monthlyRentalRate;
    private double yearlyRentalRate;
    private double perKilometerRentalPrice;
    private double hourlyRentalPrice;
    private double dailyRentalPrice;
    private double weeklyRentalPrice;
    private double monthlyRentalPrice;
    private boolean isAvailable;
    private String additionalDescription;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Rental> rentals;


    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE})
    private Insurance insurance;
}
