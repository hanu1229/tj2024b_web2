

console.log("index.js open");

/** [1] 등록 함수 */
const onSave = () => {

    let name = document.querySelector(".name").value;
    let kor = document.querySelector(".kor").value;
    let math = document.querySelector(".math").value;
    // 객체{}를 선언할때 대입할 변수명이 객체의 필드명과 동일하면 생략가능
    // let obj = {name, kor, math};
    let obj = {name : name, kor : kor, math : math};

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
    // axios 사용법
    // 1. axios 설치 CDN 사용 : <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> html에 작성
    // 2. axios 문법
        // - axios.[HTTP메소드명].() : axios.get(), axios.post(), axios.put(), axios.delete()
        // - .("통신할HTTP주소", 보낼값 , {옵션})
    axios.post(`/day04/student`, obj)
    .then(response => { console.log(response); })
    .catch(error => { console.log(error); });


}