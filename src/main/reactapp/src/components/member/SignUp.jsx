import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";


export default function SignUp(prpos) {

    // (1) 입력받은 값들을 저장하는 state변수 선언
    const [memberInfo, setMemberInfo] = useState({mid : "", mpwd : "", mname : ""});
    // (2) 입력받은 값들을 state에 렌더링하는 함수
    const changeInfo = (event) => {
        setMemberInfo({...memberInfo, [event.target.name] : event.target.value})
    }
    // (3) 입력받은 첨부파일 + 첨부파일 미리보기
    // 업로드 파일을 파일객체로 저장하는 state 변수 선언
    const [profile, setProfile] = useState(null);
    // 업로드 파일을 바이트로 저장하는 state 변수 선언
    const [preview, setPreview] = useState(null);
    const onFileChange = (event) => {
        console.log(event.target.files[0]);
        // 1. 업로드된 파일 반환
        const file = event.target.files[0];
        // 2. 업로드된 파일을 state에 저장
        setProfile(file);
        // 3. 이미지 미리보기
        if(file) {
            // 4. 파일 읽기 객체 선언
            // js에서 지원하는 파일 읽기 객체
            const reader = new FileReader();
            // 5. 파일 읽기 함수 정의 / reader.onload(() => { 파일을 읽어드릴 때 실행할 코드})
            reader.onload = () => {
                // 일어드린 파일을 출력 / reader.result : 가져온 파일의 결과물 
                console.log(reader.result);
                setPreview(reader.result);
            }
            // 6. 파일 읽기 reader.readAsDataURL(file 객체);
            // 읽어드릴 파일 대입
            reader.readAsDataURL(file);
        } else {
            setPreview(null);
        }
    }

    // (4) 입력받은 값들을 axios로 보내고 응답받기
    const navigate = useNavigate();
    const onSignup = async () => {
        // 1. formdata객체 만들기 / json과 다르게 문자열 전송이 아닌 바이트(바이너리)전송을 하기위한 폼전송
        const formData = new FormData();
        // 2. formdata에 속성 넣기 / .append("속성명", 값);
        formData.append("mid", memberInfo.mid);
        formData.append("mpwd", memberInfo.mpwd);
        formData.append("mname", memberInfo.mname);
        // 만약에 첨부파일이 존재하면 첨부파일 추가
        if(profile) {
            formData.append("uploadfile", profile);
        }
        // 3. axios에서 사용할 http 헤더 정보 / axios에서는 application/json은 기본값이기 때문에 할 필요가 없었다.
        const option = {headers : {"Content-Type" : "multipart/form-data"}};
        try {
            // 4. axios 비동기 대신 동기로
            const response = await axios.post("http://localhost:8080/api/member/signup", formData, option);
            // 5. 응답 받기
            const result = response.data;
            console.log(result);
            if(result) {
                alert("회원가입 성공");
                navigate("/member/login");
            } else {
                alert("회원가입 실패");
            }
        } catch(e) {
            console.log(e);
        }
    }

    console.log(memberInfo);

    return (
        <>
            <h3>회원가입 페이지</h3>
            <form>
                아이디 : <input type="text" name="mid" value={memberInfo.mid} onChange={changeInfo} />
                <br/>
                비밀번호 : <input type="password" name="mpwd" value={memberInfo.mpwd} onChange={changeInfo} />
                <br/>
                닉네임 : <input type="text" name="mname" value={memberInfo.mname} onChange={changeInfo} />
                <br/>
                프로필 : <input type="file" accept="image/*" onChange={onFileChange}/>
                <br/>
                미리보기 :
                {/* preview != null ? <img src={preview} style={{width : 200}} /> : <> </> 와 동일한 기능 */}
                {preview && (<img src={preview} style={{width : 200}} />)}
                <br/><br/>
                <button type="button" onClick={onSignup}>회원가입</button>
            </form>
        </>
    );
}