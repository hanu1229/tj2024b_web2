package example.day01._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// @Controller
// @Controller + 지정된 클래스내 모든 메소드의 @ResponseBody
@RestController
// 클래스내 메소드들의 공통 URL 지정
@RequestMapping("/day01")
// 1. bean(객체) 등록 2. HTTP 서블릿 자동 지원
public class RestController2 {


    @GetMapping("/day01/doget3")
    @ResponseBody
    // [1]@ResponseBody
    // 자동으로 함수 return(HTTP Response)값을 application/json으로 응답
    // - 메소드의 반환값을 HTTP 응답 본문(BODY)로 application/json타입으로 응답으로 자동으로 반환한다.
    // int                  --> application/json
    // String               --> text/plain          * String만 text/plain을 전송하고 모든 객체들은 application/json으로 전송
    // Map<String, String>  --> application/json
    // boolean              --> application/json
    // MemberDto            --> application/json
    // List<MemberDto>      --> application/json
    // 등등
    // - 지정한 클래스가 @RestController에 @ResponseBody가 포함되므로 생략이 가능하다.
    
    // [2] @ResponseBody + @Controller => @RestController
    // - 동적 페이지를 반환할때는 주로 @Controller
    // - REST를 반환할때는 주로 @RestController
    
    // [3] @RequestMapping() 클래스/메소드 사용 VS @XXXMapping 메소드 사용
    // - 클래스내 메소드들의 공통 URL 정의 : @RequestMapping() 클래스 위에서 선언 [공용 URL]
    // - 클래스내 각 메소드들의 상세 URL 정의 : @XXXMapping 메소드 위에서 선언 [각 URL]
    
    public int doGet3() { return 100; }

    @GetMapping("/doget4")
    @ResponseBody
    // 문자열은 자동으로 text/plain타입으로 자동 반환한다.
    public String doGet4() { return "안녕 나는 스프링이야!"; }

    @GetMapping("/doget5")
    @ResponseBody
    public Map<String, String> doGet5() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "강호동");
        return map;
    }

    @GetMapping("/doget6")
    @ResponseBody
    public boolean doGet6() { return true; }


}
