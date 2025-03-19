import { createSlice } from "@reduxjs/toolkit";

// (1) 전역상태(변수)로 사용할 데이터 초기값 정의
const initialState = {
    // 로그인한 정보를 저장 할 속성
    userInfo : null,
    // 로그인 여부 상태를 저장하는 속성 false : 비로그인, true : 로그인
    isAuthenticated : false
}
// (2) createSlice 함수를 이용한 상태와 리듀서 만들기
// (3) 전역 상태 정의, name : "상태(변수)의 이름", 상태(변수)의 초기값
// (4) 전역 상태를 수정하는 리듀서 만들기, reducers : {함수명 : 처리함수, 함수명 : 처리함수}
const userSlice = createSlice({
    // 상태(변수)의 이름
    name : "user",
    // 상태(변수)의 초기값
    initialState,
    //
    reducers : {
        login : (state, action) => {
            // 로그인 함수를 호출 시 로그인 여부를 true로 변경
            state.isAuthenticated = true;
            // 로그인 함수를 호출 시 매개변수를 받는 속성(값)(payload)들로 변경
            state.userInfo = action.payload;
        },
        logout : (state) => {
            // 로그아웃 함수를 호출 시 로그인 여부를 false로 변경
            state.isAuthenticated = false;
            // 로그아웃 함수를 호출 시 로그인 정보를 null로 변경
            state.userInfo = null;
        }
    }
})

// (5) export
// 액션을 생성
export const {login, logout} = userSlice.actions;
// 리듀서 내보내기 .reducer는 userSlice안에 있는 reducers를 내보내는 것이다
export default userSlice.reducer;