package com.samibarankorkmaz.internship.repository.abstracts;

import com.samibarankorkmaz.internship.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {

    //********************* GET *********************
    //popular models için yap. (list!)
    Brand findByName(String name);

    List<Brand> findByOriginCountry(String originCountry);

    List<Brand> findByParentCompany(String parentCompany);

    List<Brand> findByOriginCountryAndParentCompany(String originCountry, String parentCompany);

    //********************* POST *********************

    //********************* PUT *********************

    //********************* DELETE *********************
//    @Modifying
//    @Query("delete from Brand b where b.name = :name")
//    int deleteByName(@Param("name") String name);


    // ---- EXISTS? ----
    boolean existsByName(String name); //JPA burada exist kelimesini gördüğü an parametreye göre entity'nin varlığını arar.

//    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Brand b WHERE b.name = :name AND :popularModel IN elements(b.popularModels)")
//    boolean existsByBrandAndPopularModelContaining(@Param("name") String name, @Param("popularModel") String popularModel);


}
