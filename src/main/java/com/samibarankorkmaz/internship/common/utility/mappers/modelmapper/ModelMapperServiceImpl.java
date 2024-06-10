package com.samibarankorkmaz.internship.common.utility.mappers.modelmapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperServiceImpl implements ModelMapperService {
    private final ModelMapper modelMapper;

    @Override
    public ModelMapper forRequest() {
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }

    @Override
    public ModelMapper forResponse() {
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }
}
