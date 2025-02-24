package example.day04.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class StudentDto {
    private int sno;
    private String name;
    private int kor;
    private int math;
}
