package com.dark.webshop.service.impl;

import com.dark.webshop.database.entity.food.Additional;
import com.dark.webshop.repository.AdditionalRepository;
import com.dark.webshop.service.AdditionalService;
import com.dark.webshop.service.model.AdditionalModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdditionalServiceImpl implements AdditionalService {
    AdditionalRepository additionalRepository;

    public AdditionalServiceImpl(AdditionalRepository additionalRepository) {
        this.additionalRepository = additionalRepository;
    }

    @Override
    public void deleteAdditional(AdditionalModel additionalModel) {
      Optional<Additional> additionalEntity = additionalRepository.findById(additionalModel.getId());
        additionalEntity.ifPresent(additional -> additionalRepository.delete(additional));
    }

    @Override
    public AdditionalModel updateAdditional(AdditionalModel additionalModel) {
        return null;
    }

    @Override
    public List<AdditionalModel> findAll(boolean isDeleted) {
        return null;
    }
}
