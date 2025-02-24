package example.day04task.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class BoardDto {
    private int bno;
    private String title;
    private String content;
}
