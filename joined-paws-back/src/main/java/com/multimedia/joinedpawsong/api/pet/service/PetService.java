package com.multimedia.joinedpawsong.api.pet.service;

import com.multimedia.joinedpawsong.api.pet.dtos.PetRequest;
import com.multimedia.joinedpawsong.api.pet.dtos.PetResponse;
import com.multimedia.joinedpawsong.api.pet.mappers.PetMapper;
import com.multimedia.joinedpawsong.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;

    public List<PetResponse> findAll(){
        return petRepository.findAll()
                .stream()
                .map(petMapper::toResponse)
                .toList();

    }
    public PetResponse save (PetRequest petRequest){
        var petToCreate = petMapper.toModel(petRequest);
        var createdPet = petRepository.save(petToCreate);
        return petMapper.toResponse(createdPet);
    }


}
