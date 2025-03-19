import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { login } from "../reduxs/userSlice";

export default function Login(prpos) {

    // (*) 리덕스 (전역변수) 사용하기
    // (*-1) 리덕스를 사용하기 위한 useDispatch함수를 가져오기
    const dispatch = useDispatch();

    // (1) 입력받은 값들을 저장하는 state 변수
    const [memberInfo, setMemberInfo] = useState({mid : "", mpwd : ""});
    // (2) 입력받은 값들을 수정하는 state 수정처리 함수
    const onInputChange = (event) => {setMemberInfo({...memberInfo, [event.target.name] : event.target.value});}
    // (3) 입력받은 값들을 axios를 이용하여 자바(스프링)에게 요청과 응답받기
    const navigate = useNavigate();
    const onLogin = async () => {
        const response = await axios.post("http://localhost:8080/api/member/login", memberInfo, {withCredentials : true});
        const result = response.data;
        if(result) {
            // (4) 로그인을 성공할 경우 로그인 한 회원의 정보 가져오기
            const response2 = await axios.get("http://localhost:8080/api/member/info", {withCredentials : true});
            alert("로그인 성공");
            navigate("/");
            // location.href = "/";
            // (*-2) useDispatch 함수를 이용한 리듀서 함수 액션하기, 로그인 액션(함수)에 (로그인한)회원정보를 대입한다
            // useState(지역상태)가 아닌 store(전역상태)에 저장된다.
            dispatch(login(response2.data));

        } else {
            alert("로그인 실패");
        }
    }

    console.log(memberInfo);

    return (
        <>
            <h3>로그인 페이지</h3>
            <form>
                아이디 : <input type="text" name="mid" value={memberInfo.mid} onChange={onInputChange} /> <br/>
                비밀번호 : <input type="password" name="mpwd" value={memberInfo.mpwd} onChange={onInputChange} /> <br /><br/>
                <button type="button" onClick={onLogin}>로그인</button>
            </form>
        </>
    );
}