package com.dark.webshop.service;

import com.dark.webshop.entity.food.Additional;
import com.dark.webshop.repository.AdditionalRepository;
import com.dark.webshop.service.interfaces.AdditionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdditionalServiceImpl implements AdditionalService {
    @Autowired
    AdditionalRepository additionalRepository;

    @Override
    public Additional addAdditional(Additional additional) {
        Additional newAdditional;
        newAdditional = additionalRepository.save(additional);
        return newAdditional;
    }
}
