package com.samibarankorkmaz.internship.service.request.POST;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 40)
    private String originCountry;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 40)
    private String headquartersLocation;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 40)
    private String parentCompany;
}
