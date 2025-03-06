
// 전역변수
let a = 0;

export default function Example1(props) {
    //지역변수
    let b = 0
    ++a;
    ++b;

    // 클릭했을때 실행되는 함수
    const 증가함수 = () => {
        ++a;
        ++b;
        // 증가가 안되는이유 : innerHTML을 안했기 때문
        // 상태가 변경되었을때 렌더링(새로고침)을 해야한다
    }

    return (
        <div>
            <h3>{++a}</h3>
            <h3>{++b}</h3>
            <button type="button" onClick={증가함수}>증가함수</button>
        </div>
    );
}