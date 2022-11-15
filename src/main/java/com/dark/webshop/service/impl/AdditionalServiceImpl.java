package com.dark.webshop.service.impl;

import com.dark.webshop.database.entity.food.Additional;
import com.dark.webshop.repository.AdditionalRepository;
import com.dark.webshop.service.AdditionalService;
import com.dark.webshop.service.mapper.AdditionalServiceMapper;
import com.dark.webshop.service.model.AdditionalModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdditionalServiceImpl implements AdditionalService {
    AdditionalRepository additionalRepository;
    AdditionalServiceMapper additionalMapper;

    public AdditionalServiceImpl(AdditionalRepository additionalRepository, AdditionalServiceMapper additionalMapper) {
        this.additionalRepository = additionalRepository;
        this.additionalMapper = additionalMapper;
    }

    @Override
    public AdditionalModel findAdditionalById(int id) {
        Optional<Additional> additionalOpt = additionalRepository.findById(id);
        return additionalOpt.map(additional -> additionalMapper.additionalToAdditionalModel(additional)).orElse(null);
    }

    @Override
    public void removeAdditional(AdditionalModel additionalModel) {
        Additional additional = additionalMapper.additionalModelToAdditional(additionalModel);
        if (additionalRepository.findById(additional.getId()).isPresent()) {
            additionalRepository.delete(additional);
            additionalRepository.removeFromAvailableAdditionals(additional.getId());
        }

    }

    @Override
    public AdditionalModel updateAdditional(AdditionalModel additionalModel) {
        Additional additional = additionalMapper.additionalModelToAdditional(additionalModel);
        Additional savedAdditional = additionalRepository.save(additional);
        return additionalMapper.additionalToAdditionalModel(savedAdditional);
    }

    @Override
    public List<AdditionalModel> findAll(boolean isDeleted) {
        List<Additional> additionalList = additionalRepository.findAllByOrderByNameAsc(isDeleted);
        return additionalList.stream().map(additionalMapper::additionalToAdditionalModel).collect(Collectors.toList());
    }
}
