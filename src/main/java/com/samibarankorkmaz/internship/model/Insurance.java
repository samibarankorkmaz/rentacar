package com.samibarankorkmaz.internship.model;

import com.samibarankorkmaz.internship.common.utility.enums.InsuranceCompany;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    //allianz, anadolu, axa, generali, hdi, mapfre
    @Column(unique = true, nullable = false)
    private String policyNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean comprehensiveInsurance;
    private boolean theftInsurance;
    private boolean fireInsurance;
    private boolean glassInsurance;
    @Enumerated(EnumType.STRING)
    private InsuranceCompany insuranceCompany;
    /*
    zorunlu trafik sigortası

    zorunlu sigorta, kaza sonucu yaralanma veya ölüm, üçüncü şahıslara veya araçlara verilen maddi hasar, mülkiyetlere verilen zararlar, hukuki savunma ve tazminat masraflarını kapsar ve kiralama şirketimizdeki her arabada otomatik mevcuttur.
    */
    private boolean breakdownAssistance;
    private boolean roadsideAssistance;
    //TODO comprehensive true ise diğerleri de otomatik true olmalı
    //TODO theft  true ise breakdown da true olmalı
    //TODO fire veya glass true ise roadside de true olmalı

    @OneToOne(mappedBy = "insurance", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    private Car car;


}
