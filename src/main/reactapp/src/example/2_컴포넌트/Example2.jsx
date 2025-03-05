
export default function Example2() {
    return (
        <>
            <SubComponent1 name="유재석"/>
            <SubComponent1 name="강호동" age="10"/>
            <SubComponent2 >
                여기가 props.children입니다.
            </SubComponent2>
            <SubComponent2>
                <button>부모가 전달한 마크업</button>
            </SubComponent2>
            <SubComponent3 name="유재석" age="40"/>
            <SubComponent4 nation="일본" />
            <SubComponent4 />
        </>
    );
}

// (1) 하위 컴포넌트 매개변수
function SubComponent1(props) {
    console.log(props);
    // props.name = "신동엽"; --> 오류(수정 불가능)
    return (
        <>
            <h3>{props.name}님 안녕하세요, {props.age}</h3>
        </>
    );
}

// (2) 하위컴포넌트 자식요소
function SubComponent2(props) {
    console.log(props);
    // props.children : 자식요소 사이 innerHTML값을 가져올 수 있음
    return (
        <>
            <h3>{props.children}</h3>
        </>
    );
}

// (3) 하위 컴포넌트 매개변수 props의 구문 분해
// {name} = {name : "유재석" , "age" : 40}
// props대신에 {속성명}으로 표현하면 props내 존재하는 속성명을 변수로 각각 선언
function SubComponent3({name, age}) {
    return (
        <>
            <h3>{[name]}님 {age}살 입니다.</h3>
        </>
    );
}

// (4) 하위 컴포넌트 매개변수 기본값 지정
function SubComponent4({nation = "대한민국"}) {
    return (
        <>
            <h3>{nation} 국적입니다.</h3>
        </>
    );
}

