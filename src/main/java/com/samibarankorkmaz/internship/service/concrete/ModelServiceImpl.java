package com.samibarankorkmaz.internship.service.concrete;

import com.samibarankorkmaz.internship.service.abstracts.ModelService;
import com.samibarankorkmaz.internship.service.request.POST.CreateModelRequest;
import com.samibarankorkmaz.internship.service.response.GET.GetModelResponse;
import com.samibarankorkmaz.internship.common.utility.mappers.modelmapper.ModelMapperService;
import com.samibarankorkmaz.internship.repository.abstracts.ModelRepository;
import com.samibarankorkmaz.internship.model.Model;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;

    //***GET***main branch changeé
    @Override
    public ResponseEntity<GetModelResponse> getById(UUID uuid) {
        Model model = modelRepository.findById(uuid).orElseThrow();
        GetModelResponse getModelResponse = modelMapperService.forResponse().map(model, GetModelResponse.class);
        return ResponseEntity.ok(getModelResponse);
    }

    //***POST***
    @Override
    public ResponseEntity<Void> add(CreateModelRequest createModelRequest, UriComponentsBuilder ucb) {
        Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
        modelRepository.save(model);

        URI locationOfNewModel = ucb.path("rentacar/models/get-by-id/{uuid}").buildAndExpand(model.getId()).toUri();

        return ResponseEntity.created(locationOfNewModel).build();

    }

}
