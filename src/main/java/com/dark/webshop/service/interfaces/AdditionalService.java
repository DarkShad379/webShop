package com.dark.webshop.service.interfaces;

import com.dark.webshop.entity.food.Additional;

import java.util.List;

public interface AdditionalService {

    public Additional addAdditional(Additional additional);
    public List<Additional> getAllAdditionals();
}
