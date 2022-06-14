package com.multimedia.joinedpawsong.api.adoption.mappers;

import com.multimedia.joinedpawsong.api.adoption.dtos.AdoptionRequest;
import com.multimedia.joinedpawsong.api.adoption.dtos.AdoptionResponse;
import com.multimedia.joinedpawsong.api.pet.dtos.PetResponse;
import com.multimedia.joinedpawsong.api.pet.mappers.PetMapper;
import com.multimedia.joinedpawsong.core.models.Adoption;
import com.multimedia.joinedpawsong.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdoptionMapper {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;

    public Adoption toModel(AdoptionRequest adoptionRequest){
        return Adoption.builder()
            .email(adoptionRequest.getEmail())
            .value(adoptionRequest.getValue())
            .pet(petRepository.findByIdOrElseThrow(adoptionRequest.getPetId()))
            .build();
    }

    public AdoptionResponse toResponse(Adoption adoption){
        return AdoptionResponse.builder()
                .id(adoption.getId())
                .email(adoption.getEmail())
                .value(adoption.getValue())
                .pet(petMapper.toResponse(adoption.getPet()))
            .build();


    }
}
