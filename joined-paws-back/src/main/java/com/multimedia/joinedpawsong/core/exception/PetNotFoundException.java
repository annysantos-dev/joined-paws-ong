package com.multimedia.joinedpawsong.core.exception;

import javax.persistence.EntityNotFoundException;

public class PetNotFoundException extends EntityNotFoundException {

    public PetNotFoundException() {
        super("Pet não encontrando");
    }

    public PetNotFoundException(String message) {
        super(message);
    }
}
