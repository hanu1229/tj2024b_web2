
export default function Example1() {
    // =============== JSX문법 시작 =============== //
    return (
        <div>
            {/* 주석 내용물 */}
            <h3>컴포넌트</h3>
            {/* 다른 컴포넌트 호출 */}
            <Component1/>
            <Component2/>
            <Component3/>
            <Component4/>
            <Component5/>
            <Component6/>
            <Component7/>
        </div>
    )
    // =============== JSX문법 끝 =============== //
}

function Component1(porps) {
    return <h4>한줄로 입력시 ()생략이 가능</h4>
}

function Component2(props) {
    return (
        <div>
            <h4>두줄이상 입력시 ()를 필수로 사용</h4>
        </div>
    );
}

function Component3(props) {
    return (
        <>
            <h4>div 대신에 이름없는 마크업 사용이 가능</h4>
        </>
    );
}

function Component4(props) {
    const name = "유재석";
    const age = 40;
    const obj = {name : "강호동", age : 50};
    return (
        <>
            <h4>{name}님의 나이 : {age}</h4>
            <h4>{obj.name}님의 나이 : {obj.age}</h4>
        </>
    );
}

function Component5(props) {
    const loginState = true;
    // JSX문법 {}표현식에서는 if, for, function, const ,let등 불가능
    return (
        <>
            <h4>{loginState == true ? "로그인" : "비로그인"}</h4>
            <h4>{loginState && <p>로그인 상태일때만 보이는 메시지</p>}</h4>
        </>
    );
}

function Component6(props) {
    const items = ["사과", "딸기", "바나나"];
    // JSX문법에 목록(li, option 등)마크업들에는 key속성이 필요
    // └─ 리액트는 자동렌더링(새로고침)을 할때 key값 변화를 감지하여 변환된 key만 별도로 렌더링하는 기능을 가짐
    // JSX문법에서는 forEach함수 보다 map함수를 많이 사용
    return (
        <>
            <ul>
                {
                    items.map((item, index) => (
                        <li key={index}>{item}</li>
                    ))
                }
            </ul>
        </>
    );
}

// CSS파일 import
import './Example1.css';
function Component7(props) {
    // style = "color : blue;" 방식 X
    // style = { {CSS객체} } 방식 O --> 하이픈표기법대신 카멜표기법을 사용
    const cssObj = {color : "red"};
    // class속성이 아닌 className을 사용
    return (
        <>
            <h4 style={{color : "blue"}}>인라인 형식의 CSS 넣기</h4>
            <h4 style={cssObj}>인라인 형식의 객체CSS 넣기</h4>
            <h4 className="myClass">CSS파일내 선택자를 이용한 CSS 넣기</h4>
        </>
    );
}