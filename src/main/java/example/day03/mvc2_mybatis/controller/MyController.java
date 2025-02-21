package example.day03.mvc2_mybatis.controller;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import example.day03.mvc2_mybatis.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 1. HTTP Servlet 매핑을 지원 @Controller
// 2. ResponseBody가 포함 --> 자동으로 application/json으로 응답
// 3. 컨테이너(매모리)에 빈(객체/인스턴스)을 등록
@RestController
public class MyController {

    // 스프링 컨테이너에서 서비스 객체/인스턴스를 가져옴(주입함)
    @Autowired
    private MyService myService;

    // [1] PostMapping
    @PostMapping("/day03/save")
    public int save(@RequestBody() MyDto myDto) {
        System.out.println(">> MyController.save");
        System.out.println(">> myDto = " + myDto);
        // 컨트롤러가 유저로부터 받은 데이터를 서비스에게 전달하고 응답받기
        int result = myService.save(myDto);
        return result;
    }

    // [2] GetMapping
    @GetMapping("/day03/findall")
    public List<MyDto> findAll() {
        System.out.println(">> MyController.findAll");
        // 컨트롤러에서 서비스에게 전달하고 응답받기
        List<MyDto> result = myService.findAll();
        return result;
    }

    // [3] GetMapping
    @GetMapping("/day03/find")
    public MyDto find(@RequestParam(name = "id") int id) {
        System.out.println(">> MyController.find");
        System.out.println(">> id = " + id);
        // 컨트롤러에서 서비스에게 전달하고 응답받기
        MyDto result = myService.find(id);
        return result;
    }

    // [4] PutMapping
    @PutMapping("/day03/update")
    public int update(@RequestBody() MyDto myDto) {
        System.out.println(">> MyController.update");
        System.out.println(">> myDto = " + myDto);
        // 컨트롤러에서 서비스에게 전달하고 응답받기
        int result = myService.update(myDto);
        return result;
    }

    // [5] DeleteMapping
    @DeleteMapping("/day03/delete")
    public int delete(@RequestParam(name = "id") int id) {
        System.out.println(">> MyController.delete");
        System.out.println(">> id = " + id);
        // 컨트롤러에서 서비스에게 전달하고 응답받기
        int result = myService.delete(id);
        return result;
    }

}
