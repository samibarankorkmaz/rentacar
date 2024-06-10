package com.samibarankorkmaz.internship.webAPI.controller;

import com.samibarankorkmaz.internship.service.abstracts.ModelService;
import com.samibarankorkmaz.internship.service.request.POST.CreateModelRequest;
import com.samibarankorkmaz.internship.service.response.GET.GetModelResponse;
import lombok.AllArgsConstructor;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(name = "/rentacar/models")
@AllArgsConstructor
public class ModelsController {
    private final ModelService modelService;

    //***GET***
    @GetMapping("/get-by-id/{uuid}")
    public ResponseEntity<GetModelResponse> getById(@PathVariable UUID uuid) {
        return modelService.getById(uuid);
    }

    //***POST***
    @PostMapping("/create")
    public ResponseEntity<Void> add(CreateModelRequest createModelRequest, UriComponentsBuilder ucb) {
        return modelService.add(createModelRequest, ucb);
    }


}
