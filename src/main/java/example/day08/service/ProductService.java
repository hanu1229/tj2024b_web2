package example.day08.service;

import example.day08.model.dto.ProductDto;
import example.day08.model.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProductService {

    private final ProductMapper productMapper;
    @Autowired
    public ProductService(ProductMapper productMapper) { this.productMapper = productMapper; }

    /** 제품 등록 */
    public boolean onCreate(ProductDto productDto) {
        System.out.println("ProductService.onCreate");
        System.out.println("productDto = " + productDto);
        return productMapper.onCreate(productDto);
    }

    /** 제품 전체 출력 */
    public List<ProductDto> onRead() {
        System.out.println("ProductService.onRead");
        return productMapper.onRead();
    }

    /** 제품 수정 */
    public boolean onUpdate(ProductDto productDto) {
        System.out.println("ProductService.onUpdate");
        System.out.println("productDto = " + productDto);
        return productMapper.onUpdate(productDto);
    }

    /** 제품 삭제 */
    public boolean onDelete(int id) {
        System.out.println("ProductService.onDelete");
        System.out.println("id = " + id);
        return productMapper.onDelete(id);
    }

}
