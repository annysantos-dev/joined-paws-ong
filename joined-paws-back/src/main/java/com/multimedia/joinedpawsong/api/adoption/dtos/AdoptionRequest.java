package com.multimedia.joinedpawsong.api.adoption.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.multimedia.joinedpawsong.api.pet.validators.PetExistsById;
import com.sun.istack.NotNull;
import jdk.jfr.Experimental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class AdoptionRequest {

    @NotNull
    @Email
    @Size(max = 255)
    @NotEmpty
    private String email;

    @NotNull
    @Min(5)
    private BigDecimal value;

    @NotNull
    @Positive
    @PetExistsById
    private Long petId;
}
