package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data @Builder
public class MemberDto {
    // 회원 번호 (기본키)
    private int mno;
    // 회원 아이디
    private String mid;
    // 비밀번호
    private String mpwd;
    // 회원 이름
    private String mname;
    // 프로필 이미지 URL
    private String mimg;
}
