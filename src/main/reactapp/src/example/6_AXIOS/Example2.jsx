import axios from "axios";
import { useEffect, useState } from "react";


export default function Example2(props) {

    // [1] 입력받은 데이터를 저장하는 폼 state 변수
    const [formData, setFormData] = useState({writer : "", content : "", pwd : ""});
    // [2] 입력받은 데이터를 렌더링 하는 이벤트함수
    const formDataChange = (event) => {
        // 이벤트가 발생한 HTML DOM(마크업/태그)
        // console.log(event.target);
        // 이벤트가 발생한 HTML DOM의 name속성 값 반환
        // console.log(event.target.name);
        // 이벤트가 발생한 HTML DOM의 value속성 값 반환
        // console.log(event.target.value);
        // 스프레드 연산자를 이용한 state 변수 변경
        setFormData({...formData, [event.target.name] : event.target.value});
    }
    // [3] 현재 state변수를 스프링 서버에게 보내기
    const onPost = async (event) => {
        try {
            const response = await axios.post("http://localhost:8080/day07/react", formData);
            if(response.data == true) {
                alert("등록 성공");
                setFormData({writer: "", content : "", pwd: ""});   
                onFindAll();
            } else {
                alert("등록 실패");
            }
        } catch(error) {
            console.log(error);
        }
    }

    // [4] 서버에 저장된 방문록 정보(작성자/내용/비밀번호 여러개) 요청
    // [4-1] 컴포넌트 마운트(생성)될 때 최초 1번만 실행
    useEffect(() => {onFindAll()}, []);
    // useEffect(() => {onFindAll()}, [boards]);
    // [4-2] 여러개의 방문록을 가지는 state변수
    const [boards, setBoards] = useState([]);
    const onFindAll = async (event) => {
        // [4-3] 주로 동기 통신 : async(event) => {await axios.메소드명()}
        try {
            const response = await axios.get("http://localhost:8080/day07/react");
            // 서버로부터 받은 정보를 state변수에 저장
            setBoards(response.data);
        } catch(e) {
            console.log(e);
        }
    }

    console.log(formData);

    return (
        <>
            <div>
                <h4>입력 폼</h4>
                <form>
                    작성자 : <input type="text" name="writer" value={formData.writer} onChange={formDataChange} /><br/>
                    방문록 : <input type="text" name="content" value={formData.content} onChange={formDataChange} /><br/>
                    비밀번호 : <input type="text" name="pwd" value={formData.pwd} onChange={formDataChange} /><br/>
                    <button type="button" onClick={onPost}>등록</button>
                </form>
                <table style={{board : "solid 1px black"}}>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>작성자</th>
                            <th>방문록내용</th>
                            <th>비고</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            boards.map((board, index) => {
                                return (
                                    <tr key={index}>
                                        <td>{board.num}</td>
                                        <td>{board.writer}</td>
                                        <td>{board.content}</td>
                                        <td>수정버튼/삭제버튼</td>
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