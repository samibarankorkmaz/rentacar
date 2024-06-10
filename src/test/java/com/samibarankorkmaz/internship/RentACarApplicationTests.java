package com.samibarankorkmaz.internship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RentACarApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

//    @Test
//    void shouldCreateANewBrand() {
//        CreateBrandRequest newBrand = new CreateBrandRequest("Audi", "Germany", "Ingolstadt", "Volkswagen Group");
//        ResponseEntity<Void> createResponse = restTemplate.postForEntity("/rentacar/brands/create", newBrand, Void.class);
//        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//
//        URI locationOfNewBrand = createResponse.getHeaders().getLocation();
//        ResponseEntity<String> getResponse = restTemplate.getForEntity(locationOfNewBrand, String.class);
//        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }

}
