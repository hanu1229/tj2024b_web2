import { configureStore } from "@reduxjs/toolkit";
import userReducer from "./userSlice";
// (1) 리덕스 store만들기
// (2) 변수에 configureStore 함수를 대입한다.
// (3) configureStore 함수의 매개변수에 리듀서 정의/등록한다
// (4) {reducer : {리듀서명1 : 등록할 리듀서1, 리듀서명2 : 등록할 리듀서2, 리듀서명3 : 등록할 리듀서3}}
export const store = configureStore({
    reducer : {user : userReducer}
})
// (5) store내보내기
export default store;