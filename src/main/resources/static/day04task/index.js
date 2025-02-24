

console.log("index.js open");

/** [1] 글쓰기 */
let _write = async () => {
    let title = document.querySelector("#title-input").value;
    let content = document.querySelector("#content-input").value;
    let obj = {title : title, content : content};
    let response = await axios.post("/day04/task/board", obj);
    if(response.data == true) {
        alert("글쓰기 성공");
        document.querySelector("#title-input").value = "";
        document.querySelector("#content-input").value = "";
        _findAll();
    } else {
        alert("글쓰기 실패");
    }
}

/** [2] 전체 글 조회 */
let _findAll = async () => {
    let tbody = document.querySelector("tbody");
    let html = ``;
    try {
        let response = await axios.get("/day04/task/board");
        response.data.forEach(board => {
            html += `
            <tr>
                <td>
                    <a onclick="_find(${board.bno})">${board.bno}</a>
                </td>
                <td>${board.title}</td>
                <td>${board.content}</td>
                <td>
                    <button onclick="_update(${board.bno})">수정</button>
                    <button onclick="_delete(${board.bno})">삭제</button>
                </td>
            </tr>
            `;
        });
        tbody.innerHTML = html;
    } catch(e) {
        console.log(e);
    }
}
// 최초 1회 실행
_findAll();

/** [3] 개별 글 조회 */
let _find = async (bno) => {
    try {
        let response = await axios.get(`day04/task/board/biew?bno=${bno}`);
        if(response.data != null) {
            alert(`제목 : ${response.data.title} \n내용 : ${response.data.content}`);
        }
    } catch(e) {
        console.log(e);
    }
}

/** [4] 개별 글 수정 */
let _update = async (bno) => {
    let title = prompt("제목 수정 : ");
    let content = prompt("내용 수정 : ");
    let obj = {bno : bno, title : title, content : content};
    try {
        let response = await axios.put("/day04/task/board", obj);
        if(response.data == true) {
            alert("수정 성공");
            _findAll();
        } else {
            alert("수정 실패");
        }
    } catch(e) {
        console.log(e);
    }
}

/** [5] 개별 글 삭제 */
let _delete = async (bno) => {
    let state = confirm("정말 삭제하시겠습니까?");
    if(state == true) {
        try {
            let response = await axios.delete(`/day04/task/board?bno=${bno}`);
            if(response.data == true) {
                alert("삭제 성공");
                _findAll();
            } else {
                alert("삭제 실패");
            }
        } catch(e) {
            console.log(e);
        }
    }
}