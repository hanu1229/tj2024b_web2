package example.day03._과제.model.dto;

import lombok.*;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class BoardDto {
    private int bno;
    private String title;
    private String content;
}
