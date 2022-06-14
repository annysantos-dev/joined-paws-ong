package com.multimedia.joinedpawsong.core.repositories;

import com.multimedia.joinedpawsong.core.exception.PetNotFoundException;
import com.multimedia.joinedpawsong.core.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

    default Pet findByIdOrElseThrow(Long id){
         return findById(id)
               .orElseThrow(PetNotFoundException::new);
    }
}
