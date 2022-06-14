package com.multimedia.joinedpawsong.api.pet.validators;

import com.multimedia.joinedpawsong.core.repositories.PetRepository;
import org.hibernate.validator.cfg.context.Constrainable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PetExistsByIdValidator implements ConstraintValidator<PetExistsById,Long> {

    @Autowired
    private PetRepository petRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(value == null){
            return true;

        }
        return petRepository.existsById(value);
    }

    @Override
    public void initialize(PetExistsById constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
