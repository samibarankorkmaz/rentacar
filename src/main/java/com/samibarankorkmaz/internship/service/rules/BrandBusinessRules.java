package com.samibarankorkmaz.internship.service.rules;

import com.samibarankorkmaz.internship.common.utility.exception.BusinessException;
import com.samibarankorkmaz.internship.repository.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


// this is the place where we insert the rules for brand entity

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name) {
        if (brandRepository.existsByName(name)) {
            throw new BusinessException("Brand already exists!");
        }
    }
}
