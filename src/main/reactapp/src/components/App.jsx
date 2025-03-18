import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./layouts/Header";
import Home from "./Home";
import Footer from "./layouts/Footer";
import Login from "./member/Login";
import SignUp from "./member/SignUp";

export default function App(props) {
    return (
        <>
            {/* 모든 라우팅을 감싼다 */}
            <BrowserRouter>
                <div id="wrap">
                    {/* Routes밖에 있는 컴포넌트들이 고정 */}
                    <Header />
                    {/* Routes안에 있는 컴포넌트들이 전환 */}
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/member/signup" element={<SignUp />} />
                        <Route path="/member/login" element={<Login />} />
                    </Routes>
                    {/* Routes밖에 있는 컴포넌트들이 고정 */}
                    <Footer />
                </div>
            </BrowserRouter>
        </>
    );
}