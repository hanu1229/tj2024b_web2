import { useEffect, useState } from "react";


export default function Example1(props) {

    // (1) useEffect 함수 사용시 : import {useEffect} from "react"
    // useEffect(이펙트함수정의)
    // [] 의존성 배열이 없을 경우
    // 실행 시점 : 마운트(탄생)(최초실행), 업데이트(인생)(재렌더링)
    // 차이점 : 모든 state가 변경될 때 재실행 O
    useEffect(() => {
        console.log("이펙트 함수 실행1");
    });

    // (2) [] 의존성 배열이 빈배열일 경우
    // 실행 시점 : 마운트(탄생)(최초실행)
    // 차이점 : 재렌더링이 아닌 컴포넌트가 최초 1번만 실행해야 하는 경우에 사용
    useEffect(() => {
        console.log("이펙트 함수 실행2")
    }, []);

    // (3) 의존성 배열에 state변수가 존재할 경우
    // 실행 시점 : 마운트(탄생)(최초실행), 업데이트(인생)(재렌더링)
    // 차이점 : 의존성배열에 존재하는 state변수가 변경될때만 재실행 O
    // 차이점 : 의존성 배열에 존재하지 않는 state변수가 변경될때는 재실행 X
    const [count, setCount] = useState(0);
    useEffect(() => {
        console.log("이펙트 함수 실행3");
    }, [count]);

    const[count2, setCount2] = useState(0);

    return (
        <>
            <p>{count} / {count2}</p>
            <button onClick={(e) => {setCount(count+1)}}>업데이트1 1/3번 useEffect실행</button>
            <button onClick={(e) => {setCount2(count2+1)}}>업데이트2 1번 useEffect실행</button>
        </>
    );
}