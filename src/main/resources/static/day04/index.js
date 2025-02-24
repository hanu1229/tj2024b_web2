

console.log("index.js open");

/** [1] 등록 함수 */
const onSave = async () => {

    let name = document.querySelector(".name").value;
    let kor = document.querySelector(".kor").value;
    let math = document.querySelector(".math").value;
    // 객체{}를 선언할때 대입할 변수명이 객체의 필드명과 동일하면 생략가능
    let obj = {name, kor, math};
    // let obj = {name : name, kor : kor, math : math};

    // Fetch --> JS의 내장함수 VS $.ajax --> Jquery VS Axios --> 기본값이 JSON
    /*
    const option = {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    };
    fetch(`/day04/student`, option)
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
    .catch(error => { console.log(error); });
    */
    /*
     axios 사용법
     1. axios 설치 CDN 사용 : <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> html에 작성
     2. axios 문법
         - axios.[HTTP메소드명].() : axios.get(), axios.post(), axios.put(), axios.delete()
         - .("통신할HTTP주소", 보낼값 , {옵션})
     fetch와 비슷한 구조의 axios
     */
    /*
    axios.post(`/day04/student`, obj)
    .then(response => { console.log(response.data); })
    .catch(error => { console.log(error); });
    */
    // [2]

    console.log("axios 실행 전");

    axios.post("/day04/student", obj)
    .then(response => { console.log(response.data); onFindAll(); })
    .catch(error => { console.log(error); });

    console.log("axios 실행 후");

    /*
        비동기 통신(JS는 axios요청을 보낸 후에 응답을 기다리지 않고 다음 코드 실행)
        비동기 : 먼저 처리/응답된 순서대로 처리
        동기   : 앞에 있는 처리가 끝날때까지 다음 요청을 대기 상태
    */
    // [3]
    /*
    console.log("axios 실행 전");

    let response = axios.post("/day04/student", obj)
    console.log(response.data);

    console.log("axios 실행 후");
    */
    /*
        axios의 응답값이 반환 되기전에 두번째 콘솔이 출력된다.
    */
    // [4] 동기화(순차처리) 방법 --> 필요에 따라 / 형식 VS 비동기 방법 = 기본값
    // 동기화 : await 함수명();, 현재 함수명 앞에 async를 작성
    /*
    console.log("axios 실행 전");
    let response = await axios.post("/day04/student", obj);
    console.log(response.data);
    console.log("axios 실행 후");
    */

}

/** [2] 전체 조회 함수 */
let onFindAll = async () => {
    try {
        let response = await axios.get("/day04/student");
        // response는 응답(정보)객체, respojnse.data 는 응답객체내 본문내용
        console.log(response.data);
        let tbody = document.querySelector("tbody");
        let html = ``;
        response.data.forEach(student => {
            html += `
            <tr>
                <td>${student.name}</td>
                <td>${student.kor}</td>
                <td>${student.math}</td>
                <td>
                    <button type="button" onclick="onUpdate(${student.sno})">수정</button>
                    <button type="button" onclick="onDelete(${student.sno})">삭제</button>
                </td>
            </tr>
            `;
        });
        tbody.innerHTML = html;
    } catch(e) {
        console.log(e);
    }
}
// 최초 실행
onFindAll();

/** [3] 개별 수정 함수 */
let onUpdate = async (sno) => {
    let name = prompt("새로운 이름");
    let kor = prompt("새로운 국어 점수");
    let math = prompt("새로운 수학 점수");
    let obj = {sno, name, kor, math};
    let response = await axios.put(`/day04/student`, obj);
    if(response.data == true) { alert("수정 성공");  (); }
    else { alert("수정 실패"); }
}

/** [4] 개별 삭제 함수 */
let onDelete = async (sno) => {
    let response = await axios.delete(`/day04/student?sno=${sno}`);
    if(response.data == true) { alert("삭제 성공"); onFindAll(); }
    else { alert("삭제 실패"); }
}
