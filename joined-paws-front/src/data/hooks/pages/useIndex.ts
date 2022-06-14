import { AxiosError } from "axios";
import { useState, useEffect } from "react";
import { Pet } from "../../@types/Pet";
import { ApiService } from "../../services/ApiService";
export function useIndex(){
    const [listPets, setListPets] = useState<Pet[]>([]),
        [petSelected, setPetSelected] = useState<Pet | null>(null),
        [email, setEmail] = useState(''),
        [value, setValue] = useState(''),
        [text, setMessage] = useState('');

    useEffect(() => {
        ApiService.get('/pets')
            .then((response) => {
                setListPets(response.data);
            })
    }, [])

    useEffect(() => {
        if(petSelected === null){
            cleanForm();
        }
    }, [petSelected])

    function toAdopt(){
        if(petSelected !== null){
            if(validateAdoptionData()){
                ApiService.post('/adoptions',{
                    pet_id: petSelected.id,
                    email,
                    value
                })
                .then(() => {
                    setPetSelected(null);
                    setMessage('Pet adotado com sucesso')
                })
                .catch((error: AxiosError) => {
                    setMessage(error.response?.data.message);
                })

            }else{
                setMessage('Preencha todos os campos corretamente.')
            }
        }
    }

    function validateAdoptionData(){
        return email.length > 0 && value.length > 0;
    }

    function cleanForm(){
        setEmail('');
        setValue('');
    }

    return {
        listPets,
        petSelected,
        setPetSelected,
        email,
        setEmail,
        value,
        setValue,
        text,
        setMessage,
        toAdopt
    };
}