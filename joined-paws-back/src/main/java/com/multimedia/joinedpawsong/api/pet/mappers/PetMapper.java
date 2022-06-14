package com.multimedia.joinedpawsong.api.pet.mappers;

import com.multimedia.joinedpawsong.api.pet.dtos.PetRequest;
import com.multimedia.joinedpawsong.api.pet.dtos.PetResponse;
import com.multimedia.joinedpawsong.core.models.Pet;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
@Component
public class PetMapper {
    public PetResponse toResponse(Pet pet) {
      return PetResponse.builder()
              .id(pet.getId())
              .name(pet.getName())
              .story(pet.getStory())
              .photo(pet.getPhoto()).build();
    }
    public Pet toModel(PetRequest petRequest){
        return Pet.builder()
                .name(petRequest.getName())
                .story(petRequest.getStory())
                .photo(petRequest.getPhoto())
                .build();
    }
}
