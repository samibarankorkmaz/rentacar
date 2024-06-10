package com.samibarankorkmaz.internship.service.response.GET;

import com.samibarankorkmaz.internship.common.utility.enums.EngineType;
import com.samibarankorkmaz.internship.common.utility.enums.MarketSegment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelResponse {
    private String name;
    private int seatingCapacity;
    private boolean ecoFriendly;
    private MarketSegment marketSegment;
    private EngineType engineType;
}
