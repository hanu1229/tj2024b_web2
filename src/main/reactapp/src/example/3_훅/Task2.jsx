import { useState } from "react";
/*
    리액트 과제3 : 리액트 전화번호부 만들기
        조건1 : (저장) 이름, 전화번호를 입력받아 배열에 저장
        조건2 : (전체출력) 저장된 배열내 모든 정보(이름/전화번호)를 table 또는 ul등으로 모두 출력
        조건3 : useState를 필수로 사용
    카카오톡 제출 : ip로 제출

    [1] .jsx파일 생성

    [2] 파일내 컴포넌트(함수) 생성, 컴포넌트명 : 첫글자 대문자로 작성
    export default function 컴포넌트명(props) {
        return (
            <>

            </>
        );
    }
    [3] max.jsx에서 생성한 컴포넌트 렌더링

    [4] 입력 상자의 state변수, document.querySelector() 방식을 사용하지 않는 방법
        - 선언 방법 : const [변수명, set변수명] = useState(초기값)
            - 초기값 : 다양한 자료의 모든 타입이 가능하다
                문자열 초기값 :  "", 정수 초기값 : 0, 실수 초기값 : 0.0, 객체 초기값 : {}, 배열 초기값 : []

            - 방법1
                const[name, setName] = useState("");
                const[phone, setPhone] = useState("");
                const[list, setList] = useState([]);
            - 방법2
                const[member, setMember] = useState({name : "", phone : ""});
                const[members, setMembers] = useState([]);
            - 방법3
                const[members, setMembers] = useState([{name: "", phone : ""}]);

        - event(e) 이벤트 객체
            onChange = (event) => {}, onChange이벤트 실행 결과를 다음 함수의 매개변수로 전달
            event.target : 이벤트가 발생한 DOM(HTML마크업)
            event.target.value : 이벤트가 발생한 DOM의 value속성을 반환

        - setXXX(새로운값)
            - ...(스프레드연산자)를 보통 사용
            - setXXX(event.target.value);
            - setXXX([...기존배열, 새로운값]);
    
    [5] map반복문을 이용한 출력
    <마크업>
        {
            // 배열명.map((반복변수명, 인덱스) => {return (<></>);}) // 한줄이면 {} 여러줄이면 ()
            배열명.map((반복변수명, 인덱스) => (return (<></>);))
        }
    </마크업>

 */


export default function Task2(props) {

    const [name, setName] = useState("");
    const [phone, setPhone] = useState("");
    const [list, setList] = useState([]);

    const nameInput = (event) => {
        // console.log(event.target);
        // console.log(event.target.value);
        setName(event.target.value);
    }
    const phoneInput = (event) => {
        // console.log(event.target);
        // console.log(event.target.value);
        setPhone(event.target.value);
    }

    const addTable = (event) => {
        let temp = [...list, {name : name, phone : phone}];
        setList(temp)
        console.log(temp);
        setName("");
        setPhone("");
    }

    return(
        <>
            <h1>리액트 전화번호부</h1>
            <div>
                <div>
                    <span>  이름 : </span>
                    <input value={name} onChange={nameInput} />
                    <span style={{margin : "0px 0px 0px 10px"}}>전화번호 : </span>
                    <input value={phone} onChange={phoneInput} />
                    <button style={{margin : "0px 0px 0px 10px"}} onClick={addTable}>등록</button>
                </div>
                <br/>
                <table border={1}>
                    <thead>
                        <tr><td>이름</td><td>전화번호</td></tr>
                    </thead>
                    <tbody>
                        {
                            list.map((item, index) => (
                                //console.log(item),
                                <MakeRow key={index} name={item.name} phone={item.phone} />
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </>
    );
}

const MakeRow = (props) => {
    return (
        <>
            <tr>
                <td>{props.name}</td>
                <td>{props.phone}</td>
            </tr>
        </>
    );
}
