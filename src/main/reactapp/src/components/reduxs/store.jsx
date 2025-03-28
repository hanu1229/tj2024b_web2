import { configureStore } from "@reduxjs/toolkit";
import userReducer from "./userSlice";
// (1) 리덕스 store만들기
// (2) 변수에 configureStore 함수를 대입한다.
// (3) configureStore 함수의 매개변수에 리듀서 정의/등록한다
// (4) {reducer : {리듀서명1 : 등록할 리듀서1, 리듀서명2 : 등록할 리듀서2, 리듀서명3 : 등록할 리듀서3}}
// 리덕스 퍼시스턴스 적용 전
// export const store = configureStore({
//     reducer : {user : userReducer}
// })
// 리덕스 퍼시스턴스 적용 전
// (5) store내보내기
// export default store;

// (6) 리덕스 퍼시스턴스 함수 가져오기
import { persistStore, persistReducer } from "redux-persist";
import storage from "redux-persist/lib/storage";

// (7) 퍼시스턴스 설정 ( key --> 로컬 스토리지의 저장할 키)
// storage : storage는 localStorage에 사용 설정
// key : "root"는 localStorage에 저장할 키 설정
const persistConfig = {storage : storage, key : "root"}

// (8) 퍼시스턴스 적용할 리듀서 설정
// const persistedReducer = persistReducer(퍼시스턴스 설정, 적용할 리듀서);
const persistedReducer = persistReducer(persistConfig, userReducer);

export const store = configureStore({
    // (9) 퍼시스턴스를 적용
    reducer : {user : persistedReducer}
})
// (10) 퍼시스턴스가 적용된 스토어 내보내기
export const persistor = persistStore(store);
// (5) store내보내기
export default store;