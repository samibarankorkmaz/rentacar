package com.samibarankorkmaz.internship.service.response.GET;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandResponse {
    private String name;
    private String originCountry;
    private String headquartersLocation;
    private List<String> popularModels;
    private String parentCompany;
}
