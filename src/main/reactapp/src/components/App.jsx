import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Provider } from "react-redux";
import Header from "./layouts/Header";
import Home from "./Home";
import Footer from "./layouts/Footer";
import Login from "./member/Login";
import SignUp from "./member/SignUp";
import { store, persistor } from "./reduxs/store";
// import 할때 export default가 적용된 자료는 { }를 생략해도 된다.
// 여러개 또는 default가 아닌 자료에 대해서는 { }를 사용한다.
// 리덕스 퍼시스턴스 추가
import { PersistGate } from "redux-persist/integration/react";


export default function App(props) {
    return (
        <>
            {/* ↓ 리덕스 스토어 적용 : 현재 Provider로 감싼 컴포넌트들은 모두 리덕스 전역상태를 사용할 수 있다. */}
            <Provider store={store}>
                {/* ↓ 리덕스 퍼시스턴스 적용 */}
                <PersistGate persistor={persistor} loading={null}>
                    {/* ↓ 모든 라우팅을 감싼다 */}
                    <BrowserRouter>
                        <div id="wrap">
                            {/* ↓ Routes밖에 있는 컴포넌트들이 고정 */}
                            <Header />
                            {/* ↓ Routes안에 있는 컴포넌트들이 전환 */}
                            <Routes>
                                <Route path="/" element={<Home />} />
                                <Route path="/member/signup" element={<SignUp />} />
                                <Route path="/member/login" element={<Login />} />
                            </Routes>
                            {/* ↓ Routes밖에 있는 컴포넌트들이 고정 */}
                            <Footer />
                        </div>
                    </BrowserRouter>
                </PersistGate>
            </Provider>
        </>
    );
}