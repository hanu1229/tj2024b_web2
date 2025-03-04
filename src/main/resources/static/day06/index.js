

console.log("index.js open")

// JS의 기본 문법 정리(React에서 필요한 기본 문법)

// [1] 변수선언(let 변수명, const 변수명)
// 변수 선언
let count = 0;
// 변수값 수정
count = 1;
// 상수 선언
const count2 = 0;
// 상수값 수정
// count2 = 1;
// *주의할 점 : 객체가 상수에 저장되고 객체내 속성값은 수정이 가능하다.
const obj = {name : "유재석"};
obj.name = "강호동";
console.log(obj);

// [2] 함수(메소드)
// 정의 1 : 선언적 함수
function func1(param1, param2) {}
// 정의 2 : 익명 함수, 주로 변수 or 상수에 저장하여 사용, 이벤트 함수
const func2 = function (param1, param2) {}
// 정의 3 : 화살표 / 주로 람다식 함수, 변수 or 상수에 저장하여 사용, 이벤트 함수
let func3 = (param1, param2) => {}
// 호출
func1(4, 10);
func2("유재석", "강호동");
func3(10, "유재석");
// 기본 매개변수값 정의 : 인자가 없을때 기본값을 대입할 수 있다.
const func4 = (param1, param2, param3 = "학생") => {console.log(`${param1} / ${param2} / ${param3}`);}
func4("유재석", 10);

// [3] 객체 : { } 객체 : key 와 value 한쌍으로 구성하여 { }으로 묶음, [] 리스트/배열
// 1. 객체 : {key : value, key : value, key : value, key : value}
const obj2 = {"name" : "유재석", "age" : "40"};
// 2. 속성명(key 단축)
let name3 = "강호동";
let age3 = 50;
const obj3 = {name3, age3};
// 3. 객체의 속성값 호출
console.log(obj3.name3);
console.log(obj3.age3);
// 4. 리스트/배열 : [value, value, value, value, value, value]
const array1 = [1, 2, 3, 4, 5];
console.log(array1);
// 5. 리스트내 값 호출
console.log(array1[3]);
// 6. 스프레드 연산자(...) : 배열이나 객체를 복사하거나 합칠 때 사용
const array2 = [...array1, 6, 7];
console.log(array1);
console.log(array2);
const obj4 = {...obj3, phone : "010"};
console.log(obj4);

// [4] 백틱 : 문자열 템플릿, 연산자가 이닌 ``안에 ${}를 이용하여 문자열과 표현식을 연결할 때 사용
// 선언부 : if/for/while/객체/변수/함수 선언 등 불가능
// 표현부 : 1 + 3/ 삼항연산자 / 변수호출 / 함수호출 / 객체 호출 등 가능
const str4 = "react";
console.log(`hello ${str4}`);

// [5] 구조 분해 할당, 객체나 배열에서 값을 분해 추출하는 방법
const user = {name5 : "신동엽", age5 : 50};
// 객체내 동일한 속성명으로 변수를 여러개 분해해서 저장할 수 있다.
const {name5, age5} = user;
console.log(name5);
console.log(age5);

// [6] 비구조화 할당과 나머지 연산자
const [array6, ...rest] = [1, 2, 3, 4]
console.log(array6);
console.log(rest);

const {name6, ... rest2} = {name6 : "서장훈" , age : 70, phone : "010"};
console.log(name6);
console.log(rest2);

// [7] 삼항연산자 (조건 ? 참 : 거짓)
const loginState = true;
// 삼항연산자
console.log(loginState == true ? "로그인 상태" : "비로그인상태");

// [8] 단축 연산/평가
// 조건(A) && 참(B) : 만약에 조건이 True이면 B반환 False이면 A반환
console.log(loginState && "로그인 상태");
console.log(loginState || "비로그인 상태");
// 단축 연산/평가
// 조건(A) || 거짓(B) : 만약에 조건이 True이면 A반환 False이면 B반환
const loginState2 = false;
console.log(loginState2 && "로그인 상태")
console.log(loginState2 || "비로그인 상태");

// [9] 비동기 : 통신요청을 보내고 오기전에 다른 코드 처리, 동기 : 통신요청을 보내고 응갑이 올때까지 대기상태
// 비동기
const func8 = () => {
    fetch("").then(response => response.json()).then(data => {}).catch(error => {});
    axios.get("").then(data => {}).catch(error => {});
}
// 동기 1
const func9 = async () => {
    await fetch("").then(response => response.json()).then(data => {}).catch(error => {});
    await axios.get("").then(data => {}).catch(error => {});
}
// 동기 2
const func10 = async () => {
    try {
        const response = await fetch("");
        const data = response.json();
    } catch(e) { console.log(e); }
    try {
        const response = await axios.get("");
        const data = response.data;
    } catch(e) { console.log(e); }
}


// [11] 반복문
const arr9 = [10, 20, 30, 40, 50];
// 일반적인 for문
for(let index = 0; index < arr9.length; index++) {
    console.log(arr9[index]);
}
// 향상된 for문, in : 인덱스 순회, of : 값 순회
// 반복변수명 in 배열명
for(let index in arr9) { console.log(index); }
// 반복변수명 of 배열명
for(let value of arr9) { console.log(value); }
// forEach문 : return 불가능
// 배열명.forEach((반복변수명) => {});
arr9.forEach((value, index) => { console.log(value, index); });
// ※ map문 : return 가능
const arr10 = arr9.map((value, index) => { console.log(value, index); return value*10; });
console.log(arr10);
// filter : 조건에 맞는것만 return할 수 있다.
const arr11 = arr9.filter((value, index) => {return value % 4 === 0});
console.log(arr11);
