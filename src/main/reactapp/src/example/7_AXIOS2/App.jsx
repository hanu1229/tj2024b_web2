import {BrowserRouter, Routes, Route, Link} from "react-router-dom";

// 라우터로 연결할 컴포넌트를 import로 가져온다.
import Home from "./Home";
import SideBar from "./SideBar";
import Create from "./Create";
import Read from "./Read";
import Update from "./Update";
import Delete from "./Delete";

import "./app.css";

// App.jsx : 라우터(가상URL)를 이용한 라이팅
export default function App(props) {
    return (
        <>  
            {/* 모든 라우터를 감싼다 */}
            <BrowserRouter>
                <div id="wrap">
                    <SideBar />

                    {/* 가상으로 정의한 URL을 감싼다 */}
                    <Routes>
                        {/* path에 가상의 URL을 정의한 후 element에 컴포넌트를 연결 */}
                        <Route path="/" element={<Home />} />
                        <Route path="/create" element={<Create />} />
                        <Route path="/read" element={<Read />} />
                        <Route path="/update" element={<Update />} />
                        <Route path="/delete" element={<Delete />} />
                    </Routes>
                </div>
            </BrowserRouter>
        </>
    );
}