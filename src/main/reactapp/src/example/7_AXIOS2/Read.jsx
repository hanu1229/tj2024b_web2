import { useEffect, useState } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";


export default function Read(props) {

    // 최초 실행
    useEffect(() => {onRead();}, []);
    const [productList, setProductList] = useState([]);
    const navigate = useNavigate();
    
    const onRead = async () => {
        try {
            const response = await axios.get("http://192.168.40.64:8080/day08/products");
            console.log(response.data);
            setProductList(response.data);
        } catch(e) {
            console.log(e);
        }
    }

    const moveDelete = (event, id) => {
        navigate("/delete", {state : id});
    }
    
    return (
        <>
            <div>
                <h1>Read 페이지</h1>
                <br/>
                <table border={"1"}>
                    <thead>
                        <tr>
                            <th>제품 번호</th>
                            <th>제품 이름</th>
                            <th>제품 가격</th>
                            <th>제품 내용</th>
                            <th>삭제</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            productList.map((product, index) => {
                                return <tr key={index}>
                                    <td>
                                        <Link to="/update" state={product}>{product.id}</Link>
                                    </td>
                                    <td>{product.name}</td>
                                    <td>{product.price}</td>
                                    <td>{product.comment}</td>
                                    <td>
                                        <button type="button" onClick={(event) => {moveDelete(event, product.id)}}>삭제</button>
                                    </td>
                                </tr>
                            })
                        }
                    </tbody>
                </table>
            </div>
        </>
    );
}