package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
            // (4) 비크립트 라이브러리를 이용한 비밀번호 암호화
            // (4-1) 비크립트 객체 생성
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            // (4-2) 암호화할 자료를 .encode(암호화할 자료)의 인수로 대입
            String hashedPassword = passwordEncoder.encode(memberDto.getMpwd());
            System.out.println("hashedPassword = " + hashedPassword);
            // (4-3) 암호화된 값을 dto에 넣어서 DB 처리
            memberDto.setMpwd(hashedPassword);

            boolean result = memberMapper.signUp(memberDto);
            System.out.println("result = " + result);
            System.out.println("MemberService.signUp end");
            return result;
        } catch(Exception e) {
            // 업로드와 회원가입DB 처리중 예외 발생 시 false 반환
            return false;
        }
    }

    /** [2] 로그인 */
    public MemberDto login(MemberDto memberDto) {
        System.out.println("MemberService.login start");
        System.out.println("memberDto = " + memberDto);
        // MemberDto result = memberMapper.login(memberDto);
        // System.out.println("result = " + result);
        // System.out.println("MemberService.login end");
        // return result;
        // (1) 암호화된 진짜 비밀번호는 DB에 존재 로그인에 사용된 비밀번호는 암호화
        // (2) 로그인에서 입력받은 아이디의 암호화된 비밀번호 가져오기
        String password = memberMapper.findPassword(memberDto.getMid());
        // 아이디 조회 결과가 없으면 없는 아이디
        if(password == null) { return null; }
        // (3) 로그인에서 입력받은 비밀번호와 암호화된 비밀번호 검증
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 입력받은 비밀번호와 데이터베이스에 있는 비밀번호를 검증하는 함수
        // passwordEncoder.matches(비교할 자료, 암호화된 자료);
        boolean result = passwordEncoder.matches(memberDto.getMpwd(), password);
        // 비밀번호 검증 실패 시 false 성공 시 true
        if(!result) { return null; }
        // 로그인에서 입력한 아이디와 비밀번호가 모드 일치하면 회원정보 가져오기
        MemberDto result2 = memberMapper.login(memberDto);
        return result2;
    }
}
