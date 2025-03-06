import { useState } from "react";


export default function Example3(props) {

    // (1) 일반적인 JS방법
    const 입력함수1 = () => {
        const msg = document.querySelector(`#msg`).value;
        console.log(msg);
    }

    // (2) 리액트 방법
    const [msg, setMsg] = useState("");
    const 입력함수2 = (eventObj) => {
        // onChange가 되고 나서의 이벤트 결과 정보(객체)
        console.log(eventObj);
        // onChange이벤트를 발생 시킨 마크업(대상)
        console.log(eventObj.target);
        // onChange이벤트를 발생 시킨 마크업의 value값 반환
        console.log("value : " + eventObj.target.value);
        // 사용자가 입력한 input값을 리액트에서 관리한다.
        setMsg(eventObj.target.value);
    }
    // (3) 리액트 방법2
    // 이미지를 저장하는 state변수 선언
    const [image, setImage] = useState('dog.jpg');
    const 변경함수3 = () => {
        // state변수의 값이 변경되면 자동으로 새로고침/렌더링/컴포넌트재호출/함수재호출/함수return // 리액트 UI업데이트
        // state변수의 값을 변경하는 방법 : set변수명(새로운값)
        setImage(image == 'dog.jpg' ? "cat.jpg" : "dog.jpg");
    }

    return (
        <div>
            <h1>일반적인 JS 방법</h1>
            <input id="msg" /><br/><br/>
            <button onClick={입력함수1}>입력버튼</button>

            <h1>리액트 JS 방법</h1>
            <input value={msg} onChange={입력함수2}/><br/><br/>

            <h1>리액트 이미지 변경</h1>
            <img onClick={변경함수3} src={image} />
        </div>
    );
}

/* 
    HTML 이벤트 함수, onXXXX, 미리 만들어진 함수를 제공
    [1] 종류
    onclick     : HTML마크업을 클릭했을때 클릭 이벤트 함수 실행
    onchange    : HTML마크업의 값이 변경되었을때 이벤트 함수 실행
    [2] 반환값을 제공
        - 이벤트함수가 실행된 결과를 객체로 다음 로직으로 반환
            - onClick = {(e) => {}}
                onClick함수가 실행되고 나서 실행결과를 e(매개변수)로 다음 함수에게 전달
    HTML이벤트 함수 VS JSX(리액트)이벤트 함수 차이점
        - 차이점        : 리액트에서는 카멜표기법을 사용
        - 형태(함수명)  : onclick/onchange VS onClick/onChange
        - 속성값        : onclick = "함수명()" VS onclick = {함수명}
        - 결과리턴      : onclick = "함수명(e)" VS onClick = {함수명}        : 함수명이 존재하는 경우(다회성)
                                               VS onClick = {(e) => {}}     : 함수명이 존재하지 않는 경우(일회성)
    
*/
