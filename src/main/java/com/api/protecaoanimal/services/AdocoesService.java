package com.api.protecaoanimal.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.protecaoanimal.dtos.AdocoesDto;
import com.api.protecaoanimal.models.AdocoesModel;
import com.api.protecaoanimal.repositories.AdocoesRepository;

import jakarta.transaction.Transactional;

@Service
public class AdocoesService {
    
    final AdocoesRepository adocoesRepository;

    public AdocoesService(AdocoesRepository adocoesRepository) {
        this.adocoesRepository = adocoesRepository;
    }

    @Transactional
    public AdocoesModel save(AdocoesDto adocoesDto) {
        var adocoesModel = new AdocoesModel();
        BeanUtils.copyProperties(adocoesDto, adocoesModel);
        adocoesModel.setRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return adocoesRepository.save(adocoesModel);
    }

    public List<AdocoesModel> findAll() {
        return adocoesRepository.findAll();
    }

    public AdocoesModel findById(UUID id) {
        return adocoesRepository.findById(id).get();
    }

    public void delete(AdocoesModel adocoesModel) {
        adocoesRepository.delete(adocoesModel);
    }

}
