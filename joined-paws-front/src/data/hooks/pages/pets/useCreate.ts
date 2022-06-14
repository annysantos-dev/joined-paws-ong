import { AxiosError } from "axios";
import { useState } from "react";
import { ApiService } from "../../../services/ApiService";

export function useCreate(){
    const [name, setName] = useState(''),
    [story, setStory] = useState(''),
    [photo, setPhoto] = useState(''),
    [text, setMessage] = useState('');


    function create(){
        if(valitateForm()){
            ApiService.post('/pets',{
                name,
                story,
                photo
            })
            .then(() => {
                clean();
                setMessage('Pet cadastrado com sucesso!')
            })
            .catch((error: AxiosError) => {
                setMessage(error.response?.data.message)
            })
        }else{
            setMessage('Preencha todos os campos!')
        }
    }

    function valitateForm(){
        return name.length > 2 && story.length > 2
    }

    function clean(){
        setName('');
        setStory('');
        setPhoto('');
    }

    return{
        name, 
        story,
        photo,
        setName,
        setStory,
        setPhoto,
        create,
        text,
        setMessage
    }
}