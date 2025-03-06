import { useState } from "react"

/* 
    리액트 과제1 : 아래 코드들을 사용하여 입력된 값들의 글자수를 실시간으로 출력하시오
    카카오톡 제출 : ip로 제출
*/

export default function Task1() {
    
    // (1) 여기에 state 변수 만들기
    // useState(초기값)
    //  ├─ 변수명 : 아무거나.(임의)
    //  ├─ set변수명 : set변수명 --> 카멜표기법
    //  │   └─ set변수명(새로운값)
    //  └─ = useState(초기값) : 모든 타입의 자료가 가능
    const [msg, setMsg] = useState("");
    const [count, setCount] = useState(0);
    const[msgList, setMsgList] = useState([]);
    const 저장함수 = (e) => {
        // 입력받은 값이 저장된 state인 'msg를 msgList에 저장
        // msgList.push(msg);
        console.log(msgList);
        // setMsgList(msgList);
        // 이렇게 2가지 방법으로 작성해야 실시간으로 적용됨
        setMsgList([...msgList, msg]);
        // setMsgList((msgList) => [...msgList, msg]);
    }
    const handleChange = (event) => {
        // (2) 여기에서 state 변수값 수정하기.
        // console.log(event.target.value);
        setMsg(event.target.value);
        setCount(event.target.value.length);
    }

    return (
        <>
            <h1> input에 입력하면 실시간으로 글자 수 세기</h1>
            <input value={msg} onChange={handleChange} />
            <p>글자 수: {count}</p>
            <h1>입력받은 값을 배열에 저장</h1>
            <button onClick={저장함수}>저장</button>
            <p>{msgList}</p>
        </>
    )
}