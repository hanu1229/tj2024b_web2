package web.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import web.model.dto.MemberDto;

// 해당 인터페이스가 mapper임을 주입
@Mapper
public interface MemberMapper {

    /** [1] 회원가입 <br/> --> 입력받은 자료를 등록 */
    @Insert("insert into member(mid, mpwd, mname, mimg) values (#{mid}, #{mpwd}, #{mname}, #{mimg})")
    boolean signUp(MemberDto memberDto);

    /** [2] 로그인 <br/> --> 입력받은 자료를 확인/검증 */
    // boolean login(MemberDto memberDto); --> boolean : select 결과가 있으면 true, 없으면 null이라서 오류가 발생
    // MemberDto login(MemberDto memberDto); --> MemberDto : select결과가 있으면 memberDto 없으면 null 반환
    // @Select("select mno, mid, mname, mimg from member where mid = #{mid} and mpwd = #{mpwd}")
    // MemberDto login(MemberDto memberDto);

    /** [2-1] 로그인 <br/> --> 로그인 시 입력받은 아이디로 암호화된 패스워드 반환 */
    @Select("select mpwd from member where mid = #{mid}")
    String findPassword(String mid);

    /** [2-2] 로그인 <br/> --> 로그인 비밀번호 검증 성공 시 반환할 회원 정보 */
    @Select("select mno, mid, mname, mimg from member where mid = #{mid}")
    MemberDto login(MemberDto memberDto);

}
