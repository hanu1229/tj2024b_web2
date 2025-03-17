package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.model.dto.MemberDto;
import web.service.MemberService;

// @ResponseBody를 포함하여 restApi를 지원하는 컨트롤러 빈(객체)를 등록
@RestController
// 클래스내 http 매핑주소의 공통 url을 정의할 때 사용
@RequestMapping("/api/member")
// ---> 개발하는 사람들이 페이지 매핑과 REST 매핑을 구분하기 위한 방법
// 1. 페이지 url : ~/member/signup
/* 2. REST url :
    2-1. /member/signup.do : 뒤에 do를 붙이느 경우(과거)
    2-2. /api/member/signup : 앞에 api를 붙이는 경우(최근)
*/
// final 멤버변수에 대해서 생성자를 자동으로 지원한다
// final 필드에 대해서 자동으로 생성자를 지원하므로 @Autowired 주입을 생략해도 된다.
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /** [1] 회원가입 */
    // Content-Type : application/json
    // body : {"mid", "mpwd" , "mname" }
    @PostMapping("/signup")
    public boolean signUp(@RequestBody() MemberDto memberDto) {
        System.out.println("MemberController.signUp start");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberService.signUp(memberDto);
        System.out.println("result = " + result);
        System.out.println("MemberController.signUp end");
        return result;
    }

    /** [2] 로그인 */
    @PostMapping("/login")
    public boolean login(@RequestBody() MemberDto memberDto, HttpServletRequest req) {
        System.out.println("MemberController.login start");
        System.out.println("memberDto = " + memberDto);
        MemberDto result = memberService.login(memberDto);
        System.out.println("result = " + result);
        System.out.println("MemberController.login end");
        // 서비스 결과가 null이면 로그인 실패 / 서비스 결과가 null이 아니면 로그인 성공
        if(result == null) { return false; }
        else {
            HttpSession session = req.getSession();
            // 세선 객체내 새로운 속성 추가, 로그인 성공하면 결과를 "loginDto"라는 이름으로 저장
            session.setAttribute("loginDto", result);
            // 세션 유지시간 10분
            session.setMaxInactiveInterval(60 * 10);
            return true;
        }
    }

    /** [3] 로그아웃 */
    @GetMapping("/logout")
    public boolean logout(HttpServletRequest req) {
        System.out.println("MemberController.logout start");
        System.out.println("req = " + req);
        HttpSession session = req.getSession();
        if(session == null) { return false; }
        // 세션내 전체 속성 초기화
        // session.invalidate();
        // 세션내 특정 속성 초기화
        session.removeAttribute("loginDto");
        System.out.println("session = " + session);
        System.out.println("MemberController.logout end");
        return true;
    }

    /** [4] 로그인 상태 확인(내정보 보기, 마이페이지) */
    @GetMapping("/info")
    public MemberDto info(HttpServletRequest req) {
        System.out.println("MemberController.info start");
        HttpSession session = req.getSession();
        if(session == null) { return null; }
        // 로그인 성공시 저장한 loginDto와 로그인정보를 꺼낸다.
        Object object = session.getAttribute("loginDto");
        // 세션에 저장된 자료들은 모두 Object타입이므로 타입 변환
        MemberDto memberDto = (MemberDto)object;
        System.out.println("memberDto = " + memberDto);
        System.out.println("MemberController.info end");
        return memberDto;
    }

}
