package com.multimedia.joinedpawsong.api.adoption.dtos;

import com.multimedia.joinedpawsong.api.pet.dtos.PetResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdoptionResponse {

    private Long id;
    private String email;
    private BigDecimal value;
    private PetResponse pet;
}
