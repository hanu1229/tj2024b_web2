/*
    리액트 과제4 + Spring : 리액트 전화번호부 만들기 + Spring 서버 + myBatis
        조건1 : (저장) 이름, 전화번호를 입력받아 서버에 전송
        조건2 : (전체출력) 서버로부터 받은 모든 정보(이름, 전화번호)를 table 또는 ul등으로 모두 출력
        조건3 : useState, useEffect, axios를 필수로 사용
    카카오톡 제출 : ip로 제출

    [참고1] : 3_훅 --> Task2.jsx
    [참고2] : 6_AXIOS --> Example2.jsx
*/

import { useEffect, useState } from "react";
import axios from "axios";

export default function Task(props) {

    const [data, setData] = useState({name : "", phone : ""});
    const changeData = (event) => {
        // let name = event.target.name;
        // name == [event.target.name]
        setData({...data, [event.target.name] : event.target.value})
    }

    console.log(data);

    useEffect(() => {findAll()}, []);
    const [boards, setBoards] = useState([]);
    const submit = async (event) => {
        try {
            let response = await axios.post("http://192.168.40.64:8080/day07/task", data);
            console.log(response.data);
            if(response.data == true) {
                alert("등록 성공");
                findAll();
            } else {
                alert("등록 실패");
            }
        } catch(e) {
            console.log(e);
        }
    }

    const findAll = async (event) => {
        try {
            let response = await axios.get("http://192.168.40.64:8080/day07/task");
            console.log(response.data);
            setBoards(response.data);
        } catch(e) {
            console.log(e);
        }
    }

    return (
        <>
            <div>
                <h1>전화번호부</h1>
                <form>
                    <span> 이름 : </span>
                    <input type="text" name="name" value={data.name} onChange={changeData} />
                    <span style={{margin : "0px 0px 0px 10px"}}> 전화번호 : </span>
                    <input type="text" name="phone" value={data.phone} onChange={changeData}  />
                    <button type="button" style={{margin : "0px 0px 0px 10px"}} onClick={submit}>등록</button>
                </form>
                <br/>
                <table border={"1"} style={{margin : "0px auto"}}>
                    <thead>
                        <tr>
                            <td>이름</td>
                            <td>전화번호</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            boards.map((board, index) => {
                                return (
                                    <tr key={index}>
                                        <td>{board.name}</td>
                                        <td>{board.phone}</td>
                                    </tr>
                                )
                            })
                        }
                    </tbody>
                </table>
            </div>
        </>
    );
}