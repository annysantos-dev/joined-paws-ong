import { TitleStyled, Caption } from "./Title.style";

interface TitleProps{
    title: string;
    caption?: string | JSX.Element;
}

export default function Title(props: TitleProps): JSX.Element{
    return (
        <>
            <TitleStyled>{props.title}</TitleStyled>
            <Caption>{props.caption}</Caption>
        </>
    )
}