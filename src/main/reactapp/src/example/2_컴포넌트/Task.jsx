import './Task.css';

const ProductCard = ( props ) => {
    let list = props.children;
    console.log(list);
    let state = list.inStock;
    let color = ``;
    if(state) {
        color = "in-stock";
    } else {
        color = "out-stock";
    }
    return (
        <div className="card">
            <h2 className="">{list.title}</h2>
            <h4 className="">가격 : {list.price.toLocaleString("ko-KR")}</h4>
            <h4 className={color}>{state == true ? "재고 있음" : "재고 없음"}</h4>
        </div>
    );
};
  
export default function Task( props ) {
    const products = [
        { title: "무선 키보드", price: 45000, inStock: true },
        { title: "게이밍 마우스", price: 32000, inStock: false },
        { title: "27인치 모니터", price: 280000, inStock: true }
    ];
    return (
        <div className="content">
            {
                products.map((item, index) => (
                    <ProductCard key={index}>{item}</ProductCard>
                ))
            }
        </div>
    );
}