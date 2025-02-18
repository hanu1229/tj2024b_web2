package example.day02._3과제;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter @ToString
public class BoardDto {
    // 게시물 번호
    private int bno;
    // 게시물 제목
    private String title;
    // 게시물 내용
    private String content;
}
