package example.day08.model.mapper;

import example.day08.model.dto.ProductDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProductMapper {

    /** 제품 등록 */
    @Insert("insert into productsample(name, price, comment) values (#{name}, #{price}, #{comment})")
    boolean onCreate(ProductDto productDto);

    /** 제품 전체 출력 */
    @Select("select * from productsample")
    List<ProductDto> onRead();

    /** 제품 수정 */
    @Update("update productsample set name = #{name}, price = #{price}, comment = #{comment} where id = #{id}")
    boolean onUpdate(ProductDto productDto);

    /** 제품 삭제 */
    @Delete("delete from productsample where id = #{id}")
    boolean onDelete(int id);
}
