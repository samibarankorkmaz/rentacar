package com.samibarankorkmaz.internship.service.request.POST;

import com.samibarankorkmaz.internship.common.utility.enums.EngineType;
import com.samibarankorkmaz.internship.common.utility.enums.MarketSegment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
    @NotNull
    private UUID brand_id;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;
    @NotNull
    @Size(min = 1, max = 10)
    private int seatingCapacity;
    @NotNull
    private boolean ecoFriendly;
    @NotNull
    private MarketSegment marketSegment;
    @NotNull
    private EngineType engineType;
}
