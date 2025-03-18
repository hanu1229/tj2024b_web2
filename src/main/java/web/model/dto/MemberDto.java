package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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
    // 프로필 이미지 URL (업로드된 파일명)
    private String mimg;
    // [Form전송 시 사용] 등록 시 업로드된 파일의 바이트 인터페이스
    private MultipartFile uploadfile;
    // 첨부파일이 여러개일때
    // private List<MultipartFile> uploadfiles;
}
