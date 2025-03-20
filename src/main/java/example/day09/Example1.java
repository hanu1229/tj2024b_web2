package example.day09;

import lombok.Builder;

@Builder
class MemberDto {
    
    public MemberDto(String name, int age) { this.name = name; this.age = age; }

    private String name;
    private int age;
}

public class Example1 {
    public static void main(String[] args) {
        // (1) (객체) MemberDto를 생성할 때 멤버변수의 초기값을 대입하는 방법 (생성자)
        MemberDto memberDto0 = new MemberDto("유재석", 40);
        // 생성자 규칙 : 정의된 생성자만 사용이 가능하다. 매개변수의 순서와 타입, 개수가 일치해야한다.
        // ↓ 존재하지 않는 생성자 사용
        // MemberDto memberDto1 = new MemberDto();
        // ↓ 존재하지 않는 생성자 사용 + 매개변수 개수 불일치
        // MemberDto memberDto2 = new MemberDto("유재석");
        // ↓ 존재하지 않는 생성자 사용 + 매개변수 타입 불일치
        // MemberDto memberDto3 = new MemberDto(40, "유재석");
        // ↓ 존재하지 않는 생성자 사용 + 매개변수 개수 불일치
        // MemberDto memberDto4 = new MemberDto("유재석", 40, "연예인");
        // 다양한 생성자를 사용할여면 복잡도가 올라간다. 그렇기에 Builder Pattern을 사용
        // ! 빌더패턴 @Builder : 복잡한 객체 생성 과정을 단순화 해주는 디자인 패턴
        // (2) 룸북에서 제공하는 @Builder 어노테이션 객체 생성
        // 클래스명.builder().필드명1(초기값).필드명2(초기값).필드명3(초기값).build() : 빌더 객체를 생성
        MemberDto memberDto5 = MemberDto.builder().name("유재석").age(40).build();
        MemberDto memberDto6 = MemberDto.builder().build();
        MemberDto memberDto7 = MemberDto.builder().name("유재석").build();
        MemberDto memberDto8 = MemberDto.builder().age(40).name("유재석").build();
    }
}
