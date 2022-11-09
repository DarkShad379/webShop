package com.dark.webshop.service;

import com.dark.webshop.entity.food.Additional;
import com.dark.webshop.repository.AdditionalRepository;
import com.dark.webshop.service.interfaces.AdditionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class AdditionalServiceImpl implements AdditionalService {
    @Autowired
    AdditionalRepository additionalRepository;
    @Autowired
    private EntityManager entityManager;

    @Override
    public void deleteAdditional(Additional additional) {
        additionalRepository.delete(additional);
    }

    public List<Additional> findAll(boolean isDeleted) {
        return additionalRepository.findAllByOrderByNameAsc(isDeleted);
    }


    @Override
    public Additional addAdditional(Additional additional) {
        return additionalRepository.save(additional);
    }
}
