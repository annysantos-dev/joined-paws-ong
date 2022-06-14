package com.multimedia.joinedpawsong.api.pet.controllers;

import com.multimedia.joinedpawsong.api.pet.dtos.PetRequest;
import com.multimedia.joinedpawsong.api.pet.dtos.PetResponse;
import com.multimedia.joinedpawsong.api.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pets")
@RestController
public class PetControllher {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<PetResponse> findAll(){
        return petService.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PetResponse save(@RequestBody @Validated PetRequest petRequest){
        return petService.save(petRequest);
    }

}
