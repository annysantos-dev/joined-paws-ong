package com.multimedia.joinedpawsong.core.repositories;

import com.multimedia.joinedpawsong.core.models.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
}
