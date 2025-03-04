import React from "react";
// jsx에서는 생략이 가능 (react 17이상)
/*
    [1] 컴포넌트 만들어서 렌더링 해보기
        1. 지정한 폴더에 첫글자를 대문자로 하여 .js(import react) 또는 .jsx(권장)확장자 파일을 만든다.
        2. 함수형 컴포넌트(권장) VS 클래스형 컴포넌트
        3. return에서 jsx(html과 js가 합쳐진) 문법을 활용하여 화면을 구현
            JSP는 html과 java가 합쳐진 것
        4. 함수형 컴포넌트를 반환 (export default 컴포넌트명(함수명);)
*/
export default function Component1() {
    return <div>내가 만든 컴포넌트</div>
}