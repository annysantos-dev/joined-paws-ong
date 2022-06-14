package com.multimedia.joinedpawsong.api.adoption.controllers;

import com.multimedia.joinedpawsong.api.adoption.dtos.AdoptionRequest;
import com.multimedia.joinedpawsong.api.adoption.dtos.AdoptionResponse;
import com.multimedia.joinedpawsong.api.adoption.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/adoptions")
@RestController
public class AdoptionController {

    @Autowired
    private AdoptionService adoptionService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AdoptionResponse create(@RequestBody @Valid AdoptionRequest adoptionRequest){
        return adoptionService.save(adoptionRequest);
    }
    @GetMapping
    public List<AdoptionResponse> findAll(){
        return adoptionService.findAll();
    }


}
