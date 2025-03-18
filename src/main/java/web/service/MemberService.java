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
    private final FileService fileService;

    /** [1] 회원가입 */
    public boolean signUp(MemberDto memberDto) {
        System.out.println("MemberService.signUp start");
        System.out.println("memberDto = " + memberDto);
        try {
            // (1) 만약에 첨부파일(프로필)이 존재하는지 검사
            if(memberDto.getUploadfile() == null) {
                // 첨부파일이 존재하지 않으면 실행
            } else {
                // 첨부파일이 존재하면 파일 서비스의 업로드 메소드 사용
                // (2) 파일서비스내 업로드 함수를 이용하여 첨부파일 업로드하고 파일명 받기
                String fileName = fileService.fileUpload(memberDto.getUploadfile());
                // (3) 업로드된 파일명을 MemberDto에 저장
                memberDto.setMimg(fileName);
            }
        } catch(Exception e) {
            // 업로드와 회원가입DB 처리중 예외 발생 시 false 반환
            return false;
        }
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
