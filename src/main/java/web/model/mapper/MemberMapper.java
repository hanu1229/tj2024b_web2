package web.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import web.model.dto.MemberDto;

// 해당 인터페이스가 mapper임을 주입
@Mapper
public interface MemberMapper {

    /** [1] 회원가입 <br/> --> 입력받은 자료를 등록 */
    @Insert("insert into member(mid, mpwd, mname) values (#{mid}, #{mpwd}, #{mname})")
    boolean signUp(MemberDto memberDto);

    /** [2] 로그인 <br/> --> 입력받은 자료를 확인/검증 */
    // boolean login(MemberDto memberDto); --> boolean : select 결과가 있으면 true, 없으면 null이라서 오류가 발생
    // MemberDto login(MemberDto memberDto); --> MemberDto : select결과가 있으면 memberDto 없으면 null 반환
    @Select("select mno, mid, mname, mimg from member where mid = #{mid} and mpwd = #{mpwd}")
    MemberDto login(MemberDto memberDto);

}
