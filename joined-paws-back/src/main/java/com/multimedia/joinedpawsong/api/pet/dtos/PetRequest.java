package com.multimedia.joinedpawsong.api.pet.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 300)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 300)
    private String story;

    @URL
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 300)
    private String photo;
}
