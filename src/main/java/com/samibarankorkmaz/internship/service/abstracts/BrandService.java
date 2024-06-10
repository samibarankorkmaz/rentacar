package com.samibarankorkmaz.internship.service.abstracts;

import com.fasterxml.jackson.databind.JsonNode;
import com.samibarankorkmaz.internship.service.request.POST.CreateBrandRequest;
import com.samibarankorkmaz.internship.service.request.PUT.UpdateBrandRequest;
import com.samibarankorkmaz.internship.service.response.GET.GetAllBrandsResponse;
import com.samibarankorkmaz.internship.service.response.GET.GetBrandResponse;
import com.samibarankorkmaz.internship.model.Brand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

public interface BrandService {

    //**************** GET ****************
    long howManyBrandsDoWeHave();

    List<GetAllBrandsResponse> getAll();

    GetBrandResponse getById(UUID uuid);

    GetBrandResponse getByName(String name);

    List<GetBrandResponse> getByOriginCountry(String originCountry);

    List<GetBrandResponse> getByParentCompany(String parentCompany);

    List<GetBrandResponse> getByOriginCountryAndParentCompany(String originCountry, String parentCompany);

    //**************** POST ****************
    ResponseEntity<Void> add(CreateBrandRequest createBrandRequest, UriComponentsBuilder ucb);

    void addBulk(List<CreateBrandRequest> createBrandRequests);

    //**************** PUT ****************
    void update(UpdateBrandRequest updateBrandRequest);

    //**************** PATCH ****************
    void patch(UUID uuid, JsonNode updates);
    void patchByName(String name, JsonNode updates);

    void patchByParentCompany(String parentCompany, JsonNode updates);

    ResponseEntity<Void> patchByOriginCountry(String originCountry, JsonNode updates);

    //**************** DELETE ****************
    void deleteAll();

    ResponseEntity<Brand> deleteById(UUID id);

    ResponseEntity<GetBrandResponse> deleteByName(String name);



    // ---- EXISTS? ----
//    boolean existsByBrandAndPopularModelContaining(String brand, String popularModel);


}
