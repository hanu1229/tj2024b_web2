package example.day11._과제;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaskMapper {

    /** 총 제품의 개수를 가져오기 */
    @Select("select count(product_id) from day11products")
    int productCount();

    /** 특정 상품 현재 재고 수량 가져오기 */
    @Select("select stock_quantity from day11products where product_id = #{product_id}")
    int stockCount(@Param("product_id") int product_id);

    /** 모든 상품 정보 가져오기 */
    @Select("select * from day11products")
    List<Map<Object, String>> checkProducts();

    /** 매 30초마다 모든 제품의 재고가 3개씩 감소하는 스케줄 */
    @Update("update day11products set stock_quantity = stock_quantity-3 where product_id = #{product_id}")
    void decline(@Param("product_id") int product_id);

    /** 매 1분마다 재고가 10개 이하인 상품의 재고를 추가하는 스케줄 */
    @Update("update day11products set stock_quantity = stock_quantity+20 " +
            "where product_id = #{product_id}")
    void addProduct(@Param("product_id") int product_id);
//  and stock_quantity < 10
}
