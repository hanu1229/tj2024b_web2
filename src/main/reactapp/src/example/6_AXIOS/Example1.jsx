/*
    fetch, axios를 이용한 동기/비동기 통신
    1. 설치 : 프로젝트 최상위 폴더내 터미널에 'npm install axios' 작성
    2. 파일 상단에 import axios from "axios"; 작성
*/
import axios from "axios";

export default function Example1(props) {

    // [1] 이벤트 함수 + 이벤트 결과 정보(event)
    const onEvent1 = (event) => {
        // event --> event객체 : onClick결과 정보를 매개변수로 받을 수 있다.
        console.log(event);
    }

    // [2] 이벤트 함수 + 이벤트 결과 정보(event) + 일반 매개변수
    const onEvent2 = (event, param1) => {
        console.log(event);
        console.log(param1);
    }

    //[3] axios get
    const onEvent3 = async (event) => {
        console.log("==================== [1 GET] ====================");
        const response1 = await axios.get("https://jsonplaceholder.typicode.com/posts");
        console.log(response1.data);
        console.log("==================== [2 GET] ====================");
        // 매개변수를 path variable형식으로 보냄
        const response2 = await axios.get("https://jsonplaceholder.typicode.com/posts/1");
        console.log(response2.data);
        console.log("==================== [3 GET] ====================");
        // 매개변수를 queryString형식으로 보냄
        const response3 = await axios.get("https://jsonplaceholder.typicode.com/comments?postId=1");
        console.log(response3.data);
    }

    // [4] axios post
    const onEvent4 = async (event) => {
        console.log("==================== [1 POST] ====================");
        // 매개변수를 BODY형식으로 보냄
        const obj = {userId : 1, title : "foo", body : "bar"};
        const response1 = await axios.post("https://jsonplaceholder.typicode.com/posts", obj);
        console.log(response1.data);
    }

    // [5] axios put
    const onEvent5 = async (event) => {
        console.log("==================== [1 PUT] ====================");
        const obj = {id : 1, userId : 1, title : "foo", body : "bar"};
        const response1 = await axios.put("https://jsonplaceholder.typicode.com/posts/1", obj);
        console.log(response1.data);
    }

    // [6] axios delete
    const onEvent6 = async (event) => {
        console.log("==================== [1 DELETE] ====================");
        const response1 = await axios.delete("https://jsonplaceholder.typicode.com/posts/1");
        console.log(response1.data);
    }

    return (
        <>
            <button type="button" onClick={onEvent1}>이벤트함수1</button>
            <button type="button" onClick={event => {onEvent2(event, 13)}}>이벤트함수2</button>
            <button type="button" onClick={onEvent3}>이벤트함수3 (GET)</button>
            <button type="button" onClick={onEvent4}>이벤트함수4 (POST)</button>
            <button type="button" onClick={onEvent5}>이벤트함수5 (PUT)</button>
            <button type="button" onClick={onEvent6}>이벤트함수6 (DELETE)</button>
        </>
    );
}