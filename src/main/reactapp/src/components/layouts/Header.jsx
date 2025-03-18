import { Link } from "react-router-dom";


export default function Header(props) {
    return (
        <>
            <div>
                <ul style={{display : "flex", listStyleType : "none"}}>
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
