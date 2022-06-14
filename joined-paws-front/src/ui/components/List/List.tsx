/* eslint-disable react/jsx-key */
import { Button } from '@mui/material'
import {
    ListStyled,
    ItemList,
    Photo,
    Information,
    Name,
    Description

} from './List.style'
import { Pet } from '../../../data/@types/Pet'
import { TextService } from '../../../data/services/TextService';

interface ListProps{
    pets: Pet[];
    onSelect: (pet: Pet) => void;
}

export default function Lista(props: ListProps){
const maxTextSize = 200;

    return (
        <ListStyled>
            {props.pets.map(pet => ( 
                <ItemList key={pet.id} >
                    <Photo src={pet.photo} alt={pet.name}/>
                    <Information>
                        <Name>{pet.name}</Name>
                        <Description>{TextService.limitText(pet.story, maxTextSize)}</Description>
                        <Button 
                            variant={'contained'}
                            fullWidth
                            onClick={() => props.onSelect(pet)}
                        >
                            Adotar {pet.name}</Button>
                    </Information>
                </ItemList>
            ))}
        </ListStyled>
    )
}