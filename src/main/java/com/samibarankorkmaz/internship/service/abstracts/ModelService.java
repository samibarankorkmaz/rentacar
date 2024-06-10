package com.samibarankorkmaz.internship.service.abstracts;

import com.samibarankorkmaz.internship.service.request.POST.CreateModelRequest;
import com.samibarankorkmaz.internship.service.response.GET.GetModelResponse;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface ModelService {

    //***GET***
    ResponseEntity<GetModelResponse> getById(UUID uuid);

    //***POST***
    ResponseEntity<Void> add(CreateModelRequest createModelRequest, UriComponentsBuilder ucb);


}
