import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";



export default function Delete(props) {

    const location = useLocation();
    const id = location.state;
    const navigate = useNavigate();

    const onDelete = async () => {
        try {
            const response = await axios.delete(`http://localhost:8080/day08/products?id=${id}`);
            console.log(response.data);
            if(response.data == true) {
                alert("삭제 성공");
                navigate("/read");
            } else {
                alert("삭제 실패");
            }
        } catch(e) {
            console.log(e);
        }
    }

    return (
        <>
            <div>
                <h1>Delete 페이지</h1>
                <br/>
                <form>
                    <span>제품 번호 : </span>
                    <input type="text" readOnly value={id} />
                    <br/><br/>
                    <button type="button" onClick={onDelete}>삭제</button>
                </form>
            </div>
        </>
    );
}