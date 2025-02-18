package example.day02._1RESTparam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/day02")
public class RestController4 {

    // [1] HTTP Request(요청) body(본문)을 매핑하는 방법, (POST, PUT)
    // @RequestBody : HTTP 요청 body의 'application/json'타입 자료를 자바 타입으로 변환/매핑 해주는 어노테이션
    // --> @RequestBody도 생략하면 @ModelAttribute가 적용 되므로 body매핑은 꼭 @RequestBody를 작성해야한다.
    // --> @RequestParam도 생략하면 @ModelAttribute가 적용 되지만 queryString 매핑은 @ModelAttribute도 가능하므로 생략이 가능하다.
    @PostMapping("/dopost1")
    public boolean method1(@RequestBody() MemberDto memberDto) {
        System.out.println(">> RestController4.method1");
        System.out.println(">> memberDto = " + memberDto);
        return true;
    }

    @PostMapping("dopost2")
    public boolean method2(@RequestBody()Map<String, String> map) {
        System.out.println(">> RestController4.method2");
        System.out.println(">> map = " + map);
        return true;
    }

}
