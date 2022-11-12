package com.dark.webshop.service;

import com.dark.webshop.service.model.AdditionalModel;

import java.util.List;

public interface AdditionalService {
     void deleteAdditional(AdditionalModel additionalModel);
     AdditionalModel updateAdditional(AdditionalModel additionalModel);
     List<AdditionalModel> findAll(boolean isDeleted);
}
