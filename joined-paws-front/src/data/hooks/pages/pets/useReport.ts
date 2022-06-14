import { useEffect, useState } from "react";
import { Report } from "../../../@types/Report";
import { ApiService } from "../../../services/ApiService";

export function useReport(){
    const [listReport, setListReport] = useState<Report[]>([])

    useEffect(() => {
        ApiService.get('/adoptions').then((response) => {
            setListReport(response.data)
        })
    }, [])

    return{
        listReport
    }
}