import { useState } from "react";
/*
    리액트 과제3 : 리액트 전화번호부 만들기
        조건1 : (저장) 이름, 전화번호를 입력받아 배열에 저장
        조건2 : (전체출력) 저장된 배열내 모든 정보(이름/전화번호)를 table 또는 ul등으로 모두 출력
        조건3 : useState를 필수로 사용
    카카오톡 제출 : ip로 제출
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
