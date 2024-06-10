package com.samibarankorkmaz.internship.webAPI.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.samibarankorkmaz.internship.service.abstracts.BrandService;
import com.samibarankorkmaz.internship.service.request.POST.CreateBrandRequest;
import com.samibarankorkmaz.internship.service.request.PUT.UpdateBrandRequest;
import com.samibarankorkmaz.internship.service.response.GET.GetAllBrandsResponse;
import com.samibarankorkmaz.internship.service.response.GET.GetBrandResponse;
import com.samibarankorkmaz.internship.model.Brand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rentacar/brands")
@AllArgsConstructor
public class BrandsController { //isimlendirme geleneksel olarak çoğul yani "Brands"...
    private final BrandService brandService;

    //********************* GET **********************
    @GetMapping("/brand-counter")
    public long howManyBrandsDoWeHave(){
        return brandService.howManyBrandsDoWeHave();
    }
    @GetMapping
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/get-by-id/{uuid}")
    public GetBrandResponse getById(@PathVariable UUID uuid) {
        return brandService.getById(uuid);
    }

    @GetMapping("/get-by-name/{name}")
    public GetBrandResponse getByName(@PathVariable String name) {
        return brandService.getByName(name);
    }

    @GetMapping("/get-by-origin-country/{originCountry}")
    public List<GetBrandResponse> getByOriginCountry(@PathVariable String originCountry) {
        return brandService.getByOriginCountry(originCountry);
    }

    @GetMapping("/get-by-parent-company/{parentCompany}")
    public List<GetBrandResponse> getByParentCompany(@PathVariable String parentCompany) {
        return brandService.getByParentCompany(parentCompany);
    }

    @GetMapping("/get-by-origin-country-and-parent-company")
    public List<GetBrandResponse> getByOriginCountryAndParentCompany(@RequestParam String originCountry, @RequestParam String parentCompany) {
        return brandService.getByOriginCountryAndParentCompany(originCountry, parentCompany);
    }
    //@RequestParam("originCountry") String originCountry, @RequestParam("parentCompany") kullanımı mı doğru diğeri mi

//    @GetMapping("/check-a-popular-model")
//    public ResponseEntity<Boolean> checkPopularModelByBrand(@RequestParam String brand, @RequestParam String popularModel) {
//        boolean exists = brandService.existsByBrandAndPopularModelContaining(brand, popularModel);
//        return ResponseEntity.ok(exists);
//    }


    //********************* POST *********************
    @PostMapping("/create")
    //@ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Void> add(@RequestBody CreateBrandRequest createBrandRequest, UriComponentsBuilder ucb) {
        return brandService.add(createBrandRequest, ucb);
    }

    @PostMapping("/createBulk")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addBulk(@RequestBody List<CreateBrandRequest> createBrandRequests) {
        brandService.addBulk(createBrandRequests);
    }

    //********************* PUT *********************
    @PutMapping
    public void update(UpdateBrandRequest updateBrandRequest) {
        brandService.update(updateBrandRequest);
    }

    //********************* PATCH *********************
    @PatchMapping("/{uuid}")
    public ResponseEntity<Void> patch(@PathVariable UUID uuid, @RequestBody JsonNode updates){
        brandService.patch(uuid, updates);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/patch-by-name/{name}")
    public ResponseEntity<Void> patchByName(@PathVariable String name, @RequestBody JsonNode updates){
        brandService.patchByName(name, updates);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/patch-by-parent-company/{parentCompany}")
    public ResponseEntity<Void> patchByParentCompany(@PathVariable String parentCompany, @RequestBody JsonNode updates){
        brandService.patchByParentCompany(parentCompany, updates);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/patch-by-origin-country/{originCountry}")
    public ResponseEntity<Void> patchByOriginCountry(@PathVariable String originCountry, @RequestBody JsonNode updates){
        return brandService.patchByOriginCountry(originCountry, updates);

    }
    //********************* DELETE *********************

    @DeleteMapping("/delete-all")
    public void deleteAll(){
        brandService.deleteAll();
    }


    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<Brand> deleteById(@PathVariable UUID id) {
        return brandService.deleteById(id);
    }

    @DeleteMapping("/delete-by-name/{name}")
    public ResponseEntity<GetBrandResponse> deleteByName(@PathVariable String name) {
         return brandService.deleteByName(name);
    }


}
