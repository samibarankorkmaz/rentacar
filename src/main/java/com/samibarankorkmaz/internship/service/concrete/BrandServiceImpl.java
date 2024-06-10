package com.samibarankorkmaz.internship.service.concrete;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samibarankorkmaz.internship.service.abstracts.BrandService;
import com.samibarankorkmaz.internship.service.request.POST.CreateBrandRequest;
import com.samibarankorkmaz.internship.service.request.PUT.UpdateBrandRequest;
import com.samibarankorkmaz.internship.service.response.GET.GetAllBrandsResponse;
import com.samibarankorkmaz.internship.service.response.GET.GetBrandResponse;
import com.samibarankorkmaz.internship.service.rules.BrandBusinessRules;
import com.samibarankorkmaz.internship.common.utility.exception.BusinessException;
import com.samibarankorkmaz.internship.common.utility.mappers.modelmapper.ModelMapperService;
import com.samibarankorkmaz.internship.repository.abstracts.BrandRepository;
import com.samibarankorkmaz.internship.model.Brand;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    //private final EntityManager entityManager; //bean eklemek gerekli değil sanırım external bir sey olmadıgı için? JPA'nın sınıfı çünkü...
    private final BrandBusinessRules brandBusinessRules;


    //********************* GET *********************

    @Override
    public long howManyBrandsDoWeHave() {
        return brandRepository.count();
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

        return brands.stream().map(brand -> modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList()); //veya --> direkt ".toList()"
    }

    @Override
    public GetBrandResponse getById(UUID uuid) {
        Brand brand = brandRepository.findById(uuid).orElseThrow();
        return modelMapperService.forResponse().map(brand, GetBrandResponse.class);
    }

    @Override
    public GetBrandResponse getByName(String name) {
        Brand brand = brandRepository.findByName(name);
        return modelMapperService.forResponse().map(brand, GetBrandResponse.class);
    }

    @Override
    public List<GetBrandResponse> getByOriginCountry(String originCountry) {
        List<Brand> brands = brandRepository.findByOriginCountry(originCountry);
        return brands.stream().map(brand -> modelMapperService.forResponse().map(brand, GetBrandResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<GetBrandResponse> getByParentCompany(String parentCompany) {
        List<Brand> brands = brandRepository.findByParentCompany(parentCompany);
        return brands.stream().map(brand -> modelMapperService.forResponse().map(brand, GetBrandResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<GetBrandResponse> getByOriginCountryAndParentCompany(String originCountry, String parentCompany) {
        List<Brand> brands = brandRepository.findByOriginCountryAndParentCompany(originCountry, parentCompany);
        return brands.stream().map(brand -> modelMapperService.forResponse().map(brand, GetBrandResponse.class)).collect(Collectors.toList());
    }


    //********************* POST *********************
    @Override
    public ResponseEntity<Void> add(CreateBrandRequest createBrandRequest, UriComponentsBuilder ucb) {
        brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brandRepository.save(brand);

        URI locationOfNewBrand = ucb.path("rentacar/brands/get-by-id/{uuid}")
                .buildAndExpand(brand.getId())
                .toUri();

        return ResponseEntity.created(locationOfNewBrand).build();
    }

    @Override
    public void addBulk(List<CreateBrandRequest> createBrandRequests) {
        for (CreateBrandRequest createBrandRequest1 : createBrandRequests) {
            brandBusinessRules.checkIfBrandNameExists(createBrandRequest1.getName());
        }
        List<Brand> brands = createBrandRequests.stream().map(createBrandRequest -> modelMapperService.forResponse().map(createBrandRequest, Brand.class)).toList();
        brandRepository.saveAll(brands);

    }


    //********************* PUT *********************
    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brandRepository.save(brand);
    }

    //********************* PATCH *********************
    @Override
    public void patch(UUID uuid, JsonNode updates) {
        Brand brand = brandRepository.findById(uuid).orElseThrow(() -> new BusinessException("Brand not found!"));

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Brand updatedBrand = objectMapper.readerForUpdating(brand).readValue(updates);
            brandRepository.save(updatedBrand);
        } catch (IOException ioException) {
            throw new IllegalArgumentException("Invalid JSON format!");
        }
    }

    @Override
    public void patchByName(String name, JsonNode updates) {
        try {
            Brand brand = brandRepository.findByName(name);
            ObjectMapper objectMapper = new ObjectMapper();
            Brand updatedBrand = objectMapper.readerForUpdating(brand).readValue(updates);
            brandRepository.save(updatedBrand);
        } catch (IOException ioException) {
            throw new IllegalArgumentException("Invalid JSON format!");
        } catch (BusinessException businessException){
            throw new BusinessException("Brand not found");
        }
    }

    @Override
    public void patchByParentCompany(String parentCompany, JsonNode updates) {
        List<Brand> brands = brandRepository.findByParentCompany(parentCompany);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            for (Brand brand: brands){
                Brand updatedBrand = objectMapper.readerForUpdating(brand).readValue(updates);
                brandRepository.save(updatedBrand);
            }
        } catch (IOException ioException) {
            throw new IllegalArgumentException("Invalid JSON format!");
        }
    }

    @Override
    public ResponseEntity<Void> patchByOriginCountry(String originCountry, JsonNode updates) {
        List<Brand> brands = brandRepository.findByOriginCountry(originCountry);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            for (Brand brand: brands){
                Brand updatedBrand = objectMapper.readerForUpdating(brand).readValue(updates);
                brandRepository.save(updatedBrand);
            }
        } catch (IOException ioException) {
            throw new IllegalArgumentException("Invalid JSON format!");
        }
        return ResponseEntity.ok().build();
    }
    //********************* DELETE *********************
    @Override
    public void deleteAll() {
        brandRepository.deleteAll();
    }

    @Override
    public ResponseEntity<Brand> deleteById(UUID id) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Brand not found with uuid: " + id));
        brandRepository.delete(brand);
        return ResponseEntity.ok(brand);
    }

    @Override
    public ResponseEntity<GetBrandResponse> deleteByName(String name) {
        Brand brand = brandRepository.findByName(name);
        if (Objects.equals(brand, null)) {
            throw new NoSuchElementException(name + " markası bulunamadı!");
        }
        GetBrandResponse getBrandResponse = modelMapperService.forResponse().map(brand, GetBrandResponse.class);
        brandRepository.delete(brand);
        return ResponseEntity.ok(getBrandResponse);
    }

    // ---- EXISTS? ----
//    @Override
//    public boolean existsByBrandAndPopularModelContaining(String brand, String popularModel) {
//        return brandRepository.existsByBrandAndPopularModelContaining(brand, popularModel);
//    }


}
