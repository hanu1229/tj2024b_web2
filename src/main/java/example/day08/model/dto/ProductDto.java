package example.day08.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/** <b>제품 관련 데이터</b> */
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class ProductDto {
    // 제품 번호
    private int id;
    // 제품 이름
    private String name;
    // 제품 가격
    private int price;
    // 제품 내용
    private String comment;
}
