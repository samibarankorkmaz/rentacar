package com.samibarankorkmaz.internship.service.request.PUT;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateBrandRequest {
    @NotNull
    @NotBlank
    private UUID uuid;
    @Size(min = 2, max = 30)
    private String name;
    @Size(min = 3, max = 40)
    private String originCountry;
    @Size(min = 3, max = 40)
    private String headquartersLocation;
    private List<String> popularModels;
    @Size(min = 2, max = 40)
    private String parentCompany;

}
