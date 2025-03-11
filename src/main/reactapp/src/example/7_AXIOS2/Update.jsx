import { useState } from "react";
import axios from "axios";
import { useLocation } from "react-router-dom";


export default function Update(props) {

    const location = useLocation();
    const product = location.state;

    const [newProduct, setNewProduct] = useState(
        {...product}
    );
    const changeProduct = (event) => {
        setNewProduct({...newProduct, [event.target.name] : event.target.value});
    }

    const onUpdate = async () => {
        try {
            const response = await axios.put("http://192.168.40.64:8080/day08/products", product);
            console.log(response.data);
            if(response.data == true) {
                alert("수정 성공");
                setNewProduct({id : "", name : "", price : "", comment : ""});
            } else {
                alert("수정 실패");
            }
        } catch(e) {
            console.log(e);
        }
    }

    console.log(product);

    return (
        <>
            <div>
                <h1>Update 페이지</h1>
                <br/>
                <form>
                    <span>제품 번호 : </span>
                    <input type="number" name="id" value={newProduct.id} onChange={changeProduct} />
                    <br/><br/>
                    <span>제품명 : </span>
                    <input type="text" name="name" value={newProduct.name} onChange={changeProduct} />
                    <br/><br/>
                    <span>제품 가격 : </span>
                    <input type="number" name="price" value={newProduct.price} onChange={changeProduct} />
                    <br/><br/>
                    <span>제품 내용 : </span><br/>
                    <textarea name="comment" cols={"50"} rows={"5"} value={newProduct.comment} onChange={changeProduct} />
                    <br/><br/>
                    <button type="button" onClick={onUpdate}>수정</button>
                </form>
            </div>
        </>
    );
}