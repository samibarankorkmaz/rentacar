package com.samibarankorkmaz.internship.common.utility.mappers.modelmapper;

import org.modelmapper.ModelMapper;


public interface ModelMapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();
}
