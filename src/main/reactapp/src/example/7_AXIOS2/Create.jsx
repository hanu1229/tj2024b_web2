import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";


export default function Create(props) {

    const [product, setProduct] = useState({name : "", price : "", comment : ""});
    const changeProduct = (event) => {
        setProduct({...product, [event.target.name] : event.target.value});
    }
    const navigate = useNavigate();
    const onCreate = async () => {
        try {
            const response = await axios.post("http://192.168.40.64:8080/day08/products", product);
            console.log(response.data);
            if(response.data == true) {
                alert("등록 성공");
                setProduct({name : "", price : "", comment : ""});
                navigate("/read");
            } else {
                alert("등록 실패");
            }
        } catch(e) {
            console.log(e);
        }
    }

    console.log(product);

    return (
        <>
            <div>
                <h1>Create 페이지</h1>
                <br/>
                <form>
                    <span>제품명 : </span>
                    <input type="text" name="name" value={product.name} onChange={changeProduct} /><br/><br/>
                    <span>제품 가격 : </span>
                    <input type="text" name="price" value={product.price} onChange={changeProduct} /><br/><br/>
                    <span>제품 설명</span><br/>
                    <textarea name="comment" cols={"50"} rows={"5"} value={product.comment} onChange={changeProduct} /><br/><br/>
                    <button type="button" onClick={onCreate}>등록</button>
                </form>
            </div>
        </>
    );
}