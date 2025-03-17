package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

// 해당 클래스가 서비스임을 주입
@Service
// final 멤버변수에 대해서 생성자를 자동으로 지원한다
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    /** [1] 회원가입 */
    public boolean signUp(MemberDto memberDto) {
        System.out.println("MemberService.signUp start");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberMapper.signUp(memberDto);
        System.out.println("result = " + result);
        System.out.println("MemberService.signUp end");
        return result;
    }

    /** [2] 로그인 */
    public MemberDto login(MemberDto memberDto) {
        System.out.println("MemberService.login start");
        System.out.println("memberDto = " + memberDto);
        MemberDto result = memberMapper.login(memberDto);
        System.out.println("result = " + result);
        System.out.println("MemberService.login end");
        return result;
    }
}
