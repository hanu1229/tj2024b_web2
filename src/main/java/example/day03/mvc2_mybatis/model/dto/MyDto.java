package example.day03.mvc2_mybatis.model.dto;

import lombok.*;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class MyDto {

    private int id;
    private String name;
    private int age;

}
