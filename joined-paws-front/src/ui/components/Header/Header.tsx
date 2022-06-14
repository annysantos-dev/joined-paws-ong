import{
    ContainerHeader,
    Logo
} from './Header.style';

export default function Header(){
    return(
        <ContainerHeader>
            <Logo src="/images/logo.svg" alt="Adote um Pet"></Logo>
        </ContainerHeader>
    )
}