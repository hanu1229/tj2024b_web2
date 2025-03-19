import axios from "axios";
import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";
import { logout } from "../reduxs/userSlice";

export default function Header(props) {

    // (*) 리덕스(전역변수) 사용하기
    // (*-1) 전역상태에서 로그인한 회원정보 불러오기, user라는 이름의 리듀서 정보를 가져오기
    const loginInfo = useSelector((state) => state.user.userInfo);
    console.log(loginInfo);

    // (1) 로그인 상태를 저장하는 state 변수
    const [login, setLogin] = useState({});
    // (2) axios를 이용하여 서버에게 로그인 상태 요청하고 응답받기
    const onLoginInfo = async () => {
        // 1. axios를 이용하여 서버에 요청 후 응답 받기
        const response = await axios.get(`http://localhost:8080/api/member/info`, {withCredentials : true});
        // 2. 응답의 본문(결과)을 반환
        const result = response.data;
        console.log(result);
        // 3. 응답결과를 state 변수에 저장
        setLogin(result);
    }
    // (3) useEffect함수를 이용하여 onLoginInfo함수를 실행 / useEffect(() => {}, []) : 컴포넌트가 최초 랜더링 1번 실행될 때
    useEffect(() => {onLoginInfo();}, []);

    // (4) axios를 이용하여 로그아웃을 요청하고 응답받기
    
    const navigate = useNavigate();
    const onLogout = async () => {
        const response = axios.get("http://localhost:8080/api/member/logout", {withCredentials : true});
        if(response.data) {
            alert("로그아웃 성공");
            navigate("/");
            dispatchEvent(logout());
        } else {
            alert("로그아웃 실패");
        }
    }

    // 로그인 / 로그아웃을 했을 때 재렌더링이 필요
    return (
        <>
            <div>
                <ul style={{display : "flex", listStyleType : "none"}}>
                    <li>
                        {
                            loginInfo ? 
                            (<>
                                <div>
                                    {loginInfo.mname}님, 반갑습니다.
                                    <button type="button" onClick={onLogout}>로그아웃</button>
                                </div>

                            </>) : 
                            (<><div>비로그인중</div></>)
                        }
                    </li>
                    <li style={{margin : "0px 10px"}}>
                        <Link to="/" style={{textDecoration : "none", color : "black"}}>홈으로</Link>
                    </li>
                    <li style={{margin : "0px 10px"}}>
                        <Link to="/member/signup" style={{textDecoration : "none", color : "black"}}>회원가입</Link>
                    </li>
                    <li style={{margin : "0px 10px"}}>
                        <Link to="/member/login" style={{textDecoration : "none", color : "black"}}>로그인</Link>
                    </li>
                </ul>
                <hr/>
            </div>
        </>
    );
}
