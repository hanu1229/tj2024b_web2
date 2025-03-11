package example.day08.controller;

import example.day08.model.dto.ProductDto;
import example.day08.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/day08/products")
@CrossOrigin("http://192.168.40.64:5173")
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) { this.productService = productService; }

    /** 제품 등록 */
    @PostMapping("")
    public boolean onCreate(@RequestBody() ProductDto productDto) {
        System.out.println("ProductController.onCreate");
        System.out.println("productDto = " + productDto);
        return productService.onCreate(productDto);
    }

    /** 제품 전체 출력 */
    @GetMapping("")
    public List<ProductDto> onRead() {
        System.out.println("ProductController.onRead");
        return productService.onRead();
    }

    /** 제품 수정 */
    @PutMapping("")
    public boolean onUpdate(@RequestBody() ProductDto productDto) {
        System.out.println("ProductController.onUpdate");
        System.out.println("productDto = " + productDto);
        return productService.onUpdate(productDto);
    }

    /** 제품 삭제 */
    @DeleteMapping("")
    public boolean onDelete(@RequestParam(name = "id") int id) {
        System.out.println("ProductController.onDelete");
        System.out.println("id = " + id);
        return productService.onDelete(id);
    }

}
