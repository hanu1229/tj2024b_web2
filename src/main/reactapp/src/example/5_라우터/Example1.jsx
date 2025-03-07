
import {BrowserRouter, Routes, Route, Link, useNavigate} from 'react-router-dom';

/** 메인페이지 */
function Home(props) {
    return (
        <>
            메인페이지
        </>
    );
}

/** 소개페이지 */
function About(props) {
    return (
        <>
            소개페이지
        </>
    );
}

import { useSearchParams, useParams } from 'react-router-dom';
/** 마이페이지 */
function MyPage(props) {

    // 기존 방식
    // const name = new URL(location.href).searchParams.get("name");
    // const age = new URL(location.href).searchParams.get("age");
    
    // 리액트 방식
    // 쿼리스트링 가져오기
    // import { useSearchParams } from 'react-router-dom';
    // const [searchParams] = useSearchParams();
    // const value = searchParams.get("key"); --> localhost:5173?key=value&key=value
    const [searchParams] = useSearchParams();
    // console.log(searchParams);
    const name = searchParams.get("name");
    const age = searchParams.get("age");
    // console.log(name, age);

    return (
        <>
            <h3>마이 페이지</h3>
            <p>이름 : {name || "정보 없음"}</p>
            <p>나이 : {age || "정보 없음"}</p>
        </>
    );
}

/** 제품페이지 */
function Product(props) {
    // 리액트 path 방식
    // path 방식 : localhost:5173/product/cola/1500 --> const {} = useParams();를 사용
    // queryString 방식 : localhost:5173/product?name=cola&price=1500 --> const [searchParams] = useSearchParams();를 사용
    // import {useParams} from 'react-router-dom';
    // const {변수명1, 변수명2} = useParams();
    const {name, price} = useParams();
    return (
        <>
            <h1>제품 상세 페이지</h1>
            <p>제품명 : {name || "정보 없음"}</p>
            <p>가격 : {price || "정보 없음"}</p>
        </>
    );
}

/** 오류시 보이는 페이지 */
function Page404(props) {
    // HTTP의 404오류는 경로가 존재하지 않는다 라는 뜻
    // 403은 접근 권한

    // (1) 기존 방식 : location.href = ""
    const onHome1 = () => {location.href="/"}
    // (2) 리액트 라우트 방식
    // import {useNavigate} from 'react-router-dom';
    // const navigate = useNavigate();
    // navigate("이동할경로");
    const navigate = useNavigate();
    const onHome2 = () => {navigate("/")}

    return (
        <>
            <h3>존재하지 않는 페이지</h3>
            <button onClick={onHome1}>홈으로1</button><br/>
            <button onClick={onHome2}>홈으로2</button><br/>
            <a href="/">홈으로3</a><br/>
            <Link to="/">홈으로4</Link>
        </>
    );
}

// 전체를 연결하는 컴포넌트 = 라우터 컴포넌트
export default function App(props) {
    return (
        <>
            <BrowserRouter>
                {/* 헤더 역할을 하게 됨 */}
                <div>
                    <ul>
                        <a href="/">메인페이지(HOME / get방식)</a><br/>
                        <Link to="/">메인페이지(HOME)</Link><br/>
                        <Link to="/about">소개페이지(About)</Link><br/>
                        <Link to="/mypage">마이페이지(MyPage)</Link><br/>
                        <Link to="/mypage?name=유재석&age=40">마이 페이지(값 존재)</Link><br/>
                        <Link to="/product/cola/1500">제품 상세페이지</Link>
                    </ul>
                </div>
                <Routes>
                    {/* localhost:5137을 요청하면 Home컴포넌트가 열린다 */}
                    <Route path="/" element={<Home />} />
                    {/* localhost:5137/about을 요청하면 About컴포넌트가 열린다 */}
                    <Route path="/about" element={<About />} />
                    <Route path="/mypage" element={<MyPage />} />
                    <Route path="/product/:name/:price" element={<Product />} />
                    <Route path="*" element={<Page404 />} />
                    {/* 만약에 존재하지 않는 가상URL을 요청 시 Page404컴포넌트가 열린다. */}
                    {/* path에 *을 넣으면 정의하지 않은 가상URL을 제외한 나머지 경로를 뜻한다. */}
                </Routes>
            </BrowserRouter>
        </>
    );
}