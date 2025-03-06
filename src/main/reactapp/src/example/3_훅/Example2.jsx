import { useState } from "react";

let a = 0;

export default function Example2(props) {

    a++;
    let b = 0;
    b++;
    console.log(`전역변수 a : ${a}`);
    console.log(`지역변수 b : ${b}`);
    // (1) 전역변수/지역변수 증가하는 함수
    const 증가함수1 = () => {
        a++; b++;
        console.log(a, b);
    }
    // (2) state변수 사용, 훅 종류 중에 핵심함수(useState)
    // state 상태변수 선언
    let c = useState(0);
    // [0] : 변수값, [1] : 변수값을 수정할수 있는 함수를 제공 --> 2개의 인덱스를 가지는 배열로 반환
    console.log(c);
    console.log(c[0]);
    console.log(c[1]);
    const 증가함수2 = () => {
        // 컴포넌트/함수가 재실행, 즉 return이 다시 실행
        // 전역변수는 컴포넌트/함수 재실행(렌더링)에 관계가 없으므로 누적
        // 지역변수는 컴포넌트/함수 재실행(렌더링)에 안에 있으므로 초기화
        // state변수는 지역/전역변수 개념이 아닌 리액트가 별도로 상태(값)을 저장하고 관리
        c[1](c[0]++);
    }
    // (3) state 일반적인 사용법, 구조 분해 많이 사용
    // const {변수명, set변수명} = useState(초기값);
    const [count, setCount] = useState(0);
    const 증가함수3 = () => {
        console.log(count);
        //count = count + 1;
        console.log(count);
        // 렌더링 제공 함수, setXXX(새로운값);
        setCount(count+1);
    }

    // 컴포넌트(함수) : 한번 return된 JSX문법의 결과(HTML)은 불변성이다.
    return (
        <div>
            <div>
                <p>일반 변수 : {a}, {b}</p>
                <button onClick={증가함수1}>일반 증가</button>
            </div>
            <div>
                <p>state 변수 : {c}</p>
                <button onClick={증가함수2}>훅 증가</button>
            </div>
            <div>
                <p>state 변수2 : {count}</p>
                <button onClick={증가함수3}>훅 증가2</button>
            </div>
        </div>
    );
}