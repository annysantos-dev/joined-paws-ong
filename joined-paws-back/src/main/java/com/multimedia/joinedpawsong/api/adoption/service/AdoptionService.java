package com.multimedia.joinedpawsong.api.adoption.service;

import com.multimedia.joinedpawsong.api.adoption.dtos.AdoptionRequest;
import com.multimedia.joinedpawsong.api.adoption.dtos.AdoptionResponse;
import com.multimedia.joinedpawsong.api.adoption.mappers.AdoptionMapper;
import com.multimedia.joinedpawsong.core.models.Adoption;
import com.multimedia.joinedpawsong.core.repositories.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptionService {

    @Autowired
    private AdoptionMapper adoptionMapper;

    @Autowired
    private AdoptionRepository adoptionRepository;

    public AdoptionResponse save(AdoptionRequest adoptionRequest){
        var adoptionTocreate = adoptionMapper.toModel(adoptionRequest);
        var createAdoption = adoptionRepository.save(adoptionTocreate);
        return adoptionMapper.toResponse(createAdoption);
    }

    public List<AdoptionResponse> findAll(){
        return adoptionRepository.findAll()
                .stream()
                .map(adoptionMapper::toResponse)
                .toList();

    }


}
