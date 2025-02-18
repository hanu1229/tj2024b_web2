package example.day02._1RESTparam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// Body, QueryString으로 값을 받는 법


@RestController
@RequestMapping("/day02")
public class RestController3 {

    // [1] HTTP Servlet 내장 객체 : HttpServletRequest, HttpServletResponse
    @GetMapping("/doget1")
    public void method1(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // [1-1] 서블릿 방식의 쿼리스트링 받기
        System.out.println("RestController3.method1");
        String name = req.getParameter("name");
        System.out.println("name = " + name);
        // [1-2] 서블릿 방식으로 응답하기
        resp.setContentType("application/json");
        resp.getWriter().print("true");
    }

    // [2] 스프링이 제공하는 방법
    @GetMapping("/doget2")
    public boolean method2(@RequestParam(name = "name", defaultValue = "홍길동", required = false) String name) {
        /*
             매핑함수의 매개변수를 자동으로 쿼리스트링의 매개변수를 매핑/연결한다.
             @RequestParam : HTTP Request(요청)의 URL 쿼리스트링 매개변수를 매핑하는 어노테이션(GET, POST, PUT, DELETE)
             @RequestParam(name = "queryString매개변수명") 타입 변수명
             --> queryString 매개변수명과 함수 매개변수명과 동일하면 @RequestParam을 생략하면 @ModelAttribute가 자동으로 적용
             @RequestParam(name = "queryString매개변수명", defaultValue = "default값") 타입 변수명
             --> 만약에 queryString 매핑할 매개변수명이 존재하지 않으면 기본값 설정
             @RequestParam(name = "queryString매개변수명", defaultValue = "default값", required = "boolean값") 타입 변수명
             --> 기본값이 true, queryString의 매개변수의 필수 여부 설정, 만약에 쿼리스트링의 매개변수가 없으면 400(bad request잘못된 요청)을 요청
        */

        System.out.println("RestController3.method2");
        System.out.println("name = " + name);
        // @RestController에 @ResponseBody가 있다.
        // @ResponseBody를 사용했을때 자동으로 response를 'application/json'타입으로 응답한다.
        return true;
    }

    @GetMapping("/doget3")
    public int method3(String name, int age) {
        // 매개변수 : @RequestParam(name = "name") String name, @RequestParam(name = "age") int age
        System.out.println(">> RestController3.method3");
        System.out.println(">> name = " + name + ", age = " + age);
        return 3;
    }

    // [3] 컬렉션 프레임워크를 이용한 쿼리스트링 매개변수 매핑
    @GetMapping("/doget4")
    public String method4(@RequestParam()Map<String, String> map) {
        // 여러개의 매개변수를 하나의 map으로 받을 수 있다
        System.out.println(">> RestController3.method4");
        System.out.println(">> map = " + map);
        return "hello";
    }

    // [4] DTO를 이용한 쿼리스트링의 매개변수를 매핑
    //
    /*
        @ModelAttribute                     @RequestParam
        생략가능(기본값)                      명시해야한다.
        공식타입 + 개발자가 만든 타입(DTO)      공식적인 타입만 지원 : 기본타입 + List, Map, String
        쿼리스트링 / form첨부파일              쿼리스트링만 지원
    */
    // DTO를 사용 시 쿼리스트링 매개변수와 멤버변수명이 동일해야한다.
    @GetMapping("/doget5")
    public boolean method5( @ModelAttribute MemberDto memberDto) {
        System.out.println("RestController3.method5");
        System.out.println("memberDto = " + memberDto);
        return true;
    }

}
